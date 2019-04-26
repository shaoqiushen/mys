package com.shanyuan.bgbirdportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdportal.dto.PortalUserAddressParams;
import com.shanyuan.bgbirdportal.service.PortalUserAddressService;
import com.shanyuan.mapper.UmsUserReceiveAddressMapper;
import com.shanyuan.model.UmsUserReceiveAddress;
import com.shanyuan.model.UmsUserReceiveAddressExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 15:43
 * <p>
 * desc
 **/
@Service
public class PortalUserAddressServiceImpl implements PortalUserAddressService {

    @Autowired
    UmsUserReceiveAddressMapper umsUserReceiveAddressMapper;

    @Override
    public int createUserAddress(PortalUserAddressParams portalUserAddressParams) {
        UmsUserReceiveAddress umsUserReceiveAddress = new UmsUserReceiveAddress();

        if(portalUserAddressParams.getDefaultStatus() == 1){
            //若是有修改地址为默认地址的
            //先将用户的所有地址默认地址全置为0
            UmsUserReceiveAddressExample example = new UmsUserReceiveAddressExample();
            umsUserReceiveAddress.setDefaultStatus( 0 );
            example.createCriteria().andUserIdEqualTo( portalUserAddressParams.getUserId() );
            //先查询用户之前是否有收货地址
            List <UmsUserReceiveAddress> umsUserReceiveAddresses=umsUserReceiveAddressMapper.selectByExample( example );
            if(umsUserReceiveAddresses.size()>0){
                //若有，则执行修改默认地址状态
                umsUserReceiveAddressMapper.updateByExampleSelective( umsUserReceiveAddress,example );
            }
        }

        BeanUtils.copyProperties( portalUserAddressParams,umsUserReceiveAddress );
        return umsUserReceiveAddressMapper.insert(umsUserReceiveAddress);
    }

    @Override
    public int deleteUserAddress(Integer id) {
        return umsUserReceiveAddressMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int updateUserAddress(Integer id, PortalUserAddressParams portalUserAddressParams) {
        int count = 0;
        UmsUserReceiveAddress umsUserReceiveAddress = new UmsUserReceiveAddress();
        UmsUserReceiveAddressExample example = new UmsUserReceiveAddressExample();
        UmsUserReceiveAddressExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo( portalUserAddressParams.getUserId() );
        if(portalUserAddressParams.getDefaultStatus() == 1){
            //若是有修改地址为默认地址的
            //先将用户的所有地址默认地址全置为0
            umsUserReceiveAddress.setDefaultStatus( 0 );
            count = umsUserReceiveAddressMapper.updateByExampleSelective( umsUserReceiveAddress,example );
        }

        //
        BeanUtils.copyProperties( portalUserAddressParams,umsUserReceiveAddress );
        criteria.andIdEqualTo( id );
        count = umsUserReceiveAddressMapper.updateByExampleSelective( umsUserReceiveAddress,example );
        return count;
    }

    @Override
    public List<UmsUserReceiveAddress> listUserAddressByUserId(String userId,Integer pageNum,Integer pageSize) {
        UmsUserReceiveAddressExample example = new UmsUserReceiveAddressExample();
        example.setOrderByClause( "default_status desc,id desc" );
        example.createCriteria().andUserIdEqualTo( userId );
        PageHelper.startPage( pageNum,pageSize );
        return umsUserReceiveAddressMapper.selectByExample( example );
    }
}
