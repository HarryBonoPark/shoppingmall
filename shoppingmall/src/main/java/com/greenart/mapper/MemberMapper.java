package com.greenart.mapper;

import com.greenart.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMemberInfo(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);
}
