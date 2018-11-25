/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_2;

public class Knoten {
  String bez;
  Knoten Nf;
  Kante kopf, fuss;
  int Anz;

  Knoten(String bez) {
    this.bez = bez;
    Nf = null;
    kopf = fuss = null;
    Anz = 0;
  }
}
