package com.example.bmicalculator;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends Activity {
	
	private TextView weightTextView;
	private TextView heightTextView;
	private TextView bmiTextView;
	private TextView calcBmiTextView;
	private TextView valueBmiTextView;
	private RadioGroup unitRadioGroup;
	private RadioButton englishRadioButton;
	private RadioButton metricRadioButton;
	private Button bmiButton;
	private double weight = 0.0;
	private double height = 0.0;
	private double bmi = 0.0;
	private String value = "";
	private EditText weighteditText = null;
	private EditText heightEditText =null;
	DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        calcBmiTextView = (TextView) findViewById(R.id.calcBmiTextView);
        valueBmiTextView = (TextView) findViewById(R.id.valueBmiTextView);
        englishRadioButton = (RadioButton) findViewById(R.id.englishRadioButton);
        metricRadioButton = (RadioButton) findViewById(R.id.metricRadioButton);
        bmiButton = (Button) findViewById(R.id.bmiButton);
        weighteditText = (EditText) findViewById(R.id.weighteditText);
        weighteditText.addTextChangedListener(weighteditTextWatcher);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heighteditTextWatcher);
              	 
        
        
        bmiButton.setOnClickListener(new OnClickListener() {
        	
               			
			
			@Override
			public void onClick(View v) {
				if(englishRadioButton.isChecked()){
					englishCalc();
					
				}
				else if(metricRadioButton.isChecked()){
					metricCalc();
				}
				
			}
		});
        
    }
    
    private void englishCalc(){
    	
    	
    	if((weight == 0.0) || (height == 0.0)){
    		Toast toast = Toast.makeText(MainActivity.this, "Please Enter the weight and Height", Toast.LENGTH_SHORT);
    		toast.show();
    	}
    	else{
    		bmi =(weight*703)/(height*height);
    		String bodymass = Double.toString(bmi);
    		//bodymass = df.format(bodymass);
    		//calcBmiTextView.setText(Double.toString(bmi));
    		calcBmiTextView.setText(bodymass);
    		if(bmi < 18.5){
    			value = "Under Weight";
    		}
    		else if(bmi >= 18.5 && bmi <= 24.9){
    			value = "Normal";
    		}
    		else if(bmi >= 25 && bmi <= 29.9){
    			value = "Over Weight";
    		}
    		else{
    			value = "Obese!!!";
    		}
    		valueBmiTextView.setText(value);
    	}
    		
    	
    	
    }
    
    private void metricCalc(){
    	
    	if((weighteditText.getText().equals(null)) || (heightEditText.getText().equals(null))){
    		Toast toast = Toast.makeText(MainActivity.this, "Please Enter the weight and Height", Toast.LENGTH_SHORT);
    		toast.show();
    	}
    	else{
    		bmi = (weight)/(height*height);
    		calcBmiTextView.setText(Double.toString(bmi));
    		if(bmi < 18.5){
    			value = "Under Weight";
    		}
    		else if(bmi >= 18.5 && bmi <= 24.9){
    			value = "Normal";
    		}
    		else if(bmi >= 25 && bmi <= 29.9){
    			value = "Over Weight";
    		}
    		else{
    			value = "Obese!!!";
    		}
    		valueBmiTextView.setText(value);
    	}
    }
    
private TextWatcher weighteditTextWatcher = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
			try {
				weight = Double.parseDouble(s.toString());
			} 
			catch (NumberFormatException e) {
				weight = 0.0; 
			} 

						
		}

		

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		} 
	};
	
private TextWatcher heighteditTextWatcher = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
			try {
				height = Double.parseDouble(s.toString());
			} 
			catch (NumberFormatException e) {
				height = 0.0; 
			} 

						
		}

		

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		} 
	};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
