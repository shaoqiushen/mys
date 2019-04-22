package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserRechargeOver;
import com.shanyuan.model.UmsUserRechargeOverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserRechargeOverMapper {
    int countByExample(UmsUserRechargeOverExample example);

    int deleteByExample(UmsUserRechargeOverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserRechargeOver record);

    int insertSelective(UmsUserRechargeOver record);

    List<UmsUserRechargeOver> selectByExample(UmsUserRechargeOverExample example);

    UmsUserRechargeOver selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserRechargeOver record, @Param("example") UmsUserRechargeOverExample example);

    int updateByExample(@Param("record") UmsUserRechargeOver record, @Param("example") UmsUserRechargeOverExample example);

    int updateByPrimaryKeySelective(UmsUserRechargeOver record);

    int updateByPrimaryKey(UmsUserRechargeOver record);
}