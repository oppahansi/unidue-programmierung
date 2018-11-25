/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05.aufgabe2;

public class Artikel {

  int nummer;
  String bezeichnung;
  double preis;

  public Artikel(int nummer, String bezeichner, double preis) {
    this.nummer = nummer;
    this.bezeichnung = bezeichner;
    this.preis = preis;
  }

  public static void main(String[] args) {
    Artikel a = new Artikel(12, "Banane", 1);
    System.out.println(a.ausgabe());
  }

  public int getNummer() {
    return nummer;
  }

  public void setNummer(int nummer) {
    this.nummer = nummer;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public double getPreis() {
    return preis;
  }

  public void setPreis(double preis) {
    this.preis = preis;
  }

  public String ausgabe() {
    return "Artikel Nummer " + nummer + ": " + bezeichnung;
  }
}
