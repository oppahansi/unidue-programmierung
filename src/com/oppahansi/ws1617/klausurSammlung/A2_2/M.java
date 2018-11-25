/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_2;

class M {
  Element[] Kopf = new Element[5];

  Element p(Element x, Element y) {
    if (x == null && y == null) return null;
    else if (x == null) return new Element(y.Zahl, p(null, y.Nf));
    else if (y == null) return new Element(x.Zahl, p(x.Nf, null));
    else if (x.Zahl == y.Zahl) return new Element(x.Zahl, p(x.Nf, y.Nf));
    else if (x.Zahl < y.Zahl) return new Element(x.Zahl, p(x.Nf, y));
    else return new Element(y.Zahl, p(x, y.Nf));
  }

  Element q(Element x, Element y) {
    if (x == null) {
      return null;
    } else if (y == null) {
      return x;
    } else if (x.Zahl < y.Zahl) {
      return new Element(x.Zahl, q(x.Nf, y));
    } else if (x.Zahl > y.Zahl) {
      return q(x, y.Nf);
    } else return q(x.Nf, y.Nf);
  }

  Element s(int zahl, Element x) {
    if (x == null) {
      return new Element(zahl, null);
    } else if (zahl < x.Zahl) {
      return new Element(zahl, x);
    } else if (zahl > x.Zahl) {
      return new Element(x.Zahl, s(zahl, x.Nf));
    } else return x;
  }
}
