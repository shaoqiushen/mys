package com.shanyuan.mapper;

import com.shanyuan.model.AmsActiveUserApply;
import com.shanyuan.model.AmsActiveUserApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsActiveUserApplyMapper {
    int countByExample(AmsActiveUserApplyExample example);

    int deleteByExample(AmsActiveUserApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmsActiveUserApply record);

    int insertSelective(AmsActiveUserApply record);

    List<AmsActiveUserApply> selectByExample(AmsActiveUserApplyExample example);

    AmsActiveUserApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmsActiveUserApply record, @Param("example") AmsActiveUserApplyExample example);

    int updateByExample(@Param("record") AmsActiveUserApply record, @Param("example") AmsActiveUserApplyExample example);

    int updateByPrimaryKeySelective(AmsActiveUserApply record);

    int updateByPrimaryKey(AmsActiveUserApply record);
}