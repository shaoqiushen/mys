package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalUserAddressParams;
import com.shanyuan.model.UmsUserReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 15:43
 * <p>
 * desc
 **/
public interface PortalUserAddressService {
    @Transactional
    int createUserAddress(PortalUserAddressParams portalUserAddressParams);
    int deleteUserAddress(Integer id);
    @Transactional
    int updateUserAddress(Integer id,PortalUserAddressParams portalUserAddressParams);
    List<UmsUserReceiveAddress> listUserAddressByUserId(String userId,Integer pageNum,Integer pageSize);
    UmsUserReceiveAddress getUserAddressById(String user_id,Integer id);
}
