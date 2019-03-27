package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityFacePerson;

public interface IdentityFacePersonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IdentityFacePerson record);

    int insertSelective(IdentityFacePerson record);

    IdentityFacePerson selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityFacePerson record);

    int updateByPrimaryKey(IdentityFacePerson record);
}