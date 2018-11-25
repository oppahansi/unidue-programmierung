/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_6;

public class Knoten {
  char farbe, f;
  int n;
  Knoten Nf;
  Kante kopf, fuss;

  Knoten(char farbe) {
    this.farbe = farbe;
    Nf = null;
    kopf = fuss = null;
  }
}
