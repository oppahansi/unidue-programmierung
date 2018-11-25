/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05.aufgabe2;

public class Listenelement {

  private Artikel artikel;
  private int anzahl;
  private Listenelement next;

  public Listenelement(Artikel a, int anzahl, Listenelement next) {
    this.artikel = a;
    this.anzahl = anzahl;
    this.next = next;
  }

  public Listenelement() {}

  public static void main(String[] args) {
    /*Listenelement l = new Listenelement();
      Artikel a = new Artikel(13, "Sofa", 1000);
    l.setAnzahl(3);
    l.setArtikel(a);
    System.out.println(l.ausgabe());*/
  }

  public Artikel getArtikel() {
    return artikel;
  }

  public void setArtikel(Artikel artikel) {
    this.artikel = artikel;
  }

  public int getAnzahl() {
    return anzahl;
  }

  public void setAnzahl(int anzahl) {
    this.anzahl = anzahl;
  }

  public Listenelement getNext() {
    return next;
  }

  public void setNext(Listenelement next) {
    this.next = next;
  }

  public String ausgabe() {
    return artikel.ausgabe() + " x " + anzahl;
  }
}
