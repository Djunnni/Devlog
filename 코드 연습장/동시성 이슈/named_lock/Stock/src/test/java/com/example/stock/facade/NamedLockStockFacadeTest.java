package com.example.stock.facade;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.PessimisticLockStockService;
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
public class NamedLockStockFacadeTest {
    @Autowired
    private NamedLockStockFacade namedLockStockFacade;

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

    // namedlock은 분산락을 구현할 때, 사용한다. pessimistic_lock은 timeout을 구현하기 힘들지만 namedlock은 손쉽다.
    // 데이터 삽입시 정합성을 맞출 때도 사용할 수 있다. 트랜잭션 종료시 락 해제와 세션관리를 해주는데 중요하며 구현시 로직이 복잡할 수 있다.
    @Test
    public void 동시에_100개_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService excutorService = Executors.newFixedThreadPool(32); // 비동기 작업을 단순하게 사용하게 제공하는 자바 API
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            excutorService.submit(() -> {
                try {
                    namedLockStockFacade.decrease(1L, 1L);
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
