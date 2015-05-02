/* Group: Team Swift              Project: Lets Go
 * Description: Sign Up Form page of "Lets Go" Android Application. Allows user to
 * 			    sign up for an account to use "Lets Go" program.
 * 
 * Page Created: Sang
 * Page Modified by: 
 * 		Steven : Added Parse sign up implementation.
 * mazin test push
 */


package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends Activity {

	private EditText emailEditText;
	private EditText reEmailEditText;
	private EditText passwordEditText;
	private EditText rePasswordEditText;
	private Button submitButton;
	private Button cancelButton;
	private String emailString;
	private String reEmailString;
	private String passwordString;
	private String rePasswordString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up_page);
		
		/* Find the objects in the view */
		emailEditText = (EditText)findViewById(R.id.signUpE1);
		reEmailEditText = (EditText)findViewById(R.id.signUpE2);
		passwordEditText = (EditText)findViewById(R.id.signUpP1);
		rePasswordEditText = (EditText)findViewById(R.id.signUpP2);
		submitButton = (Button)findViewById(R.id.signUpSubmitBut);
		cancelButton = (Button)findViewById(R.id.signUpCancelBut);
		
		/*System handles the submit button*/
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				emailString = emailEditText.getText().toString();
				reEmailString = reEmailEditText.getText().toString();
				passwordString = passwordEditText.getText().toString();
				rePasswordString = rePasswordEditText.getText().toString();
				
				/* TODO */
				//Break this "if" statement to give pop up for each individual error in feild
				if (emailString.equals("") || reEmailString.equals("") 
						|| passwordString.equals("") || rePasswordString.equals(""))
				{
					/* TODO */
					Log.e("FieldForms", "FIELDS ARE EMPTY");
					/* Tell user to complete form */
					/* Pop up menu */
				}
				/* Check if emails are the same */
				else if (!emailString.equals(reEmailString))
				{
					/* TODO */
					Log.e("FieldForms", "EMAIL DOESNT MATCH");
					/* Tell user that emails are not the same */
					/* Pop up menu */
				}
				/* Check if passwords are the same */
				else if (!passwordString.equals(rePasswordString))
				{
					/* TODO */
					Log.e("FieldForms", "PASSWORD DOESNT MATCH");
					/* Tell user that passwords are not the same */
					/* Pop up menu */
				}
				
				/* All checks are good */
				else
				{
					/*TODO*/
					//Fix parse 
					/* Save new user into Parse.com Data Storage */
					ParseUser user = new ParseUser();
					
					user.setUsername(emailString);
					user.setPassword(passwordString);
					user.setEmail(emailString);
					
					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException exception)
						{
							if (exception == null)
							{
								/* TODO */
								//If good pop window of confirmation and then Move to Profile Page
								Toast.makeText(getApplicationContext(), "Make popup confirm 1", Toast.LENGTH_LONG).show();
							}
							else
							{
								/* TODO */
								//If not good, pop up window why not good and stay on page
								Toast.makeText(getApplicationContext(), "Make popup confirm 2", Toast.LENGTH_LONG).show();
							}
						}
					});
				
				}
				
				//After move to Sign Up Page, Removes Main Activity Page from stack
				finish();		
			}
		});
	
		/*
		 * Cancel Button
		 * 
		 * Returns from the Sign Up Page to the Main Activity
		 */
		cancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent moveToMainActivityPage = new Intent(SignUpPage.this, MainActivity.class);
		
				//Clears all other activities including this one when returning to the Main Activity
				moveToMainActivityPage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(moveToMainActivityPage);
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up_page, menu);
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
