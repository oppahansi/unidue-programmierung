/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung04;
// Potenz
//
// Vervollstaendigen Sie die Methode pow so, dass sie die Potenz(base hoch exponent) berechnet und
// das Ergebnis zurueckgibt. Gehen Sie davon aus, dass exponentimmer groesser oder gleich 0 ist.

public class Pow {

  public static int pow(int base, int exponent) {
    if (exponent == 0) {
      return 1;
    } else {
      int result = base;

      for (int i = 1; i < exponent; i++) {
        result *= base;
      }

      return result;
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("pow(2,4) = " + pow(2, 4) + " - Richtig: 16");
    System.out.println("pow(3,4) = " + pow(3, 4) + " - Richtig: 81");
  }
}
