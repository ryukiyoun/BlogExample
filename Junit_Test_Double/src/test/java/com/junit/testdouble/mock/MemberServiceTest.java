package com.junit.testdouble.mock;

import com.junit.testdouble.common.Member;
import com.junit.testdouble.common.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Test
    void appendSir() {
        MemberRepository memberRepository = mock(MemberRepository.class);
        MemberService memberService = new MemberService(memberRepository);
        
        given(memberRepository.findById(anyLong())).willReturn(Member.builder().id(1).name("홍길동").build());

        assertThat(memberService.appendSir(1), is("홍길동님"));
    }
}