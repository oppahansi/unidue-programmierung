package com.oppahansi.ss16.uebungen.basics;

public class Taschenrechner {

  public static void main(String[] args) {
    int add = rechne(1, 2, "+");
    int sub = rechne(3, 2, "-");
    int multi = rechne(5, 5, "*");
    int div = rechne(20, 4, "/");

    System.out.println("1 + 2 = " + add + "  -  Erwartet: 3");
    System.out.println("3 - 2 = " + sub + "  -  Erwartet: 1");
    System.out.println("5 * 5 = " + multi + "  -  Erwartet: 25");
    System.out.println("20 / 4 = " + div + "  -  Erwartet: 5");
  }

  /*
   * Diese Methode soll a und b nach dem arithmetischen Symbol zeichen berechnen. rechne(3, 5, "+")
   * --> 8 rechne(10,5, "-") --> 5 Als a und b werden dabei beliebige int Werte uebergeben, zeichen
   * ist eins der folgenden Zeichen: +,-,*,/ Die Methode soll also bei zeichen = "+" a und b
   * addieren, bei zeichen = "-" b von a subtrahieren, bei "*" a und b multiplizieren, und bei "/" a
   * durch b dividieren.
   */
  public static int rechne(int a, int b, String zeichen) {
    if (zeichen
        == "+") { // Strings mit == zu vergleichen ist schlecht und sollte später nicht mehr benutzt werden.
      return a + b; // Für den aktuellen Stand des Stoffes reicht es aber aus. - Oppahansi
    } else if (zeichen == "-") {
      return a - b;
    } else if (zeichen == "*") {
      return a * b;
    } else {
      return a / b;
    }
  }
}
