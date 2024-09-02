package com.example.kakfaTest.member.infrastructure.config;

import com.example.kakfaTest.member.domain.repository.MemberRepository;
import com.example.kakfaTest.member.infrastructure.persistence.MemberRepositoryAdapter;
import com.example.kakfaTest.member.infrastructure.persistence.jpa.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberRepositoryConfig {

    @Bean
    @Qualifier("jpaMemberRepository")
    public MemberRepository MemberRepository(JpaMemberRepository jpaMemberRepository) {
        return new MemberRepositoryAdapter(jpaMemberRepository);
    }

//    @Bean
//    @Qualifier("kafkaMemberRepository")
//    public MemberRepository MemberRepository(KafkaMemberRepository kafkaMemberRepository) {
//        return new MemberRepositoryAdapter(kafkaMemberRepository);
//    }
}
