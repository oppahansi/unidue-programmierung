/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2_A1;

/**
 * Implements a visitor that creates a string representation
 * from the fields of a board and makes it available via a
 * getter.
 * 
 * @author Marcus
 *
 */
public class FieldStringifyer implements Visitor{ // TODO: change type declaration
	
	/**
	 * The text that has been gathered by the stringifyer.
	 */
	// TODO: add text variable
	private String text;
	
	/**
	 * Returns the text that has been gathered by the
	 * stringifyer so far.
	 * 
	 * @return The text of the stringifyer.
	 */
	// TODO: add getter for text
	public String getText(){
		return text;
	}
	
	/**
	 * Appends the string representation of the field to
	 * the text.
	 * 
	 * @param field The field whose string representation
	 * 	should be appended.
	 */
	// TODO: override nextField
	public void nextField(Field field){
		text = field.toString();
	}

	/**
	 * Appends a newline character ("\n") to the text.
	 */
	// TODO: override nextRow
	public void nextRow(){
		text += "\n";
	}
	
}
