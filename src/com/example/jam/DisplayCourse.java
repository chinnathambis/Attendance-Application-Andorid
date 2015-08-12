package com.example.jam;

import java.util.ArrayList;

import com.example.jam.R;
import com.example.jam.TableData.CourseTable;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DisplayCourse extends Activity {
	 private static final String NULL = null;
	SQLiteDatabase db;
	 // TextView tv;
	ListView List;
	EditText et1,et2;
	private String[] listofcid=new String[200];
	private String[] listofcname=new String[500];
	private ArrayList<String> StrArr;
	private ArrayAdapter<String> adapter;	 // ListView lv;
	public String DISPLAY_QUERY = "select * from "+CourseTable.TABLE_NAME;

	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.display_course);
	  // tv=(TextView)findViewById(R.id.textView1);
	  //lv =(ListView) findViewById(R.id.LV); 
	   List =(ListView) findViewById(R.id.lv);
	   StrArr=new ArrayList<String>();
	   db= openOrCreateDatabase(CourseTable.DATABASE_NAME, MODE_PRIVATE, null);
	   //create new table if not already exist
	   db.execSQL("create table if not exists coursetable(course_name varchar, course_id varchar)");
	   
	   adapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,StrArr);
	   List.setAdapter(adapter);
	   List.setClickable(true);
	   List.setOnItemClickListener(new AdapterView.OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
			  //((ArrayAdapter<String>) adapter).notifyDataSetChanged();
				//adapter.notifyDataSetChanged();
			//Toast.makeText(getApplicationContext(), ""+List.getItemAtPosition(position), Toast.LENGTH_LONG).show();
			Intent i=new Intent(DisplayCourse.this,MainActivity.class);
			i.putExtra("CID",listofcid[position]);
			i.putExtra("CNAME",listofcname[position]);
			
			startActivity(i);
			
			
		}


	   	});
	   }
	  
	   //This method will call when we click on display button
	   public void display(View v)
	   {
	   //use cursor to keep all data
	   //cursor can keep data of any data type
		
	   Cursor c=db.rawQuery(DISPLAY_QUERY, null);
	   //Toast.makeText(getApplicationContext(), "Value of cursor =>"+c, Toast.LENGTH_LONG).show();
	  // tv.setText("");
	   c.moveToFirst();
	  
	   	  try
	   		{int i=0;
	    		do
	    		{
	    			
	    			String course_name1=c.getString(c.getColumnIndex(CourseTable.COURSE_NAME));
	    			String course_id1=c.getString(1);
	    			StrArr.add(course_id1+"\t\t\t"+course_name1+"\n");
	    			listofcid[i]=course_id1;
	    			listofcname[i++]=course_name1;
	    			//display on text view
	    			//tv.append(course_name1+"\t\t\t"+course_id1+"\n");
	    			//move next position until end of the data
	    		}while(c.moveToNext());
	    		i=0;
	    		adapter.notifyDataSetChanged();
	   		}
	   	  catch(Exception e)
	   	  {
	   		Toast.makeText(getApplicationContext(), "Sorry No Course is Available.....!", Toast.LENGTH_LONG).show();
	   		finish();
	   	  }
	    }
	  }
	   
