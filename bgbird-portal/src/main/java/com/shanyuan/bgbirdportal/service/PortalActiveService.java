package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalActiveCommentParams;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.AmsActive;
import com.shanyuan.model.AmsActiveComment;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 18:23
 * <p>
 * desc
 **/
public interface PortalActiveService {

    List<AmsActive> listActive();
    AmsActive findActiveById(Integer id);
    CommonResult createActiveComment(PortalActiveCommentParams portalActiveCommentParams);
    List<AmsActiveComment> getActiveCommentById(Integer activeId);
}
