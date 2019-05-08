package com.shanyuan.bgbirdportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdportal.dao.PortalCartDao;
import com.shanyuan.bgbirdportal.dto.PortalCartParams;
import com.shanyuan.bgbirdportal.dto.PortalCartResult;
import com.shanyuan.bgbirdportal.service.PortalCartService;
import com.shanyuan.mapper.OmsCartMapper;
import com.shanyuan.model.OmsCart;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 10:13
 * <p>
 * desc
 **/
@Service
public class PortalCartServiceImpl implements PortalCartService {

    @Autowired
    OmsCartMapper omsCartMapper;

    @Autowired
    PortalCartDao portalCartDao;

    @Override
    public int createCart(PortalCartParams portalCartParams) {
        OmsCart omsCart = new OmsCart();
        BeanUtils.copyProperties( portalCartParams,omsCart );
        omsCart.setDeleteStatus( 0 );
        omsCart.setCreateTime( new Date(  ) );
        return omsCartMapper.insert( omsCart );
    }

    @Override
    public int updateCartDeleteStatus(Integer id) {
        OmsCart omsCart = new OmsCart();
        omsCart.setDeleteStatus( 1 );
        omsCart.setId( id );
        return omsCartMapper.updateByPrimaryKeySelective( omsCart );
    }

    @Override
    public int updateCartBuyCount(Integer id,Integer buyCount) {
        OmsCart omsCart = new OmsCart();
        omsCart.setId( id );
        omsCart.setBuyCount( buyCount );
        return omsCartMapper.updateByPrimaryKeySelective( omsCart );
    }

    @Override
    public List<PortalCartResult> listCartByUserId(String userId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return portalCartDao.listCartByUserId( userId);
    }


}
