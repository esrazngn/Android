package com.example.book;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import java.util.List;

import com.example.book.*;

import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                
                
                MySQLiteHelper db = new MySQLiteHelper(this);
        
        /**
         * CRUD Operations
         * */
        // add Books
        // get all books
        List<Book> list = db.getAllBooks();
        	//Toast.makeText(getApplicationContext(), (CharSequence) list.get(0), Toast.LENGTH_SHORT).show();
        	Log.d("liste: ", list.get(0).toString());

        
        }

}
