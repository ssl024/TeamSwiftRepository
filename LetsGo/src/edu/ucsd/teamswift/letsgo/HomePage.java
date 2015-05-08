package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends Activity {

	//Local variable
	Button letsGoPlayBut;
	Button activitiesBut;
	Button logOutBut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		
		// retrieve current user from parse.com
		ParseUser currentUser = ParseUser.getCurrentUser();
		
		// convert currentUser into String
		String userIdString = currentUser.getUsername().toString();
		
		// locate textView in homepage.xml
		TextView userId = (TextView) findViewById(R.id.userId);
		
		// Set the currentUser String into TextView
		userId.setText("You are logged in as " + userIdString);
		//Lets program look for and find the Lets Go Play and Activities Button
	    letsGoPlayBut = (Button)this.findViewById(R.id.letsGoPlayBut);
		activitiesBut = (Button)this.findViewById(R.id.myActivitiesBut);
		logOutBut = (Button)this.findViewById(R.id.logOutBut);
		
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
		
		// Log out Button Click Listener
		logOutBut.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				// Logout current user
				ParseUser.logOut();
				//Intent will allow user to transition to login page
				Intent moveToLoginPage = new Intent(HomePage.this, MainActivity.class);
				
				//Makes it so the login page is a unique task
				moveToLoginPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
				//Then moves to Sign Up Page
				startActivity(moveToLoginPage);
				//finish();
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
