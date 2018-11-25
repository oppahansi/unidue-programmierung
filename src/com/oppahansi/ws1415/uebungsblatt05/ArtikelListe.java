/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05;

public class ArtikelListe {

  private ArtikelListenElement kopf;

  public static void main(String[] args) {}

  // neue Artikel werden am Ende der Liste eingefuegt
  public void einfuegen(Artikel a, int anzahl) {
    ArtikelListenElement iter;
    iter = kopf;
    while (iter.getNext() != null) {
      iter = iter.getNext();
    }
    ArtikelListenElement ale = new ArtikelListenElement(a, anzahl, null);
    iter.setNext(ale);
  }
}
