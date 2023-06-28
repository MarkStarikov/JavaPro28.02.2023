package com.example.homework_23.service;

import com.example.homework_23.dto.ProductDto;
import com.example.homework_23.entity.Product;
import com.example.homework_23.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductDto addToOrder(ProductDto productDto, int orderId){
        Product product = Product.builder()
                .cost(productDto.getCost())
                .name(productDto.getName())
                .orderId(orderId).build();
        Product save = productRepository.save(product);
        productDto.setId(save.getId());
        return productDto;
    }
}
