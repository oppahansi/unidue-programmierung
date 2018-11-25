/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ss15.miniprojekt.mp3.a1;

public class Tischbuchung {

  int belegtStart;
  int belegtEnde;
  Tischbuchung nf;

  public Tischbuchung(int belegtStart, int belegtEnde) {
    this.belegtStart = belegtStart;
    this.belegtEnde = belegtEnde;
  }

  public Tischbuchung getNachfolger() {
    return nf;
  }

  public void setNachfolger(Tischbuchung neueTischbuchung) {
    nf = neueTischbuchung;
  }

  public int getStart() {
    return belegtStart;
  }

  public int getEnde() {
    return belegtEnde;
  }
}
