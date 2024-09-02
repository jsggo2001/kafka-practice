package com.example.kakfaTest.member.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@DynamicInsert
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String loginId;

    private String pwd;

    private String name;

    private LocalDateTime createTime;

    private Timestamp updateTime;

    Member(String loginId, String pwd, String name, LocalDateTime createTime, Timestamp updateTime) {
        this.loginId = loginId;
        this.pwd = pwd;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public static Member create(
            String loginId,
            String pwd,
            String name) {
        return new Member(
          loginId,
          pwd,
          name,
          LocalDateTime.now(),
          Timestamp.valueOf(LocalDateTime.now())
        );
    }
}
