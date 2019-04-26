package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.dao.PmsProductAttributeValueDao;
import com.shanyuan.bgbirdadmin.dao.PmsProductFullReductionDao;
import com.shanyuan.bgbirdadmin.dao.PmsProductMemberPriceDao;
import com.shanyuan.bgbirdadmin.dao.PmsSkuStockDao;
import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.service.PmsProductService;

import com.shanyuan.mapper.PmsProductMapper;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsSkuStock;
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
    PmsSkuStockDao pmsSkuStockDao;

    @Autowired
    PmsProductMemberPriceDao pmsProductMemberPriceDao;

    @Autowired
    PmsProductFullReductionDao pmsProductFullReductionDao;

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
