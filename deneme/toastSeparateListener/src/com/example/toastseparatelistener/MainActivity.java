package com.example.toastseparatelistener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button1,button2;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);


		button1.setOnClickListener(new ToastSetter("Hello", this));
		button2.setOnClickListener(new ToastSetter("GoodBye", this));
	}
		public String setMessage(String message){
			Toast.makeText(getApplicationContext(),
                    message, Toast.LENGTH_LONG).show();
			return message;
		}
	
	
	}
		
