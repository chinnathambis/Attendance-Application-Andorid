package com.example.jam;

import com.example.jam.R;
import com.example.jam.TableData.AttInfo;
import com.example.jam.TableData.StudentInfo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class DeleteActivity extends Activity {
	 SQLiteDatabase db,db1;
	  Button REG;
	 String str2="";
	TextView show,cname;
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.delete_activity);
	   Intent i= getIntent();
	    String str = i.getStringExtra("CID");
	    str2 = i.getStringExtra("CID");
	    String str1 = i.getStringExtra("CNAME");
	    //Toast.makeText(getBaseContext(), "Coming Strings are =>"+str+"  "+str1, Toast.LENGTH_LONG).show();
	    cname=(TextView) findViewById(R.id.cname);
	    cname.setText(str1);
	    
	   
	   db= openOrCreateDatabase(StudentInfo.DATABASE_NAME, MODE_PRIVATE, null);
	   db1= openOrCreateDatabase(AttInfo.DATABASE_NAME, MODE_PRIVATE, null);
	   
	   
	   REG = (Button) findViewById(R.id.confdelete);
	   REG.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
					db.execSQL("delete from "+ StudentInfo.TABLE_NAME);
			        db.close();
			        db1.execSQL("delete from "+ AttInfo.TABLE_NAME);
			        db1.close();
			        Toast.makeText(getBaseContext(), "All Records are Deleted!!!", Toast.LENGTH_LONG).show();
			        finish();
			}
			
		});
	   
	  }
}
	   
	