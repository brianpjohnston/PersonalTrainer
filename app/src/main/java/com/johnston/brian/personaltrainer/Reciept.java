package com.johnston.brian.personaltrainer;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by brian on 9/5/2016.
 */
public class Reciept extends AppCompatActivity {
    private Button mSendMail;
    private Button mPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_receipt);

        mPrint =(Button) findViewById(R.id.button_print);
        mPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016  implement print
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.printing), Toast.LENGTH_SHORT).show();

                finish();
                //Intent intent = new Intent(Reciept.this, ClientList.class);
                //Reciept.this.startActivity(intent);
            }

        });



        mSendMail = (Button) findViewById(R.id.button_email);
        mSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016  implement email
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.emailSent), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Reciept.this, Sessions.class);
                Reciept.this.startActivity(intent);
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
