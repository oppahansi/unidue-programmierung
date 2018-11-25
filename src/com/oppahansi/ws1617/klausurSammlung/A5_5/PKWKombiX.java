/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_5;

public class PKWKombiX extends Fahrzeug {

  PKWKombiX() {
    this.Typ = "PKW-Kombi Fabrikat X";
    this.Hoechstgeschwindigkeit = 172;
  }

  double Bezinverbrauchsfunktion(int geschwindigkeit) {
    return 6 + (Math.pow(geschwindigkeit - 91, 2)) / 1920 + 0.024 * geschwindigkeit;
  }
}
