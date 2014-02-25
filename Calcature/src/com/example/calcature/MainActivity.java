package com.example.calcature;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener {

EditText etNum1;
EditText etNum2;

Button btnAdd;
Button btnSub;
Button btnMult;
Button btnDiv;

TextView tvResult;

String oper = "";

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_calcature_main);

// bileşenleri buluyoruz
etNum1 = (EditText) findViewById(R.id.etNum1);
etNum2 = (EditText) findViewById(R.id.etNum2);

btnAdd = (Button) findViewById(R.id.btnAdd);
btnSub = (Button) findViewById(R.id.btnSub);
btnMult = (Button) findViewById(R.id.btnMult);
btnDiv = (Button) findViewById(R.id.btnDiv);

tvResult = (TextView) findViewById(R.id.tvResult);

// işleticiyi belirliyoruz
btnAdd.setOnClickListener(this);
btnSub.setOnClickListener(this);
btnMult.setOnClickListener(this);
btnDiv.setOnClickListener(this);

}

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
float num1 = 0;
float num2 = 0;
float result = 0;

// giriş alanlarının boş olup olmadığını kontrol ediyoruz
if (TextUtils.isEmpty(etNum1.getText().toString())
|| TextUtils.isEmpty(etNum2.getText().toString())) {
return;
}

// EditText’i okuyoruz ve değişkenlere değerler veriyoruz
num1 = Float.parseFloat(etNum1.getText().toString());
num2 = Float.parseFloat(etNum2.getText().toString());

// basılmış butonu buluyoruz ve ona göre işlemi gerçekleştiriyoruz
// oper değişkene işlemi yazdırıyoruz, çıkış alanında kullanacağız
switch (v.getId()) {
case R.id.btnAdd:
oper = "+";
result = num1 + num2;
break;
case R.id.btnSub:
oper = "-";
result =num1-num2;
break;
case R.id.btnMult:
oper = "*";
result = num1 * num2;
break;
case R.id.btnDiv:
oper = "/";
result = num1 / num2;
break;
default:
break;
}

// çıkış alanı oluşturuyoruz
tvResult.setText(num1 + "" + oper + "" + num2 + "=" + result);
}
}
