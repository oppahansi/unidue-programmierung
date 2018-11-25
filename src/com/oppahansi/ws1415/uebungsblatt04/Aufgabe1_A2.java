/* Created by oppahansi on 24.11.2014. */
package com.oppahansi.ws1415.uebungsblatt04;

public class Aufgabe1_A2 {

  private static final int[] ARRAYA = new int[] {1, 3, 5, 7, 9};
  private static final int[] ARRAYB = new int[] {0, 2, 4, 6, 8, 10, 12, 14};
  private static int counter;

  public static void main(String[] args) {
    int[] mergedArray = merge(ARRAYA, ARRAYB);
    System.out.println("Array 1: ");
    printArray(ARRAYA);
    System.out.println("Array 2");
    printArray(ARRAYB);
    System.out.println("Merged Array:");
    printArray(mergedArray);
  }

  private static int[] merge(int[] arrayA, int[] arrayB) {
    int indexA, indexB, indexC, lengthA, lengthB;
    indexA = 0;
    indexB = 0;
    indexC = 0;
    lengthA = arrayA.length;
    lengthB = arrayB.length;
    int[] arrayC = new int[lengthA + lengthB];

    while (indexA < lengthA && indexB < lengthB) {
      if (arrayA[indexA] <= arrayB[indexB]) {
        arrayC[indexC] = arrayA[indexA];
        indexA++;
      } else {
        arrayC[indexC] = arrayB[indexB];
        indexB++;
      }
      indexC++;
    }
    if (indexA < lengthA) {
      for (int i = indexA; i < lengthA; i++, indexC++) {
        arrayC[indexC] = arrayA[i];
      }
    } else {
      for (int i = indexB; i < lengthB; i++, indexC++) {
        arrayC[indexC] = arrayB[i];
      }
    }
    return arrayC;
  }

  private static void printArray(int[] array) {
    counter = 0;
    while (counter < array.length) {
      System.out.print(array[counter++] + " ");
    }
    System.out.println();
  }
}
