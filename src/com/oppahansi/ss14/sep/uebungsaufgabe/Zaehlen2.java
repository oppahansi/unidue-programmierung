package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Zaehlen2 {

  /*
   * Zaehlmethode f�r alle Zeichen in String s, Aufgabe 3d
   */

  public static void main(String args[]) {

    Zaehlen2 a = new Zaehlen2();
    System.out.println("Erwartete Ausgabe:");
    System.out.println(
        "Der String \"Das Leben ist schoen!\" enthaelt die folgenden Zeichen:\n\'D\': 1 \'a\': 1 \'s\': 3 \' \': 3 \'L\': 1 \'e\': 3 \'b\': 1 \'n\': 2 \'i\': 1 \'t\': 1 \'c\': 1 \'h\': 1 \'o\': 1 \'!\': 1\nDer String \"Programmierung\" enthaelt die folgenden Zeichen:\n\'P\': 1 \'r\': 3 \'o\': 1 \'g\': 2 \'a\': 1 \'m\': 2 \'i\': 1 \'e\': 1 \'u\': 1 \'n\': 1");

    System.out.println();
    System.out.println("Ihre Ausgabe:");
    a.zaehleZeichen("Das Leben ist schoen!");
    System.out.println();
    a.zaehleZeichen("Programmierung");
  }

  public void zaehleZeichen(String s) {
    // erg�nzen Sie bitte hier Ihren Quellcode

  }
}
