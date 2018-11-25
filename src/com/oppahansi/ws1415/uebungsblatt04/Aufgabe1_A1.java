/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 1 - Live
 */
package com.oppahansi.ws1415.uebungsblatt04;

public class Aufgabe1_A1 {

  static int[] merge(int[] x, int[] y) {
    int ix = 0;
    int iy = 0;
    int iz = 0;

    int z[] = new int[x.length + y.length];

    while (ix < x.length || iy < y.length) {

      // beide arrays enthalten noch elemente
      if (ix < x.length && iy < y.length) {
        // vergleich x[ix] mit y[iy]
        if (x[ix] < y[iy]) { // x ist kleiner
          z[iz] = x[ix++];
        } else { // y ist kleiner
          z[iz] = y[iy++];
        }
      } else {
        //nur noch ein array enthaelt elemente
        if (ix < x.length) {
          // x etnhaelt noch elemente
          z[iz] = x[ix++];
        } else {
          // y enthaelt noch elemente
          z[iz] = y[iy++];
        }
      }
      iz++;
    }
    return z;
  }

  public static void main(String[] args) {
    int z[] = merge(new int[] {4, 8}, new int[] {4, 8});

    for (int i = 0; i < z.length; i++) {
      System.out.print(z[i] + " ");
    }
  }
}
