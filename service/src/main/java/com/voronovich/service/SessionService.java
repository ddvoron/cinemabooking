package com.voronovich.service;

import com.voronovich.pojo.Session;

import java.util.List;

public interface SessionService {

    List<Session> getAllSessions();

    Session get(int id);
}
