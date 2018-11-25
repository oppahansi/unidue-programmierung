/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 *
 * <p>Lösung siehe ss14.woche3 - Package
 */
package com.oppahansi.ws1516.uebungen.uebung03; /*
                                                 * In dieser Aufgabe geht es darum das erste mal mit Arrays zu arbeiten.
                                                 * Implementieren Sie die Methoden addArrayElements und neighbourNumbers.
                                                 * Die Verwendung einer Schleife ist in dieser Aufgabe NICHT notwendig.
                                                 */

public class ArrayReadAndWrite {

  // Die Methode addElementsOfArray erwartet ein IntegerArray mit zwei
  // Elementen. Rueckgabewert soll die Summe der beiden Arrayelemente sein.
  public static int addElementsOfArray(int[] numbers) {
    int sum = 0;

    for (int i = 0; i < numbers.length; i++) { // fuer Anfaenger
      sum += numbers[i];
    }

    //      for (Integer currentNumber : numbers) {    // for-Each Schleife
    //         sum += currentNumber;
    //      }

    return sum;

    //return Arrays.stream(numbers).sum();       // Java 8 feature stream version
  }

  // Diese Methode soll auf eine Eingabe hin ein IntegerArray erzeugen und
  // zurueckgeben. Die Eingabe ist eine ganze Zahl n und das Array soll die
  // zwei Elemente enthalten. Das erste Element soll n-1 sein, das zweite n+1.
  public static int[] neighbourNumbers(int number) {
    int[] result = new int[2];

    result[0] = number - 1;
    result[1] = number + 1;

    return result;

    //return new int[]{number - 1, number + 1};     // kurze Version
  }

  // Testausgabe. Hier koennt ihr eure Methoden testen.
  public static void main(String[] args) {
    int zahlenArray[] = new int[] {5, 17};

    System.out.println(
        "Summe der Arrayelemente: " + addElementsOfArray(zahlenArray) + " (Richtig: 22)");

    int zahl = 3;

    int ergebnisArray[] = neighbourNumbers(zahl);

    System.out.println(
        "Kleiner Nachbar der Zahl "
            + zahl
            + ": "
            + ergebnisArray[0]
            + " (Richtig: 2)"
            + "\nGrosserNachbar der Zahl "
            + zahl
            + ": "
            + ergebnisArray[1]
            + " (Richtig: 4)");
  }
}
