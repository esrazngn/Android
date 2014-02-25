package com.example.yemeksepetimdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Siparis extends Activity 
{
	MySQLiteHelper db = new MySQLiteHelper(this);
	
	
	 Spinner spin1,spin2,spin3;
	 SeekBar seek_bar1, seek_bar2,seek_bar3;
	 TextView txt1, txt2, txt3,txt4;
	 Button bt1, bt2, bt3, kaydet, yeni, cikis;
	 String yemekSiparis,icecekSiparis,salataSiparis, yemekYaz = "", icecekYaz = "", salataYaz = "";
	 int yemekAdet, salataAdet, icecekAdet, yemekFiyat, salataFiyat, icecekFiyat,toplamFiyat=0;
	
	 ArrayList<String> yemekSiparisListe = new ArrayList<String>() ;
	 ArrayList<String> icecekSiparisListe = new ArrayList<String>() ;
	 ArrayList<String> salataSiparisListe = new ArrayList<String>() ;

	 
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.siparis);
		
		
		
		bt1=(Button)findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int yemekToplamFiyat = yemekAdet*yemekFiyat;
				yemekYaz += yemekSiparis+ "   Miktar : " + yemekAdet+" --> Fiyat: "+yemekToplamFiyat+" TL ";
				toplamFiyat+=yemekToplamFiyat;
		    	System.out.println(yemekYaz);
			}
		});
		
		bt2=(Button)findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int icecekToplamFiyat = icecekAdet*icecekFiyat;
				icecekYaz += icecekSiparis+ "   Miktar : " + icecekAdet+" --> Fiyat: "+icecekToplamFiyat+" TL ";
				toplamFiyat = toplamFiyat + icecekToplamFiyat; 
				System.out.println(icecekYaz);
			}
		});
		
		bt3=(Button)findViewById(R.id.button3);
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int salataToplamFiyat = salataAdet*salataFiyat;
				salataYaz += salataSiparis + "   Miktar : "+salataAdet+" --> Fiyat: "+salataToplamFiyat+" TL ";
				toplamFiyat = toplamFiyat + salataToplamFiyat;
				System.out.println(salataYaz);
			}
		});
		
		yeni = (Button)findViewById(R.id.button5);
		yeni.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salataSiparisListe.clear();
				toplamFiyat = 0;
				onCreate(null);
				
			}
		});
		
		kaydet = (Button) findViewById(R.id.button4);
		kaydet.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				List<Siparisim> siparis = db.getAllSiparis();
				Date tarih = new Date();
			db.addSiparis(new Siparisim(siparis.size()+1, yemekYaz, icecekYaz,salataYaz,toplamFiyat+"", tarih.toString()));
				System.out.println(toplamFiyat);
			}
		});
		
		cikis = (Button)findViewById(R.id.button6);
		cikis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent cikis = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(cikis);
				
			}
		});

		final List<Yemek > yemekListem;
		yemekListem = db.getAllYemek();
		final List<String> yem = new ArrayList<String>(yemekListem.size());

		
		for (int i = 0; i<yemekListem.size(); i++)
		{
			String yemek = yemekListem.get(i).getAd() +"  "+ yemekListem.get(i).getFiyat() +" TL";
			yem.add(yemek);
		}
		
		final List<Icecek> icecekListem;
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
				  yemekSiparis = yemekListem.get(pos).getAd();
				  yemekFiyat = yemekListem.get(pos).getFiyat();
			  }
			  
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) 	
			  {
				// TODO Auto-generated method stub
				
			  }
		  } );
		  
		  
		  spin2 = (Spinner) findViewById(R.id.spinner2);
		  final ArrayAdapter<String> adaptericecek = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,ice);
		  spin2.setAdapter(adaptericecek);
		  spin2.setOnItemSelectedListener(new OnItemSelectedListener() {
			  public void onItemSelected(AdapterView<?> parent, View view,
					     int pos, long id) {
				  		icecekSiparis = icecekListem.get(pos).getAd();
					    icecekFiyat = icecekListem.get(pos).getFiyat();
					    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			
			  }})	;	
		  
		  spin3 = (Spinner) findViewById(R.id.spinner3);
		  final ArrayAdapter<String> adaptersalata = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,sal);
		  spin3.setAdapter(adaptersalata);
		  spin3.setOnItemSelectedListener(new OnItemSelectedListener() {
			  public void onItemSelected(AdapterView<?> parent, View view,
					     int pos, long id) {
				  salataSiparis = salataListem.get(pos).getAd();
				  salataFiyat = salataListem.get(pos).getFiyat();
					    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			
			  }
			})	;	
	
		  
		  txt1 = (TextView) (findViewById(R.id.textView4));
		  txt2 = (TextView) (findViewById(R.id.textView7));
		  txt3 = (TextView) (findViewById(R.id.textView10));
	       
	       
	       
	
		  seek_bar1 = (SeekBar) findViewById(R.id.seekBar1);
    
		  seek_bar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

		@Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            // TODO Auto-generated method stub
            seek_bar1.setMax(10);
            txt1.setText(String.valueOf(progress));
            yemekAdet = progress;                

        }
    });
    
    
		  seek_bar2 = (SeekBar) findViewById(R.id.seekBar2);
    
		  seek_bar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            // TODO Auto-generated method stub
            seek_bar2.setMax(10);
            txt2.setText(String.valueOf(progress));
            icecekAdet = progress;
            
            

        }
    });
    
    
		  seek_bar3 = (SeekBar) findViewById(R.id.seekBar3);
    
		  seek_bar3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        	
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            // TODO Auto-generated method stub
            seek_bar3.setMax(10);
            txt3.setText(String.valueOf(progress));
            salataAdet = progress;
            

        }
    });
	
	}
}
