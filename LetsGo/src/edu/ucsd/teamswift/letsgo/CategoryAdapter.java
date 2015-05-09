/*
 * CategoryAdapter
 * 
 * Author: Steven Lee
 * 
 * An adapter will turn an array into a usable format for a ListView.
 * This adapter will turn arrays of activities into a usable list for our activity pages.
 */
package edu.ucsd.teamswift.letsgo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<Category> {

	public CategoryAdapter(Context context, List<Category> values) {
		super(context, R.layout.category_row_horizontal, values);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		//The inflater makes the xml take up the entire view
		LayoutInflater theInflater;
		
		/*
		 * Optimization for the list.
		 * Creates the view if the view doesn't already exist, else
		 * re-uses the old convertView.
		 */
		if(convertView == null)
		{
			theInflater = LayoutInflater.from(getContext());
			convertView = theInflater.inflate(R.layout.category_row_horizontal, parent, false);
		}

		//Get one of the items from the array and grab its name to fill the textview
		Category currentCategory = (Category)getItem(position);
		String categoryName = currentCategory.getCategoryName();
	
		/*TODO*/
		//Drawable categoryIcon = getItem(position).getCategoryIcon();
	
		//Find the TextView in the list item xml so we can change its text and image
		TextView categoryNameTextView = (TextView)convertView.findViewById(R.id.categoryNameTextView);
	
		//Fill in the text
		categoryNameTextView.setText(categoryName);
		//Fill in the image
		/*TODO*/
		/*
		 * Have to make it so this can dynamically grab the image required
		 */
		categoryNameTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
		
		return convertView;
	}

}
