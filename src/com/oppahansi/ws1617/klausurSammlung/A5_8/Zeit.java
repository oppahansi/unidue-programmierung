/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_8;

abstract class Zeit {
  int Beginn, Ende;

  Zeit(int b, int e) {
    Beginn = b;
    Ende = e;
  }

  int Dauer() {
    return Ende - Beginn;
  }

  float Bezahlung() {
    return 20.0f * Dauer();
  }
}
