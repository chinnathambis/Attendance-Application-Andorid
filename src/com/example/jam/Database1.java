package com.example.jam;

import com.example.jam.TableData.CourseTable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database1 extends SQLiteOpenHelper {

	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+CourseTable.TABLE_NAME+"("+CourseTable.COURSE_NAME+" TEXT,"+CourseTable.COURSE_ID+" TEXT);";
	public Database1(Context context) {
		super(context, CourseTable.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database operations", "Table created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public void putInformation(Database1 dop, String name, String id)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(CourseTable.COURSE_NAME, name);
		cv.put(CourseTable.COURSE_ID, id);
		long k = SQ.insert(CourseTable.TABLE_NAME, null, cv);
		Log.d("Database operations", "Course added");
	}
	
	
	public Cursor getInformation(Database1 dop)
	{
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] columns = {CourseTable.COURSE_NAME, CourseTable.COURSE_ID};
		Cursor CR = SQ.query(CourseTable.TABLE_NAME, columns, null, null, null, null, null);
		return CR;
		
	}

}
