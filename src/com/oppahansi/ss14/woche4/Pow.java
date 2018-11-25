package com.oppahansi.ss14.woche4;

// Potenz
//
// Vervollstaendigen Sie die Methode pow so, dass sie die Potenz
//(base hoch exponent) berechnet und das Ergebnis zurueckgibt.
// Gehen Sie davon aus, dass exponent immer groesser oder gleich 0 ist.

/*
 * Bearbeitet von Alex S.
 * alias oppahansi
 */

public class Pow {

  /*
   * Potenz = base hoch exponent
   * Beispiel: 2 hoch 4 lässt sich schreiben als:
   * 2 * 2 * 2 * 2 - das muss jetzt nur noch als Code umgesetzt werden
   *
   * Bei exponentn = 0 muss eine 1 zurück - Definition - auch bei 0 hoch 0 gibt es 1 zurück
   *
   */
  public static int pow(int base, int exponent) {
    /*
     * Fall 1: exponent = 0
     */
    if (exponent == 0) {
      return 1;
      /*
       * Fall 2: base = 0
       */
    } else if (base == 0) {
      return 0;
    } else {
      /*
       * Hilfsvariable für das Ergebnis
       * Beginnend bei 2 - da wir am Anfang solution = base gesetzt haben
       * d.h bei exponent = 1 gibt er direkt solution zurück
       * denn: base hoch 1 ist base
       */
      int solution = base;
      for (int i = 2; i <= exponent; i++) {
        // andere Schreibweise
        // solution = solution * base;
        solution *= base;
      }
      return solution;
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("pow(2,4) = " + pow(2, 4));
  }
}
