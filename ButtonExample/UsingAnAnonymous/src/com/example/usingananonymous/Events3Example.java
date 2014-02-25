package com.example.usingananonymous;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Events3Example extends Activity {
private View mColorRegion;
private int[] mColorChoices =
{ Color.BLACK, Color.BLUE, };
private void setRegionColor(int color) {
mColorRegion.setBackgroundColor(color);
}
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mColorRegion = findViewById(R.id.color_region);
Button colorButton =
(Button)findViewById(R.id.color_button);
colorButton.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
Random generator = new Random();
int index = generator.nextInt(mColorChoices.length);
setRegionColor(mColorChoices[index]);
}
});
}
}