package com.example.kakfaTest.member.application.facade;

import com.example.kakfaTest.member.application.CreateMemberProcessor;
import com.example.kakfaTest.member.application.SelectMemberProcessor;
import com.example.kakfaTest.member.application.command.CreateMemberCommand;
import com.example.kakfaTest.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final CreateMemberProcessor createMemberProcessor;

    private final SelectMemberProcessor selectMemberProcessor;

    public Member create(CreateMemberCommand command) throws Exception {
        return createMemberProcessor.execute(command);
    }

    public Member select(Long id) throws Exception {
        return selectMemberProcessor.execute(id);
    }
}
