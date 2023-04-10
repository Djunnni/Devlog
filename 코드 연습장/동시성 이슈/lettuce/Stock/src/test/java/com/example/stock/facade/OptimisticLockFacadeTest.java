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
public class OptimisticLockFacadeTest {
    @Autowired
    private OptimisticLockStockFacade optimisticLockStockFacade;

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

    // optimisticLock의 경우 pessimistic보다 lock을 잡고 있지않아 성능상의 이점이 있다.
    // 단점으로는 업데이트 실패시 재시도 로직을 개발자가 직접 작성하며, 충돌이 빈번히 일어난다면 pessimisticlock을 이용하는게 성능상 이점이 될 수 있다.
    @Test
    public void 동시에_100개_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService excutorService = Executors.newFixedThreadPool(32); // 비동기 작업을 단순하게 사용하게 제공하는 자바 API
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            excutorService.submit(() -> {
                try {
                    optimisticLockStockFacade.decrease(1L, 1L);
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
