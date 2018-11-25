/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

/**
 * An array-based stack that adapts its capacity 
 * by a configurable number of elements.
 * 
 * @author Marcus
 */
public class StringStack {

	/**
	 * The array that stores the item.
	 */
	private String[] items;

	/**
	 * The current number of items.
	 */
	private int size = 0;
	
	/**
	 * The increment by which the items array will
	 * be increased when there is no more space left.
	 */
	private int increment = 0;
	
	/**
	 * Creates a new string stack that increments
	 * its capacity by 10.
	 */
	public StringStack() {
		this(10);
	}
	
	/**
	 * Creates a new string stack that increments
	 * its capacity by the specified increment.
	 * 
	 * @param increment The increment, must be > 0.
	 */
	public StringStack(int increment) {
		this.increment = increment;
		this.items = new String[increment];
	}
	
	/**
	 * Pushes the item onto the stack. If the 
	 * stack's capacity is not large enough to
	 * hold the additional item, the stack's
	 * capacity will be increased by the stack's
	 * increment.
	 * 
	 * @param item The item to push onto the stack.
	 */
	public void push(String item) {
        ensureStackSize(true);
        addValueToStack(item);
	}
	
	/**
	 * Pops the item from the stack. If the
	 * stack's available unused space is larger
	 * or equal than 2 times the increment, the 
	 * stack's capacity will be reduced by one
	 * full increment.
	 * 
	 * @return The item that is at the top of the
	 * 	stack or null, if the stack is empty.
	 */
	public String pop() {
	    String popValue = peek();

	    if (popValue != null) {
            popValue = removeValueFromStack();
            ensureStackSize(false);
        }

        return popValue;
	}
	
	/**
	 * Returns the size of the stack.
	 * 
	 * @return The size of the stack.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the current capacity of the stack.
	 * 
	 * @return The capacity of the stack.
	 */
	public int getCapacity() {
		return items.length;
	}

	public String peek() {
	    if (size > 0) return items[size - 1];
	    else return null;
    }

    private void ensureStackSize(boolean isPushing) {
        if (size == items.length && isPushing) extendStack();
        else if (items.length - size >= 2 * increment && !isPushing) shortenStack();
    }

    private void extendStack() {
	    String[] extendedStack = new String[items.length + increment];

	    for (int i = 0; i < items.length; i++)
            extendedStack[i] = items[i];

	    items = extendedStack;
    }

    private void shortenStack() {
	    String[] shortenedStack = new String[items.length - increment];

	    for (int i = 0; i < shortenedStack.length; i++)
	        shortenedStack[i] = items[i];

	    items = shortenedStack;
    }

    private void addValueToStack(String item) {
        items[size] = item;
        size++;
    }

    private String removeValueFromStack() {
        String popValue = items[size - 1];
        items[size - 1] = null;
        size--;

        return popValue;
    }
}
