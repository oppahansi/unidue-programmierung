/*
 * Created by Rogerg Fu on 10.11.2014.
 *
 * <p>Altermative 2
 */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_2_A2 {

  public static int summeDerDifferenzen(int[] array1, int[] array2) {
    int[] a;
    int x, summe = 0;

    if (array1.length < array2.length) {
      x = array2.length;
    } else {
      x = array1.length;
    }

    a = new int[x];

    for (int b = 0; b < x; b++) {
      int y = 0, z = 0;
      if (b < array1.length) {
        y = array1[b];
      }
      if (b < array2.length) {
        z = array2[b];
      }

      if (y < z) {
        a[b] = Math.abs(z - y);
      } else {
        a[b] = Math.abs(y - z);
      }

      summe = summe + a[b];
    }
    return summe;
  }

  public static void main(String[] args) {

    int[] array1 = {1, 2, 6, 1, -3, 2, 6};
    int[] array2 = {-10, 12, 21};

    int test = 0;

    test = summeDerDifferenzen(array1, array2);

    System.out.println(test);
  }
}
