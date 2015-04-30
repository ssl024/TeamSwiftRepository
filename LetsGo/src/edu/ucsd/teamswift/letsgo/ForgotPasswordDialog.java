/* Project: Lets Go
 * Group: Team Swift
 * Description: When the user presses the forgot password button on the Opening Page
 * 		this dialog window should appear.  Uses the forgot_password_popup_dialog.xml layout.
 * 
 * Page Created: Steven
 * Page Modified by:
 * 
 */

package edu.ucsd.teamswift.letsgo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class ForgotPasswordDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

	    /*
	     * Have to set the properties of the builder object which is the dialog.
	     * View inflate will use the layout forgot_password_dialog as the view.
	     */
	    builder.setTitle("Enter e-mail you dumbass")
	    	.setView(View.inflate(getActivity(), R.layout.forgot_password_dialog, null))
	    	/*
	    	 * Add all the buttons here.
	    	 * PositiveButton is the accept type button.
	    	 * NegativeButton is the cancel/back type button.
	    	 */
           .setPositiveButton(R.string.submitBut, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int id) {
            	   /* TODO
            	    * 
            	    * Put the action taken when user presses submit here.
            	    */
            	   Log.e("ForgotPasswordDialog", "You pressed the submit button!");
               }
           })
           .setNegativeButton(R.string.cancelBut, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   ForgotPasswordDialog.this.getDialog().cancel();
               }
           }); 
		return builder.create();
	}
}
