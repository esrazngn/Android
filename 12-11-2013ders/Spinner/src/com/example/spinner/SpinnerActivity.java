package com.example.spinner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends Activity {
private String mItemSelectedMessageTemplate;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mItemSelectedMessageTemplate =
getString(R.string.spinnerprompt);
Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
spinner1.setOnItemSelectedListener(new SpinnerInfo());

}
private void showToast(String text) {
Toast.makeText(this, text, Toast.LENGTH_LONG).show();
}
private class SpinnerInfo implements OnItemSelectedListener {
private boolean isFirst = true;
@Override
public void onItemSelected(AdapterView<?> spinner, View selectedView,
int selectedIndex, long id) {
if (isFirst) {
isFirst = false;
} else {
String selection =
spinner.getItemAtPosition(selectedIndex).toString();
String message =
String.format(mItemSelectedMessageTemplate, selection);
showToast(message);
}
}
@Override
public void onNothingSelected(AdapterView<?> spinner) {
// Won’t be invoked unless you programmatically remove entries
}
}}