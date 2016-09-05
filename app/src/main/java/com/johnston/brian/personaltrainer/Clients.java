package com.johnston.brian.personaltrainer;

import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class Clients {
    private UUID mID;
    private String mName;


    public Clients(){
        mID = UUID.randomUUID();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
