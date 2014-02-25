package com.example.buttonhandling;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void butonmesaj(View v){
    	Button b = (Button) v;
    	String name = b.getText().toString();
    	Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
    
    public void imagebutonmesaj(View v){
    	ImageButton ib = (ImageButton) v;
    	int btnID = ib.getId();
    	String s = Integer.toString(btnID);
    	Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    public void sayfa2Goster(View v){
    	Intent it = new Intent(this, activity2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
