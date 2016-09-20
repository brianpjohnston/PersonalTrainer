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
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.UUID;

/**
 * Created by brian on 9/5/2016.
 */
public class SessionComplete extends AppCompatActivity {
    private CheckBox checkComplete;
    private Button mComplete;
    private Button mCancel;
    private UUID sessionidPassed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionidPassed = (UUID) getIntent().getExtras().get("id");
        setContentView(R.layout.activity_session_complete);
        mCancel = (Button) findViewById(R.id.cancel_session);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/7/2016
                finish();
            }
        });
        mComplete = (Button) findViewById(R.id.complete_session);
        mComplete.setEnabled(false);
        checkComplete = (CheckBox) findViewById(R.id.checkBox_complete);
        checkComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkComplete.isChecked()){
                    mComplete.setEnabled(true);
                    //// TODO: 9/17/2016 set session complete to false 
                }
                else {
                    mComplete.setEnabled(false);
                }
            }
        });
        mComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

