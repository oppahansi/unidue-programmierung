/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_7;

public class Baum {
  Knoten wurzel;
  //AUFGABE 3.7 a
  Knoten frei() {
    return frei(wurzel);
  }

  Knoten frei(Knoten k) {
    if (k != null) {
      if (k.links == null || k.rechts == null) {
        return k;
      } else {
        if (frei(k.links).Tiefe <= frei(k.rechts).Tiefe) {
          return frei(k.links);
        } else {
          return frei(k.rechts);
        }
      }
    }
    return k;
  }
  //AUFGABE 3.7.c
  void fuegeEin(int zahl) {
    fuegeEin(wurzel, zahl);
    tiefeSetzen(wurzel);
  }

  Knoten fuegeEin(Knoten k, int z) {
    if (k == null) {
      return new Knoten(z, 0);
    } else {
      if (z >= 0) {
        if (k.zahl > z) {
          k.links = fuegeEin(k.links, z);
        } else if (k.zahl < z) {
          k.rechts = fuegeEin(k.rechts, z);
        }
      } else {
        Knoten frei = frei(k);
        if (frei.links == null) {
          frei.links = new Knoten(z, 0);
        } else {
          frei.rechts = new Knoten(z, 0);
        }
      }
    }
    return k;
  }

  void tiefeSetzen(Knoten k) {
    if (k != null) {
      if (k.links != null && k.links.Tiefe <= k.Tiefe) {
        k.links.Tiefe = k.Tiefe + 1;
      }
      if (k.rechts != null && k.rechts.Tiefe <= k.Tiefe) {
        k.rechts.Tiefe = k.Tiefe + 1;
      }
      tiefeSetzen(k.links);
      tiefeSetzen(k.rechts);
    }
  }
}
