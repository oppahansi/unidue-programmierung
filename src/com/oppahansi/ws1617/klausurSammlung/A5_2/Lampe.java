/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_2;

class Lampe extends Ware {
  Ware Verpackung;
  Ware[] Birnen = new Ware[2];

  Lampe() {
    super("Lampe", 8000);
    Verpackung = new Kiste(this);
    for (int i = 0; i < 2; i++) Birnen[i] = new Birne(100 + 50 * i, this);
  }

  int Rabatt() {
    return 20;
  }
}
