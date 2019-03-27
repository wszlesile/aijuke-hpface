package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.Customer;

import java.util.Map;

/**
 * @description: ${description}
 * @author: wsz
 * @create: 2019-03-21 15:54
 **/
public interface CustomerExtendsMapper extends CustomerMapper{
    Customer selectOneByParams(Map<String,Object> params);
}
