/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp2;

import java.util.Arrays;

public class Measurement {

  private int[] data;

  public Measurement() {
    this.data = new int[0];
  }

  // --------------------------------------------------------------

  public static void main(String[] args) {
    Measurement m = new Measurement();
    System.out.println("Neues Measurement-Objekt m erzeugt. m:");
    // ErwarteteAusgabe:
    // []
    m.printData();

    System.out.println("------------------------------------------------------------------");

    m.addValue(85);
    System.out.println("Hinzufügen eines neuen Wertes. m:");
    // Erwartete Ausgabe:
    // [85]
    m.printData();

    System.out.println("------------------------------------------------------------------");

    m.addValues(new int[] {58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93});
    System.out.println("Hinzuzfügen einer Menge von Werten. m:");
    // Erwartete Ausgabe:
    // [85, 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93]
    m.printData();

    System.out.println("------------------------------------------------------------------");

    int minimumValue = m.getMinimumValue();
    System.out.println("Minimaler Wert der Messreihe m:");
    // Erwartete Ausgabe: 58
    System.out.println(minimumValue);

    System.out.println("------------------------------------------------------------------");

    int[] valuesAbove78 = m.getValuesAboveThreshold(78);
    System.out.println("Messwerte über 78:");
    // Erwartete Ausgabe:
    // [85, 93, 81, 79, 81, 93]
    System.out.println(Arrays.toString(valuesAbove78));

    System.out.println("------------------------------------------------------------------");

    int[] valuesAbove93 = m.getValuesAboveThreshold(93);
    System.out.println("Messwerte über 93:");
    // Erwartete Ausgabe:
    // []
    System.out.println(Arrays.toString(valuesAbove93));
  }

  public void addValue(int value) {
    setData(copyOldArrayInLargerArray(data, value));
  }

  public void addValues(int[] values) {
    setData(copyOldArrayInLargerArray(data, values));
  }

  public int getMinimumValue() {
    int result = data[0];

    for (Integer currentValue : data) {
      if (result > currentValue) {
        result = currentValue;
      }
    }

    return result;
  }

  public int[] getValuesAboveThreshold(int threshold) {
    int[] result = new int[0];

    for (Integer currentValue : data) {
      if (currentValue > threshold) {
        result = copyOldArrayInLargerArray(result, currentValue);
      }
    }

    return result;
  }

  // --------------------------------------------------------------

  public void printData() {
    System.out.println(Arrays.toString(data));
  }

  // Hilfsmethoden von Oppahansi

  private int[] copyOldArrayInLargerArray(int[] data, int value) {
    int[] result = new int[data.length + 1];

    for (int i = 0; i < data.length; i++) {
      result[i] = data[i];
    }

    //      System.arraycopy(data, 0, result, 0, data.length);        // besser

    result[result.length - 1] = value;

    return result;
  }

  private int[] copyOldArrayInLargerArray(int[] data, int[] values) {
    int[] result = new int[data.length + values.length];

    for (int i = 0; i < data.length; i++) {
      result[i] = data[i];
    }

    //      System.arraycopy(data, 0, result, 0, data.length);                 // besser

    for (int i = data.length, j = 0; i < result.length; i++, j++) {
      result[i] = values[j];
    }

    //      System.arraycopy(values, 0, result, data.length, values.length);   // besser

    return result;
  }

  private void setData(int[] data) {
    this.data = data;
  }
}
