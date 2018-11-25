/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loopsstrings;

public class CheckPalindrom {

  /* Die Main Methode zum Testen deiner Methoden */
  public static void main(String[] args) {
    CheckPalindrom check = new CheckPalindrom();
    System.out.println("Die Ausgabe sollte cba lauten: " + check.reverse("abc"));
    System.out.println("Die Ausgabe sollte ffeed lauten: " + check.reverse("deeff"));
    System.out.println("Die Ausgabe sollte true lauten: " + check.palindrom("Lagerregal"));
    System.out.println("Die Ausgabe sollte true lauten: " + check.palindrom("Rentner"));
    System.out.println("Die Ausgabe sollte false lauten: " + check.palindrom("Hallo Welt!"));
  }

  /*
   * Diese Methode soll den als Parameter uebergebenen String umdrehen. Der erste Buchstabe steht
   * dann an letzter Stelle, der zweite davor und so weiter. Der letzte Buchstabe steht dann am
   * Anfang. Beispiel: reverse("abc")-->"cba" reverse("deeff")-->"ffeed" Tipp: mit der Methode
   * String.charAt(int index) kann man den Buchstaben an der Stelle index herausfinden Tipp 2: Man
   * kann mit der Methode String.toCharArray() einen String in ein char Array umwandeln.
   */
  public String reverse(String toReverse) {
    String result = "";

    for (int i = 0; i < toReverse.length(); i++) {
      result += toReverse.charAt(toReverse.length() - 1 - i);
    }

    return result;
  }

  /*
   * Diese Methode soll genau dann true zur�ckgeben, wenn der uebergebene String ein Palindrom ist.
   * Ein Wort ist genau dann ein Palindrom, wenn gilt, dass das Wort in beide Richtungen gelesen
   * identisch ist. Beispiele daf�r: Lagerregal, Reliefpfeiler, Rentner Gross- und Kleinschreibung
   * wird dabei nicht beachtet. Die Methode soll also beim Aufruf zurueckgeben:
   * palindrom("Lagerregal") --> true palindrom("Rentner") --> true palindrom("Hallo Welt!")-->
   * false
   */
  public boolean palindrom(String palindrom) {
    return palindrom.toLowerCase().contains(reverse(palindrom.toLowerCase()));
  }
}
