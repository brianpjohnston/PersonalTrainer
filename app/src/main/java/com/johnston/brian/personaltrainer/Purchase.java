package com.johnston.brian.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by brian on 9/5/2016.
 */
public class Purchase extends AppCompatActivity {
    private Button mpurchase;
    private Button mCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_session);
        mCancel = (Button) findViewById(R.id.cancel_payment);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/7/2016
                Intent intent = new Intent(Purchase.this, ClientList.class);
                Purchase.this.startActivity(intent);
            }
        });
        mpurchase = (Button) findViewById(R.id.submit_payment);
        mpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016 add sessions to clients
                Intent intent = new Intent(Purchase.this, Reciept.class);
                Purchase.this.startActivity(intent);
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
            Intent intent = new Intent(Purchase.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }

    }
}
