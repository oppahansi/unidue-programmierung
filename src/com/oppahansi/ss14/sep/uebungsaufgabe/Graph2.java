package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Graph2 {

  Knoten knoten;

  public static void main(String args[]) {
    /* Graphen erstellen */
    Graph2 graph = new Graph2();
    graph.knoten =
        new Knoten(
            1, new Knoten(2, new Knoten(3, new Knoten(4, new Knoten(5, new Knoten(6, null))))));

    graph.knoten.kanten = new Kante(graph.knoten.Nf, 3, null);
    graph.knoten.Nf.Nf.kanten =
        new Kante(
            graph.knoten,
            2,
            new Kante(graph.knoten.Nf, 6, new Kante(graph.knoten.Nf.Nf.Nf, 7, null)));
    graph.knoten.Nf.Nf.Nf.kanten = new Kante(graph.knoten, 1, null);
    graph.knoten.Nf.Nf.Nf.Nf.kanten = new Kante(graph.knoten.Nf.Nf.Nf, 4, null);

    /* summen aufrufen und ausgeben */
    graph.summen();
    System.out.println("Summen\n======");
    System.out.println("Knoten 1: " + graph.knoten.summe + ", richtig ist 6");
    System.out.println("Knoten 2: " + graph.knoten.Nf.summe + ", richtig ist 9");
    System.out.println("Knoten 3: " + graph.knoten.Nf.Nf.summe + ", richtig ist 15");
    System.out.println("Knoten 4: " + graph.knoten.Nf.Nf.Nf.summe + ", richtig ist 12");
    System.out.println("Knoten 5: " + graph.knoten.Nf.Nf.Nf.Nf.summe + ", richtig ist 4");
  }

  void summen() {
    //
    // ergaenzen Sie bitte hier Ihren Quellcode
    //
  }
}
