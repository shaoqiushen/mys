package com.shanyuan.bgbirdadmin.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-10 9:06
 * <p>
 * desc
 **/
public interface UmsUserMemberService {
    //领取会员卡信息入库
    int createMember(String openid,String cardCode);

}
