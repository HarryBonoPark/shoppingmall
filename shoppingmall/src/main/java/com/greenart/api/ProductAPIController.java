package com.greenart.api;

import java.util.Map;

import com.greenart.service.ProductService;
import com.greenart.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired
    ProductService service;

    @PostMapping("/product/regist")
    public Map<String, Object> postProductRegist(@RequestBody ProductVO vo) {
        
        return service.insertProductInfo(vo);
    }
}
