/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class PKW extends Kraftwagen {

  int Gewicht;

  PKW(String Bezeichnung, String Kenzeichen, int Gewicht) {
    super(Bezeichnung, Kenzeichen);
    this.Gewicht = Gewicht;
  }
}
