package com.example.firstexample;

import android.os.Bundle;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bu kisimda textview edittext ve buttonlarý tanimladim.
        final TextView tview = (TextView) findViewById(R.id.textView1);
        final EditText etext  = (EditText) findViewById(R.id.editText1);
        Button bttn = (Button) findViewById(R.id.button1);
        // butona tiklandiginda edittext de yazan metni textview de görmek için 
        // týklama olayýný tanýmladým.
        bttn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			tview.setText(etext.getText());				
			}
		});
    }


    
    
}
