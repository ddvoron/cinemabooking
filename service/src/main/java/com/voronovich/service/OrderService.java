package com.voronovich.service;

import com.voronovich.pojo.Order;

import java.util.List;

public interface OrderService {

    void add(Order order);

    void delete(int id);

    Order get(int id);

    List<Order> getAllOrders();
}
