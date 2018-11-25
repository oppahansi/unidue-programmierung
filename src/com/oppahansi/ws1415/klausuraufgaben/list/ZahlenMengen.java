/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.list;

public class ZahlenMengen {

  //从两个链表中组成新的单调递增链表
  Element[] Kopf = new Element[5];

  public static void main(String[] args) {
    ZahlenMengen zahlenMengen = new ZahlenMengen();
    zahlenMengen.Kopf[0] = new Element(3, new Element(4, null));
    zahlenMengen.Kopf[1] = new Element(2, new Element(5, new Element(7, null)));
    zahlenMengen.Kopf[3] = new Element(1, new Element(3, new Element(5, null)));
    zahlenMengen.Kopf[2] = zahlenMengen.q(zahlenMengen.Kopf[1], zahlenMengen.Kopf[3]);
    zahlenMengen.s(5, zahlenMengen.Kopf[3]);
    Element e = zahlenMengen.Kopf[3];
    while (e != null) {
      System.out.print(e.Zahl + "--->");
      e = e.Nf;
    }
  }

  Element p(Element x, Element y) {
    if (x == null && y == null) {
      return null;
    } else if (x == null) {
      return new Element(y.Zahl, p(null, y.Nf));
    } else if (y == null) {
      return new Element(x.Zahl, p(x.Nf, null));
    } else if (x.Zahl == y.Zahl) {
      return new Element(x.Zahl, p(x.Nf, y.Nf));
    } else if (x.Zahl < y.Zahl) {
      return new Element(x.Zahl, p(x.Nf, y));
    } else {
      return new Element(y.Zahl, p(x, y.Nf));
    }
  }

  Element q(Element x, Element y) {
    //从链表X中减去链表Y，并单调递增
    if (x == null && y == null) {
      return null;
    } else if (x == null) {
      return new Element(y.Zahl, q(null, y.Nf));
    } else if (y == null) {
      return new Element(x.Zahl, q(x.Nf, null));
    } else if (x.Zahl < y.Zahl) {
      return new Element(x.Zahl, q(x.Nf, y));
    } else if (x.Zahl > y.Zahl) {
      return new Element(y.Zahl, q(x, y.Nf));
    } else {
      return q(x.Nf, y.Nf);
    }
  }

  void s(int zahl, Element element) {
    //添加一个元素（数字）到指定链表
    if (zahl <= element.Zahl) {
      Element e = new Element(element.Zahl, element.Nf);
      element.Zahl = zahl;
      element.Nf = e;
    } else if (element.Nf != null) {
      s(zahl, element.Nf);
    } else {
      element.Nf = new Element(zahl, null);
    }
  }
}

//Aufgabe 2.4

class ZahlenList {

  Element Kopf, Fuss; // Listen-Anfang und -Ende.

  ZahlenList() {
    Kopf = Fuss = null;
  }

  ZahlenList L(int[] a, int[] b) {
    //如果int a 在两个数组中都出现，就加入到新的递增链表中，并返回此链表
    for (int zahl : a) {
      if (zahl >= 10 && zahl <= 99) {
        for (int number : b) {
          if (zahl == number) {
            Element e = this.Kopf;
            Element vorgeange = null;
            if (e == null) {
              this.Kopf = this.Fuss = new Element(zahl, null);
            } else {
              while (e != null) {
                if (zahl < e.Zahl) {
                  if (vorgeange == null) {
                    this.Kopf = new Element(zahl, null);
                    Kopf.Nf = e;
                  } else {
                    vorgeange.Nf = new Element(zahl, e);
                  }
                  break;
                } else if (zahl == e.Zahl) {
                  break;
                } else if (e == this.Fuss) {
                  this.Fuss = this.Fuss.Nf = new Element(zahl, null);
                }
                vorgeange = e;
                e = e.Nf;
              }
            }
          }
        }
      }
    }
    return this;
  }
}

//Aufgabe 2.4

class ZahlenAusArray {

  public static void main(String[] args) {
    int[] a = {25, 7, 14, 31, 66, 14, 15};
    int[] b = {55, 31, 25, 66, 14, 14, 7, 14, 66};
    ZahlenList list = new ZahlenList();
    list = list.L(a, b);
    Element e = list.Kopf;
    while (e != null) {
      System.out.println(e.Zahl);
      e = e.Nf;
    }
  }
}

class Element {

  int Zahl;
  Element Nf;

  Element(int Zahl, Element Nf) {
    this.Zahl = Zahl;
    this.Nf = Nf;
  }
}
