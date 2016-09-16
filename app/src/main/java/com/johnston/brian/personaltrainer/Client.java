package com.johnston.brian.personaltrainer;

import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class Client {
    private String mName;
    private UUID mID;
    private String mphoneNum;
    private String mEmail;
    private String mBillName;
    private String mBilladdress;
    private String mCreditNum;
    private String mccDate;



    public Client(){
       mID = UUID.randomUUID();

    }
    public  Client(UUID id){
        mID = id;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

    public String getMphoneNum() {
        return mphoneNum;
    }

    public void setMphoneNum(String mphoneNum) {
        this.mphoneNum = mphoneNum;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getBillName() {
        return mBillName;
    }

    public void setBillName(String billName) {
        mBillName = billName;
    }

    public String getBilladdress() {
        return mBilladdress;
    }

    public void setBilladdress(String billaddress) {
        mBilladdress = billaddress;
    }

    public String getCreditNum() {
        return mCreditNum;
    }

    public void setCreditNum(String creditNum) {
        mCreditNum = creditNum;
    }

    public String getMccDate() {
        return mccDate;
    }

    public void setMccDate(String mccDate) {
        this.mccDate = mccDate;
    }
}
