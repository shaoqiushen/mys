package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.model.OmsProductComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-13 9:46
 * <p>
 * desc
 **/
public interface PortalCommentDao {
    int createComment(@Param( "list" ) List<OmsProductComment> productComments);
}
