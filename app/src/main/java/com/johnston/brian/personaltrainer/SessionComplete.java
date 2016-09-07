package com.johnston.brian.personaltrainer;

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

/**
 * Created by brian on 9/5/2016.
 */
public class SessionComplete extends AppCompatActivity {
    private CheckBox checkComplete;
    private Button mComplete;
    private Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_complete);
        mCancel = (Button) findViewById(R.id.cancel_session);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/7/2016
                Intent intent = new Intent(SessionComplete.this, ClientList.class);
                SessionComplete.this.startActivity(intent);
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
                }
                else {
                    mComplete.setEnabled(false);
                }
            }
        });
        mComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 9/7/2016
                Intent intent = new Intent(SessionComplete.this, ClientList.class);
                SessionComplete.this.startActivity(intent);

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
            Intent intent = new Intent(SessionComplete.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }

    }
}

