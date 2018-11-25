/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub5.a1;

public class Liste {

  private Element Kopf;
  private Element Fuss;

  public Liste() {
    Kopf = Fuss = null;
  }

  public void insertElement(Element newElement) {
    if (getKopf() == null) {
      Kopf = Fuss = newElement;
    } else {
      Fuss.setNf(newElement);
      Fuss = Fuss.getNf();
    }
  }

  public Element getKopf() {
    return Kopf;
  }

  public void setKopf(final Element kopf) {
    Kopf = kopf;
  }

  public Element getFuss() {
    return Fuss;
  }

  public void setFuss(final Element fuss) {
    Fuss = fuss;
  }
}
