package com.shanyuan.bgbirdportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdportal.dao.PortalProductAttributeValueDao;
import com.shanyuan.bgbirdportal.dao.PortalProductDao;
import com.shanyuan.bgbirdportal.dto.HomeContentResult;
import com.shanyuan.bgbirdportal.dto.PortalProductDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalProductAttirbuteParamsResult;
import com.shanyuan.bgbirdportal.service.HomeService;
import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 9:09
 * <p>
 * desc
 **/
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    PmsProductCategoryMapper pmsProductCategoryMapper;

    @Autowired
    CmsShufflingMapper cmsShufflingMapper;

    @Autowired
    PmsProductMapper pmsProductMapper;

    @Autowired
    PortalProductDao portalProductDao;

    @Autowired
    PortalProductAttributeValueDao portalProductAttributeValueDao;

    @Autowired
    OmsProductCommentMapper omsProductCommentMapper;

    @Autowired
    PmsSkuStockMapper pmsSkuStockMapper;

    @Override
    public HomeContentResult homeContent() {
        HomeContentResult result = new HomeContentResult();
        //获取首页轮播广告
        result.setShufflingList( getHomeShufflingList() );
        //TODO 获取会员卡
        //
        //获取分类目录
        result.setCategoryList( getCategoryList() );
        //获取热销商品
        result.setHotSaleList( getHotSaleList( 0,8 ) );
        return result;
    }

    @Override
    public List <PmsProduct> listProductByCategoryId(Integer pageNum,Integer pageSize,Integer categoryId) {
        PageHelper.startPage( pageNum,pageSize );
        return portalProductDao.listProductByCategoryId( categoryId );
    }


    @Override
    public PortalProductDetailResult findProductDetail(Integer productId) {
        PortalProductDetailResult result = new PortalProductDetailResult();
        //商品信息
        result.setProductList( getProductInfo( productId ) );
        //商品参数
        result.setAttributeList( getProductParams( productId ) );
        //商品评价
        result.setCommentList( getProductComment( productId ) );
        //规格参数
        result.setSkuStockList( getSkuStocks( productId ) );
        return result;
    }

    private List<CmsShuffling> getHomeShufflingList(){
        CmsShufflingExample example = new CmsShufflingExample();
        example.setOrderByClause( "sort asc" );
        example.createCriteria().andTypeEqualTo( 0 )
                .andStatusEqualTo( 1 );
        return cmsShufflingMapper.selectByExample( example );
    }

    private List<PmsProductCategory> getCategoryList(){
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause( "sort asc" );
        example.createCriteria().andShowStatusEqualTo( 1 );
        return pmsProductCategoryMapper.selectByExample( example );
    }

    private List<PmsProduct> getHotSaleList(Integer pageNum,Integer pageSize){
        PageHelper.startPage( pageNum,pageSize );
        PmsProductExample example = new PmsProductExample();
        example.setOrderByClause( "sale_amount desc" );
        example.createCriteria().andDeleteStatusEqualTo( 0 )
                .andPublishStatusEqualTo( 1 );
        return pmsProductMapper.selectByExample( example );
    }

    private List<PmsProduct> getProductInfo(Integer productId){
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andPublishStatusEqualTo( 1 )
                .andDeleteStatusEqualTo( 0 )
                .andIdEqualTo( productId );
        return pmsProductMapper.selectByExample( example );
    }

    private List<PortalProductAttirbuteParamsResult> getProductParams(Integer productId){
        return portalProductAttributeValueDao.getAttributeParamsByProductId( productId );
    }

    private List<OmsProductComment> getProductComment(Integer productId){
        OmsProductCommentExample example = new OmsProductCommentExample();
        example.setOrderByClause( "create_time desc" );
        example.createCriteria().andProductIdEqualTo( productId )
                .andShowStatusEqualTo( 1 );
        return omsProductCommentMapper.selectByExample( example );
    }

    private List<PmsSkuStock> getSkuStocks(Integer productId){
        PmsSkuStockExample example = new PmsSkuStockExample();
        example.setOrderByClause( "id" );
        example.createCriteria().andProductIdEqualTo( productId );
        return pmsSkuStockMapper.selectByExample( example );
    }
}