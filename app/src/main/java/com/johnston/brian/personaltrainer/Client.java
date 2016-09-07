package com.johnston.brian.personaltrainer;

import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class Client {
    private UUID mID;
    private String mName;


    public Client(){
        mID = UUID.randomUUID();
    }

    public String getmName() {
        return mName;
    }

    public UUID getmID() {
        return mID;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
