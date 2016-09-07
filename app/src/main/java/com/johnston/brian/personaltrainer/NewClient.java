package com.johnston.brian.personaltrainer;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by brian on 9/4/2016.
 */
public class NewClient extends AppCompatActivity {

    private Button mbtnAddClient;
    private Button mbtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        mbtnAddClient = (Button) findViewById(R.id.submit_client);
        mbtnCancel = (Button) findViewById(R.id.cancel_client);

        mbtnAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016 add client 
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.clientAdd), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewClient.this, ClientList.class);
                NewClient.this.startActivity(intent);
            }
        });
        mbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.canceled), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewClient.this, ClientList.class);
                NewClient.this.startActivity(intent);
            }
        });


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
            FragmentManager manager = getFragmentManager();
            DialogFragment dialog = new DialogFragment();
            dialog.show(manager, "Logout");



            return true;
        }

    }
}
    









