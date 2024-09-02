package com.example.kakfaTest.member.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberJoinResponse {

    private Long memberId;

    public static MemberJoinResponse from(Long memberId) {
        MemberJoinResponse response = new MemberJoinResponse(memberId);
        return response;
    }

}
