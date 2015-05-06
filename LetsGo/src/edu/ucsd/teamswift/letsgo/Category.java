/*
 * Abstract Category
 * 
 * The class that all other categories will inherit from (Basketball, Baseball, E-Sports, etc)
 */
package edu.ucsd.teamswift.letsgo;

import android.graphics.drawable.Drawable;

public class Category implements Comparable<Category> {
	
	//The image icon of the category (Basketball icon)
	Drawable categoryIcon;
	
	String categoryName;

	/*
	 * Category constructor
	 */
	public Category(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public void setCategoryIcon(Drawable categoryIcon)
	{
		this.categoryIcon = categoryIcon;
	}
	
	public Drawable getCategoryIcon()
	{
		return categoryIcon;
	}
	
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
	public String getCategoryName()
	{
		return categoryName;
	}

	@Override
	public int compareTo(Category other)
	{
		return categoryName.compareTo(other.getCategoryName());
	}

}