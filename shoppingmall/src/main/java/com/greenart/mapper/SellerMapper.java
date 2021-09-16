package com.greenart.mapper;

import com.greenart.vo.SellerVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    public void insertSellerInfo(SellerVO vo);
}
