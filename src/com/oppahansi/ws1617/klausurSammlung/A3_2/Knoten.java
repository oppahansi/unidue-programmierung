/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_2;

public class Knoten {
  int Zahl;
  Knoten links, rechts;

  Knoten(int Zahl) {
    this.Zahl = Zahl;
    links = rechts = null;
  }
}
