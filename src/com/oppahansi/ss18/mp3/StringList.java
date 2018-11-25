/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

/**
 * An interface for a list that stores strings.
 * 
 * @author Marcus
 */
public interface StringList {

	/**
	 * Appends a string to the end of the list.
	 * 
	 * @param text The string to append.
	 */
	void appendString(String text);
	
	/**
	 * Returns the string at the specified index.
	 * 
	 * @param i The index of the string to retrieve.
	 * @return The string at the index or null, if
	 * 	i does not lie within the bounds of the list.
	 */
	String getStringAt(int i);
	
	/**
	 * Inserts a string at the specified index.
	 * 
	 * @param i The index to insert the string at,
	 * 	must be >= 0 and <= countElements().
	 * @param text The string to insert.
	 */
	void insertStringAt(int i, String text);
	
	/**
	 * Inserts the contents of the list into this
	 * list at the specified index.
	 * 
	 * @param i The index to insert the string at,
	 *  must be >= 0 and <= countElements().
	 * @param list The list to insert.
	 */
	void insertStringListAt(int i, StringList list);
	
	/**
	 * Replaces the string at the specified index
	 * with the text and returns the string that
	 * has been replaced.
	 * 
	 * @param i The index to replace the string,
	 * 	must be >= 0 and < countElements().
	 * @param text The text that will replace the
	 * 	text at the specified index.
	 * @return The string that has been replaced.
	 */
	String replaceStringAt(int i, String text);
	
	/**
	 * Removes the string at the specified index
	 * and returns the removed string.
	 * 
	 * @param i The index to remove, must be
	 * 	>= 0 and < countElements().
	 * @return The removed string.
	 */
	String removeStringAt(int i);
	
	/**
	 * Returns the string of the first element
	 * in the list (at index 0) or null, if the
	 * list does not have any elements.
	 * 
	 * @return The string of the first element or
	 * 	null, if the list is empty.
	 */
	String getFirstString();
	
	/**
	 * Returns the string of the last element
	 * in the list (at index -1) or null, if the
	 * list does not have any elements.
	 * 
	 * @return
	 */
	String getLastString();
	
	/**
	 * Returns a new string list that contains
	 * the elements of this string list in the
	 * reverse order. 
	 * 
	 * @return The new string list with the
	 * 	same elements but in reverse order (last
	 * 	item will be first, second last item will
	 * 	be second, etc.)
	 */
	StringList reverseStringList();
	
	/**
	 * Returns the first index of the list that
	 * contains the text when starting to search
	 * from the specified start index.
	 * 
	 * @param text The text to search.
	 * @param startIndex The first index to search
	 * 	from.
	 * @return The index at which the text can be found
	 * 	or -1 if the sublist starting at startIndex does
	 * 	not contain the string.
	 */
	int getIndexOfString(String text, int startIndex);
	
	/**
	 * Returns the number of strings stored in the list.
	 * 
	 * @return The number of strings in the list.
	 */
	int countElements();
	
	/**
	 * Converts the list into a string array that
	 * can be freely manipulated by the caller without
	 * modifying the contents of the list.
	 * 
	 * @return A string array with the current content
	 * 	of the list.
	 */
	String[] toStringArray();
	
}
