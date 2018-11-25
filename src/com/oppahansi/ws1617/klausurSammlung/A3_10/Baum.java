/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_10;

public class Baum {
  Knoten wurzel;
  // AUFGABE 3.10 d
  int minBlattabstand() {
    return minBlattabstand(wurzel);
  }

  int minBlattabstand(Knoten k) {
    if (k != null) {
      if (istBlatt(k.links) || istBlatt(k.rechts)) {
        return 1;
      } else if (k.links != null && k.rechts != null) {
        return 1 + Integer.min(minBlattabstand(k.links), minBlattabstand(k.rechts));
      } else if (k.links != null) {
        return 1 + minBlattabstand(k.links);
      } else if (k.rechts != null) {
        return 1 + minBlattabstand(k.rechts);
      }
    }
    return 0;
  }

  // AUFGABE 3.10 e
  int maxBlattabstand(Knoten k) {
    if (k != null) {
      if (istBlatt(k.links) || istBlatt(k.rechts)) {
        return 1;
      } else if (k.links != null && k.rechts != null) {
        return 1 + Integer.max(maxBlattabstand(k.links), maxBlattabstand(k.rechts));
      } else if (k.links != null) {
        return 1 + maxBlattabstand(k.links);
      } else if (k.rechts != null) {
        return 1 + maxBlattabstand(k.rechts);
      }
    }
    return 0;
  }

  boolean istBlatt(Knoten k) {
    if (k != null) {
      if (k.links == null && k.rechts == null) {
        return true;
      }
    }
    return false;
  }

  // AUFGABE 3.10 g
  int blattAnzahl(Knoten k) {
    if (k != null) {
      if (istBlatt(k)) {
        return 1;
      } else {
        return blattAnzahl(k.links) + blattAnzahl(k.rechts);
      }
    }
    return 0;
  }
}
