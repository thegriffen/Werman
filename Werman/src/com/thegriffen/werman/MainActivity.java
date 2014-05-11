package com.thegriffen.werman;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private boolean mEnglishOnTop = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Werman.init();
		Button switchLaunguage = (Button) findViewById(R.id.switch_button);
		switchLaunguage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText top = (EditText) findViewById(R.id.top_box);
				EditText bottom = (EditText) findViewById(R.id.bottom_box);
				String topText = top.getText().toString();
				String bottomText = bottom.getText().toString();
				top.setText(bottomText);
				bottom.setText(topText);
				if(mEnglishOnTop) {
					top.setHint(R.string.werman_hint);
					bottom.setHint(R.string.english_hint);
				}
				else {
					top.setHint(R.string.english_hint);
					bottom.setHint(R.string.werman_hint);
				}
				translate(top.getText().toString(), top.getHint().toString());
				mEnglishOnTop = !mEnglishOnTop;
			}
		});
		
		EditText inputText = (EditText) findViewById(R.id.top_box);
		inputText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				EditText inputText = (EditText) findViewById(R.id.top_box);
				translate(inputText.getText().toString(), inputText.getHint().toString());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void translate(String input, String launguage) {
		if(launguage.equals(this.getString(R.string.english_hint))) {			
			String translation = Werman.TranslateToWerman(input);
			EditText bottom = (EditText) findViewById(R.id.bottom_box);
			bottom.setText(translation);
		}
		else if(launguage.equals(this.getString(R.string.werman_hint))){
			String translation = Werman.TranslateFromWerman(input);
			EditText bottom = (EditText) findViewById(R.id.bottom_box);
			bottom.setText(translation);
		}
	}

}
