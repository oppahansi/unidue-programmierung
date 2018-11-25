/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_6;

class Mond extends Himmelskoerper {
  String Sicht = "Scheibe";
  Planet zentral;

  Mond(String n, Planet p) {
    super(n);
    zentral = p;
    System.out.println("Mond: " + Sicht);
  }

  String sichtbar(boolean Tag) {
    if (super.Sicht.equals("Scheibe")) return "sehr gut";
    else return "schwierig";
  }
}
