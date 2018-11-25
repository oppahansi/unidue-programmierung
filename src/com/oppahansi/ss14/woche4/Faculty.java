package com.oppahansi.ss14.woche4;

// Fakult�t
//
// Die Fakultaet ist eine mathematische Funktion, die wie folgt auf den Natuerlichen Zahlen definiert ist:
//
// n! = 1 * 2 * 3 * ... * n
//
// Zusaetzlich gilt
//
// 0! = 1
//
// Implementieren Sie die Fakultaetsfunktion in der Methode faculty aus der Code-Vorlage!

/*
 * Bearbeitet von Alex S.
 * alias oppahansi
 */

public class Faculty {

  public static int faculty(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      int solution = 1;
      for (int i = 2; i <= n; i++) {
        solution *= i;
      }
      return solution;
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("3! = 6 - Ihr Ergebnis ist: " + faculty(3));
    System.out.println("6! = 720 - Ihr Ergebnis ist: " + faculty(6));
  }
}
