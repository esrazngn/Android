package com.example.toastseparatelistener;

import android.view.View;
import android.view.View.OnClickListener;

public class ToastSetter implements OnClickListener{
	private String message;
	private MainActivity mainActivity;
	
	public ToastSetter(String message, MainActivity mainActivity){
		this.message=message;
		this.mainActivity=mainActivity;
	}
	@Override
	public void onClick(View v) {
		mainActivity.setMessage(message);
		
	}
	
}