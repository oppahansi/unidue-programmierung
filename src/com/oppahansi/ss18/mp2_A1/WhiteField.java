/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2_A1;

/**
 * Implements a white field.
 * 
 * @author Marcus
 */
public class WhiteField extends Field { 
	


// TODO: change inheritance hierarchy

	/**
	 * Creates a new white field at the specified position.
	 * 
	 * @param x The x coordinate of the position.
	 * @param y The y coordinate of the position.
	 */
	// TODO: constructor
	public WhiteField(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Returns the string "w".
	 * 
	 * @return The string "w".
	 */
	// TODO: override getColor
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
	return "w";
	}
}
