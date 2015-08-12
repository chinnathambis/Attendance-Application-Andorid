package com.example.jam;

import java.util.ArrayList;

import com.example.jam.R;
import com.example.jam.TableData.CourseTable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class DeleteCourse extends Activity {
	 SQLiteDatabase db;
	  Button REG;
	  private ArrayList<String> StrArr;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.delete_course);
	  
	   
	   db= openOrCreateDatabase(CourseTable.DATABASE_NAME, MODE_PRIVATE, null);
	   
	   
	   REG = (Button) findViewById(R.id.confdeletecourse);
		REG.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				db.execSQL("delete from "+ CourseTable.TABLE_NAME);
			       db.close();
			       Toast.makeText(getBaseContext(), "All Records are Deleted", Toast.LENGTH_LONG).show();
				finish();
			}
			
		});
	   
	  }
}
	   
	