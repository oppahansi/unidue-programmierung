/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_2;

class Birne extends Ware implements Zubehoer {

  Ware Haupt;
  int Leistung;

  Birne(int P, Ware H) {
    super("Birne", 2 * P);
    Leistung = P;
    Haupt = H;
    System.out.println("Birne " + P + " Watt, " + H.Art);
  }

  int Rabatt() {
    return 0;
  }

  public Ware Hauptware() {
    return Haupt;
  }
}
