/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05;

public class Artikel {

  static int runningNumber = 0;

  private int nr;
  private String bez;
  private double preis;

  public Artikel(String name, double preis) {
    bez = name;
    this.preis = preis;
    nr = runningNumber;
    runningNumber++;
  }

  public int getNr() {
    return nr;
  }

  public String getBez() {
    return bez;
  }

  public void setBez(String bez) {
    this.bez = bez;
  }

  public double getPreis() {
    return preis;
  }

  public void setPreis(double preis) {
    if (preis > 0) {
      this.preis = preis;
    }
  }
}
