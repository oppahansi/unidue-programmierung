/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_9;

public class Liste {

  Element Kopf = null;

  Liste(char[] a, int[] b) {
    int n = Math.max(a.length, b.length);
    for (int i = 0; i < n; i++) {
      if (i < a.length) {
        Kopf = new ElemA(a[i], Kopf);
      }
      if (i < b.length) {
        Kopf = new ElemB(b[i], Kopf);
      }
    }
  }

  //AUFGABE 2.9 c
  int summe() {
    int aus = 0;
    for (Element e = Kopf; e != null; e = e.Nf) {
      aus += e.getZahl();
    }
    return aus;
  }

  //AUFGABE 2.9 e
  char[] erzeugeArray() {
    int laenge = 0;
    for (Element e = Kopf; e != null; e = e.Nf) {
      if (e instanceof ElemA) {
        laenge++;
      }
    }
    char[] aus = new char[laenge];
    int index = 0;
    for (Element e = Kopf; e != null; e = e.Nf) {
      if (e instanceof ElemA) {
        aus[index] = ((ElemA) e).Zeichen;
        index++;
      }
    }
    return aus;
  }
}
