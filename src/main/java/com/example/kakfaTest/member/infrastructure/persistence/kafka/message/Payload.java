package com.example.kakfaTest.member.infrastructure.persistence.kafka.message;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class Payload {

    private String login_id;

    private String pwd;

    private String name;

    private String create_time;

    private String update_time;
}
