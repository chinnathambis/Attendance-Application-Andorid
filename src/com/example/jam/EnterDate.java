package com.example.jam;


import com.example.jam.TableData.StudentInfo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

	public class EnterDate extends Activity{
		SQLiteDatabase db;
		Button setBtn;
		String str2 = "";
		String str1 = "";
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.enter_date);

	 	   Intent i= getIntent();
	 	    //String str = i.getStringExtra("CID");
	 	    str2=i.getStringExtra("CID");
	 	    str1 = i.getStringExtra("CNAME");
	        
	        final DatePicker dp = (DatePicker) findViewById(R.id.dp);
	         setBtn= (Button) findViewById(R.id.set); 
	        
	        setBtn.setOnClickListener(new OnClickListener(){
	        	
	        	public void onClick(View v){
	        		
	        		Intent my=new Intent(EnterDate.this, TakeAttendence.class);
					my.putExtra("CID",str2);
					my.putExtra("CNAME",str1);
					//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
					startActivity(my);	
	        		Toast.makeText(EnterDate.this, dp.getDayOfMonth() + " " + dp.getMonth() + " " + dp.getYear(), Toast.LENGTH_SHORT).show();
	        		//int day = dp.getDayOfMonth();
	        		//db.execSQL("ALTER TABLE "+StudentInfo.TABLE_NAME+" ADD COLUMN "+day+" INTEGER DEFAULT 0");
	        	}
	        });
	         /*
	         setBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent i = new Intent("com.example.jam.TAKEATTENDENCE");
					startActivity(i);
					
				}
			});
	         */
	    }


	}



