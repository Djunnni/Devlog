package com.example.asynctest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CertService {
    Logger logger = LoggerFactory.getLogger(CertService.class);

    @Async
    public CompletableFuture<String> certProcess(long memberId) {
        String result = "false";
        try {
            Thread.sleep(1000);
            System.out.println(memberId);
            result = "true";
        } catch(InterruptedException e) {
            logger.error("CertService Error -> {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(result);
    }
}
