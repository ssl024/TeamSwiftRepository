package edu.ucsd.teamswift.letsgo;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivityPage extends Activity {

	private EditText inputStartDate,
					 inputRepeatDates,
					 inputStartTime,
					 inputEndTime,
					 inputLocation,
					 inputNumPeople,
					 inputOtherInfo;
	private Button cancelCreateBut,
				   createBut;
					 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_actvity_page);
		inputStartDate = (EditText)findViewById(R.id.inputStartDate);
		inputRepeatDates = (EditText)findViewById(R.id.inputRepeatDates);
		inputStartTime = (EditText)findViewById(R.id.inputStartTime);
		inputEndTime = (EditText)findViewById(R.id.inputEndTime);
		inputLocation = (EditText)findViewById(R.id.inputLocation);
		inputNumPeople = (EditText)findViewById(R.id.inputNumPeople);
		inputOtherInfo = (EditText)findViewById(R.id.inputOtherInfo);
		cancelCreateBut = (Button)findViewById(R.id.cancelCreateBut);
		createBut = (Button)findViewById(R.id.createBut);
		
		
		//user click on cancel button, go back to homepage
		cancelCreateBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick (View v) {
				
				Intent moveToHomePage = new Intent(CreateActivityPage.this, HomePage.class);
				
				//Clears all other activities including this one when returning to the Main Activity
				moveToHomePage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(moveToHomePage);
				finish();
				
			}
			
			
		});
		
		
	}
	//Jake make fields and pop up for confirmation
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_actvity_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
