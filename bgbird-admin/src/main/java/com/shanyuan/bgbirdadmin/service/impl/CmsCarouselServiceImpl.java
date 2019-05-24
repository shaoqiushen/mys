package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.dto.CmsCarouselParams;
import com.shanyuan.bgbirdadmin.service.CmsCarouselService;
import com.shanyuan.mapper.CmsCarouselMapper;
import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.CmsCarouselExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-17 10:27
 * <p>
 * desc
 **/
@Service
public class CmsCarouselServiceImpl implements CmsCarouselService {

    @Autowired
    CmsCarouselMapper cmsCarouselMapper;

    @Override
    public int createCarousel(CmsCarouselParams cmsShufflingParams) {
        CmsCarousel cmsCarousel = new CmsCarousel();
        BeanUtils.copyProperties( cmsShufflingParams,cmsCarousel );
        cmsCarousel.setCreateTime( new Date(  ) );
        return cmsCarouselMapper.insert( cmsCarousel );
    }

    @Override
    public int updateCarouselDeleteStatus(Integer id, Integer deleteStatus) {
        CmsCarousel cmsCarousel = new CmsCarousel();
        cmsCarousel.setDeleteStatus( deleteStatus );
        return cmsCarouselMapper.updateByPrimaryKeySelective( cmsCarousel );
    }

    @Override
    public List<CmsCarousel> listCarousel() {
        CmsCarouselExample example = new CmsCarouselExample();
        example.setOrderByClause( "sort" );
        return cmsCarouselMapper.selectByExample( example );
    }

    @Override
    public int updateCarousel(CmsCarouselParams cmsCarouselParams, Integer id) {
        CmsCarousel cmsCarousel = new CmsCarousel();
        BeanUtils.copyProperties( cmsCarouselParams,cmsCarousel );
        cmsCarousel.setId( id );
        return cmsCarouselMapper.updateByPrimaryKeySelective( cmsCarousel );
    }
}
