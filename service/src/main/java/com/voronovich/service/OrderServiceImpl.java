package com.voronovich.service;

import com.voronovich.dao.OrderDaoImpl;
import com.voronovich.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderServiceImpl() {
    }

    private static OrderServiceImpl service = null;

    public static OrderServiceImpl getService() {
        if (service == null) {
            synchronized (OrderServiceImpl.class) {
                if (service == null) {
                    service = new OrderServiceImpl();
                }
            }
        }
        return service;
    }

    private OrderDaoImpl dao = OrderDaoImpl.getDao();


    public void add(Order order) {
        dao.add(order);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Order get(int id) {
        return dao.get(id);
    }

    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    public List<Ticket> addOrderedDefinition(List<Ticket> tickets, List<Order> orders, int id) {
        for (Order o : orders) {
            if (o.getIdFilm() == id) {
                List<Ticket> orderedTickets = new ArrayList<>();
                orderedTickets = o.getTickets().getTickets();
                tickets.addAll(orderedTickets);
            }
        }
        return tickets;
    }
}
