/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2;

/**
 * Implements a black field.
 * 
 * @author Marcus
 */
public class BlackField extends Field {
    /**
	 * Creates a new black field for
	 * the specified position.
	 * 
	 * @param x The x coordinate of the position.
	 * @param y The y coordinate of the position.
	 */
	public BlackField(int x, int y) {
	    super(x, y);
    }
	
	/**
	 * Returns "b".
	 * 
	 * @return The string "b".
	 */
    @Override
    public String getColor() {
        return "b";
    }
}
