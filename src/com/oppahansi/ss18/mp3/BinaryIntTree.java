/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp3;

/**
 * A binary tree that stores unique int values
 * in its nodes and keeps them ordered. 
 * 
 * @author Marcus
 *
 */
public class BinaryIntTree {

	/**
	 * A tree node.
	 * 
	 * @author Marcus
	 */
	public static class Node {
		
		/**
		 * The node value.
		 */
		int value;
		
		/**
		 * The left child.
		 */
		Node leftChild;
		
		/**
		 * The right child.
		 */
		Node rightChild;
		
		/**
		 * Creates a node with a 
		 * particular value.
		 * 
		 * @param value The node's value.
		 */
		public Node(int value) {
			this.value = value;
		}

		/**
		 * Performs an in order traversal and writes the
		 * values of the tree into the array starting at
		 * the specified start index. When done, the
		 * method returns the updated start index that
		 * is incremented by the number of values written
		 * to the array.
		 * 
		 * @param array The array to write to.
		 * @param startIndex The start index to write from.
		 * @return The updated start index that is incremented
		 * 	by the number of values written to the array.
		 */
		public int toArray(int[] array, int startIndex) {
			// TODO: implement
			return 0;
		}
	}
	
	/**
	 * The root node.
	 */
	private Node root;
	
	/**
	 * Creates a new binary tree
	 * without any nodes.
	 */
	public BinaryIntTree() {
		super();
	}
	
	/**
	 * Determines whether a value is contained in the tree.
	 * 
	 * @param value The value to search for.
	 * @return True if it is contained, false otherwise.
	 */
	public boolean containsValue(int value) {
		return contains(root, value);
	}

	private boolean contains(Node root, int value) {
	    if (root == null) return false;
        if (value == root.value) return true;

        return value < root.value ? contains(root.leftChild, value) : contains(root.rightChild, value);
    }

	/**
	 * Inserts a value into the tree, if it does not
	 * exist already.
	 * 
	 * @param value The value to insert.
	 * @return True if the tree has been modified, false
	 * 	otherwise.
	 */
	public boolean insertValue(int value) {
        if (containsValue(value)) return false;
        else {
            root = insert(root, value);
            return true;
        }
	}

	private Node insert(Node root, int value) {
	    if (root == null) return new Node(value);

        if (value < root.value) root.leftChild =  insert(root.leftChild, value);
        else if (value > root.value) root.rightChild = insert(root.rightChild, value);

        return root;
    }

	/**
	 * Computes the number of nodes in the tree.
	 * 
	 * @return The number of nodes in the tree.
	 */
	public int getNodeCount() {
		return countNodes(root);
	}

	private int countNodes(Node root) {
	    if (root == null) return 0;
	    else if (root.leftChild == null && root.rightChild == null) return 1;
	    else return countNodes(root.leftChild) + countNodes(root.rightChild) + 1;
    }
	
	/**
	 * Determines whether all nodes have either 0 or 2
	 * children.
	 * 
	 * @return True if all nodes have zero or two children.
	 */
	public boolean isFull() {
		if (root == null) return false;
		return checkFull(root);
	}

	private boolean checkFull(Node root) {
	    if (root.leftChild == null && root.rightChild == null) return true;
	    else if (root.leftChild != null && root.rightChild == null) return false;
	    else if (root.leftChild == null) return false;
	    else return checkFull(root.leftChild) && checkFull(root.rightChild);
    }

	/**
	 * Determines whether the tree is perfect. That is
	 * all intermediate nodes have 2 children and all leafs
	 * are on the same level.
	 * 
	 * @return True if the tree is perfect.
	 */
	public boolean isPerfect() {
		return false;
	}

	/**
	 * Converts the tree to an int-array that is
	 * ordered (c.f. in-fix traversal).
	 * 
	 * @return The ordered int array.
	 */
	public int[] toIntArray() {
		int[] result = new int[getNodeCount()];
		if (result.length != 0) {
			root.toArray(result, 0);
		}
		return result;
	}
}
