/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_9;

public class ElemB extends Element {

  int zahl;

  ElemB(int x, Element e) {
    super(e);
    zahl = x;
  }

  int getZahl() {
    return zahl;
  }
}
