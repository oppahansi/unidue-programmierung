/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt5_A2;

class Knoten {

  char bez; // Bezeichnung des Knotens.
  Knoten nf; // Nachfolger-Knoten.
  Kante kopf, fuss; // Vom Knoten ausgehende Kanten.

  Knoten(char bez) {
    this.bez = bez;
    nf = null;
    kopf = fuss = null;
  }

  public void fuegeEin(Kante k) {

    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss.nf = k;
      fuss = k;
    }
  }
}
