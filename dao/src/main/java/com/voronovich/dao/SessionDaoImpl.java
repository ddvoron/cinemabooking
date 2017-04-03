package com.voronovich.dao;

import com.voronovich.pojo.Session;
import com.voronovich.pojo.Sessions;
import com.voronovich.util.DataConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionDaoImpl implements SessionDao {

    private SessionDaoImpl(){
    }

    private static SessionDaoImpl dao = null;

    public static SessionDaoImpl getDao(){
        if(dao == null){
            synchronized (SessionDaoImpl.class){
                if(dao==null){
                    dao = new SessionDaoImpl();
                }
            }
        }
        return dao;
    }

    public List<Session> getAllSessions() {
        Sessions sessions = DataConverter.unMarshalingSessions();
        List<Session> list = sessions.getSessions();
        Collections.sort(list, Session.COMPARE_BY_DATE);
        return list;
    }

    public Session get(int id) {
        Sessions sessions = DataConverter.unMarshalingSessions();
        List<Session> list = sessions.getSessions();
        for (Session session : list) {
            if(session.getIdFilm() == id){
                return session;
            }
        }
        return null;
    }
}
