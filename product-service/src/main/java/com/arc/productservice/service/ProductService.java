package com.arc.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arc.productservice.dto.ProductRequest;
import com.arc.productservice.dto.ProductResponse;
import com.arc.productservice.model.Product;
import com.arc.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    
	@Autowired
    private final ProductRepository productRepository;
    public Object getAllProducts;
    
    
    
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build(); // Fixed the typo 'buid' to 'build'
        productRepository.save(product);
        
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> mapToProductResponse(product)).toList();
        
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice()).build();

    }

}
