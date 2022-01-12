package com.jpa.fetch;

import com.jpa.fetch.entity.EagerMember;
import com.jpa.fetch.entity.EagerTeam;
import com.jpa.fetch.entity.LazyMember;
import com.jpa.fetch.entity.LazyTeam;
import com.jpa.fetch.service.MemberService;
import com.jpa.fetch.service.TeamService;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest
public class JPAFetchTypeTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @BeforeEach
    public void setInit(){
        EagerTeam eagerTeam1 = EagerTeam.builder()
                .name("eagerTeam1")
                .build();

        eagerTeam1 = teamService.saveEagerTeam(eagerTeam1);

        EagerTeam eagerTeam2 = EagerTeam.builder()
                .name("eagerTeam2")
                .build();

        eagerTeam2 = teamService.saveEagerTeam(eagerTeam2);

        EagerMember eagerMember1 = EagerMember.builder()
                .name("eagerMember1")
                .nickName("eagerMember1")
                .age(10)
                .eagerTeam(eagerTeam1)
                .build();

        memberService.saveEagerMember(eagerMember1);

        EagerMember eagerMember2 = EagerMember.builder()
                .name("eagerMember2")
                .nickName("eagerMember2")
                .age(20)
                .eagerTeam(eagerTeam2)
                .build();

        memberService.saveEagerMember(eagerMember2);

        LazyTeam lazyTeam1 = LazyTeam.builder()
                .name("lazyTeam1")
                .build();

        teamService.saveLazyTeam(lazyTeam1);

        LazyTeam lazyTeam2 = LazyTeam.builder()
                .name("lazyTeam2")
                .build();

        teamService.saveLazyTeam(lazyTeam2);

        LazyMember lazyMember1 = LazyMember.builder()
                .name("lazyMember1")
                .nickName("lazyMember1")
                .age(10)
                .lazyTeam(lazyTeam1)
                .build();

        memberService.saveLazyMember(lazyMember1);

        LazyMember lazyMember2 = LazyMember.builder()
                .name("lazyMember2")
                .nickName("lazyMember2")
                .age(20)
                .lazyTeam(lazyTeam2)
                .build();

        memberService.saveLazyMember(lazyMember2);
    }
    
    @Test
    public void eagerMemberSearchTest(){
        EagerMember member = memberService.getEagerMember(3L);

        assertThat(member.getEagerTeam(), is(instanceOf(EagerTeam.class)));
    }

    @Test
    public void lazyMemberSearchTeamTest(){
        LazyMember member = memberService.getLazyMemberAndTeam(7L);

        assertThat(member.getLazyTeam().getName(), is("lazyTeam1"));
    }

    @Test
    public void lazyMemberNonSearchTeamTest(){
        LazyMember member = memberService.getLazyMember(8L);

        assertThat(member.getLazyTeam(), is(instanceOf(HibernateProxy.class)));
    }
}
