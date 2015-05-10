/*
 * JoinCategoryPage
 * 
 * Author: Steven Lee
 * 
 * When the user wants to join a game, the user must select a category.
 */
package edu.ucsd.teamswift.letsgo;

import java.util.List;

import com.parse.ParseException;
import com.parse.FindCallback;
import com.parse.ParseQuery;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class JoinCategoryPage extends Activity {
	
	ListView categoryListView;
	Button backButton;

	//The list of categories retrieved from Parse
	List<Category> categoryList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_category_page);

		//Find the widgets in the view
		categoryListView = (ListView)this.findViewById(R.id.categoryListView);
		backButton = (Button)this.findViewById(R.id.backButton);
		
		//Back button takes user back to Home Page
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		/*
		 * Calls the retrieveCategories function to retrieve the list from Parse.
		 * Will call the fillListView function inside this function to get timing correct.
		 */
		retrieveCategories();
	}

	/*
	 * fillListView
	 * 
	 * When the categoryList is populated, this function is called to fill the list.
	 */
	private void fillListView() 
	{
		//The adapter turns our array into a usable format for our ListView
		ListAdapter listViewAdapter = new CategoryAdapter(this, categoryList);
	
		//Link the ListView with our Adapter
		categoryListView.setAdapter(listViewAdapter);

		//Used for clicks on the items in the list
		categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				/* TODO
				 * Put intent here and put extra data to carry over
				 */

			}

		});	
	}

	/*
	 * retrieveCategories
	 * 
	 * Does a Parse query to retrieve all the Category items
	 */
	private void retrieveCategories() 
	{
		//Limit the query to those of class Category
		ParseQuery<Category> query = ParseQuery.getQuery("Category");

		query.findInBackground(new FindCallback<Category>() {
			
			@Override
		    public void done(List<Category> categoryList, ParseException e) {
		        if (e == null) {
		        	//Successfully retrieved the categories
		            Log.d("ParseQuery", "Retrieved " + categoryList.size() + " categories");
		           
		            //Pass the objects out of this inner-class to the outer-class
		            objectsWereRetrievedSuccessfully(categoryList);
		            
		        } else {
		        	//Unsuccessful
		            Log.d("ParseQuery", "Error: " + e.getMessage());
		        }
		    }
			
		});
		
	}

	/*
	 * objectsWereRetrievedSuccessfully
	 * 
	 * After Parse returns the Category list, the list is returned to the JoinCategoryPage object
	 * through this function.
	 * 
	 * Calls the fillListView function after the list is retrieved.
	 */
	protected void objectsWereRetrievedSuccessfully(List<Category> categoryList) 
	{
		this.categoryList = categoryList;
		
		fillListView();
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
