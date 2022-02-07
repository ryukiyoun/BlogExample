package com.junit.testdouble.spy;

import com.junit.testdouble.common.MemberRepository;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String encodeName(long id){
        return encode(memberRepository.findById(id).getName());
    }

    public String encode(String str){
        return new String(str.getBytes(), StandardCharsets.UTF_8);
    }
}
