/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_7;

public class Fahrt {
  Bahnhof start, ziel;

  //AUFGABE 2.7 d
  void EssenHamm() {
    Fahrt f = new Fahrt();
    f.start = new Bahnhof("Essen", 0, 4);
    new Bahnhof(f, 16, "Bochum", 2);
    new Bahnhof(f, 18, "Dortmund", 4);
    new Bahnhof(f, 30, "Hamm", 3);
    this.start = f.start;
    this.ziel = f.ziel;
  }

  //AUFGABE 2.7 e
  boolean verspaetet(int zusatzdaur) {
    double zulaessig = (ziel.ankunft - start.abfahrt) / 10;
    if ((double) zusatzdaur > zulaessig) {
      return true;
    } else {
      return false;
    }
  }

  //AUFGABE 2.7 f
  boolean zielnah(Bahnhof b) {
    int vor = 0;
    int nach = 0;
    Bahnhof s = start;

    while (s != null && !s.equals(b)) {
      vor += s.nS.entfernung;
      s = s.nS.nB;
    }
    Bahnhof s1 = b;
    while (s1 != null && !s1.equals(ziel)) {
      nach += s1.nS.entfernung;
      s1 = s1.nS.nB;
    }
    if (nach < vor) {
      return true;
    } else {
      return false;
    }
  }
}
