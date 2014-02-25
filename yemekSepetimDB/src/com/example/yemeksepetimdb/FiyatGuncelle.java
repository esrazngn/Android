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

public class FiyatGuncelle extends Activity{
	 Spinner spin1,spin2,spin3;
	 Button  bt1, bt2, bt3, geri;
	 EditText yemekFiyat, salataFiyat, icecekFiyat;
	 MySQLiteHelper db = new MySQLiteHelper(this);
	 String secilenYemek, secilenIcecek, secilenSalata;

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fiyatguncelle);
		
		yemekFiyat = (EditText)findViewById(R.id.editText1);
		icecekFiyat = (EditText)findViewById(R.id.editText2);
		salataFiyat = (EditText)findViewById(R.id.editText3);

		
		
		final List<Yemek > yemekListem;
		yemekListem = db.getAllYemek();
		final List<String> yem = new ArrayList<String>(yemekListem.size());
		

		for (int i = 0; i<yemekListem.size(); i++)
		{
			String yemek = yemekListem.get(i).getAd() +"  "+ yemekListem.get(i).getFiyat() +" TL";
			yem.add(yemek);
		}
		
		
		final List<Icecek > icecekListem;
		icecekListem = db.getAllIcecek();
		final List<String> ice = new ArrayList<String>(icecekListem.size());
		

		for (int i = 0; i<icecekListem.size(); i++)
		{
			String icecek = icecekListem.get(i).getAd() +"  "+ icecekListem.get(i).getFiyat() +" TL";
			ice.add(icecek);
		}
		
		
		final List<Salata> salataListem;
		salataListem = db.getAllSalata();
		final List<String> sal = new ArrayList<String>(salataListem.size());
		

		for (int i = 0; i<salataListem.size(); i++)
		{
			String salata = salataListem.get(i).getAd() +"  "+ salataListem.get(i).getFiyat() +" TL";
			sal.add(salata);
		}
		
		spin1 = (Spinner) findViewById(R.id.spinner1);
		  final ArrayAdapter<String> adapteryemek = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,yem);
		  spin1.setAdapter(adapteryemek);
		  spin1.setOnItemSelectedListener(new OnItemSelectedListener() 
		  {
			  public void onItemSelected(AdapterView<?> parent, View view,
					  int pos, long id) 
			  {	
				  secilenYemek = yemekListem.get(pos).getAd();
			  }
			  
			  public void onNothingSelected(AdapterView<?> arg0) 	
			  {
				// TODO Auto-generated method stub
				
			  }
		  } );
		  
		  spin2 = (Spinner) findViewById(R.id.spinner2);
		  final ArrayAdapter<String> adaptericecek = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,ice);
		  spin2.setAdapter(adaptericecek);
		  spin2.setOnItemSelectedListener(new OnItemSelectedListener() 
		  {
			  public void onItemSelected(AdapterView<?> parent, View view,
					  int pos, long id) 
			  {	
				  secilenIcecek = icecekListem.get(pos).getAd();
			  }
			  
			  public void onNothingSelected(AdapterView<?> arg0) 	
			  {
				// TODO Auto-generated method stub
				
			  }
		  } );
		  
		  
		  spin3 = (Spinner) findViewById(R.id.spinner3);
		  final ArrayAdapter<String> adaptersalata = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,sal);
		  spin3.setAdapter(adaptersalata);
		  spin3.setOnItemSelectedListener(new OnItemSelectedListener() 
		  {
			  public void onItemSelected(AdapterView<?> parent, View view,
					  int pos, long id) 
			  {	
				  secilenSalata = salataListem.get(pos).getAd();
			  }
			  
			  public void onNothingSelected(AdapterView<?> arg0) 	
			  {
				// TODO Auto-generated method stub
				
			  }
		  } );
		  
		  
		  bt1 = (Button)findViewById(R.id.button1);
		  bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.updateYemek(new Yemek(secilenYemek, Integer.parseInt(yemekFiyat.getText().toString())));
				
			}
		});
		  
		  bt2 = (Button)findViewById(R.id.button2);
		  bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.updateIcecek(new Icecek(secilenIcecek, Integer.parseInt(icecekFiyat.getText().toString())));
				
			}
		});
		  
		  bt3 = (Button)findViewById(R.id.button3);
		  bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.updateSalata(new Salata(secilenSalata, Integer.parseInt(salataFiyat.getText().toString())));
				
			}
		});
		
		geri = (Button) findViewById(R.id.button4);
		geri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent geri = new Intent(getApplicationContext(), AdminGiris.class);
				startActivity(geri);
				
			}
		});
	}

}
