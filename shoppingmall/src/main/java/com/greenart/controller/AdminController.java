package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdmin() {
        return "/admin/main";
    }
    @GetMapping("/admin/category")
    public String getCategory() {
        return "/admin/category";
    }
    @GetMapping("/admin/seller")
    public String getSeller() {
        return "/admin/seller";
    }
    @GetMapping("/admin/delivery")
    public String getDelivery() {
        return "/admin/delivery";
    }
    @GetMapping("/admin/product")
    public String getProduct() {
        return "/admin/product";
    }
    @GetMapping("/admin/member")
    public String getMember() {
        return "/admin/member";
    }
    @GetMapping("/admin/recommand")
    public String getRecommand() {
        return "/admin/recommand";
    }
}
