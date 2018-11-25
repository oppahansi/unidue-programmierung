/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

/**
 * An array list to store strings.
 *
 * @author Marcus
 */
public class ArrayStringList implements StringList {

	/**
	 * The items in the list.
	 */
	private String[] items = new String[0];

	/**
	 * Creates a new empty list.
	 */
	public ArrayStringList() {
		super();
	}

	@Override
	public void appendString(String text) {
	    if (items.length == 0) {
	        items = new String[] { text };
        } else {
            String[] extendedItems = new String[items.length + 1];

            for (int i = 0; i < items.length; i++) {
                extendedItems[i] = items[i];
            }

            // Alternative zur oberen for-Schleife:
            // System.arraycopy(items, 0, extendedItems, 0, items.length);

            extendedItems[items.length] = text;

            items = extendedItems;
        }
    }

	@Override
	public String getStringAt(int i) {
	    return isIndexValid(i) ? items[i] : null;
	}

	@Override
	public void insertStringAt(int i, String text) {
	    if (isIndexValid(i)) {
	        items = getItemsWithNewItem(i, text);
        } else { // dieser Fall wurde nicht in der Aufgabenstellung definiert, ergibt sich aber aus den Main-Methode Testfaällen ?
	        if (i > 0) {
	            appendString(text);
            }
	        else {
	            insertStringAt(0, text);
            }
        }
	}

    @Override
	public void insertStringListAt(int i, StringList list) {
	    if (isIndexValid(i)) {
	        items = getItemsWithList(i, list);
        }
	}

	@Override
	public String replaceStringAt(int i, String text) {
		String oldValue = getStringAt(i);

		if (oldValue != null) {
		    items[i] = text;
        }

		return oldValue;
	}

	@Override
	public String removeStringAt(int i) {
	    String oldValue = getStringAt(i);

	    if (oldValue != null) {
	        items = getItemsWithout(i);
        }

	    return oldValue;
	}

	@Override
	public String getFirstString() {
	    return getStringAt(0);
	}

	@Override
	public String getLastString() {
	    return getStringAt(items.length - 1);
	}

	@Override
	public StringList reverseStringList() {
	    StringList reversed = new ArrayStringList();

	    for (int i = items.length - 1; i >= 0; i--) {
	        reversed.appendString(items[i]);
        }

		return reversed;
	}

	@Override
	public int getIndexOfString(String text, int from) {
		for (int i = from; i < items.length; i++) {
		    String element = getStringAt(i);

		    if (element != null && element.compareTo(text) == 0) {
		        return i;
            }
        }

		return -1;
	}

	@Override
	public int countElements() {
        return items.length;
	}

	@Override
	public String[] toStringArray() { return items; }

    private String[] getItemsWithNewItem(int index, String text) {
	    String[] extendedItems = new String[items.length + 1];

	    for (int i = 0; i < items.length; i++) {
	        if (i < index) {
	            extendedItems[i] = items[i];
            } else {
	            extendedItems[i + 1] = items[i];
            }
        }

        extendedItems[index] = text;

	    return extendedItems;
    }

    private String[] getItemsWithList(int index, StringList list) {
        String[] extendedItems = new String[items.length + list.countElements()];

        for (int i = 0, j = 0; i < extendedItems.length; i++) {
            if (i < index) {
                extendedItems[i] = items[i];
            } else if (i >= index && i < index + list.countElements()) {
                extendedItems[i] = list.getStringAt(j);
                j++;
            } else if (i >= index + list.countElements()) {
                extendedItems[i] = items[i - list.countElements()];
            }
        }

        return extendedItems;
    }

    private String[] getItemsWithout(int index) {
        String[] shortenedItems = new String[items.length - 1];

        for (int i = 0; i < shortenedItems.length; i++) {
            if (i < index) {
                shortenedItems[i] = items[i];
            } else {
                shortenedItems[i] = items[i + 1];
            }
        }

        return shortenedItems;
    }

    private boolean isIndexValid(int index) {
	    return items.length != 0 && index >= 0 && index < items.length;
    }
}
