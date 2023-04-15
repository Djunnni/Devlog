package com.example.orderservice.product.adapter;

import com.example.orderservice.product.application.port.ProductPort;
import com.example.orderservice.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter implements ProductPort {
    private ProductRepository productRepository;

    ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(()-> {throw new RuntimeException("상품이 없습니다.");});
    }
}
