/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_1;

public class Main {

  public static void main(String[] args) {

    Knoten kn1 = new Knoten("kn1");
    Knoten kn2 = new Knoten("kn2");
    Knoten kn3 = new Knoten("kn3");
    Knoten kn4 = new Knoten("kn4");

    kn1.Nf = kn2;
    kn2.Nf = kn3;
    kn3.Nf = kn4;

    Kante kan1 = new Kante("kan1");
    Kante kan2 = new Kante("kan2");
    Kante kan3 = new Kante("kan3");
    Kante kan4 = new Kante("kan4");
    Kante kan5 = new Kante("kan5");

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
    g.h();

    System.out.println(kn2.Anz);
    g.d();
    System.out.println(kn2.Anz);
  }
}
