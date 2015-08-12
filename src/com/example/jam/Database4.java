package com.example.jam;

import com.example.jam.TableData.AttInfo;
import com.example.jam.TableData.StudentInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database4 extends SQLiteOpenHelper {
	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+AttInfo.TABLE_NAME+"("+AttInfo.COURSE_ID+" Text,"+AttInfo.STUDENT_NAME+" TEXT,"+AttInfo.STUDENT_ROLL+" TEXT, "+AttInfo.PRESENT+" int DEFAULT 0, "+AttInfo.TOTALATT+" int DEFAULT 0);";

	public Database4(Context context) {
		
		super(context, AttInfo.DATABASE_NAME, null, database_version);
		Log.d("Database4", "Database created");
		// TODO Auto-generated constructor stub
	}


/*	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+TInfo.TABLE_NAME+"("+TInfo.COURSE_ID+" Text,"+TInfo.STUDENT_NAME+" TEXT,"+TInfo.STUDENT_ROLL+" TEXT);";
	public Database2(Context context) {
		super(context, TInfo.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created");
	}*/

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database4", "Table created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void putInformation1(Database4 dop,String cid, String name, String roll,int a, int b)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		a=0;
		b=0;
		cv.put(AttInfo.COURSE_ID, cid);
		cv.put(AttInfo.STUDENT_NAME, name);
		cv.put(AttInfo.STUDENT_ROLL, roll);
		cv.put(AttInfo.PRESENT, a);
		cv.put(AttInfo.TOTALATT, b);
		//cv.put(AttInfo.STUDENT_ROLL, roll);
		long k = SQ.insert(AttInfo.TABLE_NAME, null, cv);
		Log.d("Database4", "Student added");
	}
	
	
	public Cursor getInformation1(Database4 dop)
	{
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] columns = {AttInfo.COURSE_ID,AttInfo.STUDENT_NAME, AttInfo.STUDENT_ROLL, AttInfo.PRESENT, AttInfo.TOTALATT};
		Cursor CR = SQ.query(AttInfo.TABLE_NAME, columns, null, null, null, null, null);
	
		return CR;
		
	}
	
	public void updateInformation1(Database4 dop,String cid, String roll, int a)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		String selection = AttInfo.COURSE_ID+" LIKE ? AND "+AttInfo.STUDENT_ROLL+" LIKE ?";
		String[] columns = {cid, roll};
		ContentValues values = new ContentValues();
		values.put(AttInfo.PRESENT, a);
		SQ.update(AttInfo.TABLE_NAME, values, selection, columns);
		
	}
	
	public void updateInformation2(Database4 dop,String cid, String roll, int b)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		String selection = AttInfo.COURSE_ID+" LIKE ? AND "+AttInfo.STUDENT_ROLL+" LIKE ?";
		String[] columns = {cid, roll};
		ContentValues values = new ContentValues();
		values.put(AttInfo.TOTALATT, b);
		SQ.update(AttInfo.TABLE_NAME, values, selection, columns);
		
	}


}



