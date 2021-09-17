package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.SellerVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    public void insertSellerInfo(SellerVO vo);
    public Integer selectSellerInfoById(String id);
    public List<SellerVO> selectSellerInfoAll();
    public void deleteSellerInfo(Integer seq);
}
