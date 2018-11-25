/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Alex Oppa Hansi
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.miniprojekt6_A1;

public class Konto {

  protected int kontoNr;
  protected double kontoStand;
  protected Konto bankKonto;

  public Konto(int kontoNr, double kontoStand, Konto bankKonto) {
    this.kontoNr = kontoNr;
    this.kontoStand = kontoStand;
    this.bankKonto = bankKonto;
  }

  public boolean einzahlen(double betrag) {
    this.kontoStand += betrag;
    return true;
  }

  public boolean abheben(double betrag) {
    this.kontoStand -= betrag;
    return true;
  }

  public boolean ueberweisenAuf(Konto ziel, double betrag) {
    return false;
  }

  public void tagesAbschluss() {}

  public void monatsAbschluss() {}

  public void jahresAbschluss() {}

  public double getKontoStand() {
    return kontoStand;
  }

  public int getKontoNr() {
    return kontoNr;
  }
}
