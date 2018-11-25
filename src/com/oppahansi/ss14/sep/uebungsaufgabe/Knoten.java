package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Knoten {

  Knoten Nf;
  Kante kanten = null;
  int summe = 0;
  int Nr;

  Knoten(int Nummer, Knoten Nachfolger) {
    Nr = Nummer;
    Nf = Nachfolger;
  }
}
