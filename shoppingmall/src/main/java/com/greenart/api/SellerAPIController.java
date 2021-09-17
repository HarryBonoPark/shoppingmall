package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.SellerService;
import com.greenart.vo.SellerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
            resultMap.put("message", "업체가 등록되었습니다.");
        }
        
        return resultMap;
    }

    @GetMapping("/seller/checkId")
    public Map<String, Object> getCheckSellerId(@RequestParam String id) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(service.checkSellerId(id)) {
            resultMap.put("status", true);
            resultMap.put("message", "아이디가 중복됩니다.");
        }
        else {
            resultMap.put("status", false);
            resultMap.put("message", "가입 가능한 아이디입니다.");
        }
        return resultMap;
    }

    @GetMapping("/seller/list")
    public Map<String, Object> getSellerInfoAll() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<SellerVO> list = service.selectSellerInfoAll();
        resultMap.put("data", list);

        return resultMap;
    }

    @DeleteMapping("/seller/delete")
    public Map<String, Object> deleteSellerInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteSellerInfo(seq);

        resultMap.put("message", "업체가 삭제되었습니다.");
        return resultMap;
    }
}
