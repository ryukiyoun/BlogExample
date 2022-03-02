package com.jpa.nplusone.repository;

import com.jpa.nplusone.entity.EagerMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EagerMemberRepository extends JpaRepository<EagerMember, Long> {
    List<EagerMember> findAllByName(String name);

    @Query("from EagerMember where name = :name")
    List<EagerMember> AllByName(String name);

    @Query("from EagerMember m join fetch m.eagerTeam where m.name = :name")
    List<EagerMember> AllByNameJoinFetch(String name);

    @EntityGraph(attributePaths = "eagerTeam")
    @Query("from EagerMember where name = :name")
    List<EagerMember> AllByNameEntityGraph(String name);
}
