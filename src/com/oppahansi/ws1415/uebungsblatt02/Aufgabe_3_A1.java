/*
 * Created by Rogerg Fu
 *
 * <p>Eine mögliche Lösung für die Aufgabe 3 aus dem Uebungsblatt 2
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.uebungsblatt02;

public class Aufgabe_3_A1 {

  public static void main(String[] args) {

    int x, primzahlen = 0;
    boolean glatt = false;

    /*
     * eine Primzahl ist eine Zahl die sich nur durch 2 unterschiedliche ganze Zahlen ohne rest teilen lässt und zwar 1 und sich selber.
     * um nun festzustellen ob eine Zahl eine Primzahl ist, teil man sie durch alle Zahlen die kleiner sind als die Zahl und größer als 1.
     * sollte bei dieser Rechnung KEIN Rest entstehen ist es eine Primzahl.
     */

    for (int a = 2; a <= 100000; a++) {
      x =
          a
              - 1; //x ist die Zahl durch die versucht werden soll zu dividieren. Sie fängt bei der zu untersuchenden
      //zahl -1 an und wird bei II immer um 1 veringert. Dies passiert so lange bis sie 2 geworden ist (I)
      while (x > 1) { // I
        if (a % x == 0) {
          glatt =
              true; //hier wird "glatt" auf "true" gesetzt fals sich die Zahl ohne Rest teilen lässt.
        }
        x--; // II
      }
      if (glatt
          == false) { //ist "glatt" nach dem teilen immer noch "false" - also hat sich bei jeder division
        primzahlen++; //ein Rest ergeben wird die Anzahl der gezählten Primzahlen um 1 erhöht
      }
      glatt =
          false; //bevor die "for-Schleife" erneut durchläuft muss "glatt" wieder auf "false" gesetzt werden
    }

    System.out.println("Die Anzahl der Primzahlen ist: " + primzahlen);
  }
}
