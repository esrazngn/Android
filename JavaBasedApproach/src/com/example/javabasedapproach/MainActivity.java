package com.example.javabasedapproach;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        String message= "...";
        LinearLayout window = new LinearLayout(this);
        Button b = new Button(this);
        b.setText("Button Label");
        b.setOnClickListener(new  SomeHandler());
        window.addView(b);
        setContentView(window);
        
        
        
    }
    public class SomeHandler implements OnClickListener{

		@Override
		public void onClick(View clickedbutton) {
			
			
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
