/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_5;

public class Fahrzeug {

  //AUFGABE 5.5 a
  String Typ;
  int Hoechstgeschwindigkeit;

  double Bezinverbrauchsfunktion(int geschwindigkeit) {
    return 0;
  }

  int minBenzinverbrauch() {
    double benzinverbrauch = Bezinverbrauchsfunktion(1);
    int geschvindigkeit = 1;
    for (int i = 1; i <= Hoechstgeschwindigkeit; i++) {
      if (Bezinverbrauchsfunktion(i) <= benzinverbrauch) {
        benzinverbrauch = Bezinverbrauchsfunktion(i);
        geschvindigkeit = i;
      }
    }
    return geschvindigkeit;
  }
}
