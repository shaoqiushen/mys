package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserMember;
import com.shanyuan.model.UmsUserMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserMemberMapper {
    int countByExample(UmsUserMemberExample example);

    int deleteByExample(UmsUserMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserMember record);

    int insertSelective(UmsUserMember record);

    List<UmsUserMember> selectByExample(UmsUserMemberExample example);

    UmsUserMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserMember record, @Param("example") UmsUserMemberExample example);

    int updateByExample(@Param("record") UmsUserMember record, @Param("example") UmsUserMemberExample example);

    int updateByPrimaryKeySelective(UmsUserMember record);

    int updateByPrimaryKey(UmsUserMember record);
}