package com.voronovich.dao;

import com.voronovich.pojo.Session;

import java.util.List;

/**
 * Abstract classes for session functionality
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface SessionDao {

    /**
     * Returns list of sessions
     *
     * @return List<Session>
     */
    List<Session> getAllSessions();

    /**
     * Returns session by its id
     *
     * @param id Session
     * @return  Session
     */
    Session get(int id);
}
