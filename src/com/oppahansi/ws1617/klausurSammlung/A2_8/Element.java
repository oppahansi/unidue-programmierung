/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_8;

public class Element {
  Element Nf;
  String Bez;
  float ePreis;
  float gPreis;
  Element Zubehoer;

  //AUFGABE 2.8 a
  Element(String Bez, float ePreis, Produkte Liste) {
    this.Bez = Bez;
    this.ePreis = ePreis;
    this.gPreis = 0;
    this.Zubehoer = null;
    this.Nf = null;
    if (Liste.kopf == null) {
      Liste.kopf = Liste.fuss = this;
    } else {
      Liste.fuss.Nf = this;
      Liste.fuss = this;
    }
  }

  //AUFGABE 2.8 b
  // Mit == kann gepr�ft werden, ob es um gleiche String Obiekte handelt. Mit "equals" kann gepr�ft werden ob die String Objekte
  // gleiche Inhalte haben.
}
