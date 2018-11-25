/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_10;

public class Main {
  public static void main(String[] args) {
    Knoten k7 = new Knoten(7);
    Knoten k2 = new Knoten(2);
    Knoten k4 = new Knoten(4);
    Knoten k3 = new Knoten(3);
    Knoten k8 = new Knoten(8);
    Knoten k5 = new Knoten(5);
    Knoten k6 = new Knoten(6);
    Knoten k16 = new Knoten(16);
    Knoten k61 = new Knoten(61);

    Baum b = new Baum();
    b.wurzel = k7;
    k7.links = k3;
    k3.rechts = k8;
    k7.rechts = k4;
    k4.rechts = k2;
    k4.links = k5;
    k8.links = k6;
    k5.links = k16;
    k2.rechts = k61;

    System.out.println(b.minBlattabstand());
    System.out.println(b.istBlatt(k7.rechts));
    System.out.println(b.blattAnzahl(b.wurzel));
  }
}
