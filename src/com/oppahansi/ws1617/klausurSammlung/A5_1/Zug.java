/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class Zug extends Transportmittel {

  int WagonAnzahl;

  Zug(String Bezeichnung, int WagonAnzahl) {
    super(Bezeichnung);
    this.WagonAnzahl = WagonAnzahl;
  }

  public void ausgabe() {
    System.out.println(Bezeichnung + " " + WagonAnzahl);
  }
}
