package com.esc.renkler;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Renkler extends Activity {
	private View colorrgb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_renkler);
		colorrgb = findViewById(R.id.textView1);
		Button button1=(Button)findViewById(R.id.button1);
		Button button2=(Button)findViewById(R.id.button2);
		Button button3=(Button)findViewById(R.id.button3);
		RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton1);
		RadioButton radioButton2=(RadioButton)findViewById(R.id.radioButton2);
		RadioButton radioButton3=(RadioButton)findViewById(R.id.radioButton3);
		button1.setOnClickListener(new RenkSinifi(Color.RED, this));
		button2.setOnClickListener(new RenkSinifi(Color.BLUE, this));
		button3.setOnClickListener(new RenkSinifi(Color.GREEN, this));
		radioButton1.setOnClickListener(new RenkSinifi(Color.RED, this));
		radioButton2.setOnClickListener(new RenkSinifi(Color.BLUE, this));
		radioButton3.setOnClickListener(new RenkSinifi(Color.GREEN, this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.renkler, menu);
		return true;
	}
	public void setBackgroundcolor(int color){
		colorrgb.setBackgroundColor(color);
	}

}
