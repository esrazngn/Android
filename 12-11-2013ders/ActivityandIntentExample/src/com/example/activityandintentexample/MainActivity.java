package com.example.activityandintentexample;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
public EditText txtuserID, txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuserID =(EditText)findViewById(R.id.txtuserid);
        EditText txtpassword =(EditText)findViewById(R.id.txtpass);
        

        
    }
    public void loginkontrol(View v){
    	String userID = txtuserID.getText().toString();
    	String password = txtpassword.getText().toString();
    	Intent intent = new Intent(this, LoginActivity.class);
    	startActivity(intent);
    	Bundle bnd = new Bundle();
    	bnd.putString("userID", userID);
    	bnd.putString("password", password);
    	intent.putExtras(bnd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
