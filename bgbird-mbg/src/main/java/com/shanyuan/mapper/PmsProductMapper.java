package com.shanyuan.mapper;

import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper {
    int countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(PmsProduct record);

    int insertSelective(PmsProduct record);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProduct selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);
}