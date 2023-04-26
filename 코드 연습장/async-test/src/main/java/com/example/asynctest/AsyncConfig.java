package com.example.asynctest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {
    @Bean
    public ThreadPoolTaskExecutor threadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 병렬로 동시에 실행시킬 쓰레드의 개수
        executor.setMaxPoolSize(30); // 쓰레드풀의 최대 사이즈
        executor.setQueueCapacity(50); // 쓰레드 풀 큐 사이즈, corePool사이즈가 넘었을 때, queue에 테스크가 쌓임
        executor.setThreadNamePrefix("TEST-ASYNC-");
        executor.initialize();
        return executor;
    }
}