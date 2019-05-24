package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.CmsCarouselParams;
import com.shanyuan.model.CmsCarousel;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-17 10:27
 * <p>
 * desc
 **/
public interface CmsCarouselService {
    int createCarousel(CmsCarouselParams cmsCarouselParams);
    int updateCarouselDeleteStatus(Integer id,Integer deleteStatus );
    List<CmsCarousel> listCarousel();
    int updateCarousel(CmsCarouselParams cmsCarouselParams,Integer id);
}
