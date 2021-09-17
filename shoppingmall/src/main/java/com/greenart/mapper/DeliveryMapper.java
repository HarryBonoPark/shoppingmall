package com.greenart.mapper;

import com.greenart.vo.DeliveryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    public void insertDeliveryInfo(DeliveryVO vo);
    public Integer selectDeliveryInfoByName(String name);
}