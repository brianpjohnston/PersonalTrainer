package com.johnston.brian.personaltrainer;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class Sessions extends AppCompatActivity {
    private Button mpurchase;
    private ListView clients;
    public ListView mSessionList;
        public static ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);



        mSessionList = (ListView) findViewById(R.id.sessionList);
        mSessionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Sessions.this, SessionComplete.class);
                Sessions.this.startActivity(intent);
            }
        });

        mpurchase = (Button) findViewById(R.id.button_new_session);
        mpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sessions.this, Purchase.class);
                Sessions.this.startActivity(intent);
            }

        });
        viewAll();


    }



    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();


        viewAll();
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

    public void viewAll() {

        mSessionList = (ListView) findViewById(R.id.sessionList);
        SessionDataAccess session = new SessionDataAccess((getApplicationContext()));

        final List<Session> sessions = session.getSessions();


        if (adapter == null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
            mSessionList.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                for (Session s : sessions) {
                    adapter.add(s.getSessionName());
                }
                adapter.notifyDataSetChanged();
                mSessionList.invalidateViews();
            }

        });
    }

}


