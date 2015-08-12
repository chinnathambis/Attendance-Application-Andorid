package com.example.jam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash1 extends Activity{

	@Override
	protected void onCreate(Bundle StartPage) {
		// TODO Auto-generated method stub
		super.onCreate(StartPage);
		setContentView(R.layout.splash1);
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(5000);
				} 
				catch(InterruptedException e)
				{
					e.printStackTrace(); 
				} finally{
					Intent openStartingPoint = new Intent(Splash1.this,FragmentTab.class);
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
