package com.example.stock.service;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StockServiceTest {
    @Autowired
    private PessimisticLockStockService stockService;

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

    @Test
    public void stock_decrease() {
        stockService.decrease(1L, 1L);
        // 100 - 1 = 99

        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertEquals(99, stock.getQuantity());
    }

    // Hibernate: select stock0_.id as id1_0_, stock0_.product_id as product_2_0_, stock0_.quantity as quantity3_0_ from stock stock0_ where stock0_.id=? for update
    // 장점: 충돌이 빈번히 일어난다면 OPTIMISTIC LOCK보다 성능이 좋을 수 있다. 락을 통해 업데이트를 수행하다보니 데이터 정합성이 어느정도 보장
    // 별도의 락을 잡고있어 성능저하가 있다.
    @Test
    public void 동시에_100개_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService excutorService = Executors.newFixedThreadPool(32); // 비동기 작업을 단순하게 사용하게 제공하는 자바 API
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            excutorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1L);
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
