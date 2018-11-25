/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_8;

public class Baum {
  Knoten wurzel;

  //AUFGABE 3.8 a
  boolean zwei() {
    return zwei(wurzel);
  }

  boolean zwei(Knoten k) {
    if (k != null) {
      if (istBlatt(k.links) && istBlatt(k.rechts)) {
        return true;
      } else {
        if (zwei(k.links)) {
          return true;
        }
        if (zwei(k.rechts)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean istBlatt(Knoten k) {
    if (k != null && k.links == null && k.rechts == null) {
      return true;
    }
    return false;
  }

  // AUFGABE 3.8 b

  int differenz() {
    if (wurzel == null) {
      return 0;
    } else {
      return max(wurzel) - min(wurzel);
    }
  }

  int max(Knoten k) {
    if (k == null) {
      return 0;
    } else return 1 + Integer.max(max(k.links), max(k.rechts));
  }

  int min(Knoten k) {
    if (k == null) {
      return 0;
    } else return 1 + Integer.min(min(k.links), min(k.rechts));
  }
}
