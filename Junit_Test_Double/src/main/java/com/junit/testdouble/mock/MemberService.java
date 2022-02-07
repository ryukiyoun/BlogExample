package com.junit.testdouble.mock;

import com.junit.testdouble.common.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String appendSir(long id){
        return memberRepository.findById(id).getName() + "님";
    }
}
