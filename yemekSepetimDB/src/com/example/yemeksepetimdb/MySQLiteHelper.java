package com.example.yemeksepetimdb;

import java.util.LinkedList;
import java.util.List;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Columns;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper
{
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "YemekSepetiDB";

	public MySQLiteHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// SQL statement to create yemek table
	String CREATE_YEMEK_TABLE = "CREATE TABLE yemekler ( " + "ad TEXT, "
			+ "fiyat INTEGER )";

		// create yemek table
		db.execSQL(CREATE_YEMEK_TABLE);

		String CREATE_ICECEK_TABLE = "CREATE TABLE icecekler ( " + "ad TEXT, "
				+ "fiyat INTEGER )";
		db.execSQL(CREATE_ICECEK_TABLE);

		String CREATE_SALATA_TABLE = "CREATE TABLE salatalar ( " + "ad TEXT, "
				+ "fiyat INTEGER )";

		db.execSQL(CREATE_SALATA_TABLE);

		String CREATE_KULLANICI_TABLE = "CREATE TABLE kullanicilar ( "
				+ "kullaniciAd TEXT, " + "sifre TEXT, " + "yetki TEXT )";

		db.execSQL(CREATE_KULLANICI_TABLE);
		
		
		String CREATE_SIPARIS_TABLE = "CREATE TABLE siparis ( "
				+ "siparisID INTEGER PRIMARY KEY AUTOINCREMENT, " + "yemekler TEXT, " 
				+ "icecekler TEXT,"+ "salatalar TEXT," + "fiyat INTEGER,"
				+ "tarih DATE )";

		db.execSQL(CREATE_SIPARIS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Drop older yemek table if existed
		db.execSQL("DROP TABLE IF EXISTS yemekler");
		this.onCreate(db);
		db.execSQL("DROP TABLE IF EXISTS salatalar");
		this.onCreate(db);
		db.execSQL("DROP TABLE IF EXISTS icecekler");
		this.onCreate(db);
		db.execSQL("DROP TABLE IF EXISTS siparis");
		this.onCreate(db);
		db.execSQL("DROP TABLE IF EXISTS kullanicilar");
		this.onCreate(db);
		
	}

	// ---------------------------------------------------------------------

	/**
	 * CRUD operations (create "add", read "get", update, delete) book + get all
	 * books + delete all books
	 */

	// Books table name
	private static final String TABLE_YEMEK = "yemekler";
	private static final String TABLE_SALATA = "salatalar";
	private static final String TABLE_ICECEK = "icecekler";
	private static final String TABLE_SIPARIS = "siparis";
	private static final String TABLE_KULLANICILAR = "kullanicilar";

	// Books Table Columns names
	private static final String KEY_AD = "ad";
	private static final String KEY_FIYAT = "fiyat";
	

	// Books Table Columns names
	private static final String KEY_KULLANICIAD = "kullaniciAd";
	private static final String KEY_SIFRE = "sifre";
	private static final String KEY_YETKI = "yetki";
	
	private static final String KEY_ID = "siparisID";
	private static final String KEY_YEMEKLER = "yemekler";
	private static final String KEY_ICECEKLER = "icecekler";
	private static final String KEY_SALATALAR = "salatalar";
	private static final String KEY_TARIH = "tarih";



	private static final String[] COLUMNYEMEK = { KEY_AD, KEY_FIYAT };
	private static final String[] COLUMNICECEK = { KEY_AD, KEY_FIYAT };
	private static final String[] COLUMNSALATA = { KEY_AD, KEY_FIYAT };
	private static final String[] COLUMNSIPARIS = { KEY_ID, KEY_YEMEKLER, KEY_ICECEKLER, KEY_SALATALAR, KEY_FIYAT, KEY_TARIH };
	private static final String[] COLUMNKULLANICI = { KEY_KULLANICIAD,	KEY_SIFRE, KEY_YETKI };

	
	
	public void addIcecek(Icecek icecek) 
	{
		Log.d("addIcecek ", icecek.toString());

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_AD, icecek.getAd()); // get title
		values.put(KEY_FIYAT, icecek.getFiyat()); // get author

		// 3. insert
		db.insert(TABLE_ICECEK, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	public void addYemek(Yemek yemek) 
	{
		Log.d("addYemek", yemek.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_AD, yemek.getAd()); // get title
		values.put(KEY_FIYAT, yemek.getFiyat()); // get author

		// 3. insert
		db.insert(TABLE_YEMEK, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	public void addSalata(Salata salata) 
	{
		Log.d("addSalata", salata.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_AD, salata.getAd()); // get title
		values.put(KEY_FIYAT, salata.getFiyat()); // get author

		// 3. insert
		db.insert(TABLE_SALATA, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	public void addSiparis(Siparisim siparisim) 
	{
		Log.d("addSiparis", siparisim.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_ID, siparisim.getSiparisID()); 
		values.put(KEY_YEMEKLER, siparisim.getYemekler()); 
		values.put(KEY_ICECEKLER, siparisim.getIcecekler()); 
		values.put(KEY_SALATALAR, siparisim.getSalata()); 
		values.put(KEY_FIYAT, siparisim.getFiyat()); 
		values.put(KEY_TARIH, siparisim.getDate()); 



		// 3. insert
		db.insert(TABLE_SIPARIS, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	public void addKullanici(Kullanici kullanici) {
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
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}

	
	
	public Yemek getYemek(String ad) {

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();

		// 2. build query
		Cursor cursor = db.query(TABLE_YEMEK, // a. table
				COLUMNYEMEK, // b. column names
				" ad = ?", // c. selections
				new String[] { ad }, // d. selections args
				null, // e. group by
				null, // f. having
				null, // g. order by
				null); // h. limit

		// 3. if we got results get the first one
		if (cursor != null)
			cursor.moveToFirst();

		// 4. build book object;
		Yemek yemek = new Yemek();
		yemek.setFiyat(Integer.parseInt(cursor.getString(1)));
		yemek.setAd(cursor.getString(0));

		// 5. return book
		return yemek;
	}

	public Icecek getIcecek(String ad) {

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();

		// 2. build query
		Cursor cursor = db.query(TABLE_ICECEK, // a. table
				COLUMNICECEK, // b. column names
				" ad = ?", // c. selections
				new String[] { ad }, // d. selections args
				null, // e. group by
				null, // f. having
				null, // g. order by
				null); // h. limit

		// 3. if we got results get the first one
		if (cursor != null)
			cursor.moveToFirst();

		// 4. build book object;
		Icecek icecek = new Icecek();
		icecek.setFiyat(Integer.parseInt(cursor.getString(1)));
		icecek.setAd(cursor.getString(0));

		// 5. return book
		return icecek;
	}
	
	public Kullanici getKullanici(String kullaniciAd) {

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();

		// 2. build query
		Cursor cursor = db.query(TABLE_KULLANICILAR, // a. table
				COLUMNKULLANICI, // b. column names
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

	
	
	public List<Yemek> getAllYemek()
	{
		List<Yemek> yemekler = new LinkedList<Yemek>();

		// 1. build the query
		String query = "SELECT  * FROM " + TABLE_YEMEK;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Yemek yemek = null;
		if (cursor.moveToFirst()) {
			do {
				yemek = new Yemek();
				yemek.setFiyat(Integer.parseInt(cursor.getString(1)));
				yemek.setAd(cursor.getString(0));

				// Add book to books
				yemekler.add(yemek);
			} while (cursor.moveToNext());
		}

		Log.d("getAllYemek()", yemekler.toString());

		// return books
		return yemekler;
	}

	public List<Icecek> getAllIcecek()
	{
		List<Icecek> icecekler = new LinkedList<Icecek>();

		// 1. build the query
		String query = "SELECT  * FROM " + TABLE_ICECEK;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Icecek icecek = null;
		if (cursor.moveToFirst()) 
		{
			do 
			{
				icecek = new Icecek();
				icecek.setFiyat(Integer.parseInt(cursor.getString(1)));
				icecek.setAd(cursor.getString(0));

				// Add book to books
				icecekler.add(icecek);
			} while (cursor.moveToNext());
		}

		Log.d("getAllIcecek()", icecekler.toString());

		// return books
		return icecekler;
	}
	
	public List<Salata> getAllSalata()
	{
		List<Salata> salatalar = new LinkedList<Salata>();

		// 1. build the query
		String query = "SELECT  * FROM " + TABLE_SALATA;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Salata salata = null;
		if (cursor.moveToFirst()) {
			do {
				salata = new Salata();
				salata.setFiyat(Integer.parseInt(cursor.getString(1)));
				salata.setAd(cursor.getString(0));
				
				salatalar.add(salata);
			} while (cursor.moveToNext());
		}

		Log.d("getAllSalata()", salatalar.toString());

		// return books
		return salatalar;
	}
	
	public List<Siparisim> getAllSiparis()
	{
		List<Siparisim> siparisler = new LinkedList<Siparisim>();

		// 1. build the query
		String query = "SELECT  * FROM " + TABLE_SIPARIS;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Siparisim siparis = null;
		if (cursor.moveToFirst()) {
			do {
				siparis = new Siparisim();
				
				siparis.setSiparisID(Integer.valueOf(cursor.getString(0)));
				siparis.setYemekler(cursor.getString(1));
				siparis.setIcecekler(cursor.getString(2));
				siparis.setSalatalar(cursor.getString(3));
				siparis.setFiyat(cursor.getString(4));
				siparis.setDate(cursor.getString(5));

				// Add book to books
				siparisler.add(siparis);
			} while (cursor.moveToNext());
		}

		Log.d("getAllSiparis()", siparisler.toString());

		// return books
		return siparisler;
	}
	
	public List<Kullanici> getAllKullanici() {
		List<Kullanici> kullanicilar = new LinkedList<Kullanici>();

		// 1. build the query
		String query = "SELECT  * FROM " + TABLE_KULLANICILAR;

		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// 3. go over each row, build book and add it to list
		Kullanici kullanici = null;
		if (cursor.moveToFirst()) {
			do {
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
	
	
	
	
	
	public int updateYemek(Yemek yemek) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("ad", yemek.getAd()); // get title
		values.put("fiyat", yemek.getFiyat()); // get author

		// 3. updating row
		int i = db.update(TABLE_YEMEK, // table
				values, // column/value
				KEY_AD + " = ?", // selections
				new String[] { String.valueOf(yemek.getAd()) }); // selection
																	// args

		// 4. close
		db.close();

		return i;

	}

	public int updateIcecek(Icecek icecek) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("ad", icecek.getAd()); // get title
		values.put("fiyat", icecek.getFiyat()); // get author

		// 3. updating row
		int i = db.update(TABLE_ICECEK, // table
				values, // column/value
				KEY_AD + " = ?", // selections
				new String[] { String.valueOf(icecek.getAd()) }); // selection
																	// args

		// 4. close
		db.close();

		return i;

	}
	
	public int updateSalata(Salata salata) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("ad", salata.getAd()); // get title
		values.put("fiyat", salata.getFiyat()); // get author

		// 3. updating row
		int i = db.update(TABLE_SALATA, // table
				values, // column/value
				KEY_AD + " = ?", // selections
				new String[] { String.valueOf(salata.getAd()) }); // selection
																	// args

		// 4. close
		db.close();

		return i;

	}
	
	

	public int updateKullanici(Kullanici kullanici) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put("kullaniciAd", kullanici.getKullaniciAd()); // get title
		values.put("sifre", kullanici.getSifre()); // get author
		values.put("yetki", kullanici.getYetki()); // get author

		// 3. updating row
		int i = db.update(TABLE_KULLANICILAR, // table
				values, // column/value
				KEY_KULLANICIAD + " = ?", // selections
				new String[] { String.valueOf(kullanici.getKullaniciAd()) }); // selection
																				// args

		// 4. close
		db.close();

		return i;

	}
	
	
	
	
	
	public void deleteYemek(Yemek yemek) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. delete
		db.delete(TABLE_YEMEK, KEY_FIYAT + " = ?",
				new String[] { String.valueOf(yemek.getFiyat()) });

		// 3. close
		db.close();

		Log.d("deleteYemek", yemek.toString());

	}
	
	public void deleteIcecek(Icecek icecek) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. delete
		db.delete(TABLE_ICECEK, KEY_AD + " = ?",
				new String[] { icecek.getAd() });

		// 3. close
		db.close();

		Log.d("deleteIcecek", icecek.toString());

	}

	public void deleteKullanici(Kullanici kullanici) {

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. delete
		db.delete(TABLE_KULLANICILAR, KEY_KULLANICIAD + " = ?",
				new String[] { String.valueOf(kullanici.getKullaniciAd()) });

		// 3. close
		db.close();

		Log.d("deleteKullanici()", kullanici.toString());

	}
	
	
	
	
	

	
}