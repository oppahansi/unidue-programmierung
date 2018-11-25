/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class Transportmittel implements Fahrzeug {

  String Bezeichnung;

  Transportmittel(String Bezeichnung) {
    this.Bezeichnung = Bezeichnung;
  }

  public void ausgabe() {
    System.out.println(Bezeichnung);
  }
}
