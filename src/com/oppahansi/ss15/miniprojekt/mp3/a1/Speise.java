/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ss15.miniprojekt.mp3.a1;

public class Speise {

  int artNr;
  String name;
  double preis;
  String[] zutaten;
  Speise nf;

  public Speise(int artNr, String name, double preis, String[] zutaten) {
    this.artNr = artNr;
    this.name = name;
    this.preis = preis;
    this.zutaten = zutaten;
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

  public String[] getZutaten() {
    return zutaten;
  }

  public Speise getNachfolger() {
    return nf;
  }

  public void setNachfolger(Speise neueSpeise) {
    nf = neueSpeise;
  }
}
