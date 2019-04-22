package com.shanyuan.mapper;

import com.shanyuan.model.AmsActiveComment;
import com.shanyuan.model.AmsActiveCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsActiveCommentMapper {
    int countByExample(AmsActiveCommentExample example);

    int deleteByExample(AmsActiveCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmsActiveComment record);

    int insertSelective(AmsActiveComment record);

    List<AmsActiveComment> selectByExample(AmsActiveCommentExample example);

    AmsActiveComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmsActiveComment record, @Param("example") AmsActiveCommentExample example);

    int updateByExample(@Param("record") AmsActiveComment record, @Param("example") AmsActiveCommentExample example);

    int updateByPrimaryKeySelective(AmsActiveComment record);

    int updateByPrimaryKey(AmsActiveComment record);
}