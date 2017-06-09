package com.bollingers.testui;

import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PracticeUIActivity extends Activity{

	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }

	
	public void buttonClick(View button) {
		updateTime((Button)button);
		button.setBackgroundColor(Color.RED);
		
	}
	
	private void updateTime(Button btn) {
		btn.setText(new Date().toString());
	}
}