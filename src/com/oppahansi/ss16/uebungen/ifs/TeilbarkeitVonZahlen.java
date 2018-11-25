/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.ifs;

public class TeilbarkeitVonZahlen {

  /*
   * Diese Methode soll zurueckgeben, ob die Zahl zahl ganzzahlig durch zahl2 teilbar ist. Eine Zahl
   * ist genau dann ganzzahlig durch eine andere Zahl teilbar, wenn zahl%zahl2==0 ist. Also muss
   * diese Methode ueberpruefen, ob zahl%zahl2 == 0. Falls dieser Ausdruck wahr ist, soll true
   * zurueckgegeben werden, falls nicht, soll false zurueckgegeben werden.
   */
  public static boolean teilbar(int zahl, int zahl2) {
    if (zahl % zahl2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  //In dieser Methode kannst du deine Methode testen
  public static void main(String[] args) {
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 20 und 3 sollte false liefern. Deine Methode liefert: "
            + teilbar(20, 3));
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 20 und 2 sollte true liefern. Deine Methode liefert: "
            + teilbar(20, 2));
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 20 und 5 sollte true liefern. Deine Methode liefert: "
            + teilbar(20, 5));
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 42 und 7 sollte true liefern. Deine Methode liefert: "
            + teilbar(42, 7));
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 42 und 4 sollte false liefern. Deine Methode liefert: "
            + teilbar(42, 4));
    System.out.println(
        "Der Aufruf deiner Methode mit den Parametern 11 und 3 sollte false liefern. Deine Methode liefert: "
            + teilbar(11, 3));
  }
}
