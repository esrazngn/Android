package com.example.toasteventhandler;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    private String setMessage(String message){
		Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_LONG).show();
		return message;
	}
    public void Hello(View v){
    	setMessage("Hello");
    }
    public void Goodbye(View v){
    	setMessage("Goodbye");
    }
    
    

  
    
}
