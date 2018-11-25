/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_8;

abstract class Bereitschaft extends Zeit {

  boolean Pausen;

  Bereitschaft(int b, int e) {
    super(b, e);
    Pausen = false;
  }

  //AUFGABE 5.8 e
  float Bezahlung() {
    if (Pausen) {
      return 20.0f * Dauer();
    } else {
      return 20.0f * Dauer() + 20.0f * Dauer() / 10;
    }
  }
}
