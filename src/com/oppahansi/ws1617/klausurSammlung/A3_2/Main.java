/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_2;

public class Main {
  public static void main(String[] args) {

    Knoten k5 = new Knoten(5);
    Knoten k2 = new Knoten(2);
    Knoten k4 = new Knoten(4);
    Knoten k3 = new Knoten(3);

    Baum b = new Baum();
    b.Wurzel = k5;
    k5.links = k2;
    k2.links = k4;
    k5.rechts = k3;

    System.out.println(b.h());
  }
}
