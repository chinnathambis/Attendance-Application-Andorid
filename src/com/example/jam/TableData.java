package com.example.jam;

import android.provider.BaseColumns;

public class TableData {

	public TableData(){
		
	}
	/*public static abstract class TableInfo implements BaseColumns{
		
		
		public static final String COURSE_ID = "c_id";
		public static final String STUDENT_NAME = "st_name";
		public static final String STUDENT_ROLL = "st_roll";
		public static final String DATABASE_NAME = "user_info";
		public static final String TABLE_NAME = "reg_ingo";
		}*/

	public static abstract class StudentInfo implements BaseColumns{
		
		
		public static final String COURSE_ID = "Course_Id";
		public static final String STUDENT_NAME = "Student_Name";
		public static final String STUDENT_ROLL = "Student_Roll";
		public static final String DATABASE_NAME = "Student_Info";
		public static final String TABLE_NAME = "Student";
		}

	public static abstract class CourseTable implements BaseColumns{
		
		public static final String COURSE_NAME = "c_name";
		public static final String COURSE_ID = "c_id";
		public static final String DATABASE_NAME = "course_info";
		public static final String TABLE_NAME = "course_table";
		}
	
public static abstract class AttInfo implements BaseColumns{
		
		
		public static final String COURSE_ID = "C_Id";
		public static final String STUDENT_NAME = "S_Name";
		public static final String STUDENT_ROLL = "S_Roll";
		public static final String PRESENT = "present";
		public static final String TOTALATT = "totalatt";
		public static final String DATABASE_NAME = "Att_Info";
		public static final String TABLE_NAME = "Attendence";
		}
}
