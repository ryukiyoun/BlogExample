package com.jpa.convert.repository;

import com.jpa.convert.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<NameEntity, Long> {
}
