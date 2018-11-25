/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.arrayloops;

public class IntArrays {

  /*
   * Diese Methode soll den Durchschnitt aus allen Zahlen im Array array berechnen und zurueckgeben.
   * Der Durchschnitt ist dabei (array[0] + array[1] + ... + array[n-2] + array[n-1])/n wobei n die
   * Anzahl der Werte im Array ist.
   */
  public static double durchschnitt(int[] array) {
    int result = 0;

    for (Integer currentNumber : array) {
      result += currentNumber;
    }

    /* for (int i = 0; i < array.length; i++) { result += array[i]; } */
    return result;
  }

  /*
   * Diese Methode soll den Median aus einem Array berechnen und zurueckgeben. Der Median ist
   * diejenige Zahl, die in einem sortierten Array in der Mitte steht. Hat das Array eine gerade
   * Anzahl von Elementen, ist es der Durchschnitt von beiden Zahlen, die in der Mitte stehen. Du
   * kannst bei der Bearbeitung dieser Aufgabe davon ausgehen, dass das Array bereits sortiert ist.
   */
  public static double median(int[] array) {
    return 0;
  }

  /* Die Main Methode. Du kannst dir hier verschiedene Testfaelle ausdenken und testen. */
  public static void main(String[] args) {
    int[] test = {3, 4, 5, 9, 12, 16, 56};
    System.out.println(
        "Beim Aufruf der Methode 'public static double durchschnitt(int[] array)' mit dem Parameter test sollte herauskommen:"
            + "\n 15"
            + "\n Bei dir kommt heraus:"
            + durchschnitt(test));
    System.out.println(
        "Beim Aufruf der Methode 'public static double median(int[] array)' mit dem Parameter test sollte herauskommen:"
            + "\n 9"
            + "\n Bei dir kommt heraus:"
            + median(test));
  }
}
