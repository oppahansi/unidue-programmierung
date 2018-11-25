// Alternative 2 - geloest bei Mario

package com.oppahansi.ws1516.mp.mp2_A2;

import java.util.Arrays;

public class Matrix {

  private int[][] values;

  public Matrix(int[][] initialValues) {
    //Aufgabe 2a: Konstruktor
    values = initialValues;
  }

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
    //Aufgabe 2b: Skalare Multiplikation
    for (int row = 0; row < values.length; row++) {
      for (int column = 0; column < values[row].length; column++) {
        values[row][column] *= c;
        //in lang: values[row][column] =values[row][column] *c;
      }
    }
  }

  public void add(Matrix m) {
    //Aufgabe 2c: Addition
    for (int row = 0; row < values.length; row++) {
      for (int column = 0; column < values[row].length; column++) {
        values[row][column] = values[row][column] + m.values[row][column];
      }
    }
  }

  public int[] getColumnVector(int col) {
    //Aufgabe 2d: Spaltenvektor
    int[] colVector = new int[this.values.length];

    for (int index = 0; index < this.values.length; index++) {
      colVector[index] = this.values[index][col];
    }
    return colVector;
  }

  public boolean isEqualTo(Matrix m) {
    //Aufgabe 2e: Vergleich
    //Anzahl der Spalten müssen gleich sein
    if (this.values.length != m.values.length) {
      return false;
    }

    //Anzehl der Zeilen müssen gleich sein
    if (this.values[0].length != m.values[0].length) {
      return false;
    }

    //Hilfsvariable zum Zählen der Gemeinsamkeiten der einzelnen Werte in der Tabelle
    int zaehler = 0;

    //Vergleichen der einzelnen Werte der Matrizen
    for (int i = 0; i < m.values.length; i++) {
      for (int j = 0; j < m.values[i].length; j++) {
        if (this.values[i][j] == m.values[i][j]) {
          zaehler++;
        }
      }
    }
    if (zaehler == this.values.length * m.values[0].length) {
      return true;
    } else {
      return false;
    }
  }

  // --------------------------------------------------------------

  public void transpose() {
    //Aufgabe 2f: Transponieren
    //Array mit vertauschten Zeilen und Spalten
    int[][] transenMatrix = new int[this.values[0].length][this.values.length];

    //seltsame For-Schleife
    for (int i = 0; i < this.values[0].length; i++) {
      for (int j = 0; j < this.values.length; j++) {
        transenMatrix[i][j] = this.values[j][i];
      }
    }
    this.values = transenMatrix;
  }

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
