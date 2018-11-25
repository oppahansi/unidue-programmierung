/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp2;

import java.util.Arrays;

/**
 * Implements a rectangular board with 
 * black and white fields.
 * 
 * @author Marcus
 */
public class Chessboard {

	/**
	 * The fields of the chess board. The first
	 * dimension references columns (x), the second
	 * dimension references rows (y).
	 */
	private Field[][] fields;
	
	/**
	 * Creates a chessboard with width 8 
	 * and height 8.
	 */
	public Chessboard() {
		this(8, 8);
	}
	
	/**
	 * Creates a new chessboard with the specified
	 * width and height consisting of black and
	 * white fields in a checker pattern.
	 * 
	 * @param width The width (>= 0).
	 * @param height The height (>= 0).
	 */
	public Chessboard(int width, int height) {
		fields = new Field[width][height];
		for (int y = 0; y < height; y++) {
			// start every other row with a different color
			boolean white = (y % 2 == 0);
			for (int x = 0; x < width; x++) {
				if (white) {
					fields[x][y] = new WhiteField(x, y);
				} else {
					fields[x][y] = new BlackField(x, y);
				}
				// change the color for the next field in the row
				white = !white;
			}
		}
	}
	
	/**
	 * Determines whether the field with the specified
	 * index is part of the board.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return True if the board contains the field, false
	 * 	otherwise.
	 */
	public boolean hasField(int x, int y) {
	    return x >= 0 && x < fields.length && y >= 0 && y < fields[0].length;
    }
	
	/**
	 * Returns the field at the specified x and y coordinate
	 * or null, if the board does not have the field.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return The field, if it is part of the board, or null
	 * 	otherwise.
	 */
	public Field getField(int x, int y) {
	    return hasField(x, y) ? fields[x][y] : null;
    }
	
	/**
	 * Iterates over the fields of the board from
	 * line to line calls the visitor's nextField
	 * method for each field. Whenever the row 
	 * changes, the visitor's nextRow method is 
	 * called.
	 * 
	 * @param visitor The visitor to call.
	 */
	public void visitFields(Visitor visitor) {
		if (fields.length == 0) return; 
		for (int y = 0; y < fields[0].length; y++) {
			for (int x = 0; x < fields.length; x++) {
				visitor.nextField(fields[x][y]);
			}
			visitor.nextRow();
		}
	}
	
	/**
	 * Prints a compact string representation of the 
	 * board onto the console. The string representation
	 * highlights the marked fields.
	 */
	public void printMarks() {
		visitFields(new MarkPrinter());
	}
	
	/**
	 * Prints a compact string representation of the board
	 * onto the console. The string representation
	 * highlights the colors of the fields.
	 */
	public void printColors() {
		visitFields(new ColorPrinter());
	}

	/**
	 * Returns a (somewhat bloated) string representation
	 * of the board using the FieldStringifyer and the
	 * visit method.
	 */
	public String toString() {
	    FieldStringifyer fieldStringifyer = new FieldStringifyer();
		visitFields(fieldStringifyer);
		return fieldStringifyer.getText();
	}
	
	/**
	 * Removes the marks from all fields by setting them to false.
	 */
	public void clearMarks() {
        // Alternative zur unnoeting anonymen Klasse
        // Java8 Streams, lambda
	    Arrays.stream(fields).forEach(x -> Arrays.stream(x).forEach(y -> y.setMarked(false)));

        // simple foreach
	    /*for (Field[] fields : fields) {
	        for (Field field : fields) {
	            field.setMarked(false);
            }
        }*/
	}
	
	/**
	 * Marks all fields that can be reached by a knight 
	 * at a particular position in n moves. 
	 * 
	 * If (x,y) is not on the board, nothing will be marked. 
	 * 
	 * If n is smaller than 0, nothing will be marked. If
	 * n is 0, only the field at (x,y) will be marked.
	 * 
	 * If n is 1, the method will mark the fields at
	 * (x+-1, y+-2) and (x+-2, y+-1).
	 * 
	 * @param x The x coordinate to start from.
	 * @param y The y coordinate to start from.
	 * @param n The number of moves of the knight.
	 */
	public void markKnightMoves(int x, int y, int n) {
        if (hasField(x, y)) {
            fields[x][y].setMarked(true);

            if (n == 0) {
                fields[x][y].setMarked(true);
            } else {
                for (int X = x - 2; X <= x + 2; X += 4) {
                    for (int Y = y - 1; Y <= y + 1; Y += 2) {
                       	markKnightMoves(X, Y, n - 1);
                    }
                }
                for (int Y = y - 2; Y <= y + 2; Y += 4) {
                    for (int X = x - 1; X <= x + 1; X += 2) {
                        markKnightMoves(X, Y, n - 1);
                    }
                }
            }
        }
    }
	
	public static void main(String[] args) {
		Chessboard b = new Chessboard();
		System.out.println("toString:");
		System.out.print(b.toString());
		System.out.println();
		System.out.println("printColors:");
		b.printColors();
		System.out.println();
		System.out.println("printMarks:");
		b.printMarks();

		for (int i = 0; i < 2; i++) {
			System.out.println("markKnightMoves(3, 3, " +  i + ")");
			b.markKnightMoves(3, 3, i);
			b.printMarks();
			b.clearMarks();
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.println("markKnightMoves(0, 0, " +  i + ")");
			b.markKnightMoves(0, 0, i);
			b.printMarks();
			b.clearMarks();			
		}
	}
}
