package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.CustomerAllocationRecord;

public interface CustomerAllocationRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerAllocationRecord record);

    int insertSelective(CustomerAllocationRecord record);

    CustomerAllocationRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerAllocationRecord record);

    int updateByPrimaryKey(CustomerAllocationRecord record);
}