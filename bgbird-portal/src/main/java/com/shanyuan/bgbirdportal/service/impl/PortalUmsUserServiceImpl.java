package com.shanyuan.bgbirdportal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shanyuan.bgbirdportal.dto.PortalAuthorizationParams;
import com.shanyuan.bgbirdportal.dto.SmallProgramResponse;
import com.shanyuan.bgbirdportal.dto.SmallProgramUserInfo;
import com.shanyuan.bgbirdportal.service.PortalUmsUserService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.mapper.UmsUserMapper;
import com.shanyuan.model.UmsUser;
import com.shanyuan.model.UmsUserExample;
import com.shanyuan.utils.HttpUtils;
import com.shanyuan.utils.PrimaryGenerater;
import com.shanyuan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-15 15:47
 * <p>
 * desc
 **/
@Service
public class PortalUmsUserServiceImpl implements PortalUmsUserService {

    private static final String PARSEDATAURL = "https://www.shanyuankj.cn/wechat/miniprogram/parseencrypteddata";

    @Autowired
    UmsUserMapper umsUserMapper;

    @Override
    public UmsUser getUserInfo(String userId) {
        //判断用户是否存在
        UmsUserExample umsUserExample = new UmsUserExample();
        umsUserExample.createCriteria().andUserIdEqualTo( userId );
        List<UmsUser> umsUsers=umsUserMapper.selectByExample( umsUserExample );
        if(umsUsers.size() == 0){
            return null;
        }
        return umsUsers.get( 0 );
    }

    @Override
    public CommonResult authorization(PortalAuthorizationParams portalAuthorizationParams) {
        StringBuffer stringBuffer = new StringBuffer(  );
        stringBuffer.append("token="+portalAuthorizationParams.getToken()+"&");
        stringBuffer.append("way="+"1"+"&");
        stringBuffer.append("encryptedData="+portalAuthorizationParams.getEncryptedData()+"&");
        stringBuffer.append("iv="+portalAuthorizationParams.getIv());
        String result = HttpUtils.getResponse(PARSEDATAURL,stringBuffer.toString() );
        SmallProgramResponse smallProgramResponse = JSONObject.parseObject( result,SmallProgramResponse.class );
        if(smallProgramResponse.getStatus() != 1){
            return new CommonResult().failed( "授权失败" );
        }
        SmallProgramUserInfo data=smallProgramResponse.getData();

        //判断用户之前是否有授权
        UmsUserExample example = new UmsUserExample();
        UmsUserExample.Criteria criteria=example.createCriteria();
        criteria.andOpenidEqualTo( data.getOpenId() );
        List <UmsUser> umsUsers=umsUserMapper.selectByExample( example );
        String userId = "";
        String avatarUrl = "";
        String nickName = "";
        if(umsUsers.size() > 0){
            userId = umsUsers.get( 0 ).getUserId();
            if(!umsUsers.get( 0 ).getAvatarUrl().equals( data.getAvatarUrl() ) || !umsUsers.get( 0 ).getNickname().equals( data.getNickName() )){
                UmsUser umsUser = new UmsUser();
                umsUser.setNickname( data.getNickName() );
                umsUser.setAvatarUrl( data.getAvatarUrl() );
                umsUserMapper.updateByExampleSelective( umsUser, example );
            }

        }else{
            //获取用户手机号
            userId =PrimaryGenerater.getInstance().getUid();
            UmsUser umsUser = new UmsUser();
            umsUser.setActStatus( 1 );//默认账号启动状态
            umsUser.setAvatarUrl( data.getAvatarUrl() );
            umsUser.setCity( data.getCity() );
            umsUser.setGender( Integer.parseInt( data.getGender() ) );
            umsUser.setNickname( data.getNickName() );
            umsUser.setOpenid( data.getOpenId() );
            umsUser.setUserId( userId );
            umsUser.setUserStatus( 0 );//默认普通用户
            umsUser.setUnionid( data.getUnionId() );
            umsUser.setProvince( data.getProvince() );
            umsUser.setCreateTime( new Date(  ) );
            umsUserMapper.insert( umsUser );
        }

        Map map = new HashMap(  );
        map.put( "userId", userId);
        map.put( "avatarUrl", data.getAvatarUrl());
        map.put( "nickName",data.getNickName() );
        return new CommonResult().success( map );
    }
}
