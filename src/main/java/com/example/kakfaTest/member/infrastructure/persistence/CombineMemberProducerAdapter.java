package com.example.kakfaTest.member.infrastructure.persistence;

import com.example.kakfaTest.member.domain.Member;
import com.example.kakfaTest.member.domain.repository.MemberRepository;
import com.example.kakfaTest.member.infrastructure.persistence.jpa.JpaMemberRepository;
import com.example.kakfaTest.member.infrastructure.persistence.kafka.MemberProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CombineMemberProducerAdapter implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    private final MemberProducer memberProducer;

    @Override
    public Member save(Member member) {
        return memberProducer.saveProduce(member);
    }

    @Override
    public Member findById(Long id) {
        return jpaMemberRepository.findById(id).orElseThrow();
    }
}
