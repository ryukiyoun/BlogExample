package com.jpa.convert.service;

import com.jpa.convert.entity.NameEntity;
import com.jpa.convert.repository.NameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NameService {
    private final NameRepository nameRepository;

    @Transactional
    public NameEntity saveNameEntity(NameEntity entity){
        return nameRepository.save(entity);
    }
}
