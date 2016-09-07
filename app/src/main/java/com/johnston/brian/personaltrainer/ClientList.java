package com.johnston.brian.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;


/**
 * Created by brian on 9/6/2016. Login activity
 */
public class ClientList extends AppCompatActivity {
    private Button mNewClient;
    private ListView mList;

    public ClientList() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlist);
        mNewClient = (Button) findViewById(R.id.button_add_client);
        mList = (ListView) findViewById(R.id.Client_list);

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
                                              //// TODO: 9/5/2016 add client
                                              Intent intent = new Intent(ClientList.this, NewClient.class);
                                              ClientList.this.startActivity(intent);
                                          }


                                      }
        );


        final ListView clientList = (ListView) findViewById(R.id.Client_list);
        final ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Client client = new Client();
            client.setmName("Client " + i);
            list.add(client);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        clientList.setAdapter(adapter);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id ==R.id.logoff);{
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(ClientList.this, LoginActivity.class);
            startActivity(intent);
            return true;
            }

        }

    }


