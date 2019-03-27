package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityPersonHouse;

import java.util.Map;

public interface IdentityPersonHouseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IdentityPersonHouse record);

    int insertSelective(IdentityPersonHouse record);

    IdentityPersonHouse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityPersonHouse record);

    int updateByPrimaryKey(IdentityPersonHouse record);

    IdentityPersonHouse selectOneByParams(Map<String, Object> params);
}