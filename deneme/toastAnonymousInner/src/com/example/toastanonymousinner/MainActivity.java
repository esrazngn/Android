package com.example.toastanonymousinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	String message;
	private String setToast(String message){
		Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_LONG).show();
		return message;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setToast("Hello");
				
			}
		});
    
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setToast("Goodbye");
			}	
			
		});
    }
        

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
