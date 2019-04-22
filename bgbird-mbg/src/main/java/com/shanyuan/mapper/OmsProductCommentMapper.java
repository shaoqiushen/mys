package com.shanyuan.mapper;

import com.shanyuan.model.OmsProductComment;
import com.shanyuan.model.OmsProductCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsProductCommentMapper {
    int countByExample(OmsProductCommentExample example);

    int deleteByExample(OmsProductCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsProductComment record);

    int insertSelective(OmsProductComment record);

    List<OmsProductComment> selectByExample(OmsProductCommentExample example);

    OmsProductComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsProductComment record, @Param("example") OmsProductCommentExample example);

    int updateByExample(@Param("record") OmsProductComment record, @Param("example") OmsProductCommentExample example);

    int updateByPrimaryKeySelective(OmsProductComment record);

    int updateByPrimaryKey(OmsProductComment record);
}