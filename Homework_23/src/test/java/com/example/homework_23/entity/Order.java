package com.example.homework_23.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("orders")
@Data
@Builder
public class Order {
    @Id
    private int id;
    private Date date;
}
