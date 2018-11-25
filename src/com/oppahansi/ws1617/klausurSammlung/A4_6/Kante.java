/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_6;

public class Kante {
  char farbe;
  Kante Nf;
  Knoten kante;

  Kante(char farbe) {
    this.farbe = farbe;
    Nf = null;
    kante = null;
  }
}
