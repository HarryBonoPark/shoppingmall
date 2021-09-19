package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.mapper.ProductMapper;
import com.greenart.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductMapper mapper;
    
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
}
