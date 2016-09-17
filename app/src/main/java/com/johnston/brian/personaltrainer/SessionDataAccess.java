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
 * Created by brian on 9/17/2016.
 */
public class SessionDataAccess {

    private static Context mContext;
    private static SQLiteDatabase mDatabase;


    public static void init(Context context) {
        mContext = context;
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();


    }

    public SessionDataAccess(Context context) {
        mContext = context.getApplicationContext(); //
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();

    }

    public List<Session> getSessions() {
        List<Session> sessions = new ArrayList<>();

        ClientCursorWrapper cursor = querySessions(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                sessions.add(cursor.getSession());
                cursor.moveToNext();

            }
        } finally {
            cursor.close();
        }


        return sessions;
    }


    private static ClientCursorWrapper querySessions(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ClientDbSchema.SessionTable.NAME,
                null, //new String[]{"ClientDbSchema.ClientTable.Cols.CLIENTNAME"}, //Columns - null selects all columns
                whereClause,
                whereArgs,
                null, //group by
                null, //having
                null //order by
        );


        return new ClientCursorWrapper(cursor);
    }

    public static Session getSession(UUID id) {
        ClientCursorWrapper cursor = querySessions(
                ClientDbSchema.SessionTable.Cols.UUID + " =?",
                new String[]{id.toString()});

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSession();
        } finally {
            {
                cursor.close();
            }
        }
    }


    private static ContentValues getContentValues(Session s) {
        ContentValues values = new ContentValues();
        values.put(ClientDbSchema.SessionTable.Cols.UUID, s.getSessionid().toString());
        values.put(ClientDbSchema.SessionTable.Cols.CLIENTUUID, s.getClientID().toString());
        values.put(ClientDbSchema.SessionTable.Cols.SESSIONNAME, s.getSessionName().toString());


        return values;
    }


    public static void addSession(Session s) {
        ContentValues values = getContentValues(s);
        mDatabase.insert(ClientDbSchema.ClientTable.NAME, null, values);
    }

    public static void dbtransNewSession(Session s) {
        mDatabase.beginTransaction();
        try {
            addSession(s);
            mDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            //todo exception

        } finally {
            mDatabase.endTransaction();
        }
    }


}


