package com.junit.testdouble.fake;

import com.junit.testdouble.common.Member;
import com.junit.testdouble.common.MemberRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MemberServiceTest {

    @Test
    void addMember() {
        MemberService memberService = new MemberService(new FakeMemberRepository());

        memberService.addMember("test1");
    }

    @Test
    void getMemberName() {
        MemberService memberService = new MemberService(new FakeMemberRepository());

        memberService.addMember("test1");
        memberService.addMember("test2");
        memberService.addMember("test3");

        assertThat(memberService.getMemberName(1), is("test1"));
        assertThat(memberService.getMemberName(2), is("test2"));
        assertThat(memberService.getMemberName(3), is("test3"));
    }

    public static class FakeMemberRepository implements MemberRepository {
        private long sequenceId = 1;

        private final Map<Long, Member> DB = new HashMap<>();

        @Override
        public void save(String name) {
            DB.put(sequenceId, Member.builder().id(sequenceId).name(name).build());
            sequenceId++;
        }

        @Override
        public Member findById(long id) {
            return DB.get(id);
        }
    }
}