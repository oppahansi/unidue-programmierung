/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_3;

public class Baum {
  public Knoten wurzel;

  int b() {
    return b(wurzel);
  }

  int b(Knoten k) {
    if (k != null) {
      if (istBlatt(k)) {
        return 1;
      } else {
        return b(k.links) + b(k.rechts);
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

  int[] z() {
    if (wurzel != null) {
      int[] array = new int[b(wurzel)];
      z(wurzel, array);
      return array;
    }
    return null;
  }

  void z(Knoten k, int[] array) {
    if (k != null) {
      if (k.links == null && k.rechts == null) {
        for (int i = 0; i < array.length; i++) {
          if (array[i] == 0) {
            array[i] = k.zahl;
            break;
          }
        }
      }
      z(k.links, array);
      z(k.rechts, array);
    }
  }

  boolean p(int x) {
    return p(wurzel, x);
  }

  boolean p(Knoten k, int x) {
    if (k != null) {
      if (x == k.zahl) {
        return true;
      } else if (x < k.zahl) {
        return p(k.links, x);
      } else if (x > k.zahl) {
        return p(k.rechts, x);
      }
    }
    return false;
  }
}
