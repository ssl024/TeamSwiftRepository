package edu.ucsd.teamswift.letsgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage extends Activity {

	//Local variable
	Button letsGoPlayBut;
	Button activitiesBut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		
		//Lets program look for and find the Lets Go Play and Activities Button
	    letsGoPlayBut = (Button)this.findViewById(R.id.letsGoPlayBut);
		activitiesBut = (Button)this.findViewById(R.id.activitiesBut);
		
		//System handles Lets Go Play Button
		letsGoPlayBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			/*TODO*/
				//Eric link to Join and Create
			// POP out Menu to chose between Create Game or Join Game

			}
		});
				
		//System handles Activities Button
		activitiesBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//Intent will allow user to transition to Main Activities Page
				Intent moveToMainActivities = new Intent(HomePage.this, MyActivitiesPage.class);
				startActivity(moveToMainActivities);					
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
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
