package com.example.kakfaTest.member.presentation;


import com.example.kakfaTest.member.application.facade.MemberFacade;
import com.example.kakfaTest.member.presentation.request.MemberJoinRequest;
import com.example.kakfaTest.member.presentation.response.MemberJoinResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;

    //회원가입
    @PostMapping("/join")
    public ResponseEntity<Long> test(
            @Valid @RequestBody MemberJoinRequest memberJoinRequest) throws Exception {

        MemberJoinResponse result = MemberJoinResponse.from(
                memberFacade.create(memberJoinRequest.toCommand()).getId()
        );

        return new ResponseEntity<>(result.getMemberId(), HttpStatus.CREATED);
    }
}
