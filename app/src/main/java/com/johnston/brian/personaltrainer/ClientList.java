package com.johnston.brian.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 9/6/2016.
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


        mNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016 add client
                Intent intent = new Intent(ClientList.this, NewClient.class);
                ClientList.this.startActivity(intent);
            }


        }
        );
        allClients();
    }



    public void allClients() {
        final ListView clientList = (ListView) findViewById(R.id.Client_list);
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 50; i++) {
            Client client = new Client();
            client.setmName("Client " + i);
            list.add(client);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        clientList.setAdapter(adapter);


    }
}
