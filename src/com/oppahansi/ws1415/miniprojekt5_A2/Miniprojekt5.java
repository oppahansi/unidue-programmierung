/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt5_A2;

public class Miniprojekt5 {

  public static void main(String[] args) {
    Graph graph = new Graph();
    char[] knotenABC = {'A', 'B', 'C', 'D', 'E', 'F'};
    Knoten[] knoten = new Knoten[knotenABC.length];
    for (int i = 0; i < knotenABC.length; i++) {
      knoten[i] = new Knoten(knotenABC[i]);
      graph.fuegeEin(knoten[i]);
    }

    knoten[0].fuegeEin(new Kante(1, knoten[1]));
    knoten[1].fuegeEin(new Kante(2, knoten[3]));
    knoten[1].fuegeEin(new Kante(9, knoten[3]));
    knoten[0].fuegeEin(new Kante(2, knoten[2]));
    knoten[3].fuegeEin(new Kante(3, knoten[1]));
    knoten[3].fuegeEin(new Kante(4, knoten[4]));
    knoten[4].fuegeEin(new Kante(5, knoten[5]));
    knoten[5].fuegeEin(new Kante(5, knoten[4]));
    knoten[5].fuegeEin(new Kante(0, knoten[1]));

    System.out.println("a) Anzahl der Kanten im Graphen: " + graph.anzahlKanten());
    System.out.println("b) Anzahl der Knoten im Graphen: " + graph.anzahlKnoten());
    System.out.println("c) Knoten gefunden, suche(knoten[0]): " + graph.suche(knoten[0]));
    System.out.println("d) Knoten suchen nach Bezeichner, suche('G'): " + graph.suche('G'));
    System.out.println(
        "e) Anzahl der aus- und hinfuehrenden Kanten des Knotens knoten[2]: "
            + graph.anzahlKanten(knoten[2]));
    System.out.println(
        "f) Anzahl der hinfuehrenden Kanten des Knotens knoten[2]: "
            + graph.anzahlHinKanten(knoten[2]));
    System.out.println(
        "g) Anzahl der ausgehenden Kanten des Knotens knoten[2]: "
            + graph.anzahlAusKanten(knoten[2]));
    System.out.println("h) Gr��te Zahl der Kanten-Zahlen im Graph: " + graph.maxKantenZahl());
    System.out.println(
        "i) Anzahl der Knoten mit der gr�sten Kantenzahl: " + graph.anzKnotenMaxKantenZahl());
    System.out.println("j) Anzahl der Senken im Graphen: " + graph.anzSenke());
    System.out.println("k) Knoten knoten[0] ist ein Quell-Knoten :" + graph.quelle(knoten[0]));
    System.out.println(
        "l) Existiert eine Kante zwischen knoten[0] und knoten[1] :"
            + graph.exKante(knoten[0], knoten[1]));
    System.out.println(
        "m) Ist das Knotenpar (knoten[3], knoten[4]) doppelt Verbunden :"
            + graph.doppeltVerbunden(knoten[3], knoten[4]));
    System.out.println(
        "n) Ist Knoten knoten[5] nicht mit andenren Knoten verbunden :" + graph.alone(knoten[5]));
    System.out.println(
        "o) Differenz zwischen Aus- und HinfuehrendenKanten des Knotens knoten[2]: "
            + graph.diff(knoten[2]));
  }
}
