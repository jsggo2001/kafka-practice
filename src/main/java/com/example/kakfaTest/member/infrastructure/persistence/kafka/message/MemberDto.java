package com.example.kakfaTest.member.infrastructure.persistence.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MemberDto implements Serializable {

    private Schema schema;
    private Payload payload;

}
