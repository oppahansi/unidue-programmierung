/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2_A1;

/**
 * Implements a visitor that prints the field colors. 
 * 
 * @author Marcus
 */
public class ColorPrinter implements Visitor {

	public void nextField(Field field) {
		// TODO Auto-generated method stub
		System.out.print(field.getColor());
	}

	
	public void nextRow() {
		// TODO Auto-generated method stub
		System.out.println();
	} // TODO: add interface
	
	/**
	 * Prints the field color at the current position
	 * using System.out.print (not println).
	 */
	// TODO: override Visitor.nextField
	
	/**
	 * Prints a new line using System.out.println.
	 */
	// TODO: override Visitor.nextField

}
