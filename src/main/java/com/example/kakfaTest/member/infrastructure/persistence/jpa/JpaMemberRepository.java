package com.example.kakfaTest.member.infrastructure.persistence.jpa;

import com.example.kakfaTest.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {
}
