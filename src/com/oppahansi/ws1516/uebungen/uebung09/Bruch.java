/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung09;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Erweitern Sie die Klassendeklaration um das Interface Comparable. Vergessen
 * Sie nicht in spitzen Klammern den Klassennamen anzugeben.
 * Fuegen Sie danach die notwendige Methode zur Klasse hinzu und implementieren
 * Sie diese. Wenn Sie alles korrekt implementiert haben, gibt das Programm
 * mehrere Brueche in der Reihenfolge ihrer Groesse aus.
 *
 * Schauen Sie Sich zuvor das Beispiel zum Interface Comparable in JACK an.
 */
public class Bruch implements Comparable<Bruch> {

  private int zaehler;
  private int nenner;

  public Bruch(int zaehler, int nenner) {
    this.zaehler = zaehler;
    this.nenner = nenner;
  }

  public static void main(String[] args) {
    ArrayList<Bruch> brueche = new ArrayList<Bruch>();
    brueche.add(new Bruch(14, 3));
    brueche.add(new Bruch(27, 6));
    brueche.add(new Bruch(2, 7));
    brueche.add(new Bruch(155, 156));
    /*
     * Die Fehlermarkierung unter sort erscheint, weil Objekte der Klasse
     * Bruch nicht untereinander vergleichbar sind, Vergleichbarkeit aber
     * fuer die Verwendung der Methode Collections.sort notwendig ist.
     * Stellen Sie die Vergleichbarkeit her, indem sie in der
     * Klassendeklaration die Implementierung des Interfaces Comparable<T>
     * angeben und die Methoden die das Interface erfordert implementieren.
     * Wenn ihre Implementierung korrekt ist, erscheint die Liste in
     * aufsteigender Reihenfolge sortiert.
     */
    Collections.sort(brueche);
    for (int i = 0; i < brueche.size(); i++) {
      Bruch b = brueche.get(i);
      System.out.println(
          "( "
              + b.getZaehler()
              + " / "
              + b.getNenner()
              + " ) = "
              + (b.getZaehler() / (double) b.getNenner()));
    }
  }

  public int getZaehler() {
    return zaehler;
  }

  public void setZaehler(int zaehler) {
    this.zaehler = zaehler;
  }

  public int getNenner() {
    return nenner;
  }

  public void setNenner(int nenner) {
    this.nenner = nenner;
  }

  @Override
  public int compareTo(final Bruch bruch) {
    if ((this.zaehler / (double) this.nenner) < (bruch.zaehler / (double) bruch.nenner)) {
      return -1;
    } else if ((this.zaehler / (double) this.nenner) > (bruch.zaehler / (double) bruch.nenner)) {
      return 1;
    } else {
      return 0;
    }
  }
}
