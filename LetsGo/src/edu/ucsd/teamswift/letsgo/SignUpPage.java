/* Group: Team Swift              Project: Lets Go
 * Description: Sign Up Form page of "Lets Go" Android Application. Allows user to
 * 			    sign up for an account to use "Lets Go" program.
 * 
 * Page Created: Sang
 * Page Modified by: 
 */


package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.ucsd.teamswift.letsgo.DialogPopUp;

public class SignUpPage extends Activity {

	// Declare Variables 
	private EditText firstNameEditText, lastNameEditText, emailEditText, reEmailEditText,
					 	passwordEditText, rePasswordEditText;
	private String firstNameString, lastNameString, emailString,
				   		reEmailString, passwordString, rePasswordString;
	private Button submitButton,  cancelButton;
	
	// PageContext is a variable to hold the page name to pass it to DialogPopUp()
	private Context pageContext = SignUpPage.this;;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up_page);
		
		/* Find the objects in the view */
		firstNameEditText = (EditText)findViewById(R.id.firstName);
		lastNameEditText = (EditText)findViewById(R.id.lastName);
		emailEditText = (EditText)findViewById(R.id.signUpE1);
		reEmailEditText = (EditText)findViewById(R.id.signUpE2);
		passwordEditText = (EditText)findViewById(R.id.signUpP1);
		rePasswordEditText = (EditText)findViewById(R.id.signUpP2);
		submitButton = (Button)findViewById(R.id.signUpSubmitBut);
		cancelButton = (Button)findViewById(R.id.signUpCancelBut);
		//TODO Add field for first and last name
		
		//This is the method to pull phone number*****
/*		private String getMyPhoneNumber(){
		    TelephonyManager mTelephonyMgr;
		    mTelephonyMgr = (TelephonyManager)
		        getSystemService(Context.TELEPHONY_SERVICE); 
		    return mTelephonyMgr.getLine1Number();
		}

		private String getMy10DigitPhoneNumber(){
		    String s = getMyPhoneNumber();
		    return s != null && s.length() > 2 ? s.substring(2) : null;
		}  */
		
		/*System handles the submit button*/
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				firstNameString = firstNameEditText.getText().toString();
				lastNameString = lastNameEditText.getText().toString();
				emailString = emailEditText.getText().toString();
				reEmailString = reEmailEditText.getText().toString();
				passwordString = passwordEditText.getText().toString();
				rePasswordString = rePasswordEditText.getText().toString();
				
				/* TODO */
				//Break this "if" statement to give pop up for each individual error in field
				if (emailString.equals("") || reEmailString.equals("") 
						|| passwordString.equals("") || rePasswordString.equals("") 
						|| firstNameString.equals("") || lastNameString.equals(""))
				{
					/* Pop up menu to tell user to complete form */
					// Call DialogPopUp("title", "msg", "context")
					DialogPopUp.DialogPop("There was a problem", "Please fill the blank fields", pageContext);
										
				}
				/* Check if emails are the same */
				else if (!emailString.equals(reEmailString))
				{
					/* Pop up menu to Tell user that emails are not the same*/
					// Call DialogPopUp("title", "msg", "context")
					DialogPopUp.DialogPop("There was a problem", "Your emails do not match, please try again", pageContext);
					
				}
				/* Check if passwords are the same */
				else if (!passwordString.equals(rePasswordString))
				{
					/* Pop up menu to Tell user that passwords are not the same*/
					// Call DialogPopUp("title", "msg", "context")
					DialogPopUp.DialogPop("There was a problem", "Your passwords do not match, please try again", pageContext);
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
					
					// Add the user's 1st and last name to parse
					user.put("firstName", firstNameString);
					user.put("lastName", lastNameString);

					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException exception)
						{
							if (exception == null)
							{
								/* TODO */
								//If good pop window of confirmation and then Move to Profile Page
								Toast.makeText(getApplicationContext(), "TEST: user account successful", Toast.LENGTH_LONG).show();
								finish();
							}
							else
							{
								/* TODO */
								//If not good, pop up window why not good and stay on page
								Toast.makeText(getApplicationContext(), "TEST: user account unsuccessful", Toast.LENGTH_LONG).show();
							}
						}
					});
				
				}
				
				//Things to do after the entire on click happen here
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
				
				/*Intent moveToMainActivityPage = new Intent(SignUpPage.this, MainActivity.class);
		
				//Clears all other activities including this one when returning to the Main Activity
				moveToMainActivityPage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(moveToMainActivityPage);*/
				
				finish();
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
