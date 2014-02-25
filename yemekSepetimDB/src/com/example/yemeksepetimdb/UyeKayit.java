package com.example.yemeksepetimdb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UyeKayit extends Activity{
	Button kayit;
	EditText kullaniciAdi , sifre , sifreT;
	TextView mesaj;
	MySQLiteHelper db = new MySQLiteHelper(this);
	String yad, ysifre ;
	List<Kullanici > kullaniciListem ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uyekayit);
		
		mesaj = (TextView)findViewById(R.id.textView5);
		kullaniciListem = db.getAllKullanici();
		kullaniciAdi = (EditText)findViewById(R.id.editText1);
		sifre = (EditText)findViewById(R.id.editText2);
		sifreT = (EditText)findViewById(R.id.editText3);
		
		
		kayit =(Button)findViewById(R.id.button1);
		kayit.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				Boolean durum = true;
				String kullanici = (kullaniciAdi.getText()).toString();
				String sif1 = sifre.getText().toString();
				String sif2 = sifreT.getText().toString();
				System.out.println("boyut "+kullaniciListem.size());
				for (int i = 0; i<kullaniciListem.size(); i++)
				{
					System.out.println("kullanici Listem : "+kullaniciListem.get(i).getKullaniciAd()+
						"kullanici :"+kullanici+"sifre1 : "+sif1+"sifre 2 : " +sif2);
					if(kullanici.equals(kullaniciListem.get(i).getKullaniciAd()))
					{
						System.out.println("eþit");
						mesaj.setText("Daha önceden bu kullanýcý adý kullanýlmýþtýr.");
						durum = false;
					}
				}
				if(durum == true)
				{
					if(!sif1.equals(sif2))
					{
						mesaj.setText("sifreler uyusmuyor");
					}
					else{
						db.addKullanici(new Kullanici(kullanici, sif1, "0"));
						Toast.makeText(getApplicationContext(), "Kullanýcý Kayýt Baþarýlý...", Toast.LENGTH_SHORT).show();
						Intent giris = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(giris);
					}
				}
				
				
				
				
			}
		});
		
		
	}

}
