package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityFaceDevice;

public interface IdentityFaceDeviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IdentityFaceDevice record);

    int insertSelective(IdentityFaceDevice record);

    IdentityFaceDevice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityFaceDevice record);

    int updateByPrimaryKey(IdentityFaceDevice record);
}