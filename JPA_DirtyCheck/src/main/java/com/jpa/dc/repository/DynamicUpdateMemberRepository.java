package com.jpa.dc.repository;

import com.jpa.dc.entity.DynamicUpdateMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicUpdateMemberRepository extends JpaRepository<DynamicUpdateMember, Long> {
}
