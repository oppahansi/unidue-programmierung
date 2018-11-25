/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2_A1;

/**
 * An abstract base class for fields.
 * 
 * @author Marcus
 */
public abstract class Field {
	
	/**
	 * The x coordinate of the field.
	 */
	// TODO: x field
	private int x;
	/**
	 * The y coordinate of the field.
	 */
	// TODO: y field
	private int y;
	
	/**
	 * The marked state of the field.
	 */
	// TODO: marked field
	private boolean marked;
	/**
	 * Creates a new field at the specified position.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */
	// TODO: constructor with x and y
	public Field(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the marked state of the field.
	 * 
	 * @param marked True to mark, false to unmark.
	 */
	// TODO: setter for marked
	public void setMarked(boolean b){
		marked = b;
	}
	
	/**
	 * Determines whether the field is marked.
	 * 
	 * @return True if the field is marked, false otherwise.
	 */
	// TODO: getter form marked.
	public boolean isMarked(){
		return marked;
	}
	
	/**
	 * Returns a string that represents the field's color.
	 * 
	 * @return The color of the field.
	 */
	public abstract String getColor();
	
	
	/**
	 * Returns a string representation to representing the state of the field.
	 * The string representation starts with an opening bracket followed by 
	 * the x coordinate followed by a comma followed by the y coordinate followed
	 * by a comma followed by the marked state followed by a comma followed by
	 * the color followed by a closing bracket.
	 * 
	 * @return A string representation of the following form: (x,y,marked,color).
	 */
	// TODO: override java.lang.Object.toString()
	public String toString(){
		return  "(" + x+","+y+","+marked+","+getColor() +")";
		
	}
}
