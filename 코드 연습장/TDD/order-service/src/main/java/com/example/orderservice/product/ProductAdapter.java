package com.example.orderservice.product;

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
