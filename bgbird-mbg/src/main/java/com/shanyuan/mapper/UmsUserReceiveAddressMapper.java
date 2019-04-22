package com.shanyuan.mapper;

import com.shanyuan.model.UmsUserReceiveAddress;
import com.shanyuan.model.UmsUserReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserReceiveAddressMapper {
    int countByExample(UmsUserReceiveAddressExample example);

    int deleteByExample(UmsUserReceiveAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsUserReceiveAddress record);

    int insertSelective(UmsUserReceiveAddress record);

    List<UmsUserReceiveAddress> selectByExample(UmsUserReceiveAddressExample example);

    UmsUserReceiveAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsUserReceiveAddress record, @Param("example") UmsUserReceiveAddressExample example);

    int updateByExample(@Param("record") UmsUserReceiveAddress record, @Param("example") UmsUserReceiveAddressExample example);

    int updateByPrimaryKeySelective(UmsUserReceiveAddress record);

    int updateByPrimaryKey(UmsUserReceiveAddress record);
}