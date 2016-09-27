package com.johnston.brian.personaltrainer;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by brian on 9/4/2016.
 */
public class NewClient extends AppCompatActivity {

    private static final int REQUEST_PHOTO= 2;

    private Button mbtnAddClient;
    private Button mbtnCancel;
    private EditText mName;
    private EditText mphoneNum;
    private EditText mEmail;
    private EditText mBillName;
    private EditText mBilladdress;
    private EditText mCreditNum;
    private EditText mccDate;
    private ImageButton mcamera;
    private File mPhotoFile;
   private ImageView mPhotoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        mcamera =(ImageButton) findViewById(R.id.take_Image);
        mPhotoView = (ImageView) findViewById(R.id.client_Image);
        mbtnAddClient = (Button) findViewById(R.id.submit_client);
        mbtnCancel = (Button) findViewById(R.id.cancel_client);
        mName = (EditText) findViewById(R.id.edittext_Name);
        mphoneNum = (EditText) findViewById(R.id.edittext_Phone);
        mEmail = (EditText) findViewById(R.id.edittext_Email_Address);
        mBilladdress = (EditText) findViewById(R.id.edittext_BillingAddress);
        mBillName = (EditText) findViewById(R.id.edittext_Cardholder);
        mCreditNum = (EditText) findViewById(R.id.edittext_CardNumber);
        mccDate = (EditText) findViewById(R.id.edittext_CardExp);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);






                boolean canTakePhoto = mPhotoFile != null &&
                        captureImage.resolveActivity(getPackageManager()) != null;


            if (canTakePhoto) {
                Uri uri = Uri.fromFile(mPhotoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            }

            mcamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivityForResult(captureImage, REQUEST_PHOTO);
                }
            });

           mPhotoView = (ImageView) mPhotoView.findViewById(R.id.client_Image);
            updatePhotoView();








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
                ClientDataAccess.dbtransNewClient(client);
                ClientList.adapter.notifyDataSetChanged();

                mPhotoView.buildDrawingCache();
                Bitmap bm=mPhotoView.getDrawingCache();

                OutputStream fOut = null;
                Uri outputFileUri;
                try {
                    File root = new File(Environment.getExternalStorageDirectory()
                            + File.separator + "Pictures" + File.separator);
                    root.mkdirs();
                    File sdImageMainDirectory = new File(root, "IMG_" + client.getID().toString() + ".jpg");
                    outputFileUri = Uri.fromFile(sdImageMainDirectory);
                    fOut = new FileOutputStream(sdImageMainDirectory);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error occured. Please try again later.", Toast.LENGTH_SHORT).show();
                }
                try {
                    bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                } catch (Exception e) {
                }

                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.clientAdd), Toast.LENGTH_SHORT).show();




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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQUEST_PHOTO:
                if(resultCode==RESULT_OK){
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    mPhotoView.setImageBitmap(thumbnail);
                }
        }
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
    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), null);;
            mPhotoView.setImageBitmap(bitmap);
        }
    }



    }




