package com.johnston.brian.personaltrainer.database;

/**
 * Created by brian on 9/14/2016.
 */
public class ClientDbSchema {
    public static final class ClientTable {
        public static final String NAME = "clients";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String CLIENTNAME = "name";
            public static final String PHONE = "phone";
            public static final String EMAIL = "email";
            public static final String BILLNAME = "billname";
            public static final String CCNUM = "creditNum";
            public static final String EXPIRE = "expire";
            public static final String ADDRESS = "address";
        }
    }
}
