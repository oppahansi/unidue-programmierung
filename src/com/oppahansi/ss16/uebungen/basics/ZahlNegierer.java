package com.oppahansi.ss16.uebungen.basics;

public class ZahlNegierer {

  /*
   * Diese Methode soll die uebergebene Zahl negieren. Das bedeutet, das Vorzeichen der Zahl soll
   * geaendert werden. Ist zahl positiv (also groesser 0), soll diese Zahl negativ zurueckgegeben
   * werden. Ist zahl negativ (also kleiner 0), soll diese Zahl positiv zurueckgegeben werden. Ist
   * zahl 0, soll 0 zurueckgegeben werden (Denn +0==-0). Am Ende soll der Rueckgabewert also die
   * gleiche Zahl sein, nur mit dem anderen Vorzeichen, aus + wird - und aus - wird +.
   */
  public static int negiere(int zahl) {
    return zahl * -1; // return -zahl;  auch korrekt
  }

  //Hier kannst du deine Methode testen. Du kannst dir auch eigene Testfaelle ausdenken
  public static void main(String[] args) {
    System.out.println(negiere(42));
    System.out.println(negiere(-27));
    System.out.println(negiere(28));
    System.out.println(negiere(-32));
    System.out.println(negiere(54));
    System.out.println(negiere(0));
  }
}
