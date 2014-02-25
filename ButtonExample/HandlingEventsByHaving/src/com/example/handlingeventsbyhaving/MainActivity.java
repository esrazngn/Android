package com.example.handlingeventsbyhaving;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity
implements OnClickListener {
private View mColorRegion;
private int[] mColorChoices =
{ Color.BLACK, Color.BLUE, };
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mColorRegion = findViewById(R.id.color_region);
Button colorButton =
(Button)findViewById(R.id.color_button);
colorButton.setOnClickListener(this);
}
private void setRegionColor(int color) {
mColorRegion.setBackgroundColor(color);
}
@Override
public void onClick(View v) {
Random generator = new Random();
int index = generator.nextInt(mColorChoices.length);
setRegionColor(mColorChoices[index]);
}

}