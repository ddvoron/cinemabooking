package com.voronovich.pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tickets {

    @XmlElement(name = "ticket")
    private List<Ticket> tickets = null;

    public Tickets() {
    }

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tickets tickets1 = (Tickets) o;

        return tickets != null ? tickets.equals(tickets1.tickets) : tickets1.tickets == null;
    }

    @Override
    public int hashCode() {
        return tickets != null ? tickets.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "" + tickets;
    }
}
