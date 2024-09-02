package com.example.kakfaTest.member.infrastructure.persistence.kafka;

import com.example.kakfaTest.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class MemberProducer {

    private static final String TOPIC = "member_topic";

    @Autowired
    private KafkaTemplate<String, Member> kafkaTemplate;

    public Member saveProduce(Member member) {
        // 프로듀싱 로직 추가

        String key = member.getId() != null ? String.valueOf(member.getId()) : UUID.randomUUID().toString();
        kafkaTemplate.send(TOPIC, key, member);

        return member;
    }
}
