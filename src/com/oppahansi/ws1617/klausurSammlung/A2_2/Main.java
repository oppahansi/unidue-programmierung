/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_2;

public class Main {
  public static void main(String[] args) {
    M m = new M();
    Element e5 = new Element(5, null);
    Element e3 = new Element(3, e5);
    Element e1 = new Element(1, e3);
    Element e7 = new Element(7, null);
    Element e51 = new Element(5, e7);
    Element e2 = new Element(2, e51);

    m.Kopf[1] = e2;
    m.Kopf[3] = e1;

    m.Kopf[2] = m.p(m.Kopf[1], m.Kopf[3]);
    m.Kopf[2] = m.s(8, m.Kopf[2]);
    for (int i = 0; i < m.Kopf.length; i++) {
      System.out.println(m.Kopf[i]);
    }
    Element e = m.Kopf[2];
    while (e != null) {
      System.out.print(e.Zahl + " -> ");
      e = e.Nf;
    }
  }
}
