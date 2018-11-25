/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_2;

public abstract class Ware {

  String Art;
  int Preis;

  Ware(String Art, int Preis) {
    this.Art = Art;
    this.Preis = Preis;
    System.out.println("Ware " + Art + " " + Preis + " Cent");
  }

  int Preis() {
    return Preis * (100 - Rabatt()) / 100;
  }

  abstract int Rabatt();
}
