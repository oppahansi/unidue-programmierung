/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

public class Liste {

  Element kopf, fuss;

  //erhoeht das Element mit dem Bezeichner bez
  void zaehleHoch(String bez) {
    Element tmp = kopf;

    while (tmp != null) {
      if (tmp.bez.equals(bez)) {
        tmp.anzahl++;
        return;
      }
      tmp = tmp.nf;
    }
    if (kopf == null) {
      kopf = fuss = new Element(bez, 1);
    } else {
      //der nachfolger des letzten elements in der liste speichert das
      //neue objekt vom typ element
      fuss = fuss.nf = new Element(bez, 1);
    }
  }

  boolean enthaeltDoppelteElemente() {
    Element tmp = kopf;

    while (tmp != null) {
      if (tmp.anzahl >= 2) {
        return true;
      }
      tmp = tmp.nf;
    }
    return false;
  }
}
