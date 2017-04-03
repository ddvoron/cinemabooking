package com.voronovich.dao;

import com.voronovich.pojo.Order;
import com.voronovich.pojo.Orders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static com.voronovich.util.DataConverter.unMarshalingOrders;
import static com.voronovich.util.DataConverter.marshalingOrders;

public class OrderDaoImpl implements OrderDao{

    private OrderDaoImpl(){
    }

    private static OrderDaoImpl dao = null;

    public static OrderDaoImpl getDao(){
        if(dao == null){
            synchronized (OrderDaoImpl.class){
                if(dao==null){
                    dao = new OrderDaoImpl();
                }
            }
        }
        return dao;
    }

    public void add(Order order) {
        Orders orders = unMarshalingOrders();
        int lastInsertId = orders.getOrders().get(orders.getOrders().size() - 1).getIdOrder();
        System.out.println("Last id " + lastInsertId);
        order.setIdOrder(++lastInsertId);
        orders.getOrders().add(order);
        marshalingOrders(orders);
    }

    public void delete(int id) {
        Orders orders = unMarshalingOrders();
        List<Order> orders1 = new ArrayList<>();
        orders1 = orders.getOrders();
        for (Order o : orders1) {
            if(o.getIdOrder()==id){
                orders1.remove(o);
                break;
            }
        }
        marshalingOrders(orders);
    }

    public Order get(int id) {
        Orders orders = unMarshalingOrders();
        for (Order o : orders.getOrders()) {
            if(o.getIdOrder()==id){
                return o;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        Orders orders = unMarshalingOrders();
        return orders.getOrders();
    }
}
