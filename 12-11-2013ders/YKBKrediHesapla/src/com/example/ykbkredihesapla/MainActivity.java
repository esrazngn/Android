package com.example.ykbkredihesapla;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements OnItemSelectedListener {
	Spinner spinner;
    SeekBar seek_bar1, seek_bar2;
    String secilenKredi,tur;
    Double aylikTaksitTutari=0.0, yillikFaizOrani=0.0, faizMiktari=0.0, kkdf=0.0, bsmv=0.0, anaPara=0.0, kalanPara=0.0, geriOdenecekMiktar=0.0,faiz=0.0;
    int krediMiktari = 0, taksitSayisi;
    EditText edt1;
	EditText edt2;
	TextView txt1;
    String tutar,toplam;
    
    public Double aylikTaksitTutariHesapla(int KrediMiktari, double faizOrani, int taksitSayisi, String tur, double kkdf, double bsmv){
    	faizMiktari = FaizHesapla(KrediMiktari, faizOrani);
    	double faizi;
    	
    	faizi = (faizOrani+kkdf+bsmv);
    	
    	aylikTaksitTutari = (KrediMiktari*(faizi/100))/(1-(1/(Math.pow(1+(faizi/100),taksitSayisi))));
    	return aylikTaksitTutari;
    
    }
    
    public Double FaizHesapla(int KrediMiktari, double faizOrani ){
    	yillikFaizOrani = faizOrani * 12;
    	faizMiktari = KrediMiktari*yillikFaizOrani*0.00083333;
    	return faizMiktari;
    }
    
    public Double kkdf (double faizMiktari){
    	
    	if (tur.equals("Konut") || tur.equals("Tadilat Kredisi")){
    		return 0.0;
    	}
    	else{
    	kkdf = faizMiktari*0.15;
    	return kkdf;
    	}
    }
    
    public Double bsmv (double faizMiktari){
    	if (tur.equals("Konut")|| tur.equals("Tadilat Kredisi")){
    		return 0.0;
    	}
    	else{
    	bsmv = faizMiktari*0.05;
    	return bsmv;
    	}
    
    }
    public Double anaPara (double taksitTutari, double faizMiktari, double kkdf, double bsmv ){
    	anaPara = taksitTutari-faizMiktari-kkdf-bsmv;
    	return anaPara;
    }
    
    public Double kalanPara(double krediTutari, double ilkTaksit ){
    	kalanPara = krediTutari - ilkTaksit;
    	return kalanPara;
    }
    public double geriOdenecekMikter(double taksitTutari, int taksitSayisi){
    	geriOdenecekMiktar = taksitTutari * taksitSayisi;
    	return geriOdenecekMiktar;
    }
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinner = (Spinner)findViewById(R.id.spinner1);
		
		 edt1 = (EditText)findViewById(R.id.editText1);
		 edt2 = (EditText)findViewById(R.id.editText2);
		 txt1 = (TextView)findViewById(R.id.textView8);
        
        seek_bar1 = (SeekBar) findViewById(R.id.seekBar1);
        
        seek_bar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
 
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
 
            }
 
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               
 
            }
 
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                    boolean fromUser) {
                // TODO Auto-generated method stub
               
            	seek_bar1.setMax(60);
                edt1.setText(String.valueOf(progress));
                 
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
                seek_bar2.setMax(1000000);
                edt2.setText(String.valueOf(progress));
                
                
                
 
            }
        });
        final HashMap<String, Double> krediTipi = new HashMap<String, Double>();			
	     krediTipi.put("Bireysel İhtiyaç Kredisi",1.18);
	     krediTipi.put("Eğitim Kredisi",1.29);
	     krediTipi.put("İpotekli Bireysel Fin.Krd.",1.19);
	     krediTipi.put("Kaskolu 0 Km. Taşıt",1.4);
	     krediTipi.put("Kaskolu 2. El Taşıt",1.45);
	     krediTipi.put("Kaskosuz 0 Km. Taşıt",1.45);
	     krediTipi.put("Kaskosuz 2. El Taşıt",1.5);
	     krediTipi.put("Konut",0.98);
	     krediTipi.put("Motorsiklet Kredisi",1.69);
	     krediTipi.put("Opelsan",0.98);
	     krediTipi.put("Otosan",1.2);
	     krediTipi.put("Tadilat Kredisi",1.04);
	     krediTipi.put("Tekne Kredisi",1.2);

			final List<String> kredi = new ArrayList<String>(krediTipi.keySet());

        spinner = (Spinner) findViewById(R.id.spinner1);
		  final ArrayAdapter<String> adapteryemek = new ArrayAdapter<String>(this,
		    android.R.layout.simple_list_item_checked, android.R.id.text1,kredi);
		  spinner.setAdapter(adapteryemek);
		  spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			  public void onItemSelected(AdapterView<?> parent, View view,
					     int pos, long id) {
        		
        			
				    faiz = krediTipi.get(kredi.get(pos));
        			tur = kredi.get(pos);
        			txt1.setText(" "+krediTipi.get(kredi.get(pos)).toString());
                	
                      	
        	
        	}
        	public void onNothingSelected(AdapterView<?> arg0) {
        	}
        	});
 
        
		 
		 Button b = (Button) findViewById(R.id.button1);
		 b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				krediHesapla();
				Bundle bnd = new Bundle();			
				bnd.putString("aylik",tutar+" TL");
				bnd.putString("toplam",toplam+" TL");
				Intent intent = new Intent(getApplicationContext(), activity2.class);
				intent.putExtras(bnd);
				startActivity(intent);
				
			}
		});}

	

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
public void krediHesapla(){
	krediMiktari = Integer.parseInt(edt2.getText().toString());
    taksitSayisi = Integer.parseInt(edt1.getText().toString());
    kkdf = kkdf(faiz);
    bsmv = bsmv(faiz);
	aylikTaksitTutari = aylikTaksitTutariHesapla(krediMiktari, faiz, taksitSayisi, tur, kkdf ,bsmv );	
	geriOdenecekMiktar = geriOdenecekMikter(aylikTaksitTutari, taksitSayisi);
	DecimalFormat f = new DecimalFormat("###,###.00");
     
    tutar  = f.format(aylikTaksitTutari);
    toplam = f.format(geriOdenecekMiktar);
	
}
}
