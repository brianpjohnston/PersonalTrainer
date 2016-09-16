package com.johnston.brian.personaltrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johnston.brian.personaltrainer.database.ClientBaseHelper;
import com.johnston.brian.personaltrainer.database.ClientCursorWrapper;
import com.johnston.brian.personaltrainer.database.ClientDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tech140 on 9/16/2016.
 */
public class ClientLab {
    private static ClientLab sClientLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ClientLab get(Context context){
        if(sClientLab == null){
            sClientLab = new ClientLab(context);
        }
        return sClientLab;


    }

    private ClientLab(Context context) {
        mContext = context.getApplicationContext(); //
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();
    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();

        ClientCursorWrapper cursor = queryClients(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            clients.add(cursor.getClient());
            cursor.moveToNext();
        }
        cursor.close();
        return clients;
    }


    private  ClientCursorWrapper queryClients(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ClientDbSchema.ClientTable.NAME,
                null, //Columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null, //having
                null //order by
        );


        return new ClientCursorWrapper(cursor);
    }

    public Client getClient(UUID id) {
        ClientCursorWrapper cursor = queryClients(
                ClientDbSchema.ClientTable.Cols.UUID + " =?",
                new String[]{id.toString()}

        );

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


    public void addClient(Client c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(ClientDbSchema.ClientTable.NAME, null, values);
    }



}
