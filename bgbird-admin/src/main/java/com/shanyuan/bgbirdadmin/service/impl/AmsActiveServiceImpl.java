package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.AmsActiveDao;
import com.shanyuan.bgbirdadmin.dto.AmsActiveParams;
import com.shanyuan.bgbirdadmin.dto.AmsActiveResult;
import com.shanyuan.bgbirdadmin.service.AmsActiveService;
import com.shanyuan.mapper.AmsActiveDetailMapper;
import com.shanyuan.mapper.AmsActiveMapper;
import com.shanyuan.model.AmsActive;
import com.shanyuan.model.AmsActiveDetail;
import com.shanyuan.utils.MyDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 8:57
 * <p>
 * desc
 **/
@Service
@Slf4j
public class AmsActiveServiceImpl implements AmsActiveService {

    @Autowired
    AmsActiveMapper amsActiveMapper;

    @Autowired
    AmsActiveDetailMapper amsActiveDetailMapper;

    @Autowired
    AmsActiveDao amsActiveDao;

    @Override
    public int createActive(AmsActiveParams amsActiveParams)  {
        int count =0;
        AmsActive amsActive = new AmsActive();
        BeanUtils.copyProperties( amsActiveParams,amsActive );
        try {
            amsActive.setBeginTime( MyDateUtil.parseLongStringDate( amsActiveParams.getBeginTime() ) );
            amsActive.setEndTime( MyDateUtil.parseLongStringDate( amsActiveParams.getEndTime() ) );
        } catch ( ParseException e ) {
            log.error( "createActive ParseException{}",e );
            return 0;
        }
        amsActive.setCreateTime( new Date(  ) );
        //入活动信息表
        amsActiveMapper.insertSelective( amsActive );
        count =1 ;
        return count;
    }

    @Override
    public int updateActive(Integer id, AmsActiveParams amsActiveParams) {
        AmsActive amsActive = new AmsActive();
        BeanUtils.copyProperties( amsActiveParams,amsActive );
        try {
            amsActive.setBeginTime( MyDateUtil.parseLongStringDate( amsActiveParams.getBeginTime() ) );
            amsActive.setEndTime( MyDateUtil.parseLongStringDate( amsActiveParams.getEndTime() ) );
        } catch ( ParseException e ) {
            log.error( "updateActive ParseException{}",e );
            return 0;
        }
        amsActive.setId( id );
        return amsActiveMapper.updateByPrimaryKeySelective( amsActive );
    }

    @Override
    public int deleteActive(Integer id) {
        //将活动删除标志置为1
        return amsActiveDao.deleteActive( id );
    }

    @Override
    public List<AmsActiveResult> listAmsActiveInfo(Integer pageNum,Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return amsActiveDao.listActiveInfo();
    }
}
