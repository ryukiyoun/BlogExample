package com.jpa.fetch.repository;

import com.jpa.fetch.entity.LazyTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LazyTeamRepository extends JpaRepository<LazyTeam, Long> {
}
