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
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class Purchase extends AppCompatActivity {
    private Button mpurchase;
    private Button mCancel;
    private EditText mSessionName;
    private Button mSendMail;
    private Button mPrint;
    private UUID clientidnew;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clientidnew = (UUID) getIntent().getExtras().get("id");
        setContentView(R.layout.activity_purchase_session);


        mSessionName = (EditText) findViewById(R.id.EditText_sessionName);
        mCancel = (Button) findViewById(R.id.cancel_payment);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mPrint = (Button) findViewById(R.id.button_print);
        mPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Session session = new Session();
                session.setSessionName(mSessionName.getText().toString());
                session.setClientID(clientidnew);
                session.setComplete(false);

                SessionDataAccess.addSession(session);
                Sessions.adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.printing), Toast.LENGTH_SHORT).show();

                finish();

            }

        });

        mSendMail = (Button) findViewById(R.id.button_email);
        mSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/5/2016  implement email

                Session session = new Session();
                session.setSessionName(mSessionName.getText().toString());
                session.setClientID(clientidnew);
                session.setComplete(false);

                SessionDataAccess.addSession(session);
                Sessions.adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.emailSent), Toast.LENGTH_SHORT).show();
                finish();
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
