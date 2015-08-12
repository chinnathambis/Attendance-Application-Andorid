package com.example.jam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CourseAdapter extends Fragment 
{
	Button btn_click;
	View v;
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) 
	{
	   v=inflater.inflate(R.layout.course_layout,container,false); 
	   btn_click=(Button)v.findViewById(R.id.bnt_click);
	   btn_click.setOnClickListener(new OnClickListener() 
	   {		
		@Override
		public void onClick(View v) 
		{
			//btn_click.setVisibility(0);
			//btn_click.setEnabled(false);
			//Toast.makeText(getActivity(), "Hello...!", Toast.LENGTH_LONG).show();	
			Intent my=new Intent("com.example.jam.ENTERCOURSE");
			//i.setClass(v.getContext(),EnterCourse.class);
			startActivity(my);
			
		}
	});
	   return v;
	}
	
}
