package com.example.toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button1,button2;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);


		button1.setOnClickListener(new OnClickListener() {

			  @Override
			  public void onClick(View arg0) {

			     Toast.makeText(getApplicationContext(),
                               "Hello", Toast.LENGTH_LONG).show();

			  }
		});
	
	button2.setOnClickListener(new OnClickListener() {

		  @Override
		  public void onClick(View arg0) {

		     Toast.makeText(getApplicationContext(),
                         "Goodbyy", Toast.LENGTH_LONG).show();

		  }
	});
}
}