package com.example.stock.transaction;

import com.example.stock.service.StockService;

public class TransactionStockService {

    private StockService stockService;

    public TransactionStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) {
        startTransaction();

        stockService.decrease(id, quantity); // 트랜잭션이 끝나기전에 다른 스레드가 decrease함수에 접근이 가능하다.
        
        endTransaction();
    }

    private void endTransaction() {
    }

    private void startTransaction() {
    }
}
