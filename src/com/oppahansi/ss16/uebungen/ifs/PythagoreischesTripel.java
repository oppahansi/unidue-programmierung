/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.ifs;

public class PythagoreischesTripel {

  public static void main(String[] args) {
    PythagoreischesTripel tripel = new PythagoreischesTripel();
    System.out.println("Die Rueckgabe sollte true sein: " + tripel.tripel(3, 4, 5));
    System.out.println("Die Rueckgabe sollte true sein: " + tripel.tripel(20, 21, 29));
    System.out.println("Die Rueckgabe sollte false sein: " + tripel.tripel(1, 2, 3));
  }

  /*
   * Diese Methode soll zurueckgeben, ob es sich bei den drei Zahlen a, b und c um ein
   * pythagoreisches Tripel handelt. Drei Zahlen a, b und c sind genau dann ein pythagoreisches
   * Tripel, wenn gilt: a*a+b*b=c*c Beispiele: tripel(3,4,5)--> true tripel(20,21,29)--> true
   * tripel(1,2,3)--> false
   */
  public boolean tripel(int a, int b, int c) {
    if (a * a + b * b == c * c) {
      return true;
    } else {
      return false;
    }
  }
}
