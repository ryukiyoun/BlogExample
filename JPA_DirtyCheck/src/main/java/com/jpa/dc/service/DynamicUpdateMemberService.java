package com.jpa.dc.service;

import com.jpa.dc.entity.DynamicUpdateMember;
import com.jpa.dc.repository.DynamicUpdateMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DynamicUpdateMemberService {
    private final DynamicUpdateMemberRepository dynamicUpdateMemberRepository;

    @Transactional
    public void changeNickName(long id, String nickName){
        DynamicUpdateMember member = dynamicUpdateMemberRepository.getById(id);
        member.changeNickName(nickName);
    }
}
