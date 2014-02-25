package com.esc.renkler;

import android.view.View;
import android.view.View.OnClickListener;

public class RenkSinifi implements OnClickListener {
	
	private int renkKodu;
	private Renkler renkler;
	
	public RenkSinifi(int renkKodu,Renkler renkler) {
		this.renkKodu=renkKodu;
		this.renkler=renkler;
	}

	@Override
	public void onClick(View arg0) {
		renkler.setBackgroundcolor(renkKodu);
		
	}
	

}
