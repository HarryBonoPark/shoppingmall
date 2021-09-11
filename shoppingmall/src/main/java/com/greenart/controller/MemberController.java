package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/login")
    public String getLogin() {
        return "/member/login";
    }

    @GetMapping("/join")
    public String getJoin() {
        return "/member/join";
    }
}
