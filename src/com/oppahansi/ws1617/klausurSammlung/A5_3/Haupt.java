/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_3;

public class Haupt {
  public static void main(String[] leer) {
    int[] a = {3, 1, 2, 8};
    P r;
    Q s = new Q();
    r = (P) s;

    for (int i = 1; i < 4; i++) {
      if (a[i] - a[i - 1] > r.x) r.x = a[i] - a[i - 1];
      a[i] = a[i - 1] + a[i];
      if (a[i] - a[i - 1] > s.x) s.x = a[i] - a[i - 1];

      r.x = r.m(r.x);
      s.x = s.m(s.x);

      for (int j = 0; j < 4; j++) System.out.print(a[j] + " ");
      System.out.println("[" + i + "] " + r.x + ", " + s.x);
    }
  }
}
