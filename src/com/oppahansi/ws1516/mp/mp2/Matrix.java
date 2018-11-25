/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp2;

import java.util.Arrays;

public class Matrix {

  private int[][] values;

  public Matrix(int[][] initialValues) {
    this.values = initialValues;
  }

  // --------------------------------------------------------------

  public static void main(String[] args) {
    Matrix m = new Matrix(new int[][] {{2, 4, 5}, {3, 7, 2}, {-2, 0, 1}, {5, 1, 1}});

    System.out.println("Neue Matrix m erzeugt. Matrix m:");
    // Erwartete Ausgabe:
    // 4x3:
    // [2, 4, 5]
    // [3, 7, 2]
    // [-2, 0, 1]
    // [5, 1, 1]
    m.print();

    System.out.println("------------------------------------------------------------------");

    Matrix n = new Matrix(new int[][] {{1, 0, -1}, {1, 3, 3}, {-2, -4, 1}, {0, 0, 1}});

    System.out.println("Neue Matrix n erzeugt. Matrix n:");
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 0, -1]
    // [1, 3, 3]
    // [-2, -4, 1]
    // [0, 0, 1]
    n.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Skalarmultiplikation von Matrix n mit dem Wert -1. Matrix n:");
    n.scalarMultiplication(-1);
    // Erwartete Ausgabe:
    // 4x3:
    // [-1, 0, 1]
    // [-1, -3, -3]
    // [2, 4, -1]
    // [0, 0, -1]
    n.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Matrix n wird zu Matrix m addiert. Matrix m:");
    m.add(n);
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 4, 6]
    // [2, 4, -1]
    // [0, 4, 0]
    // [5, 1, 0]
    m.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Spaltenvektor mit Index 1 von Matrix m:");
    int[] columnVector = m.getColumnVector(1);
    // Erwartete Ausgabe:
    // [4, 4, 4, 1]
    System.out.println(Arrays.toString(columnVector));

    System.out.println("------------------------------------------------------------------");

    System.out.println("Vergleich von Matrix m mit Matrix n:");
    // Erwartete Ausgabe:
    // false
    System.out.println(m.isEqualTo(n));

    System.out.println("------------------------------------------------------------------");

    Matrix o = new Matrix(new int[][] {{1, 4, 6}, {2, 4, -1}, {0, 4, 0}, {5, 1, 0}});

    System.out.println("Neue Matrix o erzeugt. Matrix o:");
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 4, 6]
    // [2, 4, -1]
    // [0, 4, 0]
    // [5, 1, 0]
    o.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Vergleich von Matrix o mit Matrix m:");
    // Erwartete Ausgabe:
    // true
    System.out.println(o.isEqualTo(m));

    System.out.println("------------------------------------------------------------------");

    System.out.println("Transponieren von Matrix o. Matrix o:");
    o.transpose();
    // Erwartete Ausgabe:
    // 3x4:
    // [1, 2, 0, 5]
    // [4, 4, 4, 1]
    // [6, -1, 0, 0]
    o.print();
  }

  public void scalarMultiplication(int c) {
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[i].length; j++) {
        values[i][j] *= c;
      }
    }
  }

  public void add(Matrix m) {
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[i].length; j++) {
        values[i][j] += m.values[i][j];
      }
    }
  }

  public int[] getColumnVector(int col) {
    int[] colVector = new int[values.length];

    for (int i = 0; i < values.length; i++) {
      colVector[i] = values[i][col];
    }

    return colVector;
  }

  public boolean isEqualTo(Matrix m) {
    if (values.length == m.values.length && values[0].length == m.values[0].length) {

      for (int i = 0; i < values.length; i++) {
        for (int j = 0; j < values[0].length; j++) {
          if (values[i][j] != m.values[i][j]) {
            return false;
          }
        }
      }

      return true;

    } else {
      return false;
    }
  }

  public void transpose() {
    int[][] transMatrix = new int[values[0].length][values.length];

    for (int i = 0; i < values[0].length; i++) {
      for (int j = 0; j < values.length; j++) {
        transMatrix[i][j] = values[j][i];
      }
    }

    this.values = transMatrix;
  }

  // --------------------------------------------------------------

  private void print() {
    if (values == null) {
      System.out.println("null");
    } else {
      System.out.printf("%dx%x:%n", values.length, values[0].length);

      for (int[] row : values) {
        System.out.println(Arrays.toString(row));
      }
    }
  }
}
