package com.example.homework_23.controller;

import com.example.homework_23.dto.OrderDto;
import com.example.homework_23.dto.ProductDto;
import com.example.homework_23.service.OrderService;
import com.example.homework_23.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    @GetMapping("/{id}")
    public OrderDto get(@PathVariable int id){
       return orderService.get(id);
    }
    @GetMapping()
    public List<OrderDto>  getAll(){
     return orderService.getAll();
    }
    @PostMapping
    public OrderDto add(@RequestBody OrderDto order){
       return orderService.save(order);
    }
    @PostMapping("/{id}/product")
    public ProductDto add(@PathVariable int id, @RequestBody ProductDto product){
       return productService.addToOrder(product, id);
    }

}
