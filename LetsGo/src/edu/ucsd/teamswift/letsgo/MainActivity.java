/* Project: Lets Go
 * Group: Team Swift
 * Description: Opening Page of "Lets Go" Android Application. Allows user to
 * 			    sign up or sign in to application
 * 
 * Page Created: Steven
 * Page Modified by:
 * 		Sang : Created event handling for sign up button and created transition to second page
 * 
 */

package edu.ucsd.teamswift.letsgo;

import android.app.Activity;	
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;	// For logcat logging/debugging
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;	// For button OnClick event handling
import android.widget.Button;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Lets program look for and find the sign up button
		Button signUpButton = (Button)this.findViewById(R.id.signUpButton);
		
		signUpButton.setOnClickListener(new View.OnClickListener() {
			
			//System handles the click on sign up button
			@Override
			public void onClick(View v) {
				
				//Intent will allow user to transition to sign up page
				Intent moveToSignUpPage = new Intent(MainActivity.this, SignUpPage.class);
				startActivity(moveToSignUpPage);
				
				//Method to apply transition animation between activities
				//This is if we want it
				//overridePendingTransition(R.animator.transition_to_sign_up_page, R.animator.transition_sign_up_page_2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
