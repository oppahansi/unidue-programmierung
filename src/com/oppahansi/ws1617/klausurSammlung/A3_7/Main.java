/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_7;

public class Main {

  public static void main(String[] args) {
    Knoten k0 = new Knoten(5, 0);

    Baum b = new Baum();
    b.wurzel = k0;
    b.fuegeEin(-8);
    b.fuegeEin(8);
    b.fuegeEin(2);
    b.fuegeEin(6);
    b.fuegeEin(-9);
    b.fuegeEin(3);
    b.fuegeEin(-2);
    b.fuegeEin(-5);

    System.out.println(b.wurzel.zahl + " " + b.wurzel.Tiefe);
    System.out.println(b.wurzel.links.zahl + " " + b.wurzel.links.Tiefe);
    System.out.println(b.wurzel.rechts.zahl + " " + b.wurzel.rechts.Tiefe);
    System.out.println(b.wurzel.links.links.zahl + " " + b.wurzel.links.links.Tiefe);
    System.out.println(b.wurzel.links.rechts.zahl + " " + b.wurzel.links.rechts.Tiefe);
    System.out.println(b.wurzel.rechts.links.zahl + " " + b.wurzel.rechts.links.Tiefe);
    System.out.println(b.wurzel.rechts.rechts.zahl + " " + b.wurzel.rechts.rechts.Tiefe);
    System.out.println(b.wurzel.links.links.links.zahl + " " + b.wurzel.links.links.Tiefe);
    System.out.println(
        b.wurzel.links.rechts.rechts.zahl + " " + b.wurzel.links.rechts.rechts.Tiefe);
  }
}
