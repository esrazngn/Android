package com.example.wigdetbutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
private String mButtonMEssageTemplate;
private String mImageButtonMessageTemplate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        mButtonMEssageTemplate = getString(R.string.button_message_template);
        mImageButtonMessageTemplate = getString(R.string.image_button_message_template);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroupInfo());
               
    }
    	private class RadioGroupInfo implements OnCheckedChangeListener{
    		private RadioButton mLastChecked;
    		private String mNewSelectionMessageTemplate,  mChangedSelectionMessageTemplate;
    		
    		public RadioGroupInfo(){
    			mNewSelectionMessageTemplate = getString(R.string.new_selection_message_template);
    			mChangedSelectionMessageTemplate = getString(R.string.changed_selection_message_template);
    		}
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				RadioButton newChecked = (RadioButton)findViewById(checkedId);
				String message;
				if ( mLastChecked == null ){
					message = String.format(mNewSelectionMessageTemplate, newChecked.getText());
									
				}
				else{
					message = String.format(mChangedSelectionMessageTemplate, newChecked.getText(),mLastChecked.getText());
				
				}
				mLastChecked = newChecked;
				showToast(message);
			}
    		
    	}
    

    private void showToast(String text){
    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    public void showImageButton1Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_1_image);
    }
    public void showImageButton2Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_2_image);
    }
    public void showImageButton3Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_3_image);
    }
    public void showImageButton4Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_4_image);
    }
    public void showImageButton5Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_5_image);
    }
    public void showImageButton6Info(View clickedImageButton){
    	showImageButtonInfo(R.string.image_button_6_image);
    }
    private void showImageButtonInfo(int imageID){
    	String image = getString(imageID);
    	String message = String.format(mImageButtonMessageTemplate, image);
    	showToast(message);
    }
    
    public void showButtonText(View clickedButton){
    	Button button = (Button) clickedButton;
    	CharSequence text = button.getText();
    	String message = String.format(mButtonMEssageTemplate, text);
    	showToast(message);
    }

    
    
}
