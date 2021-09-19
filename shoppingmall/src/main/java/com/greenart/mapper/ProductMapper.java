package com.greenart.mapper;

import com.greenart.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public void insertProductInfo(ProductVO vo);
}
