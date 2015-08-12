package com.example.jam;
import com.example.jam.TableData.AttInfo;
import com.example.jam.TableData.StudentInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Second extends Activity
{
	SQLiteDatabase db;
	SQLiteDatabase db1;
	EditText USER_NAME,USER_ROLL;
	String user_name,user_roll;
	Button REG;
	Context ctx = this;
	TextView show,cname;
	String str2 = "";
	public String DISPLAY_QUERY = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		Intent i= getIntent();
	    String str = i.getStringExtra("CID");
	    str2=i.getStringExtra("CID");
	    String str1 = i.getStringExtra("CNAME");
	   // Toast.makeText(getBaseContext(), "Coming Strings are =>"+str+"  "+str1, Toast.LENGTH_LONG).show();
	    cname=(TextView) findViewById(R.id.cname);
	    cname.setText(str1);
	    
		USER_NAME = (EditText) findViewById(R.id.name);
		USER_ROLL = (EditText) findViewById(R.id.roll);
		
		REG = (Button) findViewById(R.id.b1);
		db= openOrCreateDatabase(StudentInfo.DATABASE_NAME, MODE_PRIVATE, null);
		db1= openOrCreateDatabase(AttInfo.DATABASE_NAME, MODE_PRIVATE, null);
		DISPLAY_QUERY = "select * from "+StudentInfo.TABLE_NAME ;//+"WHERE "+TableInfo.COURSE_ID+"="+str2;
	 
		REG.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				int flag=0;
				user_name = USER_NAME.getText().toString();
				user_roll = USER_ROLL.getText().toString();
				 /*Cursor c=db.rawQuery(DISPLAY_QUERY, null);
				   //move cursor to first position
				   c.moveToFirst();
				   //fetch all data one by one
				   do
				   {
					  // String name=c.getString(c.getColumnIndex(StudentInfo.STUDENT_NAME));
					   String roll=c.getString(c.getColumnIndex(StudentInfo.STUDENT_ROLL));
					 //if(c.getString(c.getColumnIndex(StudentInfo.COURSE_ID)).equals(str2)){  
				    //we can use c.getString(0) here
				    //or we can get data using column index
					   if(user_roll.equals(c.getString(c.getColumnIndex(StudentInfo.STUDENT_ROLL))))
					   {
						   USER_NAME.setText("");
						   USER_ROLL.setText("");
						   Toast.makeText(getBaseContext(), "This Roll Number Is Already Exists.....=>", Toast.LENGTH_LONG).show();
						   flag=1;
						   break;
				    //display on text view
						  // tv.append(roll+"\t\t\t"+name+"\n");
						}
				    //move next position until end of the data
				   }while(c.moveToNext());
				// TODO Auto-generated method stub
				   if(flag == 0)
				   {*/
					   	Database3 DB = new Database3(ctx);
						Database4 DB1 = new Database4(ctx);
					   	DB.putInformation(DB, str2, user_name, user_roll);
					   	DB1.putInformation1(DB1, str2, user_name, user_roll,0,0);
					   	Toast.makeText(getBaseContext(), "Student Added", Toast.LENGTH_LONG).show();
					   	finish();
				   //}
			}
			
		});
	}

	
}

