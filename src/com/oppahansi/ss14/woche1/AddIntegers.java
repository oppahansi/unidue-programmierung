package com.oppahansi.ss14.woche1;

// Integer-Werte addieren
//
// Modifizieren Sie die Methode "add" so, dass sie die Variablen "a" und "b" addiert und das Ergebnis zur�ckgibt.

public class AddIntegers {

  // ----- Modifizieren Sie diese Methode -----
  public static int add(int a, int b) {

    return a + b;
  }
  // ------------------------------------------

  public static void main(String[] args) {
    // Testaufruf
    int x = 12;
    int y = 7;

    System.out.println(add(x, y));
  }
}
