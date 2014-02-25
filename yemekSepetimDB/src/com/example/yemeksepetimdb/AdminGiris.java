package com.example.yemeksepetimdb;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminGiris extends Activity
{
	Button urunEkle, siparisListele, fiyatGuncelle, cikis;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admingiris);
		
		siparisListele = (Button)findViewById(R.id.button1);
		siparisListele.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent siparis = new Intent(getApplicationContext(), SiparisListele.class);
				startActivity(siparis);
				
			}
		});

		
		fiyatGuncelle = (Button) findViewById(R.id.button3);
		fiyatGuncelle.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent fiyat = new Intent(getApplicationContext(), FiyatGuncelle.class);
				startActivity(fiyat);
				
			}
		});
		
		urunEkle = (Button) findViewById(R.id.button2);
		urunEkle.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent urun = new Intent(getApplicationContext(), UrunEkle.class);
				startActivity(urun);
				
			}
		});
		
		cikis = (Button)findViewById(R.id.button4);
		cikis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent anasayfa = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(anasayfa);
				
			}
		});
		
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

}
