/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_4;

public class Main {

  public static void main(String[] args) {
    Knoten k7 = new Knoten(7);
    Knoten k2 = new Knoten(2);
    Knoten k4 = new Knoten(4);
    Knoten k3 = new Knoten(3);
    Knoten k8 = new Knoten(8);

    Baum b = new Baum();
    b.wurzel = k7;
    k7.links = k3;
    k3.rechts = k8;
    k4.rechts = k2;
    k7.rechts = k4;

    System.out.println(b.a());
    //	b.b();
    System.out.println(b.wurzel.links.rechts.zahl);
  }
}
