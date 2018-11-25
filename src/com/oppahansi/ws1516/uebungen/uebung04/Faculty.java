/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung04;
// Fakultaet
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

public class Faculty {

  public static int faculty(int n) {
    return (n == 0) ? 1 : faculty(n - 1) * n;
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println("3! = " + faculty(3) + " - Richtig: 6");
    System.out.println("6! = " + faculty(6) + " - Richtig: 720");
  }
}
