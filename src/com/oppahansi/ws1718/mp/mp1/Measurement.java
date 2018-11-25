/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1718.mp.mp1;

import java.util.Arrays;

public class Measurement {

    private int[] data;

    // a
    public Measurement() {
        data = new int[0];
    }

    // b
    public void addValue(int value) {
        int[] newExtendedArray = new int[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            newExtendedArray[i] = data[i];
        }

        newExtendedArray[data.length] = value;

        data = newExtendedArray;
    }

    // c
    public void addValues(int[] values) {
        int[] newExtendedArray = new int[data.length + values.length];

        for (int i = 0; i < data.length; i++) {
            newExtendedArray[i] = data[i];
        }

        for (int i = 0; i < values.length; i++) {
            newExtendedArray[data.length + i] = values[i];
        }

        data = newExtendedArray;
    }

    // d
    public int getMinimumValue() {
        int minValue = data[0];

        for (int i = 1; i < data.length; i++) {
            if (minValue > data[i]) {
                minValue = data[i];
            }
        }

        return minValue;
    }

    // e
    public int[] getValuesAboveThreshold(int threshold) {
        int counter = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > threshold) {
                counter++;
            }
        }

        int[] valuesAboveThreshhold = new int[counter];

        for (int i = 0, j = 0; i < data.length; i++) {
            if (data[i] > threshold) {
                valuesAboveThreshhold[j] = data[i];
                j++;
            }
        }

        return valuesAboveThreshhold;
    }

    // --------------------------------------------------------------

    public void printData() {
        System.out.println(Arrays.toString(data));
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

        m.addValues(new int[]{58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93});
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
}
