/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_4;

public class Baum {
  Knoten wurzel;

  boolean a() {
    return a(wurzel);
  }

  boolean a(Knoten k) {
    boolean aus = true;
    if (k != null) {
      if (k.links != null) {
        if (k.zahl <= k.links.zahl) {
          return false;
        } else {
          aus = a(k.links);
          if (!aus) {
            return false;
          }
        }
      }
      if (k.rechts != null) {
        if (k.zahl <= k.rechts.zahl) {
          return false;
        } else {
          aus = a(k.rechts);
          if (!aus) {
            return false;
          }
        }
      }
    }
    return aus;
  }

  void b() {
    b(wurzel);
  }

  void b(Knoten k) {
    if (k != null) {
      if (istBlatt(k.links)) {
        k.links = null;
      }
      if (istBlatt(k.rechts)) {
        k.rechts = null;
      }
      b(k.links);
      b(k.rechts);
    }
  }

  boolean istBlatt(Knoten k) {
    if (k != null) {
      if (k.links == null && k.rechts == null) {
        return true;
      }
    }
    return false;
  }
}
