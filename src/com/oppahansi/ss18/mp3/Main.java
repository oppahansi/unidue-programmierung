/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

import java.util.Arrays;

/**
 * A program to test the implementation.
 *
 * @author Marcus
 */
public class Main {

    /**
     * Runs test cases for the mini project.
     *
     * @param args The arguments (ignored).
     * @throws Exception Thrown if something fails.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("ArrayStringList:");
        testList(new ArrayStringList());
        System.out.println();
        System.out.println("LinkedStringList:");
        testList(new LinkedStringList());
        System.out.println();
        System.out.println("StringStack:");
        testStack();
        System.out.println();
        System.out.println("BinaryIntTree:");
        testTree();
    }


    /**
     * Runs some test cases against the list implementation.
     *
     * @param list The list to test.
     * @throws Exception Thrown if something fails.
     */
    public static void testList(StringList list) throws Exception {
        System.out.println("New list is empty: " + checkValues(0, list.countElements()));
        // append, size, content
        System.out.println("Append A");
        list.appendString("A");
        System.out.println("List with 1 entries: " + checkValues(1, list.countElements()));
        System.out.println("Check contents: " + checkValues(new String[]{"A"}, list.toStringArray()));
        // append, size, content
        System.out.println("Append B");
        list.appendString("B");
        System.out.println("List with 2 entries: " + checkValues(2, list.countElements()));
        System.out.println("Check contents: " + checkValues(new String[]{"A", "B"}, list.toStringArray()));
        // append, size, content
        System.out.println("Append C");
        list.appendString("C");
        System.out.println("List with 3 entries: " + checkValues(3, list.countElements()));
        // replace, size, content
        System.out.println("Check contents: " + checkValues(new String[]{"A", "B", "C"}, list.toStringArray()));
        System.out.println("Replace A at 0:" + checkValues("A", list.replaceStringAt(0, "B")));
        System.out.println("List with 3 entries: " + checkValues(3, list.countElements()));
        // replace, size, content
        System.out.println("Check contents: " + checkValues(new String[]{"B", "B", "C"}, list.toStringArray()));
        System.out.println("Replace B at 1:" + checkValues("B", list.replaceStringAt(1, "A")));
        System.out.println("List with 3 entries: " + checkValues(3, list.countElements()));
        System.out.println("Check contents: " + checkValues(new String[]{"B", "A", "C"}, list.toStringArray()));
        // index of
        System.out.println("Index of A at 0: " + checkValues(1, list.getIndexOfString("A", 0)));
        System.out.println("Index of A at 1: " + checkValues(1, list.getIndexOfString("A", 1)));
        System.out.println("Index of A at 2: " + checkValues(-1, list.getIndexOfString("A", 2)));
        // get last and first
        System.out.println("Get first: " + checkValues("B", list.getFirstString()));
        System.out.println("Get last: " + checkValues("C", list.getLastString()));
        // get string at
        String[] expect = new String[]{"B", "A", "C"};
        for (int i = 0; i < expect.length; i++) {
            System.out.println("Get at " + i + ": " + checkValues(expect[i], list.getStringAt(i)));
        }
        // reverse list
        System.out.println("Reverse: " + checkValues(new String[]{"C", "A", "B"}, list.reverseStringList().toStringArray()));
        // remove string
        System.out.println("Remove 0: " + checkValues("B", list.removeStringAt(0)));
        System.out.println("Remove 1: " + checkValues("C", list.removeStringAt(1)));
        // insert string
        list.insertStringAt(1, "C");
        list.insertStringAt(1, "B");
        System.out.println("Insert string: " + checkValues(new String[]{"A", "B", "C"}, list.toStringArray()));
        // insert string list
        StringList other = list.getClass().newInstance();
        other.appendString("B");
        other.appendString("C");
        list.insertStringListAt(2, other);
        System.out.println("Insert list: " + checkValues(new String[]{"A", "B", "B", "C", "C"}, list.toStringArray()));
        // insert string
        list.insertStringAt(0, "A");
        System.out.println("Insert string: " + checkValues(new String[]{"A", "A", "B", "B", "C", "C"}, list.toStringArray()));
    }

    /**
     * Tests the stack with some test cases.
     */
    public static void testStack() {
        StringStack s = new StringStack(3);
        System.out.println("Empty stack size 0: " + checkValues(0, s.getSize()));
        System.out.println("Empty stack capacity 3: " + checkValues(3, s.getCapacity()));
        s.push("-");
        System.out.println("Stack size 1: " + checkValues(1, s.getSize()));
        System.out.println("Stack capacity 3: " + checkValues(3, s.getCapacity()));
        System.out.println("Pop returns value:" + checkValues("-", s.pop()));
        System.out.println("Empty stack size 0: " + checkValues(0, s.getSize()));
        System.out.println("Empty stack capacity 3: " + checkValues(3, s.getCapacity()));
        s.push("-");
        String[] values = new String[]{"A", "B", "C"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < values.length; j++) {
                s.push(values[j]);
            }
            System.out.println("Size check 3 push: " + checkValues(1 + (i + 1) * 3, s.getSize()));
            System.out.println("Capacity check 3 push: " + checkValues((i + 2) * 3, s.getCapacity()));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Check capacity: " + checkValues(12, s.getCapacity()));
            System.out.println("Pop: " + checkValues(values[(5 - i) % 3], s.pop()));
        }
        System.out.println("Check capacity: " + checkValues(9, s.getCapacity()));
    }

    /**
     * Runs some test cases against the tree.
     */
    public static void testTree() {
        BinaryIntTree tree = new BinaryIntTree();
        System.out.println("Empty tree contains:" + checkValues(false, tree.containsValue(0)));
        System.out.println("Empty tree no nodes: " + checkValues(0, tree.getNodeCount()));
        System.out.println("Insert first node: " + checkValues(true, tree.insertValue(2)));
        System.out.println("Tree with 1 node: " + checkValues(1, tree.getNodeCount()));
        System.out.println("Insert duplicate node: " + checkValues(false, tree.insertValue(2)));
        System.out.println("Tree with 1 node: " + checkValues(1, tree.getNodeCount()));
        System.out.println("Insert node 2: " + checkValues(true, tree.insertValue(1)));
        System.out.println("Tree with 2 nodes: " + checkValues(2, tree.getNodeCount()));
        System.out.println("Insert node 3: " + checkValues(true, tree.insertValue(4)));
        System.out.println("Tree with 3 nodes: " + checkValues(3, tree.getNodeCount()));
        System.out.println("Tree full: " + checkValues(true, tree.isFull()));
        System.out.println("Tree perfect: " + checkValues(true, tree.isPerfect()));
        System.out.println("Insert node 4: " + checkValues(true, tree.insertValue(3)));
        System.out.println("Insert node 5: " + checkValues(true, tree.insertValue(5)));
        System.out.println("Tree full: " + checkValues(true, tree.isFull()));
        System.out.println("Tree perfect: " + checkValues(false, tree.isPerfect()));
        System.out.println("Insert node 6: " + checkValues(true, tree.insertValue(0)));
        System.out.println("Tree full: " + checkValues(false, tree.isFull()));
        System.out.println("Tree perfect: " + checkValues(false, tree.isPerfect()));
        System.out.println("Tree as array: " + checkValues(new int[]{0, 1, 2, 3, 4, 5}, tree.toIntArray()));
    }


    /**
     * Checks an expected against an actual value.
     *
     * @param expect The expected boolean.
     * @param actual The actual boolean.
     * @return A string to describe the result.
     */
    public static String checkValues(boolean expect, boolean actual) {
        return (expect == actual) ? "OK" : ("Failed (Expected " + expect + " but was " + actual + ")");
    }


    /**
     * Checks an expected against an actual value.
     *
     * @param expect The expected string.
     * @param actual The actual string.
     * @return A string to describe the result.
     */
    public static String checkValues(String expect, String actual) {
        return (expect.equals(actual)) ? "OK" : ("Failed (Expected " + expect + " but was " + actual + ")");
    }


    /**
     * Checks an expected against an actual value.
     *
     * @param expect The expected int.
     * @param actual The actual int.
     * @return A string to describe the result.
     */
    public static String checkValues(int expect, int actual) {
        return (expect == actual) ? "OK" : ("Failed (Expected " + expect + " but was " + actual + ")");
    }

    /**
     * Checks an expected against an actual value.
     *
     * @param expect The expected string array.
     * @param actual The actual string array.
     * @return A string to describe the result.
     */
    public static String checkValues(String[] expect, String[] actual) {
        return (Arrays.equals(expect, actual)) ? "OK" : ("Failed (Expected " + Arrays.toString(expect) + " but was " + Arrays.toString(actual) + ")");
    }

    /**
     * Checks an expected against an actual value.
     *
     * @param expect The expected int array.
     * @param actual The actual int array.
     * @return A string to describe the result.
     */
    public static String checkValues(int[] expect, int[] actual) {
        return (Arrays.equals(expect, actual)) ? "OK" : ("Failed (Expected " + Arrays.toString(expect) + " but was " + Arrays.toString(actual) + ")");
    }

}
