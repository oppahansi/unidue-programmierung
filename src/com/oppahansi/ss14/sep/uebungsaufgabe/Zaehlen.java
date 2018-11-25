package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Zaehlen {

  /*
   * Zaehlmethode f�r die Anzahl von Zeichen z in String s, Aufgabe 3b
   */

  public static void main(String args[]) {

    Zaehlen a = new Zaehlen();

    int ergebnis1 = a.zaehlen("Das Leben ist schoen", 'e');
    int ergebnis2 = a.zaehlen("Das Leben ist schoen", 'l');
    int ergebnis3 = a.zaehlen("Das Leben ist schoen", 'u');

    System.out.println("Der String lautet: Das Leben ist schoen");
    System.out.println("Ergebnis der Methode zaehlen fuer e ist " + ergebnis1 + ", richtig ist 3");
    System.out.println("Ergebnis der Methode zaehlen fuer l ist " + ergebnis2 + ", richtig ist 0");
    System.out.println("Ergebnis der Methode zaehlen fuer u ist " + ergebnis3 + ", richtig ist 0");
  }

  public int zaehlen(String s, char z) {
    int ergebnis = 0;
    // erg�nzen Sie bitte hier Ihren Quellcode
    // und speicher das Ergbnis in der Variablen ergebnis

    return ergebnis;
  }
}
