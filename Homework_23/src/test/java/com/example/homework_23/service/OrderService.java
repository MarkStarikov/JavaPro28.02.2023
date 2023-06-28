package com.example.homework_23.service;

import com.example.homework_23.NoEntityException;
import com.example.homework_23.convertor.OrderConvertor;
import com.example.homework_23.dto.OrderDto;
import com.example.homework_23.entity.Order;
import com.example.homework_23.entity.Product;
import com.example.homework_23.repository.OrderRepository;
import com.example.homework_23.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDto get(int id){
         return orderRepository.findById(id)
                 .map(order -> OrderConvertor.toOrderDto(order, productRepository.findAllByOrderId(id)))
                 .orElseThrow(() -> new NoEntityException("Entity with id"+ id + "not found"));


    }
    public List<OrderDto> getAll(){
        return orderRepository.findAll().stream()
                .map(order -> OrderConvertor.toOrderDto(order, productRepository.findAllByOrderId(order.getId())))
                .toList();
    }
    public OrderDto save(OrderDto orderDto){
        Order order = Order.builder()
                .date(Date.valueOf(LocalDate.now())).build();
        Order saveOrder = orderRepository.save(order);
        List<Product> products = orderDto.getProducts().stream()
                .map(productDto -> Product.builder()
                        .cost(productDto.getCost())
                        .name(productDto.getName())
                        .orderId(saveOrder.getId()).build())
                .toList();
        products = productRepository.saveAll(products);
        return OrderConvertor.toOrderDto(saveOrder, products);
    }
}
