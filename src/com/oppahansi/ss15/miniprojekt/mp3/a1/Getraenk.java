/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ss15.miniprojekt.mp3.a1;

public class Getraenk {

  int artNr;
  String name;
  String groesse;
  double preis;
  Getraenk nf;

  public Getraenk(int artNr, String name, String groesse, double preis) {
    this.artNr = artNr;
    this.name = name;
    this.groesse = groesse;
    this.preis = preis;
  }

  public int getArtNr() {
    return artNr;
  }

  public String getName() {
    return name;
  }

  public double getPreis() {
    return preis;
  }

  public void setPreis(double neuerPreis) {
    preis = neuerPreis;
  }

  public String getGroesse() {
    return groesse;
  }

  public Getraenk getNachfolger() {
    return nf;
  }

  public void setNachfolger(Getraenk neuesGetraenk) {
    nf = neuesGetraenk;
  }
}
