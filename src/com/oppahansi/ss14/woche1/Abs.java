package com.oppahansi.ss14.woche1;

// Betragsfunktion
//
// Implementieren Sie die Betragsfunktion in der Methode "abs". Das Ergebnis der Betragsfunktion |x| ist x, wenn x >= 0 bzw. -x, wenn x < 0.
public class Abs {

  public static int abs(int value) {
    return (value < 0) ? -value : value;
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println(abs(24));
    System.out.println(abs(-12));
  }
}
