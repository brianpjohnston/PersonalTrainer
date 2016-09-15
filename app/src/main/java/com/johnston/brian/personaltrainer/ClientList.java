package com.johnston.brian.personaltrainer;

import com.johnston.brian.personaltrainer.database.ClientBaseHelper;
import com.johnston.brian.personaltrainer.database.ClientDbSchema;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.johnston.brian.personaltrainer.database.ClientCursorWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by brian on 9/6/2016. Login activity
 */
public class ClientList extends AppCompatActivity {
    private Button mNewClient;
    private ListView mList;
    public static  ArrayList list;
    public static ArrayAdapter adapter;
    private SQLiteDatabase mDatabase;
    private Context mContext;




    public ClientList() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlist);
        mNewClient = (Button) findViewById(R.id.button_add_client);
        mList = (ListView) findViewById(R.id.Client_list);
        //mcontext = context;
        // mDatabase = new ClientBaseHelper(mcontext)
        //    .getWritableDatabase();


        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClientList.this, Sessions.class);
                ClientList.this.startActivity(intent);
            }
        });


        mNewClient.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {


                                              Intent intent = new Intent(ClientList.this, NewClient.class);
                                              ClientList.this.startActivity(intent);
                                          }


                                      }
        );
        viewAll();



    }

    @Override
    public void onPause(){
        super.onPause();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume(){
        super.onResume();
        UpdateUi();
      //  viewAll();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logoff) ;
        {
            super.onOptionsItemSelected(item);
            FragmentManager manager = getFragmentManager();
            DialogFragment dialog = new DialogFragment();
            dialog.show(manager, "Logout");


            return true;

        }
    }

    public void UpdateUi(){
        adapter.notifyDataSetChanged();
    }

    public void viewAll() {
        mList = (ListView) findViewById(R.id.Client_list);
        list = new ArrayList();



        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        mList.setAdapter(adapter);


    }


    private ClientCursorWrapper queryClients(String whereClause, String[] whereArgs) {
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



















