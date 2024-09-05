package com.example.kakfaTest.member.infrastructure.persistence.kafka;

import com.example.kakfaTest.member.domain.Member;
import com.example.kakfaTest.member.infrastructure.persistence.kafka.message.Field;
import com.example.kakfaTest.member.infrastructure.persistence.kafka.message.MemberDto;
import com.example.kakfaTest.member.infrastructure.persistence.kafka.message.Payload;
import com.example.kakfaTest.member.infrastructure.persistence.kafka.message.Schema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class MemberProducer {

    private static final String TOPIC = "member-topic";

    List<Field> fields = Arrays.asList(new Field("string",true,"login_id"),
            new Field("string",true,"pwd"),
            new Field("string",true,"name"),
            new Field("string",true,"create_time"),
            new Field("string",true,"update_time"));
    Schema schema = Schema.builder()
            .type("struct")
            .fields(fields)
            .optional(false)
            .name("member")
            .build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Member saveProduce(Member member) {

        LocalDateTime dateTime = member.getUpdateTime().toLocalDateTime();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        String formattedDate = dateFormat.format(dateTime);

        Payload payload = Payload.builder()
                .login_id(member.getLoginId())
                .pwd(member.getPwd())
                .name(member.getName())
                .create_time(member.getCreateTime().toString())
                .update_time(formattedDate)
                .build();

        MemberDto memberDto = new MemberDto(schema, payload);
//        String key = member.getId() != null ? String.valueOf(member.getId()) : UUID.randomUUID().toString();
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(memberDto);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        kafkaTemplate.send(TOPIC, jsonString);

        return member;
    }
}
