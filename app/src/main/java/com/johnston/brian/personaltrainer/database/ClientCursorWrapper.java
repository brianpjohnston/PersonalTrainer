package com.johnston.brian.personaltrainer.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.johnston.brian.personaltrainer.Client;
import com.johnston.brian.personaltrainer.database.ClientDbSchema.ClientTable;

import java.util.UUID;

/**
 * Created by brian on 9/14/2016.
 */
public class ClientCursorWrapper extends CursorWrapper {
    public ClientCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Client getClient() {
        String uuidString = getString((getColumnIndex(ClientTable.Cols.UUID)));
        String nameString = getString(getColumnIndex(ClientTable.Cols.CLIENTNAME));
        String phoneString = getString(getColumnIndex(ClientTable.Cols.PHONE));
        String emailString = getString(getColumnIndex(ClientTable.Cols.EMAIL));
        String billNameString = getString(getColumnIndex(ClientTable.Cols.BILLNAME));
        String ccNumString = getString(getColumnIndex(ClientTable.Cols.CCNUM));
        String ccExpireString = getString(getColumnIndex(ClientTable.Cols.EXPIRE));
        String addressString = getString(getColumnIndex(ClientTable.Cols.ADDRESS));


        Client client = new Client(); //        Client client = new Client(UUID.fromString(uuidString));
        client.setmName(nameString);
        client.setMphoneNum(phoneString);
        client.setEmail(emailString);
        client.setBillName(billNameString);
        client.setCreditNum(ccNumString);
        client.setMccDate(ccExpireString);
        client.setBilladdress(addressString);

        return client;
    }

}
