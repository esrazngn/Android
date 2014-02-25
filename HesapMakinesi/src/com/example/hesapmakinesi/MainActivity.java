package com.example.hesapmakinesi;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btTop,btCik,btCarp,btBol,btSil,btEsit,btSifirla;
	EditText islemekrani;
	int sayi1=0 ,sayi2=0, sonuc=0;
	String islem;
	
	private int oldNum = 0;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		bt0 = (Button)findViewById(R.id.bt0);
		bt1 = (Button)findViewById(R.id.bt1);
		bt2 = (Button)findViewById(R.id.bt2);
		bt3 = (Button)findViewById(R.id.bt3);
		bt4 = (Button)findViewById(R.id.bt4);
		bt5 = (Button)findViewById(R.id.bt5);
		bt6 = (Button)findViewById(R.id.bt6);
		bt7 = (Button)findViewById(R.id.bt7);
		bt8 = (Button)findViewById(R.id.bt8);
		bt9 = (Button)findViewById(R.id.bt9);
		btTop =(Button)findViewById(R.id.btTop);
		btCik = (Button)findViewById(R.id.btCik);
		btCarp = (Button)findViewById(R.id.btCarp);
		btBol = (Button)findViewById(R.id.btBol);
		btEsit = (Button)findViewById(R.id.btEsit);
		btSil = (Button)findViewById(R.id.btSil);
		btSifirla = (Button)findViewById(R.id.btSifirla);

		islemekrani= (EditText)findViewById(R.id.editText1);
		
		bt0.setOnClickListener(this);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);
		bt7.setOnClickListener(this);
		bt8.setOnClickListener(this);
		bt9.setOnClickListener(this);
		btTop.setOnClickListener(this);
		btCik.setOnClickListener(this);
		btCarp.setOnClickListener(this);
		btBol.setOnClickListener(this);
		btEsit.setOnClickListener(this);
		btSil.setOnClickListener(this);
		btSifirla.setOnClickListener(this);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
	
        if(arg0.equals(bt1)){
        	islemekrani.setText(islemekrani.getText() + "1");
        }
        else if(arg0.equals(bt2)){
        	islemekrani.setText(islemekrani.getText() + "2");           
        }
        else if(arg0.equals(bt3)){
        	islemekrani.setText(islemekrani.getText() + "3");           
        }
        else if(arg0.equals(bt4)){
        	islemekrani.setText(islemekrani.getText() + "4");           
        }
        else if(arg0.equals(bt5)){
        	islemekrani.setText(islemekrani.getText() + "5");           
        }
        else if(arg0.equals(bt6)){
        	islemekrani.setText(islemekrani.getText() + "6");           
        }
        else if(arg0.equals(bt7)){
        	islemekrani.setText(islemekrani.getText() + "7");           
        }
        else if(arg0.equals(bt8)){
        	islemekrani.setText(islemekrani.getText() + "8");           
        }
        else if(arg0.equals(bt9)){
        	islemekrani.setText(islemekrani.getText() + "9");           
        }
        else if(arg0.equals(bt0)){
        	islemekrani.setText(islemekrani.getText() + "0");           
        }
        else if(arg0.equals(btTop)) {
        		if(!(islemekrani.getText().toString().equals(""))){
        			sayi1=Integer.parseInt(islemekrani.getText().toString());
        			islemekrani.setText("");
        			islem = "+";
        		}

        }
        else if(arg0.equals(btCik)){
        	if(!(islemekrani.getText().toString().equals(""))){
        		sayi1=Integer.parseInt(islemekrani.getText().toString());
               islemekrani.setText("");
               islem = "-";
              }
        }

        else if(arg0.equals(btCarp)){
        	if(!(islemekrani.getText().toString().equals(""))){
        		sayi1=Integer.parseInt(islemekrani.getText().toString());
               islemekrani.setText("");
               islem = "*";
              }                    
        }
        else if(arg0.equals(btBol)){
        	if(!(islemekrani.getText().toString().equals(""))){
        		sayi1=Integer.parseInt(islemekrani.getText().toString());
               islemekrani.setText("");
               islem = "/";}
        }
        else if(arg0.equals(btSifirla)){
               if(!(islemekrani.getText().toString().equals(""))) {
            	   islemekrani.setText("");
                   islem="";
                   sayi1=0;
                   sayi2=0; 
              }
               else{
            	   islem="";

               }
        }
        else if(arg0.equals(btSil)){
               if(!(islemekrani.getText().toString().equals("")))   {
                String kopyaekran = islemekrani.getText().toString();
                kopyaekran=kopyaekran.substring(0,kopyaekran.length()-1);
                 islemekrani.setText(kopyaekran);   
                 }
               else{
                      islem="";
               }
        }
        else{
        	sayi2=Integer.parseInt((islemekrani.getText().toString()));
        	if(islem.equals("+")){
        		sonuc = sayi1+sayi2;
        		sayi1=0;
                sayi2=0;
            }
        	else if(islem.equals("-")){
        		sonuc = sayi1-sayi2;
                sayi1=0;
                sayi2=0;
        	}
        	else if(islem.equals("*")){
        		sonuc = sayi1*sayi2;
                sayi1=0;
                sayi2=0;
        	}
        	else if(islem.equals("/")){
        		sonuc = sayi1/sayi2;
                sayi1=0;
                sayi2=0;
        	}
        	islemekrani.setText(Integer.toString(sonuc));           



        }
	}
}

