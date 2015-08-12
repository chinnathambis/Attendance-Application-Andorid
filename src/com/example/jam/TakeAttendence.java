package com.example.jam;


//package com.cross.attendance;

import java.util.ArrayList;

//import com.jam.attendance.R;









import com.example.jam.TableData.AttInfo;
import com.example.jam.TableData.CourseTable;
import com.example.jam.TableData.StudentInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TakeAttendence  extends Activity {
	
	SQLiteDatabase db;
	ArrayList<student> students = new ArrayList<student>();
	ListAdapter boxAdapter;
	String str2="";
	TextView show,cname;
	int i;
	public String DISPLAY_QUERY = "select * from "+AttInfo.TABLE_NAME ;
	
	Context ctx = this;
	Context ctx1 = this;
	Database4 DB,DB1;
	
	  /** Called when the activity is first created. */
	
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.take_attendence);
	    db= openOrCreateDatabase(AttInfo.DATABASE_NAME, MODE_PRIVATE, null);
		   //create new table if not already exist

		Intent i= getIntent();
	    String str = i.getStringExtra("CID");
	    str2=i.getStringExtra("CID");
	    String str1 = i.getStringExtra("CNAME");
	   // Toast.makeText(getBaseContext(), "Coming Strings are =>"+str+"  "+str1, Toast.LENGTH_LONG).show();
	    cname=(TextView) findViewById(R.id.cname);
	    cname.setText(str1);
	    

	    fillData();
	    boxAdapter = new ListAdapter(this, students);

	    ListView lvMain = (ListView) findViewById(R.id.lvMain);
	    lvMain.setAdapter(boxAdapter);
	  }

	  void fillData() { 
		  Cursor c=db.rawQuery(DISPLAY_QUERY, null);
		  c.moveToFirst();
		 i=0;
		  do
  		{
			  if(str2.equals(c.getString(c.getColumnIndex(AttInfo.COURSE_ID))))
			   {
				  String student_name=c.getString(c.getColumnIndex(AttInfo.STUDENT_NAME));
				  //String course_id1=c.getString(1);
				  String student_roll=c.getString(c.getColumnIndex(AttInfo.STUDENT_ROLL));
				  students.add(new student(student_name, student_roll,R.drawable.ic_launcher, false));
				  
				  
				  DB1 =new Database4(ctx1);
				  String student_roll1=c.getString(c.getColumnIndex(AttInfo.STUDENT_ROLL));
				  String course_id=c.getString(c.getColumnIndex(AttInfo.COURSE_ID));
				  int b =c.getInt(c.getColumnIndex(AttInfo.TOTALATT));
				  b = b + 1;
				  DB1.updateInformation2(DB1, course_id, student_roll1, b);
				
				  i++;  
			   }
  			//move next position until end of the data
  		}while(c.moveToNext());

	  }
	  
	 
	  
	  public void showResult(View v) {
	   // String result = "Attendance Result is:";
	    //int total_present = 0; 
	    //int no_of_present = 0;
	    
	    for (student p : boxAdapter.getBox()) {
	    	//no_of_present++;
	      if (p.box)
	      {
	        //result += "\n" + p.std_name;
	       // result += "\n" + p.roll_no;
	        Cursor c=db.rawQuery(DISPLAY_QUERY, null);
			 c.moveToFirst();
			 //i=0;
			  do
	  		{
				  if(str2.equals(c.getString(c.getColumnIndex(AttInfo.COURSE_ID))) && p.roll_no.equals(c.getString(c.getColumnIndex(AttInfo.STUDENT_ROLL))))
				   {
					  String stroll=c.getString(c.getColumnIndex(AttInfo.STUDENT_ROLL));
					  String cid1=c.getString(c.getColumnIndex(AttInfo.COURSE_ID));
					  int pr=c.getInt(c.getColumnIndex(AttInfo.PRESENT));
					  pr = pr + 1;
					  DB = new Database4(ctx);
					  DB.updateInformation1(DB, cid1, stroll, pr);
					  //students.add(new student(student_name, student_roll,R.drawable.ic_launcher, false));
					  Toast.makeText(this, "Attendence Successfully Submitted in database!!!!" , Toast.LENGTH_LONG).show();
					 // i++;
					  finish();
				   }
				  
	  			
	  			//move next position until end of the data
	  		}while(c.moveToNext());
	        //total_present+=p.roll_no;
			
	      }
	    }
	    //int no_of_absent= i - no_of_present;
	    //Toast.makeText(this, result+"\n"+"Total Presents:="+no_of_present +"Absents:="+no_of_absent, Toast.LENGTH_LONG).show();

	  }
	}