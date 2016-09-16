package com.johnston.brian.personaltrainer;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by brian on 9/4/2016.
 */
public class NewClient extends AppCompatActivity {

    private Button mbtnAddClient;
    private Button mbtnCancel;
    private EditText mName;
    private EditText mphoneNum;
    private EditText mEmail;
    private EditText mBillName;
    private EditText mBilladdress;
    private EditText mCreditNum;
    private EditText mccDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        mbtnAddClient = (Button) findViewById(R.id.submit_client);
        mbtnCancel = (Button) findViewById(R.id.cancel_client);
        mName = (EditText) findViewById(R.id.edittext_Name);
        mphoneNum = (EditText) findViewById(R.id.edittext_Phone);
        mEmail = (EditText) findViewById(R.id.edittext_Email_Address);
        mBilladdress = (EditText) findViewById(R.id.edittext_BillingAddress);
        mBillName = (EditText) findViewById(R.id.edittext_Cardholder);
        mCreditNum = (EditText) findViewById(R.id.edittext_CardNumber);
        mccDate = (EditText) findViewById(R.id.edittext_CardExp);


        mbtnAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client client = new Client();
                client.setmName(mName.getText().toString());
                client.setMphoneNum(mphoneNum.getText().toString());
                client.setEmail(mEmail.getText().toString());
                client.setBillName(mBillName.getText().toString());
                client.setBilladdress(mBilladdress.getText().toString());
                client.setCreditNum(mCreditNum.getText().toString());
                client.setMccDate(mccDate.getText().toString());
                ClientDataAccess.addClient(client);

                ClientList.adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.clientAdd), Toast.LENGTH_SHORT).show();

               //Intent intent = new Intent(NewClient.this, ClientList.class);
              // NewClient.this.startActivity(intent);


                finish();

            }
        });
        mbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.canceled), Toast.LENGTH_SHORT).show();
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
    









