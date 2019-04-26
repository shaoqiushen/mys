package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.CmsShuffling;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsProductCategory;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 9:10
 * <p>
 * desc
 **/
@Data
public class HomeContentResult {
    /*轮播广告*/
    List<CmsShuffling> shufflingList;

    //TODO
    /*会员卡*/

    /*热销商品*/
    List<PmsProduct> hotSaleList;
    /*商品分类目录*/
    List<PmsProductCategory> categoryList;
}
