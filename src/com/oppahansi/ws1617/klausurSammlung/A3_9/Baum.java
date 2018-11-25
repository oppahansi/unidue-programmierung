/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_9;

public class Baum {
  Knoten wurzel;

  // AUFGABE 3.9 a
  Knoten maxi() {
    return maxi(wurzel);
  }

  Knoten maxi(Knoten k) {
    Knoten aus = k;
    if (k != null) {
      if (k.links != null) {
        if (aus.zahl < maxi(k.links).zahl) {
          aus = maxi(k.links);
        }
      }
      if (k.rechts != null) {
        if (aus.zahl < maxi(k.rechts).zahl) {
          aus = maxi(k.rechts);
        }
      }
    }
    return aus;
  }

  //AUFGABE 3.9 b
  Knoten mini(Knoten k) {
    Knoten aus = k;
    if (k != null) {
      if (k.links != null) {
        if (aus.zahl > mini(k.links).zahl) {
          aus = mini(k.links);
        }
      }
      if (k.rechts != null) {
        if (aus.zahl > mini(k.rechts).zahl) {
          aus = mini(k.rechts);
        }
      }
    }
    return aus;
  }
}
