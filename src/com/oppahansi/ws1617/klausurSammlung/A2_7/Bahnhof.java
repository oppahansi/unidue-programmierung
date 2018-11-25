/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_7;

public class Bahnhof {
  String name;
  Strecke nS;
  int ankunft, dauer, abfahrt;
  //AUFGABE 2.7 a
  Bahnhof(String name, int ankunft, int dauer) {
    this.name = name;
    this.ankunft = ankunft;
    this.dauer = dauer;
    abfahrt = ankunft + dauer;
    nS = null;
  }

  //AUFGABE 2.7 b
  Bahnhof(Fahrt f, int entfernung, String name, int dauer) {
    if (f.start != null) {
      if (f.ziel == null) {
        f.ziel = new Bahnhof(name, f.start.abfahrt + entfernung / 2, dauer);
        f.start.nS = new Strecke(f.ziel, entfernung);
      } else {
        Bahnhof neu = new Bahnhof(name, f.ziel.abfahrt + entfernung / 2, dauer);
        f.ziel.nS = new Strecke(neu, entfernung);
        f.ziel = neu;
      }
    }
  }

  //AUFGABE 2.7 c
  // �berladen. Weil die Datentypen der �bergabeparametern unterschiedlich sind.

}
