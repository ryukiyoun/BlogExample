package com.junit.mockmockbean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class MemberServiceMockBeanTest {
    @MockBean
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void addMember() {
        //given
        given(memberRepository.findByName("tester")).willReturn(Optional.empty());
        given(memberRepository.save(any(Member.class))).willReturn(Member.builder().id(3).name("tester").build());

        //when
        long result = memberService.addMember("tester");

        //then
        assertThat(result, is(3L));
    }
}
