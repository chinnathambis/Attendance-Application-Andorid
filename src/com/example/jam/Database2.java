package com.example.jam;

import com.example.jam.TableData.StudentInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database2 extends SQLiteOpenHelper {

	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+StudentInfo.TABLE_NAME+"("+StudentInfo.COURSE_ID+" Text,"+StudentInfo.STUDENT_NAME+" TEXT,"+StudentInfo.STUDENT_ROLL+" TEXT);";
	public Database2(Context context) {
		super(context, StudentInfo.DATABASE_NAME, null, database_version);
		Log.d("Database2", "Database created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database2", "Table created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void putInformation(Database2 dop,String cid, String name, String roll)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(StudentInfo.COURSE_ID, cid);
		cv.put(StudentInfo.STUDENT_NAME, name);
		cv.put(StudentInfo.STUDENT_ROLL, roll);
		long k = SQ.insert(StudentInfo.TABLE_NAME, null, cv);
		Log.d("Database2", "Student added");
	}
	
	
	public Cursor getInformation(Database2 dop)
	{
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] columns = {StudentInfo.COURSE_ID,StudentInfo.STUDENT_NAME, StudentInfo.STUDENT_ROLL};
		Cursor CR = SQ.query(StudentInfo.TABLE_NAME, columns, null, null, null, null, null);
	
		return CR;
		
	}

}


