package com.thegriffen.werman;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private boolean englishOnTop = true;
	private boolean wermanDone = false, englishDone = false;
	private boolean swapped = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button switchLaunguage = (Button) findViewById(R.id.button1);
		switchLaunguage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				TextView werman = (TextView) findViewById(R.id.editText2);
				TextView english = (TextView) findViewById(R.id.editText1);
				Animation wermanAnimation, englishAnimation;
				if(englishOnTop) {
					wermanAnimation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.ABSOLUTE, (english.getTop() - werman.getTop()));
					wermanAnimation.setDuration(500);
					
					englishAnimation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.ABSOLUTE, (werman.getTop() - english.getTop()));
					englishAnimation.setDuration(500);
				}
				else {
					wermanAnimation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.ABSOLUTE, (werman.getTop() + english.getTop()));
					wermanAnimation.setDuration(500);
					
					englishAnimation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.ABSOLUTE, (werman.getTop() - english.getTop()));
					englishAnimation.setDuration(500);
				}
				
				werman.startAnimation(wermanAnimation);
				english.startAnimation(englishAnimation);
				englishAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						swapped = false;
						englishDone = false;
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						englishDone = true;
						TextView werman = (TextView) findViewById(R.id.editText2);
						TextView english = (TextView) findViewById(R.id.editText1);
						Button button = (Button) findViewById(R.id.button1);
						LinearLayout parent = (LinearLayout) findViewById(R.id.LinearLayout1);
						if(wermanDone && englishDone && !swapped) {
							parent.removeAllViews();
							if(englishOnTop) {
								parent.addView(werman);
								parent.addView(button);
								parent.addView(english);
							}
							else {
								parent.addView(english);
								parent.addView(button);
								parent.addView(werman);
							}
							swapped = true;
							englishOnTop = !englishOnTop;
						}
					}
				});
				wermanAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						swapped = false;
						wermanDone = false;
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						wermanDone = true;
						TextView werman = (TextView) findViewById(R.id.editText2);
						TextView english = (TextView) findViewById(R.id.editText1);
						Button button = (Button) findViewById(R.id.button1);
						LinearLayout parent = (LinearLayout)findViewById(R.id.LinearLayout1);
						if(wermanDone && englishDone && !swapped) {
							parent.removeAllViews();
							if(englishOnTop) {
								parent.addView(werman);
								parent.addView(button);
								parent.addView(english);
							}
							else {
								parent.addView(english);
								parent.addView(button);
								parent.addView(werman);
							}
							swapped = true;
							englishOnTop = !englishOnTop;
						}
					}
				});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
