package com.johnston.brian.personaltrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by brian on 9/5/2016.
 */
public class Sessions extends AppCompatActivity {
    private Button mpurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        mpurchase = (Button) findViewById(R.id.button_new_session);
        mpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sessions.this, Purchase.class);
                Sessions.this.startActivity(intent);
            }

        });
    }
}
