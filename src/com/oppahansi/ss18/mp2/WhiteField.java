/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2;

/**
 * Implements a white field.
 * 
 * @author Marcus
 */
public class WhiteField extends Field{
	/**
	 * Creates a new white field at the specified position.
	 * 
	 * @param x The x coordinate of the position.
	 * @param y The y coordinate of the position.
	 */
	public WhiteField(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Returns the string "w".
	 * 
	 * @return The string "w".
	 */
    @Override
    public String getColor() {
        return "w";
    }
}
