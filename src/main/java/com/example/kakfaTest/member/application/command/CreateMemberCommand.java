package com.example.kakfaTest.member.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateMemberCommand {

    private String loginId;

    private String pwd;

    private String name;
}
