package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.DeliveryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    public void insertDeliveryInfo(DeliveryVO vo);
    public Integer selectDeliveryInfoByName(String name);
    public List<DeliveryVO> selectDeliveryInfoAll();
}
