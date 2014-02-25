package com.example.handlingeventhandler;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
public class MainActivity extends Activity {
private View mColorRegion;
private int[] mColorChoices =
{ Color.BLACK, Color.BLUE};
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mColorRegion = findViewById(R.id.color_region);
// No need to look up the button or assign event handler
}
private void setRegionColor(int color) {
mColorRegion.setBackgroundColor(color);
}
public void randomizeColor(View v) {
Random generator = new Random();
int index = generator.nextInt(mColorChoices.length);
setRegionColor(mColorChoices[index]);
}
}