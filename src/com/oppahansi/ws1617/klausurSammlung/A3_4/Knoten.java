/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_4;

public class Knoten {
  int zahl;
  Knoten links, rechts;

  Knoten(int zahl) {
    this.zahl = zahl;
    links = rechts = null;
  }
}
