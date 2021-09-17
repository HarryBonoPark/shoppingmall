package com.greenart.service;

import com.greenart.mapper.DeliveryMapper;
import com.greenart.vo.DeliveryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryMapper mapper;

    public boolean insertDeliveryInfo(DeliveryVO vo) {
        Integer cnt = mapper.selectDeliveryInfoByName(vo.getDi_name());
        // 일치하는 배송사 명이 있으면, 가입 불가 (false)
        if(cnt != 0) {
            return false;
        }
        mapper.insertDeliveryInfo(vo);
        
        return true;
    }

    public boolean checkDeliveryName(String name) {
        Integer r = mapper.selectDeliveryInfoByName(name);
        if(r == 0) {
            return false;
        }
        return true;
    }
}
