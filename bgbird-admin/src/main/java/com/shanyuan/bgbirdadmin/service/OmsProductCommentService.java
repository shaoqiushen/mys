package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.model.OmsProductComment;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-28 14:48
 * <p>
 * desc
 **/
public interface OmsProductCommentService {
    List<OmsProductComment> listCommentByParams(String productName);
    int updateComment(Integer id,Integer showStatus);
    int createCommentReply(Integer commentId,String replyContent);
}
