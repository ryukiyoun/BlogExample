package com.junit.mockmockbean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMethodTest {

    @Test
    void addMember() {
        MemberRepository memberRepository = mock(MemberRepository.class);
        MemberService memberService = new MemberService(memberRepository);

        //given
        given(memberRepository.findByName("tester")).willReturn(Optional.empty());
        given(memberRepository.save(any(Member.class))).willReturn(Member.builder().id(3).name("tester").build());

        //when
        long result = memberService.addMember("tester");

        //then
        assertThat(result, is(3L));
    }
}
