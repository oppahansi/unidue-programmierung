// Alternative 2 - geloest bei Mario

package com.oppahansi.ws1516.mp.mp2_A2;

import java.util.Arrays;

public class Measurement {

  private int[] data;

  public Measurement() {
    //Aufgabe 1a: Konstruktor
    data = new int[0];
  }

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
    //Aufgabe 1b: Messwert hinzufügen
    int[] neu = new int[data.length + 1];
    for (int index = 0; index < data.length; index++) {
      neu[index] = data[index];
    }
    neu[neu.length - 1] = value;
    data = neu;
  }

  public void addValues(int[] values) {
    //Aufgabe 1c: Mehrere Messwerte hinzufügen
    int[] neu = new int[data.length + values.length];
    for (int index = 0; index < data.length; index++) {
      neu[index] = data[index];
    }
    for (int index = data.length; index < data.length + values.length; index++) {
      neu[index] = values[index - data.length];
    }
    data = neu;
  }

  public int getMinimumValue() {
    //Aufgabe 1d: Kleinster Wert
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < data.length; i++) {
      if (data[i] < min) {
        min = data[i];
      }
    }
    return min;
  }

  // --------------------------------------------------------------

  public int[] getValuesAboveThreshold(int threshold) {
    //Aufgabe 1e: Werte über dem Schwellenwert threshold
    int groesse = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] > threshold) {
        groesse++;
      }
    }

    int[] neu = new int[groesse];
    for (int indexData = 0, indexNeu = 0; indexNeu < neu.length; indexData++) {
      if (data[indexData] > threshold) {
        neu[indexNeu] = data[indexData];
        indexNeu++;
      }
    }
    return neu;
  }

  public void printData() {
    System.out.println(Arrays.toString(data));
  }
}
