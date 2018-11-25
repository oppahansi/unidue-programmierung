/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_2;

class Kiste extends Ware implements Verpackung, Zubehoer {
  Ware Haupt;

  Kiste(Ware Haupt) {
    super("Kiste", 400);
    this.Haupt = Haupt;
    System.out.println("Kiste, " + Haupt.Art);
  }

  public int Kosten(int Dauer) {
    return 40 * Dauer;
  }

  public Ware Hauptware() {
    return Haupt;
  }

  int Rabatt() {
    return 10;
  }

  int Preis() {
    return 10 + Kosten(5);
  }
}
