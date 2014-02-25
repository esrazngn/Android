package com.example.odevim;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main extends Activity {
    Button but1,but2,but3;
    String status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 Button b = (Button) findViewById(R.id.button1);
		 final Button but1 = (Button) findViewById(R.id.bt1);
		 final CheckBox chk1 = (CheckBox) findViewById(R.id.chk1);
		 final CheckBox chk2 = (CheckBox) findViewById(R.id.chk2);
		 final RadioButton rad1 = (RadioButton)findViewById(R.id.rad1);
		 final RadioButton rad2 = (RadioButton)findViewById(R.id.rad2);
		 
		 
		 b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if( but1.isClickable()   &status == "ON" &  chk1.isChecked()  & !chk2.isChecked() & rad2.isChecked() & !rad1.isChecked()  ){
				Intent intent = new Intent(getApplicationContext(), sonraki.class);
					startActivity(intent);
				}
				else{
					showToast("Gerekli butonlara basilmadığında diğer sayfaya yönlendirilemiyor");
					
					
				}
				
			}
		});
		 
		}
	
	
	
	public void showToggleButtonInfo(View clickedToggleButton) { 
        ToggleButton toggleButton = (ToggleButton)clickedToggleButton;
        
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        
    }
	  private void showToast(String text) {
	        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	    }
}
