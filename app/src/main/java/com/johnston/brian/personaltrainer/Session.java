package com.johnston.brian.personaltrainer;

import java.util.UUID;

/**
 * Created by brian on 9/7/2016.
 */
public class Session {
    private UUID sessionid;
    private String sessionName;

    public Session() {
        sessionid = UUID.randomUUID();
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public UUID getSessionid() {
        return sessionid;
    }
}
