package com.shanyuan.bgbirdportal.service;

import com.shanyuan.model.AmsActive;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 18:23
 * <p>
 * desc
 **/
public interface ActiveService {

    List<AmsActive> listActive();
    AmsActive findActiveById(Integer id);
}
