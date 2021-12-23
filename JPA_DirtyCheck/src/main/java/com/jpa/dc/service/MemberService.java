package com.jpa.dc.service;

import com.jpa.dc.entity.Member;
import com.jpa.dc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void changeNickName(long id, String nickName){
        Member member = memberRepository.getById(id);
        member.changeNickName(nickName);
    }
}
