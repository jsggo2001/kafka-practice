package com.example.kakfaTest.member.infrastructure.persistence;

import com.example.kakfaTest.member.domain.Member;
import com.example.kakfaTest.member.domain.repository.MemberRepository;
import com.example.kakfaTest.member.infrastructure.persistence.jpa.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryAdapter implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public Member save(Member member) {

        Member savedMember = jpaMemberRepository.save(member);

        return savedMember;
    }

}
