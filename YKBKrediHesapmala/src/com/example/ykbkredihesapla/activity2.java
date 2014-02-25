package com.example.ykbkredihesapla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class activity2 extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity2);
	TextView txt1 = (TextView)findViewById(R.id.text2);
	TextView txt2 = (TextView)findViewById(R.id.text4);
	
	Bundle veri = getIntent().getExtras();
	String gelen = veri.getString("aylik");
	String gelen1 = veri.getString("toplam");
	txt1.setText(gelen);
	txt2.setText(gelen1);
	Button geri = (Button)findViewById(R.id.button1);
	geri.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			
		}
	});


}
	}




