package com.example.mycalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView disp; 
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		disp = (TextView)findViewById(R.id.textView1);
		disp.setText("0"); 
 		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	static boolean isempty=true;
	public void num_Clicked(View sender){
		Button bt = (Button)sender;
		if (disp.getText().length()>7)return;
		if(isempty){
			if(bt.getText().toString().equals("0")) return;
			disp.setText(bt.getText());
			isempty=false;
		}
		else{
			
			disp.append(bt.getText());
		}
}
	static int accumulator = 0;
	static short operationToDo = 0;
	public void op_Clicked(View sender) {
		Button bt = (Button)sender;
		switch(operationToDo){
		case 0:
			accumulator+=Integer.parseInt(disp.getText().toString());
		break;
		case 1:
			accumulator-=Integer.parseInt(disp.getText().toString());
		break;
		case 2:
			accumulator+=Integer.parseInt(disp.getText().toString());
		break;
		case 3:
			accumulator+=Integer.parseInt(disp.getText().toString());
		break;
		}
		disp.setText(Integer.toString(accumulator));	
		if(bt.getText().toString().equals("+")) operationToDo=0;
		if(bt.getText().toString().equals("-")) operationToDo=1;
		if(bt.getText().toString().equals("/")) operationToDo=2;
		if(bt.getText().toString().equals("*")) operationToDo=3;
		isempty=true;
	
		
		
}	}
	
