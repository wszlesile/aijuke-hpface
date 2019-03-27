package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityFaceDevice;

import java.util.Map;

public interface IdentityFaceDeviceExtendsMapper extends IdentityFaceDeviceMapper{
    IdentityFaceDevice selectOneByParams(Map<String,Object> params);
}