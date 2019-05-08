package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.dao.PortalProductDao;
import com.shanyuan.bgbirdportal.dto.PortalProductSkuInfo;
import com.shanyuan.bgbirdportal.service.PromotionService;
import com.shanyuan.model.OmsCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 10:56
 * <p>
 * desc
 **/
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PortalProductDao portalProductDao;

    @Override
    public List <PortalProductSkuInfo> calcCartPromotion(List <OmsCart> omsCarts) {
        //获取商品的优惠信息
        List <PortalProductSkuInfo> promotionProductList=getPromotionProductList( omsCarts );

        return promotionProductList;
    }

    private List<PortalProductSkuInfo> getPromotionProductList(List <OmsCart> omsCarts){
//        //商品id集合
//        List<Integer> productIdList = new ArrayList <>(  );
//        for(OmsCart omsCart : omsCarts){
//            productIdList.add( omsCart.getProductId() );
//        }
        return portalProductDao.getPromotionProductList( omsCarts );
    }
}
