/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_9;

public class Main {

  public static void main(String[] args) {
    char[] c = {'g', 'b'};
    int[] z = {5, 7, 2};
    Liste L = new Liste(c, z);

    for (Element e = L.Kopf; e != null; e = e.Nf) {
      if (e instanceof ElemA) {
        ElemA a = (ElemA) e;
        System.out.println(a.Zeichen);
      } else {
        ElemB b = (ElemB) e;
        System.out.println(b.zahl);
      }
    }
    System.out.println(L.summe());

    char[] Arr = L.erzeugeArray();
    for (int i = 0; i < Arr.length; i++) {
      System.out.println(Arr[i]);
    }
  }
}
