/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class LKW extends Kraftwagen {

  int Ladekapazitaet;

  LKW(String Bezeichnung, String Kenzeichen, int Ladekapazitaet) {
    super(Bezeichnung, Kenzeichen);
    this.Ladekapazitaet = Ladekapazitaet;
  }

  public void ausgabe() {
    System.out.println(Bezeichnung + " " + Kenzeichen + " " + Ladekapazitaet);
  }
}
