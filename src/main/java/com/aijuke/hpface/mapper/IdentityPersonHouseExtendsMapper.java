package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityPersonHouse;

import java.util.Map;

public interface IdentityPersonHouseExtendsMapper extends IdentityPersonHouseMapper{
    IdentityPersonHouse selectOneByParams(Map<String, Object> params);
}