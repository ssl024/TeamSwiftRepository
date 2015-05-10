/*
 * Abstract Category
 * 
 * The class that all other categories will inherit from (Basketball, Baseball, E-Sports, etc)
 */
package edu.ucsd.teamswift.letsgo;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.parse.GetDataCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;

@ParseClassName(value = "Category")
public class Category extends ParseObject {
	Bitmap icon;
	/*
	 * Category constructor
	 */
	public Category() {}

	//get and set CategoryName
	public String getCategoryName()
	{
		return getString("Name");
	}
	
	public boolean isJoinOnly()
	{
		return getBoolean("JoinOnly");
	}
	
	public int getActivityLevel()
	{
		return getInt("ActivityLevel");
	}
	
	//get and set CategoryIcon
	/* TODO */
	public Bitmap getCategoryIcon(){
		
		// Locate the column named "ImageName" and set the string
		ParseFile fileObject = getParseFile("ImageFile");
		fileObject.getDataInBackground(new GetDataCallback(){

			@Override
			public void done(byte[] data, ParseException e) {
				if(e == null)
				{
					Bitmap icon = BitmapFactory.decodeByteArray(data, 0, data.length);
				  giveIcon(icon);
				} else {
					giveIcon(null);
					Log.e("bitmap","There was a problem downloading the data.");
				}
			}
		});
		return icon;
	}
	
	
	private void giveIcon(Bitmap I){
		icon = I;
	}

}
