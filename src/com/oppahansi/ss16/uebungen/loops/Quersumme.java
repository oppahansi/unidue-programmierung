/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loops;

public class Quersumme {

  /*
   * Diese Methode soll die Quersumme von zahl berechnen. Die Quersumme einer Zahl ist die Summe
   * aller Ziffern in der Zahl.
   */
  public static int berechneQuersumme(int zahl) {
    String number = "" + zahl;
    int result = 0;

    for (int i = 0; i < number.length(); i++) {
      result += Integer.parseInt("" + number.charAt(i));
    }

    return result;
  }

  /* Die Main Methode. Du kannst dir hier verschiedene Testfaelle ausdenken und testen. */
  public static void main(String[] args) {
    System.out.println(
        "Die Quersumme der Zahl 123 ist: " + berechneQuersumme(123) + " (Richtig waere 6)");
    System.out.println(
        "Die Quersumme der Zahl 42 ist: " + berechneQuersumme(42) + " (Richtig waere 6)");
    System.out.println(
        "Die Quersumme der Zahl 87 ist: " + berechneQuersumme(87) + " (Richtig waere 15)");
  }
}
