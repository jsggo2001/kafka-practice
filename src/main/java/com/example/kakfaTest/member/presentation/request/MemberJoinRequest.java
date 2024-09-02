package com.example.kakfaTest.member.presentation.request;

import com.example.kakfaTest.member.application.command.CreateMemberCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.Size;
@Getter
@AllArgsConstructor
public class MemberJoinRequest {
    @NotBlank
    @Size(min = 5, max = 15)
    private String loginId;

    @NotBlank
    @Size(min = 8, max = 20)
    private String pwd;

    @NotBlank
    @Size(max = 20)
    private String name;

    public CreateMemberCommand toCommand() {
        return new CreateMemberCommand(
            this.loginId,
            this.pwd,
            this.name
        );
    }
}
