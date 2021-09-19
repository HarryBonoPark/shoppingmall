package com.greenart.controller;

import java.util.List;

import com.greenart.service.CategoryService;
import com.greenart.service.DeliveryService;
import com.greenart.service.SellerService;
import com.greenart.vo.CategoryVO;
import com.greenart.vo.DeliveryVO;
import com.greenart.vo.SellerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired CategoryService c_service;
    @Autowired SellerService s_service;
    @Autowired DeliveryService d_service;

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
    public String getProduct(Model model) {
        List<CategoryVO> clist = c_service.selectCategoryAll();
        List<SellerVO> slist = s_service.selectSellerInfoAll();
        List<DeliveryVO> dlist = d_service.selectDeliveryInfoAll();

        model.addAttribute("clist", clist);
        model.addAttribute("slist", slist);
        model.addAttribute("dlist", dlist);

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
