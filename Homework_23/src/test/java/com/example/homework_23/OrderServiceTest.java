package com.example.homework_23;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.homework_23.dto.OrderDto;
import com.example.homework_23.dto.ProductDto;
import com.example.homework_23.entity.Order;
import com.example.homework_23.entity.Product;
import com.example.homework_23.repository.OrderRepository;
import com.example.homework_23.repository.ProductRepository;
import com.example.homework_23.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceTest {
    private  OrderRepository orderRepository;
    private ProductRepository productRepository;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderRepository = Mockito.mock(OrderRepository.class);
        productRepository = Mockito.spy(Mockito.mock(ProductRepository.class));
        orderService = new OrderService(orderRepository,productRepository);
    }
    @Test
    public void getTest(){
        int orderId = 43;
        Date date = Date.valueOf(LocalDate.of(2023, 7, 11)); //insert current date here
        List<Product> products = List.of(
                Product.builder().cost(59).name("paper").orderId(orderId).build(),
                Product.builder().cost(41).name("glue").orderId(orderId).build(),
                Product.builder().cost(50).name("thread").orderId(orderId).build()

        );
        Order order = Order.builder().id(orderId).date(Date.valueOf(LocalDate.now())).build();

        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));
        when(productRepository.findAllByOrderId(anyInt())).thenReturn(products);

        OrderDto orderDto = orderService.get(orderId);
        Assertions.assertEquals(150, orderDto.getCost());
        Assertions.assertEquals(3, orderDto.getProducts().size());
        Assertions.assertEquals(date, orderDto.getDate());

    }
    @Test
    public void getAllTest(){
        List<Product> bookFactory = List.of(
                Product.builder().cost(59).name("paper").orderId(43).build(),
                Product.builder().cost(41).name("glue").orderId(43).build(),
                Product.builder().cost(50).name("thread").orderId(43).build()
        );
        List<Product> steelPlant= List.of(
                Product.builder().cost(100).name("ore").orderId(44).build(),
                Product.builder().cost(200).name("coal").orderId(44).build(),
                Product.builder().cost(300).name("fire clay").orderId(44).build()
        );

        Mockito.when(orderRepository.findAll()).thenReturn(List.of(
                Order.builder().id(43).date(Date.valueOf(LocalDate.now())).build(),
                Order.builder().id(44).date(Date.valueOf(LocalDate.now())).build()
        ));

        Mockito.when(productRepository.findAllByOrderId(43)).thenReturn(bookFactory);
        Mockito.when(productRepository.findAllByOrderId(44)).thenReturn(steelPlant);

        List<ProductDto> industry = List.of(
                ProductDto.builder().cost(59).name("paper").build(),
                ProductDto.builder().cost(41).name("glue").build(),
                ProductDto.builder().cost(50).name("thread").build(),
                ProductDto.builder().cost(100).name("ore").build(),
                ProductDto.builder().cost(200).name("coal").build(),
                ProductDto.builder().cost(300).name("fire clay").build()
        );
        List<OrderDto> all = orderService.getAll();
        List<ProductDto> total = new ArrayList<>();
        total.addAll(all.get(0).getProducts());
        total.addAll(all.get(1).getProducts());

        Mockito.verify(productRepository, Mockito.times(2)).findAllByOrderId(43);
        Mockito.verify(productRepository, Mockito.times(2)).findAllByOrderId(44);
        Assertions.assertEquals(2, all.size());
        Assertions.assertEquals(750, all.get(1).getCost() + all.get(0).getCost());
        Assertions.assertEquals(industry, total);
    }
    @Test
    public void saveTest(){
        Date date = Date.valueOf(LocalDate.of(2023, 7, 11)); //insert current date here

        Order order = Order.builder().id(43).date(Date.valueOf(LocalDate.now())).build();

        OrderDto orderDto = OrderDto.builder().id(43).date(Date.valueOf(LocalDate.now())).cost(150).products(new ArrayList<>()).build();

        when(orderRepository.save(any(Order.class))).thenReturn(order);
        OrderDto result = orderService.save(orderDto);
        verify(orderRepository).save(any(Order.class));

        Assertions.assertEquals(43, result.getId());
        Assertions.assertEquals(0, result.getCost());
        Assertions.assertEquals(date, result.getDate());

    }
}
