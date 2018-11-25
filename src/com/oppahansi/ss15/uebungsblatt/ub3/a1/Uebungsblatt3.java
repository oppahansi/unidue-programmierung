/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub3.a1;

import java.util.Arrays;

public class Uebungsblatt3 {

  private static int[] arrayOne = {0, 1, 2, 3, 4, 5, 6, 7, 8};
  private static int[] arrayTwo = {7, 1, 6, 9, 1, 5, 2, 1, 8};
  private static int[][] matrixA = {{2, 2, 1}, {3, 1, 0}, {0, -1, -2}};

  public static void main(String[] args) {
    System.out.println("--- Task 1 ---\nYour Solution:");
    int[] testArray = doTastOne(arrayOne);
    printArray(testArray);
    System.out.println("\nExpected Solution:\n[0, 3, 6]\n");

    System.out.println("--- Task 2 ---\nYour Solution:");
    int[][] testMatrix = doTaskTwo(matrixA, 5);
    printMatrix(testMatrix);
    System.out.println("\nExpected Solution:\n[10, 10, 5]\n[15, 5, 0]\n[0, -5, -10]\n");

    System.out.println("--- Task 3 ---\nYour Solution:");
    System.out.println(doTaskThree(arrayTwo));
    System.out.println("\nExpected Solution:\n8\n");
  }

  /*
  Aufgabe 1 - 3
   */
  private static int[] doTastOne(int[] numbersArray) {
    int[] result = new int[numbersArray.length / 3];

    for (int i = 0, j = 0; i < numbersArray.length; i++) {
      if (i % 3 == 0) {
        result[j] = numbersArray[i];
        j++;
      }
    }

    return result;
  }

  private static int[][] doTaskTwo(int[][] matrixA, int skalar) {
    int[][] result = new int[matrixA.length][matrixA[0].length];

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        result[i][j] = matrixA[i][j] * skalar;
      }
    }

    return result;
  }

  private static int doTaskThree(int[] numbers) {
    int result = 0;

    for (int i = 0; i < numbers.length - 1; i++) {
      if (Math.abs(numbers[i] - numbers[i + 1]) > result) {
        result = Math.abs(numbers[i] - numbers[i + 1]);
      }
    }

    return result;
  }

  /*
  Hilfsmethoden
   */
  public static void printArray(int[] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      System.out.println(Arrays.toString(array));
    }
  }

  public static void printMatrix(int[][] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) {
        System.out.println(Arrays.toString(array[i]));
      }
    }
  }
}
