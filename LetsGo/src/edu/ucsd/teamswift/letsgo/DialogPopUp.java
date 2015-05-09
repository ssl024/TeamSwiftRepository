package edu.ucsd.teamswift.letsgo;

import android.app.AlertDialog;
import android.content.Context;


public class DialogPopUp {

private static AlertDialog.Builder dialogBuilder;

	public static  void DialogPop(String title, String msg, Context page ) {
		// TODO Auto-generated method stub
		dialogBuilder = new AlertDialog.Builder(page);
		dialogBuilder.setTitle(title);
		dialogBuilder.setMessage(msg);
		AlertDialog popupDialog = dialogBuilder.create();
		popupDialog.show();
	}
	
}
