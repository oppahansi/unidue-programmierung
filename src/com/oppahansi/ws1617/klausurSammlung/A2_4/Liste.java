/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_4;

class Liste {
  Element Kopf, Fuss; // Listen-Anfang und -Ende.

  Liste() {
    Kopf = Fuss = null;
  }

  public Liste l(int[] a, int[] b) {
    Liste aus = new Liste();
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 9 && a[i] < 100) {
        einfuege(aus, new Element(a[i]));
      }
    }
    for (int i = 0; i < b.length; i++) {
      if (b[i] > 9 && b[i] < 100) {
        einfuege(aus, new Element(b[i]));
      }
    }
    return aus;
  }

  public void einfuege(Liste l, Element e) {
    if (l.Kopf == null) {
      l.Kopf = l.Fuss = e;
    } else if (e.Zahl == l.Kopf.Zahl || e.Zahl == l.Fuss.Zahl) {
      return;
    } else if (e.Zahl < l.Kopf.Zahl) {
      e.Nf = l.Kopf;
      l.Kopf = e;
    } else if (e.Zahl > l.Fuss.Zahl) {
      l.Fuss.Nf = e;
      l.Fuss = e;
    } else {
      Element f = l.Kopf;
      while (f.Nf != null && f.Nf.Zahl < e.Zahl) {
        f = f.Nf;
      }
      if (f.Nf.Zahl == e.Zahl) {
        return;
      }
      e.Nf = f.Nf;
      f.Nf = e;
    }
  }
}
