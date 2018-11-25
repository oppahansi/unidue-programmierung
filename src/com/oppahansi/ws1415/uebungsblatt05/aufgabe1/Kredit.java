/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05.aufgabe1;

public class Kredit {

  private double zinssatz;
  private double gebuehr;
  private double betrag, rate;

  public Kredit(double zinssatz, double gebuehr, double betrag, double rate) {
    this.zinssatz = zinssatz;
    this.gebuehr = gebuehr;
    this.betrag = betrag;
    this.rate = rate;
  }

  public static void main(String[] args) {
    Kredit k = new Kredit(0.06, 10, 1000, 100);
    Kredit k2 = new Kredit(0.10, 15, 10000, 1500);
    System.out.println(k.ausgabe());
    System.out.println(k2.ausgabe());
    k2.durchrechnen();
  }

  public double getZinssatz() {
    return zinssatz;
  }

  public double getGebuehr() {
    return gebuehr;
  }

  public double getBetrag() {
    return betrag;
  }

  public double getRate() {
    return rate;
  }

  public String ausgabe() {
    String s;
    s = "Kreditobjekt: ";
    s += "Zinssatz: " + zinssatz + "; ";
    s += "Gebuehr: " + gebuehr + "; ";
    s += "Betrag: " + betrag + "; ";
    s += "Rate: " + rate + ";";
    return s;
  }

  public void durchrechnen() {
    double gesamtbetrag = betrag + gebuehr;
    int jahre = 0;
    while (gesamtbetrag > 0) {
      jahre++;
      gesamtbetrag = gesamtbetrag * (1 + zinssatz);
      gesamtbetrag -= rate;
      if (gesamtbetrag < 0) {
        gesamtbetrag = 0;
      }
      System.out.println("RestBetrag nach " + jahre + " Jahren: " + gesamtbetrag);
    }
  }
}
