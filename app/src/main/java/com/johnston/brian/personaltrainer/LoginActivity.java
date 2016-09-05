package com.johnston.brian.personaltrainer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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



                if (mUser.getText().toString().equals(getApplicationContext().getString(R.string.correct_user))) {
                    if(mPassword.getText().toString().equals(getApplicationContext().getString(R.string.correct_pw)))
                        {
                            Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.success_login), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, Client.class);
                            LoginActivity.this.startActivity(intent);
                        }
                    else{

                       Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.bad_user_pw), Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.bad_user_pw), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
