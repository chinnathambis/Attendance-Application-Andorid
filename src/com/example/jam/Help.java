package com.example.jam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Help extends Activity {
	//Button newTermButton;
	//EditText TERM_NAME;
	//String term_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_layout);
		//initview();
	}
	/*private void initview() {
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
				Intent my=new Intent(Help.this, EnterCourse.class);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);
				//startActivity(my);	
				
			}
		});
		
		
	}*/

	
}




/*package com.example.jam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Help extends Activity {
	//Button newTermButton;
	//EditText TERM_NAME;
	//String term_name;
	//TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_layout);
		//tv=(TextView)findViewById(R.id.textView1);
		//initview();
	}
	/*private void initview() {
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
				Intent my=new Intent(Help.this, EnterCourse.class);
				//Toast.makeText(getApplicationContext(), "This is the course id sending from main=>"+str2, Toast.LENGTH_LONG).show();
				startActivity(my);
				//startActivity(my);	
				
			}
		});
		
		
	}

	
}*/



/*package com.example.jam;

import android.app.Activity;
import android.os.Bundle;

public class Help extends Activity{
	
	 protected void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		    setContentView(R.layout.help_layout);
	 }

}*/
