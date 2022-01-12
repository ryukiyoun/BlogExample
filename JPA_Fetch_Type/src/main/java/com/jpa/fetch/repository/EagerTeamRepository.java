package com.jpa.fetch.repository;

import com.jpa.fetch.entity.EagerTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EagerTeamRepository extends JpaRepository<EagerTeam, Long> {
}
