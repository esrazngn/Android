package com.example.xmlapproach;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class XMLMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlmain);
    }
public void showToast(View v) {
	String greetingText = getString(R.string.greeting_test);
	Toast tempMessage = Toast.makeText(this, greetingText, Toast.LENGTH_SHORT);
	tempMessage.show();
}


    
}
