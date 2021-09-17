package com.greenart.service;

import java.util.List;

import com.greenart.mapper.SellerMapper;
import com.greenart.vo.SellerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerMapper mapper;

    public boolean insertSellerInfo(SellerVO vo) {
        Integer cnt = mapper.selectSellerInfoById(vo.getSi_id());
        if(cnt != 0) {
            return false;
        }

        if(vo.getSi_id() == "" || vo.getSi_id() == null || vo.getSi_id().length() < 4) {
            return false;
        }

        if(vo.getSi_pwd() == "" || vo.getSi_pwd() == null || vo.getSi_pwd().length() < 6) {
            return false;
        }

        if(vo.getSi_name() == "" || vo.getSi_name() == null) {
            return false;
        }

        if(vo.getSi_address() == "" || vo.getSi_address() == null) {
            return false;
        }

        if(vo.getSi_email() == "" || vo.getSi_email() == null) {
            return false;
        }

        if(vo.getSi_phone() == "" || vo.getSi_phone() == null) {
            return false;
        }

        mapper.insertSellerInfo(vo);
        return true;
    }

    public boolean checkSellerId(String id) {
        Integer r = mapper.selectSellerInfoById(id);
        if(r == 0) {
            return false;
        }
        return true;
    }

    public List<SellerVO> selectSellerInfoAll() {
        return mapper.selectSellerInfoAll();
    }

    public void deleteSellerInfo(Integer seq) {
        mapper.deleteSellerInfo(seq);
    }
}
