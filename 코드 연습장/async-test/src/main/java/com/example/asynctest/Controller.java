package com.example.asynctest;

import com.example.asynctest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    private final MemberService memberService;

    @Autowired
    public Controller(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public void call() {
        memberService.certMember();
        /**
         * 2023-04-26T09:18:17.421+09:00  INFO 10505 --- [nio-8080-exec-1] c.e.asynctest.service.MemberService      : 대기 시간이 긴 Thread 호출 전 - 1
         * 2023-04-26T09:18:17.426+09:00  INFO 10505 --- [nio-8080-exec-1] c.e.asynctest.service.MemberService      : 대기응답이 짧은 사용자 조회 호출전 - 2
         * 2023-04-26T09:18:17.427+09:00  INFO 10505 --- [nio-8080-exec-1] c.e.asynctest.service.MemberService      : 대기응답이 짧은 사용자 저장 호출후 - 2
         *
         * 2023-04-26T09:18:18.430+09:00  INFO 10505 --- [   TEST-ASYNC-1] c.e.asynctest.service.MemberService      : 대기응답이 긴 Thread 응답 결과 true
         * 2023-04-26T09:18:18.436+09:00  INFO 10505 --- [   TEST-ASYNC-1] c.e.asynctest.service.MemberService      : 사용자 최종상태 변경 호출전 - 4
         * 2023-04-26T09:18:18.436+09:00  INFO 10505 --- [   TEST-ASYNC-1] c.e.asynctest.service.MemberService      : 대기응답이 긴 Thread 호출 후 - 1
         */
    }

}
