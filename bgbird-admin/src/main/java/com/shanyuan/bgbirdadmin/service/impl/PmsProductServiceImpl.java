package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.*;
import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductQueryParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductResult;
import com.shanyuan.bgbirdadmin.service.PmsProductService;

import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:31
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    PmsProductMapper pmsProductMapper;

    @Autowired
    PmsProductAttributeValueDao pmsProductAttributeValueDao;

    @Autowired
    PmsProductAttributeValueMapper pmsProductAttributeValueMapper;

    @Autowired
    PmsSkuStockDao pmsSkuStockDao;

    @Autowired
    PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    PmsProductMemberPriceDao pmsProductMemberPriceDao;

    @Autowired
    PmsProductMemberPriceMapper pmsProductMemberPriceMapper;

    @Autowired
    PmsProductFullReductionDao pmsProductFullReductionDao;

    @Autowired
    PmsProductFullReductionMapper pmsProductFullReductionMapper;

    @Autowired
    PmsProductDao pmsProductDao;

    @Override
    public int createProduct(PmsProductParams productParams) {
        int count = 0;
        //创建商品
        PmsProduct pmsProduct = productParams;
        //添加商品基本信息
        pmsProductMapper.insertSelective( pmsProduct );
        Integer productId = pmsProduct.getId();
        //会员价格设置
        relateAndInsertList(pmsProductMemberPriceDao,productParams.getMemberPriceList(),productId);
        //满减价格设置
        relateAndInsertList(pmsProductFullReductionDao,productParams.getFullReductionList(),productId);
        //处理sku -code编码
        handleSkuStockCode(productParams.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(pmsSkuStockDao,productParams.getSkuStockList(),productId);
        //添加自定义参数，规格
        relateAndInsertList(pmsProductAttributeValueDao,productParams.getProductAttributeValueList(),productId);
        count=1;
        return count;
    }

    @Override
    public List <PmsProduct> listProduct(PmsProductQueryParams pmsProductQueryParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsProductExample example = new PmsProductExample();
        example.setOrderByClause( "id desc" );
        PmsProductExample.Criteria criteria=example.createCriteria();
        criteria.andDeleteStatusEqualTo( 0 );
        if(!StringUtils.isEmpty(pmsProductQueryParams.getKeyword())){
            criteria.andProductNameLike( "%"+pmsProductQueryParams.getKeyword()+"%" );
        }
        if(!StringUtils.isEmpty( pmsProductQueryParams.getProductCategoryId() )){
            criteria.andProductCategoryIdEqualTo( pmsProductQueryParams.getProductCategoryId() );
        }
        if(!StringUtils.isEmpty( pmsProductQueryParams.getPublishStatus() )){
            criteria.andPublishStatusEqualTo( pmsProductQueryParams.getPublishStatus() );
        }
        return pmsProductMapper.selectByExample( example );
    }

    @Override
    public int updateProductDeleteStatus(List <Integer> ids, Integer deleteStatus) {
        PmsProduct pmsProduct = new PmsProduct();
        pmsProduct.setDeleteStatus( deleteStatus );
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn( ids );
        return pmsProductMapper.updateByExampleSelective( pmsProduct,example );
    }

    @Override
    public PmsProductResult getUpdateProductInfoById(Integer productId) {
        return pmsProductDao.getUpdateProductInfoById( productId );
    }

    @Override
    public int updateProductById(Integer productId, PmsProductParams pmsProductParams) {
        int count;
        //更新商品信息
        PmsProduct product = pmsProductParams;
        product.setId(productId);
        pmsProductMapper.updateByPrimaryKeySelective(product);
        //更新满减价格
        PmsProductFullReductionExample fullReductionExample = new PmsProductFullReductionExample();
        fullReductionExample.createCriteria().andProductIdEqualTo( productId );
        pmsProductFullReductionMapper.deleteByExample( fullReductionExample );
        //满减价格设置
        relateAndInsertList(pmsProductFullReductionDao,pmsProductParams.getFullReductionList(),productId);

        //更新sku信息
        PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo( productId );
        pmsSkuStockMapper.deleteByExample( skuStockExample );
        //处理sku -code编码
        handleSkuStockCode(pmsProductParams.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(pmsSkuStockDao,pmsProductParams.getSkuStockList(),productId);

        //更新参数规格
        PmsProductAttributeValueExample pmsProductAttributeValueExample = new PmsProductAttributeValueExample();
        pmsProductAttributeValueExample.createCriteria().andProductIdEqualTo( productId );
        pmsProductAttributeValueMapper.deleteByExample( pmsProductAttributeValueExample );
        //添加自定义参数，规格
        relateAndInsertList(pmsProductAttributeValueDao,pmsProductParams.getProductAttributeValueList(),productId);

        //更新会员价格
        PmsProductMemberPriceExample pmsProductMemberPriceExample = new PmsProductMemberPriceExample();
        pmsProductAttributeValueExample.createCriteria().andProductIdEqualTo( productId );
        pmsProductMemberPriceMapper.deleteByExample( pmsProductMemberPriceExample );
        //会员价格设置
        relateAndInsertList(pmsProductMemberPriceDao,pmsProductParams.getMemberPriceList(),productId);

        count = 1;

        return count;
    }

    @Override
    public int updatePublishStatues(List <Integer> ids, Integer publishStatus) {
        PmsProduct pmsProduct = new PmsProduct();
        pmsProduct.setPublishStatus( publishStatus );
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn( ids );
        return pmsProductMapper.updateByExampleSelective( pmsProduct,example );
    }


    /**
     * 建立和插入关系表操作
     *
     * @param dao       可以操作的dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Integer productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Integer.class);
                setId.invoke(item, (Integer) null);//id主键，数据自增，不用赋值
                Method setProductId = item.getClass().getMethod("setProductId", Integer.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            log.error("创建产品出错:{}", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Integer productId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            PmsSkuStock skuStock = skuStockList.get(i);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }
}
