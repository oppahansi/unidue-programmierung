/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_4;

public class Main {

  static boolean g(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] == a[i + 1]) {
        return true;
      }
    }
    return false;
  }

  static boolean m(int[] a) {
    double summe = 0;
    for (int i = 0; i < a.length; i++) {
      summe += a[i];
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] == summe / a.length) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int x[] = new int[] {25, 7, 14, 31, 66, 14, 15};
    int y[] = new int[] {55, 31, 25, 66, 14, 14, 7, 14, 66};

    Liste L = new Liste();
    L = L.l(x, y);

    Element e = L.Kopf;

    while (e != null) {
      System.out.println(e.Zahl);
      e = e.Nf;
    }
  }
}
