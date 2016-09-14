package com.johnston.brian.personaltrainer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.johnston.brian.personaltrainer.database.ClientDbSchema.ClientTable;

/**
 * Created by brian on 9/14/2016.
 */
public class ClientBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "ClientBaseHelper";
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "ClientBase.db";

    public ClientBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ClientTable.NAME + "(" + " _id integer primary key autoincrement,"
                + ClientTable.Cols.UUID + ", "
                + ClientTable.Cols.CLIENTNAME + ", "
                + ClientTable.Cols.PHONE + ", "
                + ClientTable.Cols.EMAIL + ", "
                + ClientTable.Cols.BILLNAME + ", "
                + ClientTable.Cols.CCNUM + ", "
                + ClientTable.Cols.EXPIRE + ", "
                + ClientTable.Cols.ADDRESS + ")"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
