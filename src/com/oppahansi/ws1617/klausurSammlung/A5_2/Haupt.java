/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_2;

public class Haupt {
  public static void main(String[] leer) {
    Lampe Verkauf = new Lampe();

    System.out.println("A " + Verkauf.Birnen[1].Preis());
    System.out.println("B " + Verkauf.Verpackung.Preis());
    System.out.println("C " + ((Birne) (Verkauf.Birnen[1])).Hauptware().Preis());
  }
}
