package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Suchen {

  /*
   * suchmethode f�r die Suche von String s2 in String s1, Aufgabe 3c
   */

  public static void main(String args[]) {

    Suchen a = new Suchen();

    boolean s1 = a.suche("Das Leben ist schoen", "ist");
    boolean s2 = a.suche("Das Leben ist schoen", "Leben");
    boolean s3 = a.suche("Das Leben ist schoen", "leben");

    System.out.println("Der String lautet: Das Leben ist schoen");
    System.out.println("Suche: ist    Ergebnis:" + s1 + " richtig ist true");
    System.out.println("Suche: Leben  Ergebnis:" + s2 + " richtig ist true");
    System.out.println("Suche: leben  Ergebnis:" + s3 + " richtig ist false");
  }

  public boolean suche(String s1, String s2) {
    boolean ergebnis = false;
    // erg�nzen Sie bitte hier Ihren Quellcode
    // und speicher das Ergbnis in der Variablen ergebnis

    return ergebnis;
  }
}
