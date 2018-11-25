/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_6;

public class Haupt {
  public static void main(String[] unbenutzt) {

    Himmelskoerper[] Stern = new Himmelskoerper[2];
    Mond m;
    Stern[0] = m = new Mond("Titan", null);
    Stern[1] = new Planet("Saturn", 7, m);
    System.out.println(((Planet) Stern[1]).Monde[0].Sicht);
    System.out.println(m.sichtbar(true));
    System.out.println(Stern[1].Sicht);
    System.out.println(Stern[1].sichtbar(true));
  }
}
