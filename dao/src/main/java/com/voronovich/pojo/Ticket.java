package com.voronovich.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    private int row;
    private int seat;
    private int booked; // 0 - free; 1 - booked

    public Ticket() {
    }

    public Ticket(int row, int seat, int booked) {
        this.row = row;
        this.seat = seat;
        this.booked = booked;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (row != ticket.row) return false;
        if (seat != ticket.seat) return false;
        return booked == ticket.booked;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + seat;
        result = 31 * result + booked;
        return result;
    }

    @Override
    public String toString() {
        return " Ticket" +
                "(row-" + row +
                ", seat-" + seat + ") ";
    }
}
