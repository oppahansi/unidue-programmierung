package com.oppahansi.ss14.woche6;
/*
 * Codevorlage nicht mein Eigentum.
 * Codevorlage entstand an der Universitaet Duisburg-Essen am Lehrstuhl fuer Angewandte Informatik.
 * Benoetigt fuer die Bearbeitung der RecursiveWordList Aufgabe - Rekursion - Listen
 * Implementierung der Methoden von Oppa Hansi.
 */

// Fibonacci-Zahlen
//
// Die Fibonacci-Folge ist folgenderma?en definiert:
//
// f_{0} = 0
// f_{1} = 1
// f_{n} = f_{n-1} + f_{n-2} fuer n>=2
//
// In der Code-Vorlage befindet sich eine Klasse mit der Methode fibonacci,
// welche die n-te Fibonacci-Zahl berechnet.
// Vervollstaendigen Sie die Methode mit Nutzung der Rekursion aus der obigen Definition!

public class Fibonacci {

  public static int fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return (fibonacci(n - 1) + fibonacci(n - 2));
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println(fibonacci(4));
    System.out.println(fibonacci(12));
    System.out.println(fibonacci(20));
  }
}
