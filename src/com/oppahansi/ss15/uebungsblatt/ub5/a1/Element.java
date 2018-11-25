/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub5.a1;

public class Element {

  private Element Nf; // Nachfolge-Element in der Liste.
  private int Zahl; // In das Element eingetragene Zahl.

  public Element(int Zahl) {
    this.Zahl = Zahl;
    Nf = null;
  }

  public int getZahl() {
    return Zahl;
  }

  public void setZahl(final int zahl) {
    Zahl = zahl;
  }

  public Element getNf() {
    return Nf;
  }

  public void setNf(final Element nf) {
    Nf = nf;
  }
}
