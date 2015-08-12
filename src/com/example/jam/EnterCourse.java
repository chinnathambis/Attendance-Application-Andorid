package com.example.jam;
import com.example.jam.TableData.CourseTable;
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
import android.widget.Toast;
public class EnterCourse extends Activity
{
	SQLiteDatabase db;
	EditText COURSE_ID,COURSE_NAME,host;
	String course_id,course_name;
	Button enterCourseButton,viewCourseButton,deleteCourseButton;
	Context ctx = this;
	public String DISPLAY_QUERY = "" ;
	//Context ctx1;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_course);
		//Toast.makeText(getBaseContext(), "Deleting database =>", Toast.LENGTH_LONG).show();
	   // ctx1.deleteDatabase(TableInfo.DATABASE_NAME);
		db= openOrCreateDatabase(CourseTable.DATABASE_NAME, MODE_PRIVATE, null);
		DISPLAY_QUERY = "select * from "+CourseTable.TABLE_NAME ;//+"WHERE "+TableInfo.COURSE_ID+"="+str2;
	 
		initview();
	}
	
	private void initview()
	{
		// TODO Auto-generated method stub
		//enterCourseButton=(Button)findViewById(R.id.Click);
		//viewCourseButton=(Button)findViewById(R.id.bview);
		//deleteStudentButton=(Button)findViewById(R.id.bdelete);
		//enterCourseButton=(Button)findViewById(R.id.regcourse);
		//show=(TextView)findViewById(R.id.textView1);
		
		
		enterCourseButton = (Button) findViewById(R.id.registerc);
		viewCourseButton = (Button) findViewById(R.id.vcourse);
		deleteCourseButton = (Button) findViewById(R.id.delete_course);
	
		
		
		
		enterCourseButton.setOnClickListener(new OnClickListener(){
				@Override
			public void onClick(View v) {
				int flag=0;
				COURSE_NAME = (EditText) findViewById(R.id.cname);
				COURSE_ID = (EditText) findViewById(R.id.cid);
				
				course_name = COURSE_NAME.getText().toString();
				course_id = COURSE_ID.getText().toString();
				// TODO Auto-generated method stub
				/*Cursor c=db.rawQuery(DISPLAY_QUERY, null);
				   //move cursor to first position
				   c.moveToFirst();
				 do
				   {
					  // String name=c.getString(c.getColumnIndex(StudentInfo.STUDENT_NAME));
					   String cid=c.getString(c.getColumnIndex(CourseTable.COURSE_ID));
					 //if(c.getString(c.getColumnIndex(StudentInfo.COURSE_ID)).equals(str2)){  
				    //we can use c.getString(0) here
				    //or we can get data using column index
					   if(course_id.equals(c.getString(c.getColumnIndex(CourseTable.COURSE_ID))))
					   {
						   COURSE_NAME.setText("");
						   COURSE_ID.setText("");
						   Toast.makeText(getBaseContext(), "This Course Is Already Exists.....=>", Toast.LENGTH_LONG).show();
						   flag=1;
						   break;
				    //display on text view
						  // tv.append(roll+"\t\t\t"+name+"\n");
						}
				    //move next position until end of the data
				   }while(c.moveToNext());
				 if(flag == 0)
				 {*/
					 Database1 DB = new Database1(ctx);
					 DB.putInformation(DB, course_name, course_id);
					 Toast.makeText(getBaseContext(), "Course Registered", Toast.LENGTH_LONG).show();
				
				/*Intent i =new Intent("com.example.jam.MAINACTIVITY");
				startActivity(i);*/
					 COURSE_NAME.setText("");
					 COURSE_ID.setText("");
				//finish();
				// }
				
			}
			
		});
		
		viewCourseButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(EnterCourse.this, DisplayCourse.class);
				startActivity(my);				
			}
		});
		
		deleteCourseButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent my=new Intent(EnterCourse.this, DeleteCourse.class);
				startActivity(my);				
			}
		});
	}
}
	
	
	

	

