package com.oppahansi.ss14.woche4;

// Fibonacci-Zahlen
//
// Die Fibonacci-Folge ist folgendermassen definiert:
//
// f_0 = 0
// f_1 = 1
// f_n = f_{n-1} + f_{n-2} fuer n>=2
//
// In der Code-Vorlage befindet sich eine Klasse mit der Methode fibonacci,
// welche die n-te Fibonacci-Zahl berechnet. Vervollstaendigen Sie die Methode!

/*
 * Bearbeitet von Alex S.
 * alias oppahansi
 */

public class Fibonacci {

  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      int fiba1 = 0; // f_0 = 0
      int fiba2 = 1; // f_1 = 1
      /*
       * Da wir ab mindestens 2 Anfangen und die andere Fälle schon kennen
       * beginnen wir mit dem Startwert i = 2
       */
      for (int i = 2; i <= n; i++) {
        /*
         * Hier passiert folgendes:
         * Da wir die Reihen ab 2 berechnen sollen, habe ich 2 Hilfsvariablen erstellt,
         * die mir helfen f_{n-1} und f_{n-2} zu speichern
         * fiba1 und fiba2
         * die fibHelp-Variable hilft mir immer das aktuelle Ergebnis zu erzeugen
         * bei n = 2 wäre es 1 - deswegen sind am Anfang fiba1 = 0 und fiba2 = 1
         */
        int fibHelp = fiba1 + fiba2; // aktuelle Ergebnis
        fiba1 = fiba2;
        fiba2 = fibHelp;
        /*
         * Vielleicht hilft noch das:
         * f(2) = f(0) + f(1) = 1 ---- ( f(0) = 0 und f(1) = 1 )
         * f(3) = f(1) + f(2) = 2 ---- ( f(1) = 1 und f(2) = 1 )
         * f(4) = f(2) + f(3) = 3 ---- ( f(2) = 1 und f(3) = 2 )
         * f(5) = f(3) + f(4) = 5 ---- ( f(3) = 2 und f(4) = 3 )
         * f(6) = f(4) + f(5) = 8 ---- ( f(4) = 4 und f(5) = 5 )
         * f(7) = f(5) + f(6) = 13 ---- ( f(5) = 5 und f(6) = 8 )
         * ...
         */
      }
      return fiba2;
      /*
       * Alternativ rekursive Lösung
       * return fibonacci(n-1) + fibonacci(n-2);
       */
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println(fibonacci(4));
    System.out.println(fibonacci(12));
  }
}
