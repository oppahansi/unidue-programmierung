/*
 * Created by: Institut fuer Informatik und Wirtschaftsinformatik, Universitaet Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 *
 * <p>Loesung siehe WS1516 MP2
 */

/* Loesung siehe WS1516 MP2 */
package com.oppahansi.ss16.mp.mp1;

import java.util.Arrays;

public class Measurement {

  private int[] data;

  public Measurement() {}

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

  public void addValue(int value) {}

  public void addValues(int[] values) {}

  public int getMinimumValue() {
    return -1;
  }

  // --------------------------------------------------------------

  public int[] getValuesAboveThreshold(int threshold) {
    return null;
  }

  public void printData() {
    System.out.println(Arrays.toString(data));
  }
}
