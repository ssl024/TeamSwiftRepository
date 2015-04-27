/* Group: Team Swift              Project: Lets Go
 * Description: Sign Up Form page of "Lets Go" Android Application. Allows user to
 * 			    sign up for an account to use "Lets Go" program.
 * 
 * Page Created: Sang
 * Page Modified by: 
 * 		Steven : Added Parse sign up implementation.
 */


package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends Activity {

	/* Variables for the sign up page */
	EditText emailEditText;
	EditText reEmailEditText;
	EditText passwordEditText;
	EditText rePasswordEditText;
	Button submitButton;
	Button cancelButton;
	
	String emailString;
	String reEmailString;
	String passwordString;
	String rePasswordString;
	
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
		
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				emailString = emailEditText.getText().toString();
				reEmailString = reEmailEditText.getText().toString();
				passwordString = passwordEditText.getText().toString();
				rePasswordString = rePasswordEditText.getText().toString();
				
				/* Check if all fields are filled */
				if (emailString.equals("") || reEmailString.equals("") 
						|| passwordString.equals("") || rePasswordString.equals(""))
				{
					/* TODO */
					Log.v("FieldForms", "ALL FIELDS ARE EMPTY");
					/* Tell user to complete form */
					/* Pop up menu */
				}
				/* Check if emails are the same */
				else if (!emailString.equals(reEmailString))
				{
					/* TODO */
					Log.v("FieldForms", "EMAIL DOESNT MATCH");
					/* Tell user that emails are not the same */
					/* Pop up menu */
				}
				/* Check if passwords are the same */
				else if (!passwordString.equals(rePasswordString))
				{
					/* TODO */
					Log.v("FieldForms", "PASSWORD DOESNT MATCH");
					/* Tell user that passwords are not the same */
					/* Pop up menu */
				}
				/* All checks are good */
				else
				{
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
								Toast.makeText(getApplicationContext(), "Make popup confirm 1", Toast.LENGTH_LONG).show();
							}
							else
							{
								/* TODO */
								Toast.makeText(getApplicationContext(), "Make popup confirm 2", Toast.LENGTH_LONG).show();
							}
						}
					});
				}
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
