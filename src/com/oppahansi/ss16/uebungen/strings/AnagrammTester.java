/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.strings;

public class AnagrammTester {

  /*
   * Diese Methode soll zurueckgeben, ob die beiden Strings s1 und s2 Anagramme sind. Zwei Woerter
   * sind genau dann Anagramme, wenn man ein Wort durch Vertauschen der Buchstaben aus dem anderen
   * Wort erzeugen kann. Dazu muessen beide Worter die gleichen Buchstaben in der gleichen Anzahl
   * enthalten. Auf Gross und Kleinschreibung wird dabei nicht geachtet. Mit
   * String.toLowerCase(String) kann man sich einen String zurueckgeben lassen, der die gleichen
   * Zeichen wie der uebergebene String enthaelt, aber nur in Kleinschreibung. Beispiele fuer
   * Anagramme sind: mehl und helm ampel und lampe naja milchsocke und michael jackson
   */
  public static boolean anagramm(String s1, String s2) {
    return false;
  }

  /* In der Main Methode kannst du deine Methode testen. */
  public static void main(String[] args) {
    System.out.println(anagramm("helm", "mehl")); //Sollte true ausgeben
    System.out.println(anagramm("ampel", "lampe")); //Sollte true ausgeben
    System.out.println(anagramm("naja milchsocke", "michael jackson")); //Sollte true ausgeben
    System.out.println(anagramm("hallo welt", "ampel")); //Sollte false ausgeben
  }
}
