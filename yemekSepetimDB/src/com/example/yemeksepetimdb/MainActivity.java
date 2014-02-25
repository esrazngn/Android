package com.example.yemeksepetimdb;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
	EditText kullaniciAd, sifre;
	String okunanKullaniciSifre, girilenKullaniciAd, girilenSifre,okunanYetki;
	Button giris, kayit;
    MySQLiteHelper db = new MySQLiteHelper(this);
    List<Kullanici> okunanKullaniciAd ;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		giris = (Button) findViewById(R.id.button1);
		final Intent admin = new Intent(getApplicationContext(), AdminGiris.class);
		final Intent siparis = new Intent(getApplicationContext(), Siparis.class);

		kayit = (Button)findViewById(R.id.button2);
		kayit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				final Intent kayit = new Intent(getApplicationContext(), UyeKayit.class);
				startActivity(kayit);
				
			}
		});
		
		
		giris.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				kullaniciAd = (EditText)findViewById(R.id.editText1);
				sifre = (EditText) findViewById(R.id.editText2); 
				
				girilenKullaniciAd = kullaniciAd.getText().toString();
				girilenSifre = sifre.getText().toString();
				
				
				List<Kullanici> kullaniciListesi = 	db.getAllKullanici();
				for(int i = 0; i<kullaniciListesi.size(); i++)
				{
					Log.d("kullanici adi ", kullaniciListesi.get(i).getKullaniciAd().toString());
					System.err.println("yetki "+ kullaniciListesi.get(i).getYetki());

					if(kullaniciListesi.get(i).getKullaniciAd().toString().equals(girilenKullaniciAd))
					{
						if(kullaniciListesi.get(i).getSifre().toString().equals(girilenSifre))
						{
							Toast.makeText(getApplicationContext(), "baþarýlý giriþ", Toast.LENGTH_SHORT).show();
							if(kullaniciListesi.get(i).getYetki().equals("1"))
							{	
								startActivity(admin);
							}
							else
							{
								startActivity(siparis);
							}
						}
						else
						{
							Toast.makeText(getApplicationContext(), "Þifre Hatasý", Toast.LENGTH_SHORT).show();
							break;
						}
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
