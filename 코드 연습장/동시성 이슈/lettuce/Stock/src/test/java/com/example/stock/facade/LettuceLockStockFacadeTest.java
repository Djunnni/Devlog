package com.example.stock.facade;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LettuceLockStockFacadeTest {
    @Autowired
    private LettuceLockStockFacade lettuceLockStockFacade;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before() {
        Stock stock = new Stock(1L, 100L);
        stockRepository.saveAndFlush(stock);
    }
    @AfterEach
    public void after() {
        stockRepository.deleteAll();
    }

    // lettuce는 mysql 네임드락과 유사하다. 레디스를 활용한다는 점과 세션관리에 신경 안써도 됨.
    // 스핀락으로 레디스에 부하를 줄 수 있다. 락 획득 전까지 sleep을 활용해 락 획득 재시도에 텀을 준다.
    @Test
    public void 동시에_100개_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService excutorService = Executors.newFixedThreadPool(32); // 비동기 작업을 단순하게 사용하게 제공하는 자바 API
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            excutorService.submit(() -> {
                try {
                    lettuceLockStockFacade.decrease(1L, 1L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 다른 스레드에서 작업이 완료될때까지 기다려줌


        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertEquals(0L, stock.getQuantity()); // race 컨디션으로 인해 깨짐
    }
}
