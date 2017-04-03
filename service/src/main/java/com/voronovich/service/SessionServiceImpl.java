package com.voronovich.service;

import com.voronovich.dao.SessionDaoImpl;
import com.voronovich.pojo.Session;

import java.util.List;

public class SessionServiceImpl implements SessionService{

    private SessionServiceImpl(){}

    private static SessionServiceImpl service = null;

    public static SessionServiceImpl getService(){
        if(service == null){
            synchronized (SessionServiceImpl.class){
                if(service==null){
                    service = new SessionServiceImpl();
                }
            }
        }
        return service;
    }

    private SessionDaoImpl dao = SessionDaoImpl.getDao();

    public List<Session> getAllSessions() {
        return dao.getAllSessions();
    }

    public Session get(int id) {
        return dao.get(id);
    }
}
