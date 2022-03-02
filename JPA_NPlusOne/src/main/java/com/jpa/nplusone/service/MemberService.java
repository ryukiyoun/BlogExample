package com.jpa.nplusone.service;

import com.jpa.nplusone.entity.LazyMember;
import com.jpa.nplusone.repository.LazyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final LazyMemberRepository lazyMemberRepository;

    @Transactional
    public List<String> getMemberTeamName(String memberName){
        List<LazyMember> eagerMember = lazyMemberRepository.findAllByName(memberName);

        return eagerMember.stream().map(eagerMember1 -> eagerMember1.getLazyTeam().getTeamName())
                .collect(Collectors.toList());
    }
}
