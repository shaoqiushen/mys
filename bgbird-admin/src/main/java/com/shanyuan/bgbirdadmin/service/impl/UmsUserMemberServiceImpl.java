package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.service.UmsUserMemberService;
import com.shanyuan.bgbirdadmin.service.UmsUserService;
import com.shanyuan.mapper.UmsUserMemberLevelMapper;
import com.shanyuan.mapper.UmsUserMemberMapper;
import com.shanyuan.mapper.UmsUserPointsRecordMapper;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-10 9:06
 * <p>
 * desc
 **/
@Service
@Slf4j
public class UmsUserMemberServiceImpl implements UmsUserMemberService {

    @Autowired
    UmsUserMemberMapper umsUserMemberMapper;

    @Autowired
    UmsUserService umsUserService;

    @Autowired
    UmsUserMemberLevelMapper umsUserMemberLevelMapper;

    @Autowired
    UmsUserPointsRecordMapper umsUserPointsRecordMapper;





    @Override
    public int createMember(String openid, String cardCode) {
        //根据openid查询用户信息
        UmsUser userInfo=umsUserService.getUserInfo( openid );
        if(userInfo != null){
            //查询会员卡默认级别
            UmsUserMemberLevelExample levelExample = new UmsUserMemberLevelExample();
            levelExample.createCriteria().andDefaultStatusEqualTo( 1 );
            List <UmsUserMemberLevel> umsUserMemberLevels=umsUserMemberLevelMapper.selectByExample( levelExample );
            if(!StringUtils.isEmpty( umsUserMemberLevels )) {
                UmsUserMember umsUserMember=new UmsUserMember();
                umsUserMember.setCardCode( cardCode );
                umsUserMember.setUserId( userInfo.getUserId() );
                umsUserMember.setCreateTime( new Date() );
                umsUserMember.setMemberLevelId( umsUserMemberLevels.get( 0 ).getId() );
                umsUserMember.setIntegration( 0 );//默认初始化0积分
                return umsUserMemberMapper.insertSelective( umsUserMember );
            }else {
                log.info( "createMember no have default level" );
            }
        }
        return 0;
    }



}
