package com.shanyuan.mapper;

import com.shanyuan.model.CmsShuffling;
import com.shanyuan.model.CmsShufflingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsShufflingMapper {
    int countByExample(CmsShufflingExample example);

    int deleteByExample(CmsShufflingExample example);

    int deleteByPrimaryKey(Integer shuffingId);

    int insert(CmsShuffling record);

    int insertSelective(CmsShuffling record);

    List<CmsShuffling> selectByExample(CmsShufflingExample example);

    CmsShuffling selectByPrimaryKey(Integer shuffingId);

    int updateByExampleSelective(@Param("record") CmsShuffling record, @Param("example") CmsShufflingExample example);

    int updateByExample(@Param("record") CmsShuffling record, @Param("example") CmsShufflingExample example);

    int updateByPrimaryKeySelective(CmsShuffling record);

    int updateByPrimaryKey(CmsShuffling record);
}