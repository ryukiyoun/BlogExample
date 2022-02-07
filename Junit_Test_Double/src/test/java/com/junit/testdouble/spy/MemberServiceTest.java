package com.junit.testdouble.spy;

import com.junit.testdouble.common.Member;
import com.junit.testdouble.common.MemberRepository;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MemberServiceTest {

    @Test
    void encodeName() {
        MemberRepository memberRepository = mock(MemberRepository.class);
        MemberService memberService = spy(new MemberService(memberRepository));

        when(memberRepository.findById(anyLong())).thenReturn(Member.builder().id(1).name("홍길동").build());
        when(memberService.encode(anyString())).thenReturn("encodeStr");

        assertThat(memberService.encodeName(1), is("encodeStr"));
    }
}