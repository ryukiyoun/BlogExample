package com.junit.mockmockbean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public long addMember(String name){
        Member member = memberRepository.findByName(name).orElse(null);

        if(member != null)
            throw new RuntimeException("member is duple");
        else
            return memberRepository.save(Member.builder()
                    .id(1)
                    .name(name)
                    .build()).getId();
    }
}
