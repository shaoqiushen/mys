package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.AmsActiveParams;
import com.shanyuan.bgbirdadmin.dto.AmsActiveResult;
import com.shanyuan.model.AmsActive;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 8:57
 * <p>
 * desc
 **/
public interface AmsActiveService {
    @Transactional
    int createActive(AmsActiveParams amsActiveParams);
    int updateActive(Integer id,AmsActiveParams amsActiveParams);
    int deleteActive(Integer id);
    List<AmsActiveResult> listAmsActiveInfo(Integer pageNum,Integer pageSize,String startTime1,String startTime2);
    AmsActive getActiveInfoById(Integer id);
}
