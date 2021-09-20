package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.ProductService;
import com.greenart.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired
    ProductService service;

    @PostMapping("/product/regist")
    public Map<String, Object> postProductRegist(@RequestBody ProductVO vo) {
        
        return service.insertProductInfo(vo);
    }

    @GetMapping("/product/list")
    public Map<String, Object> getProductList(
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer category
    ) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectProductInfo(keyword, category);
        resultMap.put("data", list);
        return resultMap;
    }
}
