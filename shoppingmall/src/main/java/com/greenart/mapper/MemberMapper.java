package com.greenart.mapper;

import java.util.List;

import com.greenart.vo.LoginVO;
import com.greenart.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMemberInfo(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);

    public Integer MemberLogin(LoginVO vo);
    public MemberInfoVO selectMemberInfo(String id);

    public List<MemberInfoVO> selectMemberInfoAll();
}
