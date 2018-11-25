/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_6;

class Planet extends Himmelskoerper {
  String Sicht = "Punkt";
  Mond[] Monde;

  Planet(String n, int a, Mond m) {
    super(n);
    Monde = new Mond[a];
    Monde[0] = m;
    System.out.println("Planet: " + Sicht);
  }

  String sichtbar(boolean Tag) {
    if (Tag) return Sicht + " (schwach)";
    else return "sichtbar";
  }
}
