package com.shanyuan.mapper;

import com.shanyuan.model.PmsSkuStock;
import com.shanyuan.model.PmsSkuStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsSkuStockMapper {
    int countByExample(PmsSkuStockExample example);

    int deleteByExample(PmsSkuStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsSkuStock record);

    int insertSelective(PmsSkuStock record);

    List<PmsSkuStock> selectByExample(PmsSkuStockExample example);

    PmsSkuStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    int updateByExample(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

    int updateByPrimaryKeySelective(PmsSkuStock record);

    int updateByPrimaryKey(PmsSkuStock record);
}