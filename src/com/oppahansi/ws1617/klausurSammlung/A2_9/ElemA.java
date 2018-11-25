/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_9;

public class ElemA extends Element {

  char Zeichen;

  ElemA(char x, Element e) {
    super(e);
    Zeichen = x;
  }

  int getZahl() {
    return 10;
  }
}
