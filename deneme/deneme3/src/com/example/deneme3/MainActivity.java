package com.example.deneme3;

import java.util.Random;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private View mColorRegion;
	private int [] mColorChoices = {Color.BLACK, Color.BLUE, Color.GREEN };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mColorRegion = findViewById(R.id.color_region);
        Button colorButton = (Button) findViewById(R.id.color_button);
        colorButton.setOnClickListener(new ColorRandomizer());
        
    }

    private void setRegionColor (int color){
    	mColorRegion.setBackgroundColor(color);
    }
    
    private class ColorRandomizer implements OnClickListener{
    	public void onClick(View v){
    		Random generator = new Random();
    		int index = generator.nextInt(mColorChoices.length);
    		setRegionColor(mColorChoices[index]);
    	}
    }
    
}
