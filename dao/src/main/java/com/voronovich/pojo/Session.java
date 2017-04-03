package com.voronovich.pojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Comparator;

import static com.voronovich.util.DataConverter.convertDate;

@XmlRootElement(name = "session")
@XmlAccessorType(XmlAccessType.FIELD)
public class Session implements Serializable {

    private int idFilm;
    private String film;
    private String date;

    @XmlElement(name = "session")
    private Tickets tickets;

    public Session(){

    }

    public Session(int idFilm, String film) {
        this.idFilm = idFilm;
        this.film = film;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getFilm() {
        return film;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static final Comparator<Session> COMPARE_BY_DATE = new Comparator<Session>() {
        public int compare(Session lhs, Session rhs) {
            return (int) ((convertDate(lhs.getDate()).getTime() - convertDate(rhs.getDate()).getTime()));
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (idFilm != session.idFilm) return false;
        if (film != null ? !film.equals(session.film) : session.film != null) return false;
        if (date != null ? !date.equals(session.date) : session.date != null) return false;
        return tickets != null ? tickets.equals(session.tickets) : session.tickets == null;
    }

    @Override
    public int hashCode() {
        int result = idFilm;
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Session{" +
                "idFilm=" + idFilm +
                ", film='" + film + '\'' +
                ", date='" + date + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
