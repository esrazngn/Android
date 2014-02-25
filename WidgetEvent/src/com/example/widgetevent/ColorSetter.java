package com.example.widgetevent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;


public class ColorSetter implements OnClickListener, android.view.View.OnClickListener {
	private int regionColor;
	private MainActivity mainActivity;
	public ColorSetter (int regionColor, MainActivity mainActivity){
		this.regionColor = regionColor;
		this.mainActivity = mainActivity;
		
	}


	@Override
	public void onClick(DialogInterface dialog, int which) {
		
	}


	@Override
	public void onClick(View v) {
		mainActivity.setRegionColor(regionColor);
		
	}
	
	

}