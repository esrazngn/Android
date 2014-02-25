package com.example.snipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String mItemSelectedMessageTemplate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.spinner);
        mItemSelectedMessageTemplate =
        getString(R.string.spinner_message_template);
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
    	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
