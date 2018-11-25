/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_4;

public class Kante {
  String bez;
  Kante Nf;
  Knoten kante;

  Kante(String bez) {
    this.bez = bez;
    Nf = null;
    kante = null;
  }
}
