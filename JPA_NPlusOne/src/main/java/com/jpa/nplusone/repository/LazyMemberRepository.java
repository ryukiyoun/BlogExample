package com.jpa.nplusone.repository;

import com.jpa.nplusone.entity.LazyMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LazyMemberRepository extends JpaRepository<LazyMember, Long> {
    List<LazyMember> findAllByName(String name);

    @Query("from LazyMember where name = :name")
    List<LazyMember> AllByName(String name);

    @Query("from LazyMember m join fetch m.lazyTeam where m.name = :name")
    List<LazyMember> AllByNameJoinFetch(String name);

    @EntityGraph(attributePaths = "lazyTeam")
    @Query("from LazyMember where name = :name")
    List<LazyMember> AllByNameEntityGraph(String name);
}
