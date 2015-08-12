package com.example.jam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Button enterStudentButton;
	Button viewStudentButton;
	Button deleteStudentButton;
	Button enterCourseButton;
	Button enterDateButton;
	Button viewAttButton;
	TextView show,cname;
	String str2 = "";
	String str3 = "";
	//Context ctx;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent i= getIntent();
	    String str = i.getStringExtra("CID");
	    str2=i.getStringExtra("CID");
	    String str1 = i.getStringExtra("CNAME");
	    str3 = i.getStringExtra("CNAME");
	    //Toast.makeText(getBaseContext(), "Coming Strings are =>"+str+"  "+str1, Toast.LENGTH_LONG).show();
	    cname=(TextView) findViewById(R.id.cname);
	    cname.setText(str1);
	    
	    initview();
		
	}

	/*private void strcpy(String str, String str22) {
		// TODO Auto-generated method stub
		
	}*/

	private void initview()
	{
		// TODO Auto-generated method stub
		enterStudentButton=(Button)findViewById(R.id.Click);
		viewStudentButton=(Button)findViewById(R.id.bview);
		deleteStudentButton=(Button)findViewById(R.id.bdelete);
		enterDateButton=(Button)findViewById(R.id.batt);
		viewAttButton=(Button)findViewById(R.id.bvatt);
		//show=(TextView)findViewById(R.id.textView1);
		
		enterStudentButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(MainActivity.this, Second.class);
				my.putExtra("CID",str2);
				my.putExtra("CNAME",str3);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);				
			}
		});
		
		
		viewStudentButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(MainActivity.this, DisplayActivity.class);
				my.putExtra("CID",str2);
				my.putExtra("CNAME",str3);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);				
			}
		});
		
		
		deleteStudentButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(MainActivity.this, DeleteActivity.class);
				my.putExtra("CID",str2);
				my.putExtra("CNAME",str3);
				startActivity(my);				
			}
		});
		

		enterDateButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(MainActivity.this, EnterDate.class);
				my.putExtra("CID",str2);
				my.putExtra("CNAME",str3);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);				
			}
		});
		
		

		viewAttButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(MainActivity.this, ViewActivity.class);
				my.putExtra("CID",str2);
				my.putExtra("CNAME",str3);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
