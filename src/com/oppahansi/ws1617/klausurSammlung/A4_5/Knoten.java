/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_5;

public class Knoten {
  String bez;
  int index;
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
