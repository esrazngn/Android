package com.example.localizationlanguage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	    }
	    
	    public void confirmRegistration(View clickedButton) {
	        String message = getString(R.string.confirmed);
	        showToast(message);
	    }
	    
	    private void showToast(String text) {
	        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	    }
	}