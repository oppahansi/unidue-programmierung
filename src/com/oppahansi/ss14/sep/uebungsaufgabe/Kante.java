package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Kante {

  Kante Nf;
  Knoten Ziel;
  int gewicht;

  Kante(Knoten Zielknoten, int Gewicht, Kante Nachfolger) {
    Ziel = Zielknoten;
    Nf = Nachfolger;
    gewicht = Gewicht;
  }

  Kante(Knoten Zielknoten, Kante Nachfolger) {
    Ziel = Zielknoten;
    Nf = Nachfolger;
  }
}
