package com.aijuke.hpface.mapper;

import com.aijuke.hpface.model.SubOrders;

public interface SubOrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubOrders record);

    int insertSelective(SubOrders record);

    SubOrders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubOrders record);

    int updateByPrimaryKey(SubOrders record);
}