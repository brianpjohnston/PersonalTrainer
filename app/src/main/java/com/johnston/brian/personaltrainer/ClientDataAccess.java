package com.johnston.brian.personaltrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.johnston.brian.personaltrainer.database.ClientBaseHelper;
import com.johnston.brian.personaltrainer.database.ClientCursorWrapper;
import com.johnston.brian.personaltrainer.database.ClientDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tech140 on 9/16/2016.
 */
public class ClientDataAccess {
   // private static ClientDataAccess sClientDataAccess;

    private static Context mContext;
    private static  SQLiteDatabase mDatabase;



    public static void init(Context context){
        mContext = context;
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();


    }

    public ClientDataAccess(Context context) {
        mContext = context.getApplicationContext(); //
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();

    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();

        ClientCursorWrapper cursor = queryClients(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                clients.add(cursor.getClient());
                cursor.moveToNext();

            }
        }finally{
                cursor.close();
            }



        return clients;
    }


    private static   ClientCursorWrapper queryClients(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ClientDbSchema.ClientTable.NAME,
                null, //new String[]{"ClientDbSchema.ClientTable.Cols.CLIENTNAME"}, //Columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null, //having
                null //order by
        );


        return new ClientCursorWrapper(cursor);
    }

    public static Client getClient(UUID id) {
        ClientCursorWrapper cursor = queryClients(
                ClientDbSchema.ClientTable.Cols.UUID + " =?",
                new String[]{id.toString()});

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getClient();
        } finally {
            {
                cursor.close();
            }
        }
    }


    private static ContentValues getContentValues(Client client) {
        ContentValues values = new ContentValues();
        values.put(ClientDbSchema.ClientTable.Cols.UUID, client.getmID().toString());
        values.put(ClientDbSchema.ClientTable.Cols.CLIENTNAME, client.getmName());
        values.put(ClientDbSchema.ClientTable.Cols.EMAIL, client.getEmail());
        values.put(ClientDbSchema.ClientTable.Cols.PHONE, client.getMphoneNum());
        values.put(ClientDbSchema.ClientTable.Cols.BILLNAME, client.getBillName());
        values.put(ClientDbSchema.ClientTable.Cols.CCNUM, client.getCreditNum());
        values.put(ClientDbSchema.ClientTable.Cols.EXPIRE, client.getMccDate());
        values.put(ClientDbSchema.ClientTable.Cols.ADDRESS, client.getBilladdress());

        return values;
    }


    public static void addClient(Client c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(ClientDbSchema.ClientTable.NAME, null, values);
    }

    public static void dbtransNewClient(Client c) {
        mDatabase.beginTransaction();
        try {
            addClient(c);
            mDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            //todo exception

        } finally {
            mDatabase.endTransaction();
        }
    }




}
