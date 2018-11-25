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

public class GiroKonto extends Konto {

  private double kreditlimit;

  public GiroKonto(int kontoNr, double kontoStand, Konto bankKonto, double kreditlimit) {
    super(kontoNr, kontoStand, bankKonto);
    this.kreditlimit = kreditlimit;
  }

  @Override
  public boolean abheben(double betrag) {
    return (getKontoStand() + kreditlimit - betrag >= 0) && super.abheben(betrag);
  }

  @Override
  public boolean ueberweisenAuf(Konto ziel, double betrag) {
    return abheben(betrag) && ziel.einzahlen(betrag);
  }

  public double getKreditlimit() {
    return kreditlimit;
  }

  public void setKreditlimit(double kreditlimit) {
    this.kreditlimit = kreditlimit;
  }
}
