package com.example.kakfaTest.member.presentation.response;

import com.example.kakfaTest.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberSelectResponse {

    private Long id;

    private String loginId;

    private String pwd;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static MemberSelectResponse from(Member member) {
        return new MemberSelectResponse(
                member.getId(),
                member.getLoginId(),
                member.getPwd(),
                member.getName(),
                member.getCreateTime(),
                member.getUpdateTime().toLocalDateTime()
        );
    }
}
