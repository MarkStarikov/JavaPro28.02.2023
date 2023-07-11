package com.example.homework_23.convertor;

import com.example.homework_23.dto.OrderDto;
import com.example.homework_23.dto.ProductDto;
import com.example.homework_23.entity.Order;
import com.example.homework_23.entity.Product;

import java.util.List;

public class OrderConvertor {
    public static OrderDto toOrderDto(Order order, List<Product> products){
        List<ProductDto> productDtos = products.stream().map(p -> ProductDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .cost(p.getCost())
                        .build())
                .toList();
        int sum = productDtos.stream()
                .mapToInt(ProductDto::getCost)
                .sum();
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(sum)
                .products(productDtos)
                .build();
    }
}
