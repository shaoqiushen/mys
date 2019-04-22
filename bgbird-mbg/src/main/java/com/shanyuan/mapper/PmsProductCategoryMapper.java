package com.shanyuan.mapper;

import com.shanyuan.model.PmsProductCategory;
import com.shanyuan.model.PmsProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductCategoryMapper {
    int countByExample(PmsProductCategoryExample example);

    int deleteByExample(PmsProductCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(PmsProductCategory record);

    int insertSelective(PmsProductCategory record);

    List<PmsProductCategory> selectByExample(PmsProductCategoryExample example);

    PmsProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByExample(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByPrimaryKeySelective(PmsProductCategory record);

    int updateByPrimaryKey(PmsProductCategory record);
}