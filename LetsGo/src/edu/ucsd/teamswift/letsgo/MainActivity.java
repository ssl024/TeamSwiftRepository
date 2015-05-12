/* Project: Lets Go
 * Group: Team Swift
 * Description: Opening Page of "Lets Go" Android Application. Allows user to
 * 			    sign up or sign in to application
 * 
 * Page Created: Steven
 * Page Modified by:
 * 		Sang : Created event handling for lets go play and active activities
 * 			 
 */

package edu.ucsd.teamswift.letsgo;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.LogInCallback;
import com.parse.ParseException;
import edu.ucsd.teamswift.letsgo.DialogPopUp;
import android.app.Activity;	
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	
	Button forgotPasswordBut;
	Button signUpBut;
	Button logInBut;
	String emailString;
	String passwordStirng;
	EditText passwordEditText;
	EditText emailEditText;
	
	// PageContext is a variable to hold the page name to pass it to DialogPopUp()
	Context pageContext = MainActivity.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Parse activation
		//Enable Local Datastore.
		//Parse.enableLocalDatastore(this);

		//Register all ParseObject subclasses here:
		ParseObject.registerSubclass(Category.class);
		
		Parse.initialize(this, "hB3eXHmQndkVq2f3Ir1I4G2WKW8va1p10ZUmi3iw", "uhv7L1VPCLM5xYdvEXHwb1tMJ1hCrYLkftaYUFeK");	

		//Lets program look for and find the sign up button
		forgotPasswordBut = (Button)this.findViewById(R.id.forgotPasswordBut);
		signUpBut = (Button)this.findViewById(R.id.signUpBut);
		logInBut = (Button)this.findViewById(R.id.logInBut);
		emailEditText = (EditText) findViewById(R.id.userEmail);
		passwordEditText = (EditText) findViewById(R.id.userPassword);
		
	
		/*
		 * Forgot Password Button
		 * 
		 * Displays the forgot password dialog box
		 * The class is located in ForgotPasswordDialog.java
		 */
		forgotPasswordBut.setOnClickListener(new View.OnClickListener() {
			
			
			
			
			@Override
			public void onClick(View v) {
				
				
				
				/* TODO
				 * Warning: Forgot password is being used as a temporary link to the
				 * JoinCategoryPage.java
				 * 
				 */
				
				/*DialogFragment dialogPopup = new ForgotPasswordDialog();
				dialogPopup.show(getFragmentManager(), "ForgotPasswordDialogTag");*/
				
				Intent testMove = new Intent(MainActivity.this, JoinCategoryPage.class);
				testMove.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(testMove);
			
				
			}
		});
			
		/*
		 * Sign Up Button
		 * 
		 * Transitions to the Sign Up Page
		 */
		signUpBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			
				//Intent will allow user to transition to sign up page
				Intent moveToSignUpPage = new Intent(MainActivity.this, SignUpPage.class);
				
				//Makes it so the sign up page is a unique task
				moveToSignUpPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
				//Then moves to Sign Up Page
				startActivity(moveToSignUpPage);
				
				//Method to apply transition animation between activities
				//overridePendingTransition(R.animator.transition_to_sign_up_page, R.animator.transition_sign_up_page_2);
			}
		});
	
		/*
		 * Log In Button
		 * 
		 * Logic that handles the log in and transitions to the Home Page
		 */
		logInBut.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				
				/*TODO*/
				//Before transition, check if Login Credential are good on parse carry token 
				// getText from the login page and store it in strings
				emailString = emailEditText.getText().toString();
				passwordStirng = passwordEditText.getText().toString();

				// Send data to parse for verification
				ParseUser.logInInBackground(emailString, passwordStirng, new LogInCallback() {
					public void done(ParseUser user, ParseException e) {
						if (user != null) {
							// if the user exist and authenticated, send user to home screen
							Intent intent = new Intent(MainActivity.this, HomePage.class);
							startActivity(intent);
							finish();
						} else {
							//Break this "if" statement to give pop up for each individual error in field
							if (emailString.equals("") || passwordStirng.equals("")) {
								
								/* Pop up menu to tell user to complete form */
								// Call DialogPopUp("title", "msg", "context")
								DialogPopUp.DialogPop("There was a problem", "Please fill the blank fields", pageContext);
								
							}
							
							else {
								/* Pop up menu to tell user to complete form */
								// Call DialogPopUp("title", "msg", "context")
								DialogPopUp.DialogPop("There was a problem", "No such user exist, please sign up", pageContext);
							
							}
						}
					}
				
				});
						
			}
		});
	}
		
	//Removed Menu Icon on Opening Page
/*	@Override
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
	}*/
}
