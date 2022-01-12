package com.jpa.fetch.repository;

import com.jpa.fetch.entity.EagerMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EagerMemberRepository extends JpaRepository<EagerMember, Long> {
}
