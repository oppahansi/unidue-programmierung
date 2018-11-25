/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_8;

class RufBereitschaft extends Bereitschaft {

  int Rufnummer;

  //AUFGABE 5.8 c
  RufBereitschaft(int r, int b, int e) {
    super(b, e);
    Rufnummer = r;
    Pausen = true;
  }

  float Bezahlung() {
    return super.Bezahlung() / 2;
  }
}
