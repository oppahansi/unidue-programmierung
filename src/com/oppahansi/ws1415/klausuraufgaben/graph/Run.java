/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.graph;

public class Run {

  public static void main(String[] args) {
    Graph graph = new Graph();
    String[] knotenABC = {"A", "B", "C", "D", "E", "F", "G"};
    Knoten[] knoten = new Knoten[knotenABC.length];
    for (int i = 0; i < knotenABC.length; i++) {
      knoten[i] = new strKnoten(knotenABC[i]);
      graph.fuegeEin(knoten[i]);
    }
    graph.indiziere();

    knoten[0].fuegeEin(new Kante(knoten[1]));
    knoten[1].fuegeEin(new Kante(knoten[3]));
    knoten[1].fuegeEin(new Kante(knoten[4]));
    knoten[1].fuegeEin(new Kante(knoten[6]));
    knoten[2].fuegeEin(new Kante(knoten[0]));
    knoten[2].fuegeEin(new Kante(knoten[1]));
    knoten[2].fuegeEin(new Kante(knoten[3]));
    knoten[2].fuegeEin(new Kante(knoten[5]));
    knoten[3].fuegeEin(new Kante(knoten[5]));
    knoten[3].fuegeEin(new Kante(knoten[6]));
    knoten[5].fuegeEin(new Kante(knoten[6]));
    knoten[6].fuegeEin(new Kante(knoten[4]));

    // Test
    Knoten k = graph.kopf;
    while (k != null) {
      Kante kante = k.kopf;
      System.out.println(((strKnoten) k).bez + " hat folgende Kanten:");
      while (kante != null) {
        System.out.println(
            "[" + ((strKnoten) k).bez + "]" + "--->" + ((strKnoten) kante.hinKnote).bez);
        kante = kante.nf;
      }
      k = k.nf;
    }
    System.out.println("Die Indizietmaxtrix ist:");
    int[][] matrix = graph.Matrix();
    for (int[] zahlen : matrix) {
      for (int zahl : zahlen) {
        System.out.print(zahl + " ");
      }
      System.out.println();
    }

    System.out.println(graph.Summe(knoten[1]));
    System.out.println(graph.anzMax());
  }
}
