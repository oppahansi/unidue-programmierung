/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_6;

class Himmelskoerper {
  String Name, Sicht;

  Himmelskoerper(String Name) {
    this.Name = Name;
    Sicht = "unbekannt";
    System.out.println("Himmelsk�rper: " + Name);
  }

  String sichtbar(boolean Tag) {
    if (Tag) return "unsichtbar";
    else return Sicht;
  }
}
