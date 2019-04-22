package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserMemberLevel;
import com.shanyuan.model.UmsUserMemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserMemberLevelMapper {
    int countByExample(UmsUserMemberLevelExample example);

    int deleteByExample(UmsUserMemberLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserMemberLevel record);

    int insertSelective(UmsUserMemberLevel record);

    List<UmsUserMemberLevel> selectByExample(UmsUserMemberLevelExample example);

    UmsUserMemberLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserMemberLevel record, @Param("example") UmsUserMemberLevelExample example);

    int updateByExample(@Param("record") UmsUserMemberLevel record, @Param("example") UmsUserMemberLevelExample example);

    int updateByPrimaryKeySelective(UmsUserMemberLevel record);

    int updateByPrimaryKey(UmsUserMemberLevel record);
}