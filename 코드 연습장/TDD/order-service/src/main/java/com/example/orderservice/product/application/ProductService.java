package com.example.orderservice.product.application;

import com.example.orderservice.product.application.port.ProductPort;
import com.example.orderservice.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public
class ProductService {
    private ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public GetProductResponse getProduct(long productId) {
        final Product p = productPort.getProduct(productId);
        return new GetProductResponse(p.getId(),p.getName(),p.getPrice(),p.getDiscountPolicy());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        final Product product = productPort.getProduct(productId);

        final GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy()
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@PathVariable final Long productId,@RequestBody final UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.ok().build();
    }
}
