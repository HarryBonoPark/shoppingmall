package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.service.SellerService;
import com.greenart.vo.SellerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerAPIController {
    @Autowired
    SellerService service;

    @PostMapping("/seller/regist")
    public Map<String, Object> postSellerRegist(@RequestBody SellerVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Boolean r = service.insertSellerInfo(vo);
        if(r) {
            resultMap.put("result", "success");
            resultMap.put("message", "회원가입이 성공적으로 완료되었습니다.");
        }
        
        return resultMap;
    }
}
