/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub1.a1;

public class Uebungsblatt1 {

  /*
  K�mmert Euch nur um die Aufgaben, die ich unten mit "Aufgabe 2 / 3" gekennzeichnet habe.
  Ignoriert alles andere vorerst.
   */
  public static void main(String[] args) {
    doTaskThree();
  }

  /*
   * Aufgabe 2
   */
  /*public static void doTaskTwo() throws Exception {
      int x;
      int y = 5;
      double a = 3.2;
      double b;
      double c;

      x = y - 2;
      x = x + 2;
      a = x;
      x = a;
      a = b + c;
      x = Y / 0;

      System.out.println(A hat den Wert + a)

      byte i = y;
  }*/

  /*
   * Aufgabe 3
   */
  public static void doTaskThree() {
    int a = 2;
    int b = 2;
    String c = "0";
    String ergebnisText;
    // Erg�nzen Sie den Quellcode hier!
    // a)
    ergebnisText = "" + (a - b);
    System.out.print(ergebnisText + " ist das erste Ergebnis, ");
    // b)
    ergebnisText = "" + ((a + b) * Integer.parseInt(c));
    System.out.print(ergebnisText + " ist das zweite Ergebnis, ");
    // c)
    ergebnisText = "" + (a / b * (b * b * b));
    System.out.print(ergebnisText + " ist das dritte Ergebnis, ");
    // d)
    ergebnisText = "" + (Integer.parseInt(c) / (a + 655535) * (65535 + b));
    System.out.print(ergebnisText + " ist das vierte Ergebnis.");
  }
}
