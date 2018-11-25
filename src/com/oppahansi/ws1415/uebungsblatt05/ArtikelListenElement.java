/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05;

public class ArtikelListenElement {

  Artikel a;
  int anzahl;
  ArtikelListenElement next;

  public ArtikelListenElement(Artikel a, int anzahl, ArtikelListenElement next) {
    this.a = a;
    this.anzahl = anzahl;
    this.next = next;
  }

  public Artikel getA() {
    return a;
  }

  public void setA(Artikel a) {
    this.a = a;
  }

  public int getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(int anzahl) {
    this.anzahl = anzahl;
  }

  public ArtikelListenElement getNext() {
    return next;
  }

  public void setNext(ArtikelListenElement next) {
    this.next = next;
  }
}
