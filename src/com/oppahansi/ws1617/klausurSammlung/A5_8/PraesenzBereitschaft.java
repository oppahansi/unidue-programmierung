/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_8;

class PraesenzBereitschaft extends Bereitschaft {

  PraesenzBereitschaft(int b) {
    super(b, b + 8);
  }

  //AUFGABE 5.8 d
  int dauer() {
    return Ende - Beginn + 1;
  }
}
