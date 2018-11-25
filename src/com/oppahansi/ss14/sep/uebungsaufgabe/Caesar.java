package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Caesar {

  /*
   * Caesarchiffre, Aufgabe 3e
   */

  public static void main(String args[]) {

    Caesar c = new Caesar();

    System.out.println(
        "Casesar-Chiffre von 'haus' mit 1 ist " + c.chiffre("haus", 1) + " richtig ist: ibvt");
    System.out.println(
        "Casesar-Chiffre von 'bauzaun' mit 8 ist "
            + c.chiffre("bauzaun", 8)
            + " richtig ist: jichicv");
    System.out.println(
        "Casesar-Chiffre von 'hundert' mit 10 ist "
            + c.chiffre("hundert", 10)
            + " richtig ist: rexnobd");
    System.out.println(
        "Casesar-Chiffre von 'rexnobd' mit 16 ist "
            + c.chiffre("rexnobd", 16)
            + " richtig ist: hundert");
  }

  public String chiffre(String s, int v) {

    String ergebnis = "";

    // erg�nzen Sie bitte hier Ihren Quellcode
    // und speichern sie das Ergebnis in der Variablen ergebnis

    return ergebnis;
  }
}
