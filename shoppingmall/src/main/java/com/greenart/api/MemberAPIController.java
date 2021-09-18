package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.greenart.service.MemberService;
import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {
    @Autowired
    MemberService service;

    @PostMapping("/member/join")
    public Map<String, Object> MemberJoin(@RequestBody MemberInfoVO vo) {
        return service.insertMemberInfo(vo);
    }

    @GetMapping("/member/id_check")
    public Map<String, Object> getMemberIdCheck(@RequestParam String id) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedId(id) == true) {
            resultMap.put("status", false);
            resultMap.put("message", "[ "+id+" ] 는 이미 사용중인 아이디입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "[ "+id+" ] 는 사용하실 수 있습니다.");

        return resultMap;
    }

    @GetMapping("/member/email_check")
    public Map<String, Object> getMemberEmailCheck(@RequestParam String email) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(service.isDuplicatedEmail(email) == true) {
            resultMap.put("status", false);
            resultMap.put("message", "이미 사용중인 이메일입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "사용 가능한 이메일입니다.");

        return resultMap;
    }

    @PostMapping("/member/login")
    public Map<String, Object> postMemberLogin(@RequestBody LoginVO vo, HttpSession session) {
        Map<String, Object> resultMap = service.MemberLogin(vo);
        session.setAttribute("member", resultMap.get("member"));

        return resultMap;
    }

    @GetMapping("/member/list")
    public Map<String, Object> getMemberInfoAll() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<MemberInfoVO> list = service.selectMemberInfoAll();
        resultMap.put("data", list);

        return resultMap;
    }

    @DeleteMapping("/member/delete")
    public Map<String, Object> deleteMemberInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteMemberInfo(seq);

        resultMap.put("message", "삭제가 완료되었습니다.");
        return resultMap;
    }
}
