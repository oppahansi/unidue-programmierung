/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05;

public class Kredit {

  double betrag, gebuehr, zinssatz, rate;

  public Kredit(double betrag, double gebuehr, double zinssatz, double rate) {
    this.betrag = betrag;
    this.gebuehr = gebuehr;
    this.zinssatz = zinssatz;
    this.rate = rate;
  }

  public static void main(String[] args) {
    Kredit k = new Kredit(1000, 15, 0.06, 150);
    System.out.println(k.toString());
  }

  public String toString() {
    String ausgabe = "Kreditobjekt: ";
    ausgabe += "Betrag(" + betrag + "), ";
    ausgabe += "Gebuehr(" + gebuehr + "), ";
    ausgabe += "Zinssatz(" + zinssatz + "), ";
    ausgabe += "Rate(" + rate + ")";
    return ausgabe;
  }
}
