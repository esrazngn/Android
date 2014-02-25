package com.example.usingaseparatelistener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {
		private View mColorRegion;
		@Override
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mColorRegion = findViewById(R.id.color_region);
		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		Button b3 = (Button)findViewById(R.id.button3);
		RadioButton r1 =
		(RadioButton)findViewById(R.id.radio_button1);
		RadioButton r2 =
		(RadioButton)findViewById(R.id.radio_button2);
		RadioButton r3 =
		(RadioButton)findViewById(R.id.radio_button3);

		b1.setOnClickListener(new ColorSetter(Color.RED, this));
		b2.setOnClickListener(new ColorSetter(Color.BLUE, this));
		b3.setOnClickListener(new ColorSetter(Color.YELLOW, this));
		r1.setOnClickListener(new ColorSetter(Color.RED, this));
		r2.setOnClickListener(new ColorSetter(Color.BLUE, this));
		r3.setOnClickListener(new ColorSetter(Color.YELLOW, this));
}
public void setRegionColor(int color) {
mColorRegion.setBackgroundColor(color);
}
}