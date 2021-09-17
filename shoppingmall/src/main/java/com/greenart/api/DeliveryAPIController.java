package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.DeliveryService;
import com.greenart.vo.DeliveryVO;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryAPIController {
    @Autowired
    DeliveryService service;

    @PostMapping("/delivery/regist")
    public Map<String, Object> postDeliveryRegist(@RequestBody DeliveryVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Boolean r = service.insertDeliveryInfo(vo);
        if(r) {
            resultMap.put("status", r);
            resultMap.put("message", "배송 업체 등록이 완료되었습니다.");
        }
        return resultMap;
    }

    @GetMapping("/delivery/checkName")
    public Map<String, Object> getCheckDeliveryName(@RequestParam String name) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(service.checkDeliveryName(name)) {
            resultMap.put("status", true);
            resultMap.put("message", "이미 가입된 배송 업체입니다.");
        }
        else {
            resultMap.put("status", false);
            resultMap.put("message", "가입 가능한 배송업체입니다.");
        }
        return resultMap;
    }

    @GetMapping("/delivery/list")
    public Map<String, Object> getDeliveryInfoAll() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<DeliveryVO> list = service.selectDeliveryInfoAll();
        resultMap.put("data", list);

        return resultMap;
    }

    @DeleteMapping("/delivery/delete")
    public Map<String, Object> deleteDeliveryInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteDeliveryInfo(seq);

        resultMap.put("message", "삭제가 완료되었습니다.");
        return resultMap;
    }
}
