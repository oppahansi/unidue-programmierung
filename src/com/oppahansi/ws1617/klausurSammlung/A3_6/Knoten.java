/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_6;

public class Knoten {
  String Bez;
  Knoten links, rechts;

  Knoten(String Bez) {
    this.Bez = Bez;
    links = rechts = null;
  }

  // AUFGABE 3.6 a
  boolean TB(Knoten k1, Knoten k2) {
    boolean aus = false;
    if (k1 == null || k2 == null) {
      return false;
    } else {
      if (k1.links != null) {
        if (k1.links.equals(k2)) {
          return true;
        } else {
          if (TB(k1.links, k2)) {
            return true;
          }
        }
      }
      if (k1.rechts != null) {
        if (k1.rechts.equals(k2)) {
          return true;
        } else {
          if (TB(k1.rechts, k2)) {
            return true;
          }
        }
      }
    }
    return aus;
  }

  //nicht vollstaendig

}
