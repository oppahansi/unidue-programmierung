/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loopsstrings;

public class ZahlenZaehlen {

  /*
   * Diese Methode soll zaehlen, wie viele Zahlen der String string enthaelt. Dabei ist string ein
   * Satz, der verschiedene Woerter und eben auch Zahlen enthaelt. Eine Zahl ist hierbei ein
   * Teilstring, der vollstaendig aus Ziffern besteht und von Leerzeichen umgeben ist oder der
   * Beginn oder das Ende von string ist.
   */
  public static int zahlen(String string) {
    int result = 0;

    for (int i = 0; i < string.length(); i++) {
      if (Character.isDigit(string.charAt(i))) {
        result++;
      }
    }

    return result;
  }

  /*
   * Diese Methode soll den Durchschnitt aus allen Zahlen im String string zurueckgeben. Enthaelt
   * string keine Zahlen, soll 0 zurueckgegeben werden.
   */
  public static double durchschnitt(String string) {
    int result = 0;
    int numbersCounter = 0;

    for (int i = 0; i < string.length(); i++) {
      if (Character.isDigit(string.charAt(i))) {
        result += Integer.parseInt("" + string.charAt(i));
        numbersCounter++;
      }
    }

    return result / numbersCounter;
  }

  /* Die Main Methode. Du kannst dir hier verschiedene Testfaelle ausdenken und testen. */
  public static void main(String[] args) {

    System.out.println(zahlen("ab2c4defghi987dlsk0"));
    System.out.println(durchschnitt("ab2c4defghi987dlsk0"));
  }
}
