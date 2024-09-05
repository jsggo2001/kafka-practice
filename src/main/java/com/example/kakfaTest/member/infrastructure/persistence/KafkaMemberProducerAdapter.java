//package com.example.kakfaTest.member.infrastructure.persistence;
//
//import com.example.kakfaTest.member.domain.Member;
//import com.example.kakfaTest.member.domain.repository.MemberRepository;
//import com.example.kakfaTest.member.infrastructure.persistence.kafka.MemberProducer;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@RequiredArgsConstructor
//public class KafkaMemberProducerAdapter implements MemberRepository {
//
//    private final MemberProducer memberProducer;
//
//    @Override
//    public Member save(Member member) {
//        return memberProducer.saveProduce(member);
//    }
//
//}
