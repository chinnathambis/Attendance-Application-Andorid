package com.example.jam;

import com.example.jam.R;
import com.example.jam.TableData.StudentInfo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DisplayActivity extends Activity {
	 SQLiteDatabase db;
	  TextView tv;
	  EditText et1,et2;
	  TextView show,cname;
	  String str2 = "";
	 public String DISPLAY_QUERY = null;//"select * from "+TableInfo.TABLE_NAME +"WHERE "+TableInfo.COURSE_ID+"="+str2;

	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	    setContentView(R.layout.display_activity);
	   tv=(TextView)findViewById(R.id.textView1);
	   
	   Intent i= getIntent();
	    String str = i.getStringExtra("CID");
	    str2=i.getStringExtra("CID");
	    String str1 = i.getStringExtra("CNAME");
	   // Toast.makeText(getBaseContext(), "Coming Strings are =>"+str+"  "+str1, Toast.LENGTH_LONG).show();
	    cname=(TextView) findViewById(R.id.cname);
	    cname.setText(str1);
	    db= openOrCreateDatabase(StudentInfo.DATABASE_NAME, MODE_PRIVATE, null);
	    DISPLAY_QUERY = "select * from "+StudentInfo.TABLE_NAME ;//+"WHERE "+TableInfo.COURSE_ID+"="+str2;
 
	    
	  
	   //create new table if not already exist
	   //db.execSQL("create table if not exists mytable(name varchar, roll_no varchar)");
	   }
	  
	   //This method will call when we click on display button
	   public void display(View v)
	   {
	   //use cursor to keep all data
	   //cursor can keep data of any data type
		//   Toast.makeText(getBaseContext(), "Course Id for which we want list =>"+str2, Toast.LENGTH_LONG).show();
	   Cursor c=db.rawQuery(DISPLAY_QUERY, null);
	   tv.setText("");
	   //move cursor to first position
	   c.moveToFirst();
	   //fetch all data one by one
	  try
	  {
		  int i=0;
	   do
	   {
		 //if(c.getString(c.getColumnIndex(StudentInfo.COURSE_ID)).equals(str2)){  
	    //we can use c.getString(0) here
	    //or we can get data using column index
		   if(str2.equals(c.getString(c.getColumnIndex(StudentInfo.COURSE_ID))))
		   {
			   i=1;
			   String name=c.getString(c.getColumnIndex(StudentInfo.STUDENT_NAME));
			   String roll=c.getString(c.getColumnIndex(StudentInfo.STUDENT_ROLL));
	    //display on text view
			   tv.append(roll+"\t\t\t"+name+"\n");
			}
	    //move next position until end of the data
	   }while(c.moveToNext());
	   if(i == 0)
	   {
		   Toast.makeText(getApplicationContext(), "Sorry No Student is Available.....!", Toast.LENGTH_LONG).show();
	   		finish();  
	   }
	  }
	  catch(Exception e)
   	  {
   		Toast.makeText(getApplicationContext(), "Sorry No Student is Available.....!", Toast.LENGTH_LONG).show();
   		finish();
   	  }
	}
}




