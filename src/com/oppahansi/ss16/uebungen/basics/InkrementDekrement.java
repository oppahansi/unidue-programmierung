/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.basics;

public class InkrementDekrement {

  /*
   * Diese Methode soll die Zahl zahl inkrementieren, das heisst um 1 erhoehen, und zurueckgeben.
   * Dazu muss also zahl+1 berechnet werden und anschliessend zurueckgegeben werden. Beispiel:
   * inkrementiere(42) --> 43
   */
  public static int inkrementiere(int zahl) {
    return zahl + 1; //zu Bearbeiten
  }

  /*
   * Diese Methode soll die Zahl zahl um 1 dekrementieren, das heisst um 1 erniedrigen, und
   * zurueckgeben. Dazu muss also zahl-1 berechnet werden und anschliessend zurueckgegeben werden.
   * Beispiel: dekrementiere(43) --> 42
   */
  public static int dekrementiere(int zahl) {
    return zahl - 1; //zu bearbeiten
  }

  //Die main Methode zum Testen der Methoden. Du kannst auch eigene Testfaelle testen.
  public static void main(String[] args) {
    System.out.println(inkrementiere(42)); //Erwartet:43
    System.out.println(inkrementiere(27)); //Erwartet:28
    System.out.println(inkrementiere(30)); //Erwartet:31
    System.out.println(dekrementiere(43)); //Erwartet:42
    System.out.println(dekrementiere(20)); //Erwartet:19
    System.out.println(dekrementiere(37)); //Erwartet:36
  }
}
