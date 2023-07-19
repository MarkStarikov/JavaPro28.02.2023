package com.example.homework_23;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.homework_23.dto.ProductDto;
import com.example.homework_23.entity.Product;
import com.example.homework_23.repository.ProductRepository;
import com.example.homework_23.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = Mockito.spy(Mockito.mock(ProductRepository.class));
        productService = new ProductService(productRepository);
    }
    @Test
    public void addToOrderTest(){
        ProductDto productDto = ProductDto.builder().id(1).name("foundry sand").cost(150).build();
        Product saveProduct = Product.builder().id(1).name("foundry sand").cost(150).orderId(1).build();

        when(productRepository.save(any(Product.class))).thenReturn(saveProduct);

        ProductDto result = productService.addToOrder(productDto, 1);

        verify(productRepository).save(any(Product.class));

        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("foundry sand", result.getName());
        Assertions.assertEquals(150, result.getCost());

    }
}
