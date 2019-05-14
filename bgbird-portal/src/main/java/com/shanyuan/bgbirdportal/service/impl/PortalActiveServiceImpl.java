package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.dto.PortalActiveCommentParams;
import com.shanyuan.bgbirdportal.service.PortalActiveService;
import com.shanyuan.bgbirdportal.service.PortalUmsUserService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.mapper.AmsActiveCommentMapper;
import com.shanyuan.mapper.AmsActiveMapper;
import com.shanyuan.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 18:24
 * <p>
 * desc
 **/
@Service
public class PortalActiveServiceImpl implements PortalActiveService {

    @Autowired
    AmsActiveMapper amsActiveMapper;

    @Autowired
    AmsActiveCommentMapper amsActiveCommentMapper;

    @Autowired
    PortalUmsUserService portalUmsUserService;

    @Override
    public List<AmsActive> listActive() {
        AmsActiveExample example = new AmsActiveExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andDeleteStatusEqualTo( 0 )
                .andIsEnableEqualTo( 1 );
        return amsActiveMapper.selectByExample( example );
    }

    @Override
    public AmsActive findActiveById(Integer id) {
        AmsActive amsActive=amsActiveMapper.selectByPrimaryKey( id );
        return amsActive;
    }

    @Override
    public CommonResult createActiveComment(PortalActiveCommentParams portalActiveCommentParams) {

        //判断用户是否存在
        UmsUser userInfo=portalUmsUserService.getUserInfo( portalActiveCommentParams.getUserId() );
        if(userInfo == null){
            return new CommonResult().failed( "用户不存在" );
        }

        //判断活动是否存在
        AmsActive amsActive=amsActiveMapper.selectByPrimaryKey( portalActiveCommentParams.getActiveId() );
        if(amsActive == null){
            return new CommonResult().failed( "活动不存在" );
        }
        AmsActiveComment amsActiveComment = new AmsActiveComment();
        BeanUtils.copyProperties( portalActiveCommentParams,amsActiveComment );
        amsActiveComment.setCreateTime( new Date(  ) );
        amsActiveComment.setShowStatus( 1 );
        int count=amsActiveCommentMapper.insert( amsActiveComment );
        return new CommonResult().success( count );
    }

    @Override
    public List <AmsActiveComment> getActiveCommentById(Integer activeId) {
        AmsActiveCommentExample amsActiveCommentExample = new AmsActiveCommentExample();
        amsActiveCommentExample.createCriteria().andActiveIdEqualTo( activeId );
        return amsActiveCommentMapper.selectByExample( amsActiveCommentExample );
    }
}
