/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_7;

public class Knoten {
  int zahl, Tiefe;
  Knoten links, rechts;

  Knoten(int z, int t) {
    zahl = z;
    Tiefe = t;
    links = rechts = null;
  }
}
