package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.service.ProductService;
import com.greenart.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired
    ProductService service;

    @PostMapping("/product/regist")
    public Map<String, Object> postProductRegist(@RequestBody ProductVO vo) {
        
        return service.insertProductInfo(vo);
    }

    @GetMapping("/product/list")
    public Map<String, Object> getProductList(
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer category
    ) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectProductInfo(keyword, category);
        resultMap.put("data", list);
        return resultMap;
    }

    @DeleteMapping("/product/delete")
    public Map<String, Object> deleteProductInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteProductInfo(seq);

        resultMap.put("message", "상품이 삭제되었습니다.");
        return resultMap;
    }

    @GetMapping("/product/get")
    public Map<String, Object> getProductInfo(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        ProductVO vo = service.selectProductInfoBySeq(seq);
        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
    @PatchMapping("/product/update")
    public Map<String, Object> updateProductInfo(@RequestBody ProductVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.updateProductInfo(vo);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");

        return resultMap;
    }

    @GetMapping("/product/recommand")
    public Map<String, Object> getRecommandProduct() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ProductVO> list = service.selectRecommandProduct();
        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }
    @GetMapping("/product/not_recommand")
    public Map<String, Object> getNotRecommandProduct() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ProductVO> list = service.selectNotRecommandProduct();
        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }
    @PutMapping("/product/put_recommand")
    public Map<String, Object> putRecommandProduct(@RequestParam Integer prod_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.insertRecommandProduct(prod_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천 상품이 추가되었습니다.");

        return resultMap;
    }
    @DeleteMapping("/product/delete_recommand")
    public Map<String, Object> deleteRecommandProduct(@RequestParam Integer prod_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteRecommandProduct(prod_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천 상품이 삭제되었습니다.");

        return resultMap;
    }
}
