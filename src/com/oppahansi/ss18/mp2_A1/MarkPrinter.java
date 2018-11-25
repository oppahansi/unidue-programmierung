/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2_A1;

/**
 * Implements a vistor that prints a compact representation
 * of the marked state of a board onto the console.
 * 
 * @author Marcus
 */
public class MarkPrinter implements Visitor {

	public void nextField(Field field) {
		// TODO Auto-generated method stub
		if(field.isMarked()){
			System.out.print("X");
		}
		else
			System.out.print("-");
	}

	@Override
	public  void nextRow() {
		// TODO Auto-generated method stub
		System.out.println();
	} // TODO: add interface

	/**
	 * Prints the state of the specified field onto
	 * the console (using print, not println). 
	 * If the field is marked, the method prints 
	 * "X". If the field is not marked, the method
	 * prints "-". 
	 */
	// TODO: override Visitor.nextField
	
	/**
	 * Prints a new line onto the console.
	 */
	// TODO: override Visitor.nextRow
	
}
