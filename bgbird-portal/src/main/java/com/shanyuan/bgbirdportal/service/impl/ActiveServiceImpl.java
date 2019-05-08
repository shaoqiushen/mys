package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.service.ActiveService;
import com.shanyuan.mapper.AmsActiveMapper;
import com.shanyuan.model.AmsActive;
import com.shanyuan.model.AmsActiveExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 18:24
 * <p>
 * desc
 **/
@Service
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    AmsActiveMapper amsActiveMapper;

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
}
