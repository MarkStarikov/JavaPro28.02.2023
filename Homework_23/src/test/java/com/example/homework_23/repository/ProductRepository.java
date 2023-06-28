package com.example.homework_23.repository;

import com.example.homework_23.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByOrderId(int orderId);

    List<Product> saveAll(List<Product> products);
}
