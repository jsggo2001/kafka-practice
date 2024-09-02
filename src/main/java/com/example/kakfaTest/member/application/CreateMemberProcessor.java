package com.example.kakfaTest.member.application;

import com.example.kakfaTest.member.application.command.CreateMemberCommand;
import com.example.kakfaTest.member.domain.Member;
import com.example.kakfaTest.member.domain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMemberProcessor {

    private final MemberRepository memberRepository;

//    public CreateMemberProcessor(@Qualifier("jpaMemberRepository") MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Transactional
    public Member execute(CreateMemberCommand command) throws Exception {

        Member member = Member.create(
                command.getLoginId(),
                command.getPwd(),
                command.getName()
        );

        return memberRepository.save(member);
    }

}
