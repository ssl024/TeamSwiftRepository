/*
 * Abstract Category
 * 
 * The class that all other categories will inherit from (Basketball, Baseball, E-Sports, etc)
 */
package edu.ucsd.teamswift.letsgo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName(value = "Category")
public class Category extends ParseObject {
	
	/*
	 * Category constructor
	 */
	public Category() {}

	//get and set CategoryName
	public String getCategoryName()
	{
		return getString("Name");
	}
	
	public void setCategoryName(String categoryName)
	{
		put("Name", categoryName);
	}
	
	//get and set CategoryIcon
	/* TODO */
}