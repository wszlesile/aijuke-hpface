package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.IdentityFacePerson;

import java.util.Map;

public interface IdentityFacePersonExtendsMapper extends IdentityFacePersonMapper{
   IdentityFacePerson selectOneByParams(Map<String,Object> params);
}