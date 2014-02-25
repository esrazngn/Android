package com.example.exampledb;

import java.util.Locale;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	private static String DB_PATH = "/data/data/ExampleDB/databases/";     
	private static String DB_NAME = "myDBName";
	long usid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 boolean dbExist = checkDataBase();
	        
	        if(!dbExist){
	            db = openOrCreateDatabase(DB_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
	            db.setVersion(1);
	            db.setLocale(Locale.getDefault());
	            db.setLockingEnabled(true);
	            
	            final String CREATE_TABLE_USER =
	                "CREATE TABLE tbl_user (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,surname TEXT);";
	            
	            db.execSQL(CREATE_TABLE_USER);
	        }
	        else{
	            db = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
	        }
	        
	        Button add = (Button)findViewById(R.id.add);
	        Button edit =(Button)findViewById(R.id.edit);
	        Button delete =(Button)findViewById(R.id.delete);
	        edit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
	                // TODO Auto-generated method stub
	                TextView id,name,surname;
	                id=(TextView) findViewById(R.id.editID);
	                name=(TextView) findViewById(R.id.editName);
	                surname=(TextView) findViewById(R.id.editSurname);
	                
	                ContentValues updateUser = new ContentValues();
	                updateUser.put("name", name.getText().toString());
	                updateUser.put("surname", surname.getText().toString());
	                try{
	                    db.update("tbl_user", updateUser, "id=?", new String[] {id.getText().toString()});
	                    Toast.makeText(getApplicationContext(), id.getText().toString()+" IDli Kayýt Düzenlendi", Toast.LENGTH_LONG).show();
	                }
	                catch (Exception e){
	                    Log.e("edit",e.getMessage());
	                }
	            }
	        });
	        
	            
	            
	        	add.setOnClickListener(new OnClickListener() {
					
	        		public void onClick(View v) {
		                // TODO Auto-generated method stub
		                TextView name,surname;
		                name=(TextView) findViewById(R.id.addName);
		                surname=(TextView) findViewById(R.id.addSurname);
		                
		                ContentValues values = new ContentValues();
		                values.put("name", name.getText().toString());
		                values.put("surname", surname.getText().toString());
		               
		                   try {
		                    usid = db.insertOrThrow("tbl_user", null, values);
		                    Toast.makeText(getApplicationContext(), "Kaydýnýz Yapýldý. ID: "+usid, Toast.LENGTH_LONG).show();
		                } catch (Exception e) {
		                    Log.e("insert",e.getMessage());
		                }
		            }
		        });
		        
		        delete.setOnClickListener(new OnClickListener() {
					
		        	public void onClick(View v) {
		                // TODO Auto-generated method stub
		                TextView id;
		                id=(TextView) findViewById(R.id.deleteID);
		                
		                try{
		                     db.delete("tbl_user", "id=?", new String[] {id.getText().toString()});
		                    Toast.makeText(getApplicationContext(), id.getText().toString()+" IDli Kayýt Silindi", Toast.LENGTH_LONG).show();
		                }
		                catch (Exception e){
		                    Log.e("delete",e.getMessage());
		                }
		            }
		        });
	    }
	private boolean checkDataBase(){
        
        SQLiteDatabase checkDB = null;
 
        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
        }catch(SQLiteException e){
 
            //database does’t exist yet.
 
        }
 
        if(checkDB != null){
 
            checkDB.close();
 
        }
 
        return checkDB != null ? true : false;
    

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
