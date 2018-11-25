/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05.aufgabe2;

public class Warenkorb {

  private Listenelement kopf, fuss;

  public static void main(String[] args) {
    Warenkorb w = new Warenkorb();
    w.artikeleinfuegen(new Artikel(1, "Erdbeere", 0.4), 100);
    Artikel a = new Artikel(2, "Birne", 1);
    w.artikeleinfuegen(a, 5);
    w.artikeleinfuegen(new Artikel(3, "Apfel", 1000), 1);
    System.out.println(w.ausgabe());
  }

  public void artikeleinfuegen(Artikel a, int anzahl) {
    Listenelement neu = new Listenelement(a, anzahl, null);

    if (kopf == null) {
      kopf = neu;
      fuss = neu;
    } else {
      fuss.setNext(neu);
      fuss = neu;
    }
  }

  public String ausgabe() {
    String s = "Warenkorb:\n";
    Listenelement iterator = kopf;
    while (iterator != null) {
      s += iterator.ausgabe() + "\n";
      iterator = iterator.getNext();
    }
    s += "Gesamtpreis: " + gesamtsumme();
    return s;
  }

  public double gesamtsumme() {
    double sum = 0;
    Listenelement iterator = kopf;
    while (iterator != null) {
      sum += iterator.getArtikel().getPreis() * iterator.getAnzahl();
      iterator = iterator.getNext();
    }

    return sum;
  }
}
