package com.junit.testdouble.fake;

import com.junit.testdouble.common.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void addMember(String name){
        memberRepository.save(name);
    }

    public String getMemberName(long id){
        return memberRepository.findById(id).getName();
    }
}
