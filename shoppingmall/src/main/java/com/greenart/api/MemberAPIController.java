package com.greenart.api;

import java.util.Map;

import com.greenart.service.MemberService;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {
    @Autowired
    MemberService service;

    @PostMapping("/member/join")
    public Map<String, Object> MemberJoin(@RequestBody MemberInfoVO vo) {
        return service.insertMemberInfo(vo);
    }
}
