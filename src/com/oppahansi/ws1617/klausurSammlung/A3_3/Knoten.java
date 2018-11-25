/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_3;

public class Knoten {
  int zahl;
  Knoten links, rechts;

  public Knoten(int zahl) {
    this.zahl = zahl;
    links = rechts = null;
  }
}
