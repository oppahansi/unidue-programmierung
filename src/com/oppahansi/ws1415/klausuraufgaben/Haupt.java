/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben;

class p {

  int x;

  p() {
    x = 0;
    System.out.println("p " + x);
  }

  int m(int i) {
    return 2 * i;
  }
}

class q extends p {

  int x;

  q() {
    x = 1;
    System.out.println("q " + x);
  }

  int m(int k) {
    return k - 1;
  }
}

public class Haupt {

  public static void main(String[] leer) {
    int[] a = {3, 1, 2, 8};
    p r;
    q s = new q();
    r = (p) s;
    for (int i = 1; i < 4; i++) {
      if (a[i] - a[i - 1] > r.x) {
        r.x = a[i] - a[i - 1];
      }
      a[i] = a[i - 1] + a[i];
      if (a[i] - a[i - 1] > s.x) {
        s.x = a[i] - a[i - 1];
      }
      r.x = r.m(r.x);
      s.x = s.m(s.x);
      for (int j = 0; j < 4; j++) {
        System.out.print(a[j] + " ");
      }
      System.out.println("[ " + i + "] " + r.x + ", " + s.x);
    }
  }
}
