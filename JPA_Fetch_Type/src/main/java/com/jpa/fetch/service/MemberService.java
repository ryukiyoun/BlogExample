package com.jpa.fetch.service;

import com.jpa.fetch.entity.EagerMember;
import com.jpa.fetch.entity.LazyMember;
import com.jpa.fetch.repository.EagerMemberRepository;
import com.jpa.fetch.repository.LazyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final EagerMemberRepository eagerMemberRepository;
    private final LazyMemberRepository lazyMemberRepository;

    @Transactional
    public EagerMember saveEagerMember(EagerMember eagerMember){
        return eagerMemberRepository.save(eagerMember);
    }

    @Transactional
    public LazyMember saveLazyMember(LazyMember lazyMember){
        return lazyMemberRepository.save(lazyMember);
    }

    @Transactional
    public EagerMember getEagerMember(long memberId){
        return eagerMemberRepository.findById(memberId).orElse(null);
    }

    @Transactional
    public LazyMember getLazyMemberAndTeam(long memberId){
        LazyMember member = lazyMemberRepository.findById(memberId).orElse(null);
        String teamName = member.getLazyTeam().getName();
        return member;
    }

    @Transactional
    public LazyMember getLazyMember(long memberId){
        return lazyMemberRepository.findById(memberId).orElse(null);
    }
}
