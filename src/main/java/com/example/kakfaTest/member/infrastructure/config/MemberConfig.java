package com.example.kakfaTest.member.infrastructure.config;

import com.example.kakfaTest.member.application.CreateMemberProcessor;
import com.example.kakfaTest.member.application.SelectMemberProcessor;
import com.example.kakfaTest.member.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
//    public CreateMemberProcessor createMemberProcessor(@Qualifier("jpaMemberRepository") MemberRepository memberRepository) {
    public CreateMemberProcessor createMemberProcessor(@Qualifier("combineMemberRepository") MemberRepository memberRepository) {
        return new CreateMemberProcessor(memberRepository);
    }

    @Bean
//    public CreateMemberProcessor createMemberProcessor(@Qualifier("jpaMemberRepository") MemberRepository memberRepository) {
    public SelectMemberProcessor selectMemberProcessor(@Qualifier("combineMemberRepository") MemberRepository memberRepository) {
        return new SelectMemberProcessor(memberRepository);
    }
}
