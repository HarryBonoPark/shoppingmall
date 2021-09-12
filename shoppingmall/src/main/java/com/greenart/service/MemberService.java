package com.greenart.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.mapper.MemberMapper;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberMapper mapper;

    public Map<String, Object> insertMemberInfo(MemberInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        resultMap.put("status", true);
        resultMap.put("message", "회원가입이 완료되었습니다.");

        mapper.insertMemberInfo(vo);

        return resultMap;
    }

    public boolean isDuplicatedId(String id) {
        return mapper.selectMemberById(id) > 0;
    }

    public boolean isDuplicatedEmail(String email) {
        return mapper.selectMemberByEmail(email) > 0;
    }
}
