package com.example.yemeksepetim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnRatingBarChangeListener {

	 RatingBar ratingBar;
	 Spinner spin1,spin2,spin3;
	 SeekBar seek_bar1, seek_bar2,seek_bar3;
	 TextView txt1, txt2, txt3,txt4;
	 Button bt1, bt2, bt3,bt4,bt5;
	 String yemekSiparis,icecekSiparis,salataSiparis, fatura  = "Yemek.txt";
	 int yemekAdet, salataAdet, icecekAdet,siparisID=100, okunanID=0;
	 Double yemekFiyat, salataFiyat, icecekFiyat,toplamFiyat=0.0;
	 
   ArrayList<String> siparis = new ArrayList<String>() ;
  
    
   private void save(String filename, ArrayList<String> siparisyaz)
    {
        try
        {	
        	
            FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
            for ( int  i = 0 ; i < siparisyaz.size() ; i++){
            fos.write(siparisyaz.get(i).getBytes());
            }
            fos.close();
        	Toast.makeText(getApplicationContext(),"Kaydedildi",Toast.LENGTH_SHORT).show();
            
        }
        
        catch (Exception ex)
        {
        	Toast.makeText(getApplicationContext(),"Error saving file: " + ex.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }

        
    }
    private void load(String filename)
    {
        try
        {
            FileInputStream fis = openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = reader.readLine()) != null){
            	
            	if( line.substring(0, 3).equals("sip")){
            		continue;
            	}
            	else{
            		okunanID = Integer.parseInt(line.substring(0, 3));
            		if(okunanID==siparisID){
            			siparisID+=1;
            			load(fatura);
            		}
            		
            	}
           	}
            reader.close();
            fis.close();
        }
        catch (Exception ex)
        {
        	//Yeni bir dosyaya yazdırırken başına siparisID ve Siparisler yazmak için bu blogu kullan 
            try {
            	// dosya yoksa burada dosya olusturulup içine siparişler ve siparişIDler yazılır.
            	FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
				fos.write("siparisID\t\tSiparisler\n".getBytes());
				fos.close();
				Toast.makeText(getApplicationContext(), "Dosya Olusturuldu.", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
	        	Toast.makeText(getApplicationContext(),"Error saving file: " + ex.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
        }
    }
    
     

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		load(fatura);
		siparis.add(siparisID+"\t\t\t\t");
		txt4 = (TextView)findViewById(R.id.textView12);
		
		ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
		ratingBar.setOnRatingBarChangeListener(this);
		
		bt1=(Button)findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Double yemekToplamFiyat = yemekAdet*yemekFiyat;
				siparis.add(yemekSiparis+ "   Miktar : " + yemekAdet+" --> Fiyat: "+yemekToplamFiyat+" TL ");
				
				toplamFiyat+=yemekToplamFiyat;
		    	
			}
		});
		
		
		
		
		bt2=(Button)findViewById(R.id.button2);
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Double icecekToplamFiyat = icecekAdet*icecekFiyat;
				siparis.add(icecekSiparis+ "   Miktar : " + icecekAdet+" --> Fiyat: "+icecekToplamFiyat+" TL ");
				toplamFiyat = toplamFiyat + icecekToplamFiyat; 
			}
		});
		
		bt3=(Button)findViewById(R.id.button3);
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Double salataToplamFiyat = salataAdet*salataFiyat;
				siparis.add(salataSiparis + "   Miktar : "+salataAdet+" --> Fiyat: "+salataToplamFiyat+" TL ");
			toplamFiyat = toplamFiyat + salataToplamFiyat;
			}
		});
		
		
		
		bt4 = (Button)findViewById(R.id.button4);
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String toplamFiyati = toplamFiyat.toString();
				siparis.add("Toplam Tutar : "+toplamFiyati+" TL ");
				siparis.add("Raiting : "+txt4.getText()+"\n");
		
				save(fatura, siparis);	
			}
		});
		
		bt5 = (Button)findViewById(R.id.button5);
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				siparis.clear();
				toplamFiyat = 0.0;
				onCreate(null);
				
			}
		});
		
		 final HashMap<String, Double> yemek = new HashMap<String, Double>();			
	     yemek.put("Bolu Köfte 9.90 TL",9.90);
	     yemek.put("Kasap Köfte 9.90 TL",9.90);
	     yemek.put("Tavuk Pirzola 9.50 TL",9.50);
	     yemek.put("Tavuk Şiş 9.50 TL",9.50);
	     yemek.put("Kuzu Pirzola 15.00 TL",15.0);
	     yemek.put("Kuzu Şiş 15.00 TL",15.0);
	     yemek.put("Dana Biftek 15.00 TL",15.0);
	     yemek.put("Dana Sadra 15.00 TL",15.0);
	     yemek.put("Et Şiş 15.00 TL",15.0);
	     yemek.put("Bolu Special Izgara 40.00 TL" ,40.0);
																		
		 
		 
		 final HashMap<String, Double> icecek = new HashMap<String, Double>();
			 
			 icecek.put("Pepsi (33 cl.) 2.50 TL",2.50);
			 icecek.put("Pepsi Light (33 cl.) 2.50 TL",2.50);
			 icecek.put("Yedigün (33 cl.)  2.50 TL",2.50);
			 icecek.put("Meyve Suyu (33 cl.) 2.50 TL",2.50);
			 icecek.put("Ayran (30 cl.) 1.50 TL",1.50);
			 icecek.put( "Su 1.00 TL",1.0);
			        
		 
		 
			 
		 final HashMap<String,Double> salata = new HashMap<String, Double>();
		 
		 salata.put("Çoban Salata  4.00 TL",4.00);
		 salata.put("Mevsim Salata  4.00 TL",4.00);
		 salata.put("Akdeniz Salata  8.00 TL",8.00);
		 salata.put("Ege Salata 8.50 TL",8.50);
		 salata.put("Tavuk Salata 10.50 TL",10.50);
		 salata.put("Piyaz 5.00 TL",5.0);
			final List<String> yem = new ArrayList<String>(yemek.keySet());
			final List<String> ice = new ArrayList<String>(icecek.keySet());
			final List<String> sal = new ArrayList<String>(salata.keySet());

				 spin1 = (Spinner) findViewById(R.id.spinner1);
				  final ArrayAdapter<String> adapteryemek = new ArrayAdapter<String>(this,
				    android.R.layout.simple_list_item_checked, android.R.id.text1,yem);
				  spin1.setAdapter(adapteryemek);
				  spin1.setOnItemSelectedListener(new OnItemSelectedListener() {
					  public void onItemSelected(AdapterView<?> parent, View view,
							     int pos, long id) {
							    yemekSiparis = yem.get(pos);
							    yemekFiyat = yemek.get(yemekSiparis);
							    }

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}});
				  
				  spin2 = (Spinner) findViewById(R.id.spinner2);
				  final ArrayAdapter<String> adaptericecek = new ArrayAdapter<String>(this,
				    android.R.layout.simple_list_item_checked, android.R.id.text1,ice);
				  spin2.setAdapter(adaptericecek);
				  spin2.setOnItemSelectedListener(new OnItemSelectedListener() {
					  public void onItemSelected(AdapterView<?> parent, View view,
							     int pos, long id) {
							    icecekSiparis = ice.get(pos);
							    icecekFiyat = icecek.get(icecekSiparis);
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
						  salataSiparis = sal.get(pos);
						  salataFiyat = salata.get(salataSiparis);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		public void onRatingChanged(RatingBar ratingbar, float rating, boolean fromtouch) {
		// TODO Auto-generated method stub
		final int numStar = ratingbar.getNumStars();
		txt4.setText(" "+rating+"/"+numStar+" ");
		}
}
