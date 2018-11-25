/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2;

/**
 * Implements a vistor that prints a compact representation
 * of the marked state of a board onto the console.
 * 
 * @author Marcus
 */
public class MarkPrinter implements Visitor {
	/**
	 * Prints the state of the specified field onto
	 * the console (using print, not println). 
	 * If the field is marked, the method prints 
	 * "X". If the field is not marked, the method
	 * prints "-". 
	 */
	@Override
	public void nextField(Field field) {
		if (field.isMarked()) {
		    System.out.print("X");
        } else {
		    System.out.print("-");
        }
	}
	
	/**
	 * Prints a new line onto the console.
	 */
	@Override
	public void nextRow() {
		System.out.println();
	}
}
