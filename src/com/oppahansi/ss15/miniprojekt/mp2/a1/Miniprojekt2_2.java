/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.miniprojekt.mp2.a1;

import java.util.Arrays;

public class Miniprojekt2_2 {
  /*
   * Wichtig:
   * Die Methodensignatur darf nicht veraendert werden.
   */

  public static void main(String[] args) {
    int[][] mA = {{2, 2, 1}, {3, 1, 0}, {0, -1, -2}};
    int[][] mB = {{2, 1, 1}, {3, 3, 1}, {4, 0, 0}};
    int[][] mC = {{0, 12, 0}, {-12, 0, -8}, {0, 8, 0}};
    int[][] resultM;

    Miniprojekt2_2 mini = new Miniprojekt2_2();

    System.out.println("--- Task 2a ---\nYour Solution:");
    resultM = mini.matrixAddition(mA, mB);
    System.out.println("mA + mB = ");
    mini.ausgabeA(resultM);
    System.out.println("\nExpected Solution:\n[4, 3, 2]\n[6, 4, 1]\n[4, -1, -2]\n");

    System.out.println("--- Task 2b ---\nYour Solution:");
    resultM = mini.skalarMultiplikation(mA, 5);
    System.out.println("5 * mB = ");
    mini.ausgabeA(resultM);
    System.out.println("\nExpected Solution:\n[10, 10, 5]\n[15, 5, 0]\n[0, -5, -10]\n");

    System.out.println("--- Task 2c ---\nYour Solution:");
    resultM = mini.transponierteMatrix(mA);
    System.out.println("mA^T = ");
    mini.ausgabeA(resultM);
    System.out.println("\nExpected Solution:\n[2, 3, 0]\n[2, 1, -1]\n[1, 0, -2]\n");

    System.out.println("--- Task 2d ---\nYour Solution:");
    resultM = mini.matrixSubstraktion(mA, mB);
    System.out.println("mA - mB = ");
    mini.ausgabeA(resultM);
    System.out.println("\nExpected Solution:\n[0, 1, 0]\n[0, -2, -1]\n[-4, -1, -2]\n");

    System.out.println("--- Task 2e ---\nYour Solution:");
    boolean check = mini.matrixIstSymmetrisch(mA);
    System.out.println("mA ist Symmetrisch?");
    System.out.println("check --> " + check);
    System.out.println("\nExpected Solution:\ncheck --> false\n");

    System.out.println("--- Task 2f ---\nYour Solution:");
    check = mini.matrixIstSchiefsymmetrisch(mC);
    System.out.println("mA ist Symmetrisch?");
    System.out.println("check --> " + check);
    System.out.println("\nExpected Solution:\ncheck --> true\n");

    System.out.println("--- Task 2g ---\nYour Solution:");
    resultM = mini.matrixMultiplikation(mA, mB);
    System.out.println("mA * mB = ");
    mini.ausgabeA(resultM);
    System.out.println("\nExpected Solution:\n[14, 8, 4]\n[9, 6, 4]\n[-11, -3, -1]\n");
  }

  // Aufgabe 2a
  public int[][] matrixAddition(int[][] matrixA, int[][] matrixB) {
    int[][] result = new int[matrixA.length][matrixA[0].length];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        result[i][j] = matrixA[i][j] + matrixB[i][j];
      }
    }

    return result;
  }

  // Aufgabe 2b
  public int[][] skalarMultiplikation(int[][] matrixA, int skalar) {
    int[][] result = new int[matrixA.length][matrixA[0].length];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        result[i][j] += (matrixA[i][j] * skalar);
      }
    }

    return result;
  }

  // Aufgabe 2c
  public int[][] transponierteMatrix(int[][] matrixA) {
    int[][] result = new int[matrixA[0].length][matrixA.length];

    for (int i = 0; i < matrixA[0].length; i++) {
      for (int j = 0; j < matrixA.length; j++) {
        result[j][i] = matrixA[i][j];
      }
    }

    return result;
  }

  // Aufgabe 2d
  public int[][] matrixSubstraktion(int[][] matrixA, int[][] matrixB) {
    int[][] result = new int[matrixA.length][matrixA[0].length];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        result[i][j] += (matrixA[i][j] - matrixB[i][j]);
      }
    }

    return result;
  }

  // Aufgabe 2e
  public boolean matrixIstSymmetrisch(int[][] matrixA) {
    int[][] transposedMatrixA = transponierteMatrix(matrixA);

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        if (transposedMatrixA[i][j] != matrixA[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  // Aufgabe 2f
  public boolean matrixIstSchiefsymmetrisch(int[][] matrixA) {
    int[][] negativTransposedMatrixA = skalarMultiplikation(transponierteMatrix(matrixA), -1);

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        if (negativTransposedMatrixA[i][j] != matrixA[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  // Aufgabe 2g
  public int[][] matrixMultiplikation(int[][] matrixA, int[][] matrixB) {
    int[][] result = new int[matrixA.length][matrixA[0].length];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        for (int k = 0; k < matrixA[i].length; k++) {
          result[i][j] += (matrixA[i][k] * matrixB[k][j]);
        }
      }
    }

    return result;
  }

  /*
   * Debugausgabe
   * Kann zu Testzwecken verwendet werden, um die Werte eines Arrays auszugeben.
   * */
  public void ausgabeA(int[][] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) {
        System.out.println(Arrays.toString(array[i]));
      }
    }
  }

  /*
   * Debugausgabe
   * Kann zu Testzwecken verwendet werden, um die Werte eines Arrays auszugeben.
   * */
  public void ausgabeA(int[] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) {
        System.out.println("[" + array[i] + "]");
      }
    }
  }
}
