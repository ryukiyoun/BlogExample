package com.jpa.nplusone;

import com.jpa.nplusone.entity.EagerMember;
import com.jpa.nplusone.entity.EagerTeam;
import com.jpa.nplusone.entity.LazyMember;
import com.jpa.nplusone.entity.LazyTeam;
import com.jpa.nplusone.repository.EagerMemberRepository;
import com.jpa.nplusone.repository.EagerTeamRepository;
import com.jpa.nplusone.repository.LazyMemberRepository;
import com.jpa.nplusone.repository.LazyTeamRepository;
import com.jpa.nplusone.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class NPlusOneTest {
    @Autowired
    EagerTeamRepository eagerTeamRepository;

    @Autowired
    EagerMemberRepository eagerMemberRepository;

    @Autowired
    LazyMemberRepository lazyMemberRepository;

    @Autowired
    LazyTeamRepository lazyTeamRepository;

    @Autowired
    MemberService memberService;

    @AfterEach
    public void reset(){
        eagerMemberRepository.deleteAllInBatch();
        eagerTeamRepository.deleteAllInBatch();

        lazyMemberRepository.deleteAllInBatch();
        lazyTeamRepository.deleteAllInBatch();
    }

    @BeforeEach
    public void init(){
        EagerTeam hongEagerTeam = EagerTeam.builder().id(1).teamName("홍팀").build();

        eagerTeamRepository.save(hongEagerTeam);

        EagerMember eagerMember1 = EagerMember.builder().id(2).name("tester1").eagerTeam(hongEagerTeam).build();

        eagerMemberRepository.save(eagerMember1);

        EagerTeam chungEagerTeam = EagerTeam.builder().id(3).teamName("청팀").build();

        eagerTeamRepository.save(chungEagerTeam);

        EagerMember eagerMember2 = EagerMember.builder().id(4).name("tester1").eagerTeam(chungEagerTeam).build();

        eagerMemberRepository.save(eagerMember2);


        LazyTeam hongLazyTeam = LazyTeam.builder().id(5).teamName("홍팀").build();

        lazyTeamRepository.save(hongLazyTeam);

        LazyMember lazyMember1 = LazyMember.builder().id(6).name("tester1").lazyTeam(hongLazyTeam).build();

        lazyMemberRepository.save(lazyMember1);

        LazyTeam chungLazyTeam = LazyTeam.builder().id(7).teamName("청팀").build();

        lazyTeamRepository.save(chungLazyTeam);

        LazyMember lazyMember2 = LazyMember.builder().id(8).name("tester1").lazyTeam(chungLazyTeam).build();

        lazyMemberRepository.save(lazyMember2);
    }

    @Test
    @DisplayName("즉시 로딩 PK사용 N+1 미발생")
    public void EagerNotNPlusOne(){
        EagerMember eagerMember = eagerMemberRepository.findById(2L).orElseThrow(RuntimeException::new);
    }

    @Test
    @DisplayName("즉시 로딩 메소드명명 N+1 발생")
    public void EagerNPlusOne(){
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllByName("tester1");
    }

    @Test
    @DisplayName("즉시 로딩 Query사용 N+1 발생")
    public void EagerNPlusOne2(){
        List<EagerMember> eagerMembers = eagerMemberRepository.AllByName("tester1");
    }

    @Test
    @DisplayName("지연 로딩 메소드명명 N+1 미발생")
    public void LazyNPlusOne1(){
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllByName("tester1");
    }

    @Test
    @DisplayName("지연 로딩 메소드명명 N+1 발생")
    public void LazyNPlusOne2(){
        assertThat(memberService.getMemberTeamName("tester1").size(), is(2));
    }

    @Test
    @DisplayName("즉시 로딩 Join Fetch N+1 해결")
    public void EagerNPlusOneJoinFetchSolution(){
        List<EagerMember> eagerMembers = eagerMemberRepository.AllByNameJoinFetch("tester1");
    }

    @Test
    @DisplayName("지연 로딩 Join Fetch N+1 해결")
    public void LazyNPlusOneJoinFetchSolution(){
        List<LazyMember> lazyMembers = lazyMemberRepository.AllByNameJoinFetch("tester1");
    }

    @Test
    @DisplayName("즉시 로딩 EntityGraph N+1 해결")
    public void EagerNPlusOneEntityGraphSolution(){
        List<EagerMember> eagerMembers = eagerMemberRepository.AllByNameEntityGraph("tester1");
    }

    @Test
    @DisplayName("지연 로딩 EntityGraph N+1 해결")
    public void LazyNPlusOneEntityGraphSolution(){
        List<LazyMember> lazyMembers = lazyMemberRepository.AllByNameEntityGraph("tester1");
    }
}
