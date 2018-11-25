/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt5_A3;

class Kante {

  int zahl; // Zahlen-Wert der Kante.
  Kante nf; // Nachfolger-Kante.
  Knoten kante; // Knoten, zu dem die Kante hinf�hrt.

  public Kante(int zahl, Knoten Kante) {
    this.zahl = zahl;
    nf = null;
    this.kante = Kante;
  }
}
