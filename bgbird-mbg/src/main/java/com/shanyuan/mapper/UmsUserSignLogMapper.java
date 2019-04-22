package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserSignLog;
import com.shanyuan.model.UmsUserSignLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserSignLogMapper {
    int countByExample(UmsUserSignLogExample example);

    int deleteByExample(UmsUserSignLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserSignLog record);

    int insertSelective(UmsUserSignLog record);

    List<UmsUserSignLog> selectByExample(UmsUserSignLogExample example);

    UmsUserSignLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserSignLog record, @Param("example") UmsUserSignLogExample example);

    int updateByExample(@Param("record") UmsUserSignLog record, @Param("example") UmsUserSignLogExample example);

    int updateByPrimaryKeySelective(UmsUserSignLog record);

    int updateByPrimaryKey(UmsUserSignLog record);
}