package com.shanyuan.mapper;

import com.shanyuan.model.PmsProductAttribute;
import com.shanyuan.model.PmsProductAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductAttributeMapper {
    int countByExample(PmsProductAttributeExample example);

    int deleteByExample(PmsProductAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsProductAttribute record);

    int insertSelective(PmsProductAttribute record);

    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);

    PmsProductAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    int updateByExample(@Param("record") PmsProductAttribute record, @Param("example") PmsProductAttributeExample example);

    int updateByPrimaryKeySelective(PmsProductAttribute record);

    int updateByPrimaryKey(PmsProductAttribute record);
}