package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Addieren {

  /*
   * Berechnungsmethode f�r die Summe der Zahlen von
   * 1 bis n. Aufgabe 3a
   */

  public static void main(String args[]) {

    Addieren a = new Addieren();

    int ergebnis1 = a.addieren(1);
    int ergebnis3 = a.addieren(3);
    int ergebnis6 = a.addieren(6);
    int ergebnis100 = a.addieren(100);

    System.out.println("addieren(1)   hat " + ergebnis1 + " berechnet, richtig ist 1");
    System.out.println("addieren(3)   hat " + ergebnis3 + " berechnet, richtig ist 6");
    System.out.println("addieren(6)   hat " + ergebnis6 + " berechnet, richtig ist 21");
    System.out.println("addieren(100) hat " + ergebnis100 + " berechnet, richtig ist 5050");
  }

  public int addieren(int n) {
    int ergebnis = 0;
    // ergaenzen Sie bitte hier Ihren Quellcode
    // und speicher das Ergbnis in der Variablen ergebnis

    return ergebnis;
  }
}
