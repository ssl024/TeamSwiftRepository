package edu.ucsd.teamswift.letsgo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class JoinCategoryPage extends Activity {
	
	ListView categoryListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_category_page);

		Category[] categories = new Category[3];
		categories[0] = new Category("Basketball");
		categories[1] = new Category("Football");
		categories[2] = new Category("Dota");
		
		//The adapter turns our array into a usable format for our ListView
		ListAdapter listViewAdapter = new CategoryAdapter(this, categories);
	
		//Find the ListView on the page
		categoryListView = (ListView)this.findViewById(R.id.categoryListView);
	
		//Link the ListView with our Adapter
		categoryListView.setAdapter(listViewAdapter);
	
		//Used for clicks on the items in the list
		categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				String categoryPicked = "You selected " + String.valueOf(parent.getItemAtPosition(position));

				Toast.makeText(JoinCategoryPage.this, categoryPicked, Toast.LENGTH_SHORT).show();
			}

		});
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.join_category_page, menu);
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
