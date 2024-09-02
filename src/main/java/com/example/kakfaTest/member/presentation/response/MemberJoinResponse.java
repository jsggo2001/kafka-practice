package com.example.kakfaTest.member.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberJoinResponse {

    private String memberId;

    public static MemberJoinResponse from(String loginId) {
        MemberJoinResponse response = new MemberJoinResponse(loginId);
        return response;
    }

}
