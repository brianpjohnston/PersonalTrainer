package com.johnston.brian.personaltrainer;

import java.util.UUID;

/**
 * Created by brian on 9/7/2016.
 */
public class Session {
    private UUID sessionid;
    private String sessionName;
    private UUID clientID;
    private String isComplete;

    public Session() {
        sessionid = UUID.randomUUID();
    }

    public Session(UUID id) {
        sessionid = id;
    }

    public void setSessionid(UUID sessionid) {
        this.sessionid = sessionid;
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

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
    }

    public String getisComplete() {
        return isComplete;
    }

    public void setComplete(String complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return sessionName;
    }
}
