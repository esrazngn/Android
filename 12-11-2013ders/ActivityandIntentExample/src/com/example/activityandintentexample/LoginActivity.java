package com.example.activityandintentexample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtuser = (TextView)findViewById(R.id.txtuser);
        TextView txtpassword = (TextView)findViewById(R.id.txtpass);

        Intent gelenintent = getIntent();
        Bundle gelenbnd = gelenintent.getExtras();
        txtuser.setText(gelenbnd.getString("userID"));
        txtpassword.setText(gelenbnd.getString("userpassword"));
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
