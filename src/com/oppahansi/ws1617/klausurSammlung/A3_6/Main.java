/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_6;

public class Main {
  public static void main(String[] args) {
    Knoten g = new Knoten("g");
    Knoten d = new Knoten("d");
    Knoten h = new Knoten("h");
    Knoten i = new Knoten("i");
    Knoten e = new Knoten("e");
    Knoten b = new Knoten("b");
    Knoten a = new Knoten("a");
    Knoten j = new Knoten("j");
    Knoten k = new Knoten("k");
    Knoten f = new Knoten("f");
    Knoten c = new Knoten("c");

    a.links = b;
    a.rechts = c;
    b.links = d;
    b.rechts = e;
    d.links = g;
    e.links = h;
    e.rechts = i;
    c.links = f;
    f.links = j;
    f.rechts = k;

    System.out.println(a.TB(a, d));
  }
}
