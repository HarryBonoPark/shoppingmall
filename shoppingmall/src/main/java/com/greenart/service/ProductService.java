package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.mapper.CategoryMapper;
import com.greenart.mapper.DeliveryMapper;
import com.greenart.mapper.ProductMapper;
import com.greenart.mapper.SellerMapper;
import com.greenart.vo.ProductImageVO;
import com.greenart.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired ProductMapper mapper;
    @Autowired CategoryMapper c_mapper;
    @Autowired SellerMapper s_mapper;
    @Autowired DeliveryMapper d_mapper;
    
    public Map<String, Object> insertProductInfo(ProductVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(vo.getPi_name() == "" || vo.getPi_name() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "제품명을 입력해주세요.");
        }
        if(vo.getPi_price() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "가격을 입력해주세요.");
        }
        if(vo.getPi_cate_seq() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "카테고리를 선택해주세요.");
        }
        if(vo.getPi_si_seq() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "판매자를 선택해주세요.");
        }
        if(vo.getPi_di_seq() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "배송업체를 선택해주세요.");
        }
        if(vo.getPi_price() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "제품 가격을 입력해주세요.");
        }

        if(vo.getPi_stock() == null) vo.setPi_stock(0);
        if(vo.getPi_discount_rate() == null) vo.setPi_discount_rate(0);
        if(vo.getPi_weight() == null) vo.setPi_weight(0);
        if(vo.getPi_point_rate() == null) vo.setPi_point_rate(0);

        mapper.insertProductInfo(vo);

        resultMap.put("status", "success");
        resultMap.put("message", "상품이 추가되었습니다.");

        return resultMap;
    }

    public void insertProductImage(ProductImageVO vo) {
        mapper.insertProductImage(vo);
    }

    public String selectProductImagePath(String uri) {
        return mapper.selectProductImagePath(uri);
    }

    public List<ProductVO> selectProductInfo(String keyword, Integer category) {
        if(keyword == null) { keyword = "%%"; }
        else { keyword = "%"+keyword+"%"; }
        
        List<ProductVO> list = mapper.selectProductInfo(keyword, category);

        for(int i=0; i<list.size(); i++) {
            String cate_name = c_mapper.selectCategoryNameBySeq(list.get(i).getPi_cate_seq());
            list.get(i).setCategory_name(cate_name);
        }
        for(int i=0; i<list.size(); i++) {
            String seller_name = s_mapper.selectSellerNameBySeq(list.get(i).getPi_si_seq());
            list.get(i).setSeller_name(seller_name);
        }
        for(int i=0; i<list.size(); i++) {
            String delivery_name = d_mapper.selectDeliveryNameBySeq(list.get(i).getPi_di_seq());
            list.get(i).setDelivery_name(delivery_name);
        }

        return list;
    }

    public void deleteProductInfo(Integer seq) {
        mapper.deleteProductInfo(seq);
    }

    public ProductVO selectProductInfoBySeq(Integer seq) {
        return mapper.selectProductInfoBySeq(seq);
    }
    public void updateProductInfo(ProductVO vo) {
        mapper.updateProductInfo(vo);
    }

    public List<ProductVO> selectRecommandProduct() {
        List<ProductVO> list = mapper.selectRecommandProduct();

        for(int i=0; i<list.size(); i++) {
            String cate_name = c_mapper.selectCategoryNameBySeq(list.get(i).getPi_cate_seq());
            list.get(i).setCategory_name(cate_name);
        }
        for(int i=0; i<list.size(); i++) {
            String seller_name = s_mapper.selectSellerNameBySeq(list.get(i).getPi_si_seq());
            list.get(i).setSeller_name(seller_name);
        }

        return list;
    }
    public List<ProductVO> selectNotRecommandProduct() {
        List<ProductVO> list = mapper.selectNotRecommandProduct();

        for(int i=0; i<list.size(); i++) {
            String cate_name = c_mapper.selectCategoryNameBySeq(list.get(i).getPi_cate_seq());
            list.get(i).setCategory_name(cate_name);
        }
        for(int i=0; i<list.size(); i++) {
            String seller_name = s_mapper.selectSellerNameBySeq(list.get(i).getPi_si_seq());
            list.get(i).setSeller_name(seller_name);
        }
        
        return list;
    }
    public void insertRecommandProduct(Integer prod_seq) {
        mapper.insertRecommandProduct(prod_seq);
    }
    public void deleteRecommandProduct(Integer prod_seq) {
        mapper.deleteRecommandProduct(prod_seq);
    }

}
