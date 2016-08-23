package com.johnston.brian.personaltrainer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mUser;
    private EditText mPassword;
    private Button mLogin;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mUser = (EditText)findViewById(R.id.text_user);
        mPassword= (EditText)findViewById(R.id.text_password);
        mLogin = (Button) findViewById(R.id.button_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (mUser.getText().toString().equals("jdoe")) {
                    if(mPassword.getText().toString().equals("welcome1"))
                        {
                            //// TODO: 8/23/2016

                        }
                    else{





                       Toast.makeText(getApplicationContext(), "Bad username/password", Toast.LENGTH_SHORT).show();
                    }
                }
                else {


                    Toast.makeText(getApplicationContext(), "Bad username/password", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
