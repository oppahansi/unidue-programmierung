/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_6;

public class Main {

  public static void main(String[] args) {

    Knoten kn1 = new Knoten('r');
    Knoten kn2 = new Knoten('r');
    Knoten kn3 = new Knoten('s');
    Knoten kn4 = new Knoten('b');

    kn1.Nf = kn2;
    kn2.Nf = kn3;
    kn3.Nf = kn4;

    Kante kan1 = new Kante('r');
    Kante kan2 = new Kante('s');
    Kante kan3 = new Kante('s');
    Kante kan4 = new Kante('b');
    Kante kan5 = new Kante('b');

    kn1.kopf = kn1.fuss = kan1;
    kan1.kante = kn2;

    kn2.kopf = kan2;
    kn2.fuss = kan3;
    kan2.kante = kn3;
    kan3.kante = kn4;
    kan2.Nf = kan3;

    kn3.kopf = kn3.fuss = kan4;
    kan4.kante = kn1;

    kn4.kopf = kn4.fuss = kan5;
    kan5.kante = kn3;

    Graph g = new Graph();
    g.kopf = kn1;
    g.fuss = kn4;

    System.out.println(g.kopf.farbe);
    System.out.println(g.anzRot());
    System.out.println(g.Anz_Gleichfarbig());
    g.faerbe_hinfuehrend();
    System.out.println(g.kopf.Nf.Nf.f);
    System.out.println(g.kopf.Nf.Nf.n);
    System.out.println(g.kopf.farbe);
  }
}
