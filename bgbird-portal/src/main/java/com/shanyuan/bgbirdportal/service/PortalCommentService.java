package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalCommentParams;
import com.shanyuan.domain.CommonResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 8:52
 * <p>
 * desc
 **/
public interface PortalCommentService {
    @Transactional
    CommonResult createComment(PortalCommentParams portalCommentParams);
}
