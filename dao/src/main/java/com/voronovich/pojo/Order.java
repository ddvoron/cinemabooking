package com.voronovich.pojo;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    private int idOrder;
    private String film;
    private Date date;
    private int idFilm;

    @XmlElement(name = "tickets")
    private Tickets tickets;

    public Order() {
    }

    public Order(int idOrder, String film, Date date, int idFilm, Tickets tickets) {
        this.idOrder = idOrder;
        this.film = film;
        this.date = date;
        this.idFilm = idFilm;
        this.tickets = tickets;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getFilm() {
        return film;
    }

    public Date getDate() {
        return date;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (idFilm != order.idFilm) return false;
        if (film != null ? !film.equals(order.film) : order.film != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return tickets != null ? tickets.equals(order.tickets) : order.tickets == null;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idFilm;
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", film='" + film + '\'' +
                ", date=" + date +
                ", idFilm=" + idFilm +
                ", tickets=" + tickets +
                '}';
    }
}
