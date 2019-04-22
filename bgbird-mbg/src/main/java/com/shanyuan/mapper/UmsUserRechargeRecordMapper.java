package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserRechargeRecord;
import com.shanyuan.model.UmsUserRechargeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserRechargeRecordMapper {
    int countByExample(UmsUserRechargeRecordExample example);

    int deleteByExample(UmsUserRechargeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserRechargeRecord record);

    int insertSelective(UmsUserRechargeRecord record);

    List<UmsUserRechargeRecord> selectByExample(UmsUserRechargeRecordExample example);

    UmsUserRechargeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserRechargeRecord record, @Param("example") UmsUserRechargeRecordExample example);

    int updateByExample(@Param("record") UmsUserRechargeRecord record, @Param("example") UmsUserRechargeRecordExample example);

    int updateByPrimaryKeySelective(UmsUserRechargeRecord record);

    int updateByPrimaryKey(UmsUserRechargeRecord record);
}