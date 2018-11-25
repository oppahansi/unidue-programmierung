package com.oppahansi.ss14.sep.uebungsaufgabe;

class Eratosthenes {

  public static void main(String args[]) {

    Eratosthenes s = new Eratosthenes();

    System.out.println();
    System.out.println("Sieb der ersten 50 Zahlen");
    System.out.println("Erwartetes Ergebnis:");
    System.out.println("1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47");
    System.out.println("Ihre Loesung:");
    s.sieb(50);

    System.out.println();
    System.out.println();
    System.out.println("Sieb der ersten 100 Zahlen");
    System.out.println("Erwartetes Ergebnis:");
    System.out.println("1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97");
    System.out.println("Ihre Loesung:");
    s.sieb(100);
  }

  public void sieb(int max) {

    // erg�nzen Sie bitte hier Ihren Quellcode

  }
}
