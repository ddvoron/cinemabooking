package com.voronovich.pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sessions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sessions {

    @XmlElement(name = "session")
    private List<Session> sessions = null;

    public Sessions() {
    }

    public Sessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setEmployees(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sessions sessions1 = (Sessions) o;

        return sessions != null ? sessions.equals(sessions1.sessions) : sessions1.sessions == null;
    }

    @Override
    public int hashCode() {
        return sessions != null ? sessions.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "sessions=" + sessions +
                '}';
    }
}
