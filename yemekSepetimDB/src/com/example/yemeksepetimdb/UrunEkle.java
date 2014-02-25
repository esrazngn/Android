package com.example.yemeksepetimdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UrunEkle extends Activity
{
	MySQLiteHelper db = new MySQLiteHelper(this);
	Button yemekEkle, icecekEkle, salataEkle, geri;
	EditText yemek, yfiyat, icecek, ifiyat, salata, sfiyat;
	String eklenecekYemek, eklenecekIcecek, eklenencekSalata;
	int eklenecekYfiyat, eklenecekIfiyat, eklenecekSfiyat;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.urunekle);
		
		yemek = (EditText) findViewById(R.id.editText1);
		yfiyat = (EditText)findViewById(R.id.editText2);
		
		icecek = (EditText) findViewById(R.id.editText3);
		ifiyat = (EditText)findViewById(R.id.editText4);
		
		salata = (EditText) findViewById(R.id.editText5);
		sfiyat = (EditText)findViewById(R.id.editText6);
		
		
		yemekEkle = (Button)findViewById(R.id.button1);
		yemekEkle.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				
				eklenecekYemek = yemek.getText().toString();
				eklenecekYfiyat = Integer.parseInt(yfiyat.getText().toString());
				System.out.println(eklenecekYemek+eklenecekYfiyat);
				if(!eklenecekYemek.equals(null))
				{
					System.out.println(eklenecekYemek+eklenecekYfiyat);
					db.addYemek(new Yemek(eklenecekYemek, eklenecekYfiyat));
				}
			}
		});
	
		icecekEkle = (Button)findViewById(R.id.button2);
		icecekEkle.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				
				eklenecekIcecek = icecek.getText().toString();
				eklenecekIfiyat = Integer.parseInt(ifiyat.getText().toString());
				if(!eklenecekIcecek.equals(null))
				{
					db.addIcecek(new Icecek(eklenecekIcecek, eklenecekIfiyat));
				}
			}
		});
		
		
		salataEkle = (Button)findViewById(R.id.button3);
		salataEkle.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				
				eklenencekSalata = salata.getText().toString();
				eklenecekSfiyat = Integer.parseInt(sfiyat.getText().toString());
				if(!eklenencekSalata.equals(null))
				{
					db.addSalata(new Salata(eklenencekSalata, eklenecekSfiyat));
				}
			}
		});
		
		geri = (Button)findViewById(R.id.button4);
		geri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent admin = new Intent(getApplicationContext(), AdminGiris.class);
				startActivity(admin);
				
			}
		});
	}
	
	

}
