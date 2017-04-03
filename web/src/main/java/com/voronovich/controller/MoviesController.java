package com.voronovich.controller;

import com.voronovich.pojo.*;
import com.voronovich.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MoviesController {

    private static SessionServiceImpl sessionService = SessionServiceImpl.getService();
    private static OrderServiceImpl orderService = OrderServiceImpl.getService();
    private static final int SEATS_NUMBER = 100;

    @RequestMapping(value = {"/", "/movies"}, method = RequestMethod.GET)
    public String showMovies(ModelMap model) {
        List<Session> sessions = sessionService.getAllSessions();
        model.addAttribute("movies", sessions);
        return "movies";
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public String showMovieDetails(@PathVariable int id, ModelMap model) {

        int freeSeatNumber = 0;
        List<Order> orders = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();
        orders = orderService.getAllOrders();
        tickets = orderService.addOrderedDefinition(tickets, orders, id);

        freeSeatNumber = SEATS_NUMBER - tickets.size();
        Session film = sessionService.get(id);


        List<Ticket> schema = fillCinema();

        List<Ticket> ordered = new ArrayList<>();
        List<Order> orders1 = new ArrayList<>();
        orders1 = orderService.getAllOrders();
        ordered = orderService.addOrderedDefinition(ordered, orders1, id);

        for (Ticket ticket : ordered) {
            for (Ticket t : schema) {
                if (ticket.equals(t)) {
                    t.setBooked(1);
                }
            }
        }

        model.addAttribute("freeSeats", freeSeatNumber);
        model.addAttribute("movie", film);
        model.addAttribute("schema", schema);
        return "movie";
    }

    private List<Ticket> fillCinema() {
        List<Ticket> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(new Ticket(i + 1, j + 1, 0));
            }
        }
        return list;
    }
}