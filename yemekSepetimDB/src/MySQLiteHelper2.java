/*

import java.util.LinkedList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper2 extends SQLiteOpenHelper
{
        
        // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "YemekSepetiDB";
   
        public MySQLiteHelper2(Context context) 
        {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);        
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
                String CREATE_KULLANICI_TABLE = "CREATE TABLE kullanicilar ( " +
                        "kullaniciAd TEXT, "+
                        "sifre TEXT, "+
                        "yetki TEXT )";
                
                db.execSQL(CREATE_KULLANICI_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        {
                // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS kullanicilar");
        
        // create fresh books table
        this.onCreate(db);
        }
        //---------------------------------------------------------------------
   
        *//**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     *//*
        
        // Books table name
   // private static final String TABLE_YEMEKLER = "yemekler";
    private static final String TABLE_KULLANICILAR = "kullanicilar";

    
    // Books Table Columns names
    private static final String KEY_KULLANICIAD = "kullaniciAd";
    private static final String KEY_SIFRE = "sifre";
    private static final String KEY_YETKI = "yetki";

    
    private static final String[] COLUMNS = {KEY_KULLANICIAD,KEY_SIFRE, KEY_YETKI};
    
        public void addKullanici(Kullanici kullanici)
        {
                Log.d("addKullanici", kullanici.toString());
                // 1. get reference to writable DB
                SQLiteDatabase db = this.getWritableDatabase();
                 
                // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_KULLANICIAD, kullanici.getKullaniciAd()); // get title 
        values.put(KEY_SIFRE, kullanici.getSifre()); // get author
        values.put(KEY_YETKI, kullanici.getYetki()); // get author

        // 3. insert
        db.insert(TABLE_KULLANICILAR, // table
                        null, //nullColumnHack
                        values); // key/value -> keys = column names/ values = column values
        
        // 4. close
        db.close(); 
        }
        
        public Kullanici getKullanici(String kullaniciAd)
        {

                // 1. get reference to readable DB
                SQLiteDatabase db = this.getReadableDatabase();
                 
                // 2. build query
        Cursor cursor = 
                        db.query(TABLE_KULLANICILAR, // a. table
                        COLUMNS, // b. column names
                        " kullaniciAd = ?", // c. selections 
                new String[] { kullaniciAd }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build book object;
        Kullanici kullanici = new Kullanici();
        kullanici.setYetki(cursor.getString(2));
        kullanici.setKullaniciAd(cursor.getString(0));
        kullanici.setSifre(cursor.getString(1));
        // 5. return book
        return kullanici;
        }
        
        // Get All Books
        public List<Kullanici> getAllKullanici() 
        {
        List<Kullanici> kullanicilar = new LinkedList<Kullanici>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_KULLANICILAR;
 
            // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build book and add it to list
        Kullanici kullanici = null;
        	if (cursor.moveToFirst()) 
        	{
        		do 
        		{
                    kullanici = new Kullanici();
                kullanici.setYetki(cursor.getString(2));
                kullanici.setKullaniciAd(cursor.getString(0));
                kullanici.setSifre(cursor.getString(1));
                // Add book to books
                kullanicilar.add(kullanici);
        		} while (cursor.moveToNext());
        	}
        
                Log.d("getAllKullanici()", kullanicilar.toString());

        // return books
        return kullanicilar;
        }
        
         // Updating single book
        public int updateKullanici(Kullanici kullanici) 
        {

            // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
                // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("kullaniciAd", kullanici.getKullaniciAd()); // get title 
        values.put("sifre", kullanici.getSifre()); // get author
        values.put("yetki", kullanici.getYetki()); // get author

        // 3. updating row
        int i = db.update(TABLE_KULLANICILAR, //table
                        values, // column/value
                        KEY_KULLANICIAD+" = ?", // selections
                new String[] { String.valueOf(kullanici.getKullaniciAd()) }); //selection args
        
        // 4. close
        db.close();
        
        return i;
        
        }

    // Deleting single book
    public void deleteKullanici(Kullanici kullanici) 
    {

            // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        
        // 2. delete
        db.delete(TABLE_KULLANICILAR,
                        KEY_KULLANICIAD+" = ?",
                new String[] { String.valueOf(kullanici.getKullaniciAd()) });
        
        // 3. close
        db.close();
        
                Log.d("deleteKullanici()", kullanici.toString());

    }
}*/