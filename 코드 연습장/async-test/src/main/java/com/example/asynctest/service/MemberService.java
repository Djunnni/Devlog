package com.example.asynctest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MemberService {
    Logger logger = LoggerFactory.getLogger(MemberService.class);
    private CertService certService;

    @Autowired
    public MemberService(CertService certService) {
        this.certService = certService;
    }
    public void certMember() {
        logger.info("대기 시간이 긴 Thread 호출 전 - 1");
        final CompletableFuture<String> certResult = certService.certProcess(1L);
        certResult.thenAccept(result -> {
            logger.info("대기응답이 긴 Thread 응답 결과 {}", result);
            if("false".equals(result)) {
                logger.warn("Cert 인증 실패");
                return;
            }

            logger.info("사용자 최종상태 변경 호출전 - 4");
            logger.info("대기응답이 긴 Thread 호출 후 - 1");
        });

        logger.info("대기응답이 짧은 사용자 조회 호출전 - 2");

        logger.info("대기응답이 짧은 사용자 저장 호출후 - 2");
    }
}
