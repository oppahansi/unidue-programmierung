/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

class Knoten {

  String bez;
  Knoten nf;
  Kante kopf, fuss;
  boolean marker;

  //konstruktor
  Knoten(String bez) {
    this.bez = bez;
    nf = null;
    kopf = fuss = null;
  }

  public void fuegeEin(Kante k) {
    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss = fuss.nf = k;
    }
  }

  public void gibAus() {
    System.out.print(bez + " -> ");
    //Kante wird gespeichert (referenz)
    Kante tmp = kopf;
    //Kanten werden Durchlaufen
    while (tmp != null) {
      System.out.print(tmp.ziel.bez + "(" + tmp.bez + ")");
      if (tmp.nf != null) {
        System.out.print(", ");
      }
      tmp = tmp.nf;
    }
    System.out.println();
  }
}
