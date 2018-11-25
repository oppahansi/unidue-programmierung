package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Graph1 {

  Knoten knoten;

  public static void main(String args[]) {
    /* Graphen erstellen */
    Graph1 graph = new Graph1();
    graph.knoten =
        new Knoten(
            1, new Knoten(2, new Knoten(3, new Knoten(4, new Knoten(5, new Knoten(6, null))))));

    graph.knoten.kanten = new Kante(graph.knoten.Nf, null);
    graph.knoten.Nf.Nf.kanten =
        new Kante(graph.knoten, new Kante(graph.knoten.Nf, new Kante(graph.knoten.Nf.Nf.Nf, null)));
    graph.knoten.Nf.Nf.Nf.kanten = new Kante(graph.knoten, null);
    graph.knoten.Nf.Nf.Nf.Nf.kanten = new Kante(graph.knoten.Nf.Nf.Nf, null);

    /* vergleiche aufrufen */
    System.out.println(
        "vergleiche(1,2) hat " + graph.vergleiche(1, 2) + " zurueckegegeben, richtig ist true");
    System.out.println(
        "vergleiche(1,3) hat " + graph.vergleiche(1, 3) + " zurueckegegeben, richtig ist false");
    System.out.println(
        "vergleiche(5,2) hat " + graph.vergleiche(5, 2) + " zurueckegegeben, richtig ist false");
    System.out.println(
        "vergleiche(3,4) hat " + graph.vergleiche(3, 4) + " zurueckegegeben, richtig ist true");
    System.out.println(
        "vergleiche(2,4) hat " + graph.vergleiche(2, 4) + " zurueckegegeben, richtig ist false");
    System.out.println(
        "vergleiche(4,1) hat " + graph.vergleiche(4, 1) + " zurueckegegeben, richtig ist true");
  }

  boolean vergleiche(int eins, int zwei) {
    boolean ergebnis = false;
    // ergaenzen Sie bitte hier Ihren Quellcode
    // und speicher das Ergbnis in der Variablen ergebnis

    return ergebnis;
  }
}
