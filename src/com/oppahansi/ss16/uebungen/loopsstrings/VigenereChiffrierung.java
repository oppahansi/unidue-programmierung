/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loopsstrings;

public class VigenereChiffrierung {

  /*
   * Diese Methode soll den String was mit dem String womit verschluesseln. Bei der Vigenere
   * Chiffrierung wird wie bei der CaesarChiffrierung auch jedem Buchstaben ein Wert zugeordnet.
   * A=1, B=2, ... , Z=26 a=1, b=2, ... , z=26 Gross- und Kleinschreibung spielt keine Rolle. Wird
   * ein Grossbuchstabe verschluesselt, ist das Ergebnis ein Grossbuchstabe, wird ein Kleinbuchstabe
   * verschluesselt, ist das Ergebnis ein Kleinbuchstabe. Der Buchstabe nach dem Z ist das A. Nun
   * wird auf jeden Buchstaben aus was der zugehoerige Buchstabe aus womit addiert, um den
   * verschluesselten Buchstaben zu erhalten. Dabei wird dem Buchstaben an Stelle i von was immer
   * dem Buchstaben an Stelle i%womit.length() zugeordnet. Sonderzeichen ewrden nicht
   * verschluesselt. Beispiel: verschluessel("abc", "a") --> "bcd" verschluessel("abc", "def") -->
   * "egi" verschluessel("abcdef", "fedcba") --> "gggggg"
   */
  public static String verschluessel(String was, String womit) {
    return null;
  }

  /*
   * Diese Methode soll den String was wieder mit dem String womit entschluesseln. Dazu muss analog
   * zur verschluesseln Methode wieder jeder Buchstabe aus womit vom zugehoerigen Buchstaben aus was
   * abgezogen werden. Wenn beide Methoden richtig funktionieren sollte gelten:
   * entschluessel(verschluessel(was, womit), womit).equals(was) == true
   */
  public static String entschluessel(String was, String womit) {
    return null;
  }

  /* Die Main Methode. Du kannst dir hier verschiedene Testfaelle ausdenken und testen. */
  public static void main(String[] args) {}
}
