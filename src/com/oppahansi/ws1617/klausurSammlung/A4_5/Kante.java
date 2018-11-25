/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_5;

public class Kante {
  int zahl;
  Kante Nf;
  Knoten kante;

  Kante(int zahl) {
    this.zahl = zahl;
    Nf = null;
    kante = null;
  }
}
