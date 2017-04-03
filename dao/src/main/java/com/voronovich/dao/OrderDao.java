package com.voronovich.dao;

import com.voronovich.pojo.Order;

import java.util.List;

/**
 * Abstract classes for order functionality
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface OrderDao {

    /**
     * Create order
     *
     * @param order Order
     */
    void add(Order order);

    /**
     * Delete order
     *
     * @param id Order
     */
    void delete(int id);

    /**
     * Returns order by its id
     *
     * @param id Order
     * @return  Order
     */
    Order get(int id);

    /**
     * Returns list of orders
     *
     * @return List<Order>
     */
    List<Order> getAllOrders();
}
