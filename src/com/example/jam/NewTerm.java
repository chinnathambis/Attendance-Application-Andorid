package com.example.jam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTerm extends Activity {
	Button newTermButton;
	EditText TERM_NAME;
	String term_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newterm);
		initview();
	}
	private void initview() {
		// TODO Auto-generated method stub
		newTermButton=(Button)findViewById(R.id.term);
		newTermButton.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				TERM_NAME = (EditText) findViewById(R.id.e1);
				term_name = TERM_NAME.getText().toString();
				
				Toast.makeText(getApplicationContext(), "Entered Term is =>"+term_name, Toast.LENGTH_LONG).show();
				TERM_NAME.setText("");
				Intent my=new Intent(NewTerm.this, EnterCourse.class);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);
				//startActivity(my);	
				
			}
		});
		
		
	}

	
}
