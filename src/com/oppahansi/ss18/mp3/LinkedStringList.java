/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

/**
 * A linked list to store strings.
 *
 * @author Marcus
 */
public class LinkedStringList implements StringList {

    /**
     * An item in the linked list.
     *
     * @author Marcus
     */
    public static class Item {

        /**
         * The string stored in the item.
         */
        private final String string;

        /**
         * The next element in the list or
         * null, if this is the last element.
         */
        private Item next;

        /**
         * Creates an item to store the string.
         *
         * @param string The string to store.
         */
        public Item(String string) {
            this.string = string;
        }

        /**
         * Returns the string stored in the item.
         *
         * @return The string stored in the item.
         */
        public String getString() {
            return string;
        }

        /**
         * Returns the next item in the list or
         * null, if this is the last item.
         *
         * @return The next item.
         */
        public Item getNext() {
            return next;
        }

        /**
         * Sets the next item of the list.
         *
         * @param next The value for the next item.
         */
        public void setNext(Item next) {
            this.next = next;
        }

    }

    /**
     * The head (i.e. first element) of the
     * list or null, if the list is empty.
     */
    private Item head;

    /**
     * Creates a new, empty list.
     */
    public LinkedStringList() {
        super();
    }

    @Override
    public String getFirstString() {
        // check if empty
        if (head == null) return null;
        // else return string in first element
        return head.getString();
    }

    @Override
    public void appendString(String text) {
        if (head == null) {
            head = new Item(text);
        } else {
            Item item = getItemAt(countElements() - 1);

            if (item != null) {
                item.setNext(new Item(text));
            }
        }
    }

    @Override
    public String getStringAt(int i) {
        if (head == null || !isIndexValid(i)) {
            return null;
        } else {
            Item item = getItemAt(i);

            if (item == null) {
                return null;
            } else {
                return item.getString();
            }
        }
    }

    @Override
    public void insertStringAt(int i, String text) {
        if (head != null && isIndexValid(i)) {
            if (i == 0) {
                Item newHead = new Item(text);
                newHead.setNext(head);
                head = newHead;
            } else {
                Item newItem = new Item(text);
                Item prev = getItemAt(i - 1);

                if (prev != null) {
                    Item next = prev.getNext();

                    newItem.setNext(next);
                    prev.setNext(newItem);
                }
            }
        } else { // dieser Fall wurde nicht in der Aufgabenstellung definiert, ergibt sich aber aus den Main-Methode Testfaällen ?
            appendString(text);
        }
    }

    @Override
    public void insertStringListAt(int i, StringList list) {
        if (head != null && isIndexValid(i)) {
            for (int index = 0; index < list.countElements(); index++) {
                insertStringAt(i + index, list.getStringAt(index));
            }
        }
    }

    @Override
    public String replaceStringAt(int i, String text) {
        String oldValue = null;

        if (head != null && isIndexValid(i)) {
            if (i == 0) {
                Item newHead = new Item(text);

                newHead.setNext(head.getNext());
                oldValue = head.getString();
                head = newHead;
            } else {
                Item itemToReplace = getItemAt(i);
                Item newItem = new Item(text);
                Item prev = getItemAt(i - 1);

                if (itemToReplace != null) {
                    oldValue = itemToReplace.getString();
                    newItem.setNext(itemToReplace.getNext());
                }

                if (prev != null) {
                    prev.setNext(newItem);
                }
            }
        }

        return oldValue;
    }

    @Override
    public String removeStringAt(int i) {
        String oldValue = null;

        if (head != null && isIndexValid(i)) {
            if (i == 0) {
                oldValue = head.getString();
                head = head.getNext();
            } else {
                Item itemToRemove = getItemAt(i);
                Item prev = getItemAt(i - 1);

                if (itemToRemove != null) {
                    oldValue = itemToRemove.getString();

                    if (prev != null) {
                        prev.setNext(itemToRemove.getNext());
                    }
                }
            }
        }

        return oldValue;
    }

    @Override
    public String getLastString() {
        if (head != null) {
            Item lastItem = getItemAt(countElements() - 1);

            if (lastItem != null) {
                return lastItem.getString();
            }
        }

        return null;
    }

    @Override
    public StringList reverseStringList() {
        StringList reversedStringList = new LinkedStringList();

        for (int i = countElements() - 1; i >= 0; i--) {
            String currentString = getStringAt(i);

            if (currentString != null) {
                reversedStringList.appendString(currentString);
            }
        }

        return reversedStringList;
    }

    @Override
    public int getIndexOfString(String text, int from) {
        if (head != null && isIndexValid(from)) {
            Item currentElement = getItemAt(from);
            int index = from;

            while (currentElement != null) {
                if (currentElement.getString().compareTo(text) == 0) {
                    return index;
                }

                index++;
                currentElement = currentElement.getNext();
            }
        }

        return -1;
    }

    @Override
    public int countElements() {
        if (head == null) {
            return 0;
        } else {
            Item currentElement = head;
            int counter = 0;

            while (currentElement != null) {
                counter++;
                currentElement = currentElement.getNext();
            }

            return counter;
        }
    }

    @Override
    public String[] toStringArray() {
        if (head == null) {
            return new String[0];
        } else {
            Item currentElement = head;
            String[] itemsArray = new String[countElements()];
            int index = 0;

            while (currentElement != null) {
                itemsArray[index] = currentElement.getString();

                index++;
                currentElement = currentElement.getNext();
            }

            return itemsArray;
        }
    }

    private Item getItemAt(int i) {
        if (head == null || !isIndexValid(i)) {
            return null;
        } else if (i == 0) {
            return head;
        } else {
            Item currentElement = head;
            int index = 0;

            while (currentElement != null && index != i) {
                index++;
                currentElement = currentElement.getNext();
            }

            return currentElement;
        }
    }

    private boolean isIndexValid(int index) {
        return head != null && index >= 0 && index < countElements();
    }
}
