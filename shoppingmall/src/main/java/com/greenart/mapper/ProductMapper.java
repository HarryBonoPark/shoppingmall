package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.ProductImageVO;
import com.greenart.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public void insertProductInfo(ProductVO vo);

    public void insertProductImage(ProductImageVO vo);
    public String selectProductImagePath(String uri);

    public List<ProductVO> selectProductInfo(String keyword, Integer category);

    public void deleteProductInfo(Integer seq);

    public ProductVO selectProductInfoBySeq(Integer seq);
    public void updateProductInfo(ProductVO vo);

    public List<ProductVO> selectRecommandProduct();
    public List<ProductVO> selectNotRecommandProduct();
    public void insertRecommandProduct(Integer prod_seq);
    public void deleteRecommandProduct(Integer prod_seq);
}
