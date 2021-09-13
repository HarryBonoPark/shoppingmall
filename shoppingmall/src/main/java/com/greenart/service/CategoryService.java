package com.greenart.service;

import java.util.List;

import com.greenart.mapper.CategoryMapper;
import com.greenart.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper mapper;

    public boolean addCategory(String name) {
        Integer n = mapper.isDuplicateCategory(name);
        // 등록된 카테고리 명이 있는가?
        if(n != 0) {
            // 이미 존재하는 카테고리가 있으므로, 실패처리
            return false;
        }
        // 카테고리가 존재하지 않으면, 추가를 한다.
        mapper.insertCategory(name);

        return true;
    }

    public List<CategoryVO> selectCategoryAll() {
        return mapper.selectCategoryAll();
    }

    public void deleteCategory(Integer seq) {
        mapper.deleteCategory(seq);
    }
}
