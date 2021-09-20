package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public void insertCategory(String name);
    public Integer isDuplicateCategory(String name);
    public List<CategoryVO> selectCategoryAll();
    public void deleteCategory(Integer seq);

    public String selectCategoryNameBySeq(Integer seq);
}
