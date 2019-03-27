package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.CustomerAllocationRecord;

import java.util.Map;

/**
 * @description: ${description}
 * @author: wsz
 * @create: 2019-03-21 15:44
 **/
public interface CustomerAllocationRecordExtendsMapper extends CustomerAllocationRecordMapper{
    CustomerAllocationRecord selectTodayByParams(Map<String, Object> params);
}
