package com.example.asynctest;

import com.example.asynctest.service.CertService;
import com.example.asynctest.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsyncTestApplicationTests {

    @Test
    void contextLoads() {

            MemberService test = new MemberService(new CertService());
            test.certMember();

    }

}
