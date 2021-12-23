package com.jpa.dc;

import com.jpa.dc.entity.DynamicUpdateMember;
import com.jpa.dc.entity.Member;
import com.jpa.dc.repository.DynamicUpdateMemberRepository;
import com.jpa.dc.repository.MemberRepository;
import com.jpa.dc.service.DynamicUpdateMemberService;
import com.jpa.dc.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class DirtyCheckingTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DynamicUpdateMemberService dynamicUpdateMemberService;

    @Autowired
    DynamicUpdateMemberRepository dynamicUpdateMemberRepository;

    @Test
    public void Spring_Data_JPA_Dirty_Checking(){
        Member member = Member.builder()
                .name("tom")
                .nickName("tomato")
                .build();

        member = memberRepository.save(member);

        long id = member.getId();

        memberService.changeNickName(id, "tomato_ju");

        Member findMember = memberRepository.findById(id).orElse(null);

        assertThat(findMember, notNullValue());
        assertThat(findMember.getNickName(), is("tomato_ju"));
    }

    @Test
    public void Spring_Data_JPA_Dirty_Checking_DynamicUpdate(){
        DynamicUpdateMember member = DynamicUpdateMember.builder()
                .name("tom")
                .nickName("tomato")
                .build();

        member = dynamicUpdateMemberRepository.save(member);

        long id = member.getId();

        dynamicUpdateMemberService.changeNickName(id, "tomato_ju");

        DynamicUpdateMember findMember = dynamicUpdateMemberRepository.findById(id).orElse(null);

        assertThat(findMember, notNullValue());
        assertThat(findMember.getNickName(), is("tomato_ju"));
    }
}