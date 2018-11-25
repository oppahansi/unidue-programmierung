/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_2;

public class Baum {
  Knoten Wurzel;

  int h() {
    return h(Wurzel);
  }

  int h(Knoten k) {
    if (k == null) {
      return 0;
    } else {
      return 1 + Integer.max(h(k.rechts), h(k.links));
    }
  }

  int e() {
    return e(Wurzel);
  }

  int e(Knoten k) {
    if (k == null) {
      System.out.println("Leeres Baum ");
      return 0;
    } else if (k.rechts == null && k.links != null) {
      System.out.println(k.Zahl + " " + "Knoten mit genau einem Nachfolger");
      return 1 + e(k.links);
    } else if (k.rechts != null && k.links == null) {
      System.out.println(k.Zahl + " " + "Knoten mit genau einem Nachfolger");
      return 1 + e(k.rechts);
    } else if (k.rechts != null && k.links != null) {
      System.out.println(k.Zahl + " " + "Knoten mit genau zwei Nachfolger");
      return e(k.links) + e(k.rechts);
    } else {
      System.out.println(k.Zahl + " " + " Knoten mit keinem Nachfolger");
      return 0;
    }
  }

  void v() {
    int hoehe = h(Wurzel);
    v(hoehe, Wurzel);
  }

  void v(int hoehe, Knoten k) {
    if (hoehe > 1) {
      if (k.links == null) {
        k.links = new Knoten(1);
      }
      if (k.rechts == null) {
        k.rechts = new Knoten(1);
      }
      v(hoehe - 1, k.links);
      v(hoehe - 1, k.rechts);
    }
  }
}
