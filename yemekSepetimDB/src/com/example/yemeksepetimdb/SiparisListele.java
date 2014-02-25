package com.example.yemeksepetimdb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SiparisListele extends Activity{
	Spinner spin1;
	Button listele, geri;
	TextView yemekListele, icecekListele, salataListele, fiyat, tarih;
	 MySQLiteHelper db = new MySQLiteHelper(this);
	 String yemek ,icecek, salata, fiyati, tarihi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.siparislistele);
		
		yemekListele = (TextView)findViewById(R.id.textView4);
		icecekListele = (TextView)findViewById(R.id.textView6);
		salataListele = (TextView)findViewById(R.id.textView8);
		fiyat = (TextView)findViewById(R.id.textView10);
		tarih = (TextView)findViewById(R.id.textView12);
		
		final List<Siparisim> siparisListem;
		siparisListem = db.getAllSiparis();
		final ArrayList<String> sip = new ArrayList<String>(siparisListem.size());
		
		for (int i = 0; i<siparisListem.size(); i++)
		{
			String siparisID = (siparisListem.get(i).getSiparisID())+"";
			sip.add(siparisID);
		}
		
		
		spin1 = (Spinner) findViewById(R.id.spinner1);
		  final ArrayAdapter<String> adaptersiparis = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,sip);
		  spin1.setAdapter(adaptersiparis);
		  spin1.setOnItemSelectedListener(new OnItemSelectedListener() 
		  {
			  public void onItemSelected(AdapterView<?> parent, View view,
					  int pos, long id) 
			  {	
				  yemek = siparisListem.get(pos).getYemekler();
				  icecek = siparisListem.get(pos).getIcecekler();
				  salata = siparisListem.get(pos).getSalata();
				  fiyati = siparisListem.get(pos).getFiyat();
				  tarihi = siparisListem.get(pos).getDate();
			  }
			  
			  public void onNothingSelected(AdapterView<?> arg0) 	
			  {
				// TODO Auto-generated method stub
				
			  }
		  } );
		  
		  listele = (Button)findViewById(R.id.button1);
		  listele.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				yemekListele.setText(yemek);
				icecekListele.setText(icecek);
				salataListele.setText(salata);
				fiyat.setText(fiyati+" TL");
				tarih.setText(tarihi);
			}
		});
		  
		  geri = (Button)findViewById(R.id.button2);
		  geri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent geri = new Intent(getApplicationContext(), AdminGiris.class);
				startActivity(geri);
				
			}
		});
		
		
	}

}
