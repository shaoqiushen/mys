package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.service.OmsProductCommentService;
import com.shanyuan.mapper.OmsProductCommentMapper;
import com.shanyuan.mapper.OmsProductCommentReplyMapper;
import com.shanyuan.model.OmsProductComment;
import com.shanyuan.model.OmsProductCommentExample;
import com.shanyuan.model.OmsProductCommentReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-28 14:49
 * <p>
 * desc
 **/
@Service
public class OmsProductCommentServiceImpl implements OmsProductCommentService {

    @Autowired
    OmsProductCommentMapper omsProductCommentMapper;

    @Autowired
    OmsProductCommentReplyMapper omsProductCommentReplyMapper;

    @Override
    public List<OmsProductComment> listCommentByParams(String productName) {
        OmsProductCommentExample example = new OmsProductCommentExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andProductNameLike( productName );
        return omsProductCommentMapper.selectByExample( example );
    }

    @Override
    public int updateComment(Integer id, Integer showStatus) {
        OmsProductComment omsProductComment = new OmsProductComment();
        omsProductComment.setShowStatus( showStatus );
        omsProductComment.setId( id );
        return omsProductCommentMapper.updateByPrimaryKeySelective(omsProductComment);
    }

    @Override
    public int createCommentReply(Integer commentId, String replyContent) {
        OmsProductCommentReply commentReply = new OmsProductCommentReply();
        commentReply.setCommentId( commentId );
        commentReply.setCreateTime( new Date(  ) );
        commentReply.setReplyContent( replyContent );
        return omsProductCommentReplyMapper.insert( commentReply );
    }
}
