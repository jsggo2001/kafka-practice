package com.example.kakfaTest.member.application;

import com.example.kakfaTest.member.domain.Member;
import com.example.kakfaTest.member.domain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectMemberProcessor {

    private final MemberRepository memberRepository;

    @Transactional
    public Member execute(Long id) throws Exception {
        return memberRepository.findById(id);
    }
}
