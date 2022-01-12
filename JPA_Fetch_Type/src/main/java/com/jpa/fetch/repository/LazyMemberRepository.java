package com.jpa.fetch.repository;

import com.jpa.fetch.entity.LazyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LazyMemberRepository extends JpaRepository<LazyMember, Long> {
}
