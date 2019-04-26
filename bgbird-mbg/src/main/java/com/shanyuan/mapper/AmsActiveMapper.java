package com.shanyuan.mapper;

import com.shanyuan.model.AmsActive;
import com.shanyuan.model.AmsActiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsActiveMapper {
    int countByExample(AmsActiveExample example);

    int deleteByExample(AmsActiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmsActive record);

    int insertSelective(AmsActive record);

    List<AmsActive> selectByExampleWithBLOBs(AmsActiveExample example);

    List<AmsActive> selectByExample(AmsActiveExample example);

    AmsActive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmsActive record, @Param("example") AmsActiveExample example);

    int updateByExampleWithBLOBs(@Param("record") AmsActive record, @Param("example") AmsActiveExample example);

    int updateByExample(@Param("record") AmsActive record, @Param("example") AmsActiveExample example);

    int updateByPrimaryKeySelective(AmsActive record);

    int updateByPrimaryKeyWithBLOBs(AmsActive record);

    int updateByPrimaryKey(AmsActive record);
}