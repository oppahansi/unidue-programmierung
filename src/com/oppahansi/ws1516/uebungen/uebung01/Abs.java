/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung01;

// Betragsfunktion
//
// Implementieren Sie die Betragsfunktion in der Methode "abs".
// Das Ergebnis der Betragsfunktion |x| ist x, wenn x >= 0 bzw. -x, wenn x < 0.

public class Abs {

  public static int abs(int value) {
    if (value >= 0) {
      return value;
    } else {
      return value * -1;
    }

    // return value >= 0 ? value : value * -1;            // Kurze version
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("Der Betrag von -24 = " + abs(-24) + " (24 ist korrekt)");
    System.out.println("Der Betrag von   0 = " + abs(0) + " (0 ist korrekt)");
    System.out.println("Der Betrag von   4 = " + abs(4) + " (4 ist korrekt)");
  }
}
