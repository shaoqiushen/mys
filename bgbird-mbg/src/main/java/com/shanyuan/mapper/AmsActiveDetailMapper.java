package com.shanyuan.mapper;

import com.shanyuan.model.AmsActiveDetail;
import com.shanyuan.model.AmsActiveDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsActiveDetailMapper {
    int countByExample(AmsActiveDetailExample example);

    int deleteByExample(AmsActiveDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmsActiveDetail record);

    int insertSelective(AmsActiveDetail record);

    List<AmsActiveDetail> selectByExampleWithBLOBs(AmsActiveDetailExample example);

    List<AmsActiveDetail> selectByExample(AmsActiveDetailExample example);

    AmsActiveDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmsActiveDetail record, @Param("example") AmsActiveDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") AmsActiveDetail record, @Param("example") AmsActiveDetailExample example);

    int updateByExample(@Param("record") AmsActiveDetail record, @Param("example") AmsActiveDetailExample example);

    int updateByPrimaryKeySelective(AmsActiveDetail record);

    int updateByPrimaryKeyWithBLOBs(AmsActiveDetail record);

    int updateByPrimaryKey(AmsActiveDetail record);
}