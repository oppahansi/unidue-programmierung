/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.ifs;

public class TheAnswer {

  /* Die main Methode verschiedene Aufrufe testen */
  public static void main(String[] args) {
    System.out.println(TheAnswer.theAnswer(42)); //sollte true zurueckgeben
    System.out.println(TheAnswer.theAnswer(27)); //sollte false zurueckgeben
  }

  /*
   * Diese Methode soll zurueckgeben, ob der uebergeben Parameter 42 ist. Falls also gilt zahl = 42,
   * soll true zurueckgegeben werden, ansonsten false.
   */
  public static boolean theAnswer(int zahl) {
    //Hier beginnt der zu bearbeitende Bereich

    if (zahl == 42) {
      return true;
    } else {
      return false;
    }

    // return zahl == 42;  Kurze variante.
    //Hier endet der zu bearbeitende Bereich
  }
}
