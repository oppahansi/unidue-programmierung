/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung04;
// Fibonacci-Zahlen
//
// Die Fibonacci-Folge ist folgenderma�en definiert:
//
// f_0 = 0
// f_1 = 1
// f_n = f_{n-1} + f_{n-2} f�r n>=2
//
// In der Code-Vorlage befindet sich eine Klasse mit der Methode fibonacci,
// welche die n-te Fibonacci-Zahl berechnet. Vervollstaendigen Sie die Methode!

public class Fibonacci {

  public static int fibonacci(int n) {
    if (n < 2) {
      return (n == 0) ? 0 : 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("Aufruf mit 4 liefert: " + fibonacci(4) + " - Richtig: 3");
    System.out.println("Aufruf mit 12 liefert: " + fibonacci(12) + " - Richtig: 144");
  }
}
