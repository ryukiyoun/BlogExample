package com.jpa.fetch.service;

import com.jpa.fetch.entity.EagerTeam;
import com.jpa.fetch.entity.LazyTeam;
import com.jpa.fetch.repository.EagerTeamRepository;
import com.jpa.fetch.repository.LazyTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final EagerTeamRepository eagerTeamRepository;
    private final LazyTeamRepository lazyTeamRepository;

    @Transactional
    public EagerTeam saveEagerTeam(EagerTeam eagerTeam){
        return eagerTeamRepository.save(eagerTeam);
    }

    @Transactional
    public LazyTeam saveLazyTeam(LazyTeam lazyTeam){
        return lazyTeamRepository.save(lazyTeam);
    }
}