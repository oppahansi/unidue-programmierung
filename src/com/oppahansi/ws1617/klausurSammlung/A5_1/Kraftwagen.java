/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class Kraftwagen extends Transportmittel {

  String Kenzeichen;

  Kraftwagen(String Bezeichnung, String Kenzeichen) {
    super(Bezeichnung);
    this.Kenzeichen = Kenzeichen;
  }

  public void ausgabe() {
    System.out.println(Bezeichnung + " " + Kenzeichen);
  }
}
