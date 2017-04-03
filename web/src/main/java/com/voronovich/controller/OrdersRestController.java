package com.voronovich.controller;

import com.voronovich.pojo.*;
import com.voronovich.service.OrderServiceImpl;
import com.voronovich.service.SessionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.voronovich.util.DataConverter.convertDate;


@Controller
public class OrdersRestController {

    private static OrderServiceImpl orderService = OrderServiceImpl.getService();
    private static SessionServiceImpl sessionService = SessionServiceImpl.getService();

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String addOrder(@RequestParam(value = "arr") String [] arr,
                           @PathVariable int id) {
        Order order = new Order();
        List<String> list = new ArrayList<>();
        Tickets ticketOrdered = new Tickets();
        List<Ticket> tickets = new ArrayList<>();
        Collections.addAll(list, arr);
        for (String s : list) {
            Ticket ticket = new Ticket();
            ticket.setRow(Integer.parseInt(s.split("-")[0]));
            ticket.setSeat(Integer.parseInt(s.split("-")[1]));
            ticket.setBooked(0);
            tickets.add(ticket);
        }
        ticketOrdered.setTickets(tickets);
        Session film = sessionService.get(id);
        order.setIdFilm(film.getIdFilm());
        order.setFilm(film.getFilm());
        order.setDate(convertDate(film.getDate()));
        order.setTickets(ticketOrdered);
        orderService.add(order);
        return "redirect:../movies/" + id;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(ModelMap model){
        List<Order> orders = new ArrayList<>();
        orders = orderService.getAllOrders();
        orders.remove(0);
        model.addAttribute("orders", orders);
        return "orders";
    }

    /**
     * Method removes selected order
     *
     * @param ID - order id
     */
    @RequestMapping(value = "/orders/{ID}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable int ID) {
        orderService.delete(ID);
    }

    @RequestMapping(value = "/order/search", method = RequestMethod.GET)
    public String getSearchPage() {
        return "order";
    }

    @RequestMapping(value = "/order/search/order", method = RequestMethod.GET)
    public String getOrder(@RequestParam int id, ModelMap model) {
        model.addAttribute("order", orderService.get(id));
        return "order";
    }
}
