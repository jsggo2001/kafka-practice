package com.example.kakfaTest.member.presentation;


import com.example.kakfaTest.member.application.facade.MemberFacade;
import com.example.kakfaTest.member.presentation.request.MemberJoinRequest;
import com.example.kakfaTest.member.presentation.response.MemberJoinResponse;
import com.example.kakfaTest.member.presentation.response.MemberSelectResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;

    //회원가입
    @PostMapping("/join")
    public ResponseEntity<String> join(
            @Valid @RequestBody MemberJoinRequest memberJoinRequest) throws Exception {

        MemberJoinResponse result = MemberJoinResponse.from(
                memberFacade.create(memberJoinRequest.toCommand()).getLoginId()
        );
        return new ResponseEntity<>(result.getMemberId(), HttpStatus.CREATED);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberSelectResponse> select(
            @PathVariable Long id
    ) throws Exception {
        MemberSelectResponse result = MemberSelectResponse.from(
                memberFacade.select(id)
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
