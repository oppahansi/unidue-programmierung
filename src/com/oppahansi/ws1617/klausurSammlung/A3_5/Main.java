/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_5;

public class Main {

  public static void main(String[] args) {
    Array a = new Array();
    int[] x = a.neu();
    x[0] = 0;
    x[1] = 0;
    x[2] = 0;
    x[3] = 0;
    a.sortiereEin(x, 200);
    a.sortiereEin(x, 2);
    a.sortiereEin(x, 11);

    for (int i = 0; i < x.length; i++) {
      System.out.println(x[i]);
    }
    System.out.println(a.sortiert(x));
    System.out.println(1 / 2);

    Baum b = new Baum();

    Knoten k = new Knoten(1);
    b.einfuege(k);

    System.out.println(b.wurzel);
  }
}
