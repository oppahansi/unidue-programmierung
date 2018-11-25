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

public class SparKonto extends Konto {

  private double zinssatz;
  private double tagesZinsen;
  private double abschluesse;

  public SparKonto(int kontoNr, double kontoStand, Konto bankKonto, double zinssatz) {
    super(kontoNr, kontoStand, bankKonto);
    this.zinssatz = zinssatz;
  }

  @Override
  public boolean abheben(double betrag) {
    // Alternative zum einfachen return.
    // Weiterhin werde ich, wenn moeglich, einfache return verwenden, ohne ifs

    //      if (getKontoStand() - betrag >= 0) {
    //         return super.abheben(betrag);
    //      }
    //      else {
    //         return false;
    //      }
    return getKontoStand() - betrag >= 0 && super.abheben(betrag);
  }

  @Override
  public boolean ueberweisenAuf(Konto ziel, double betrag) {
    // Alternative zum einfachen return.
    // Weiterhin werde ich, wenn moeglich, einfache return verwenden, ohne ifs

    //      if (getKontoStand() - betrag >= 0) {
    //         super.abheben(betrag);
    //         ziel.einzahlen(betrag);
    //         return true;
    //      }
    //      else {
    //         return false;
    //      }
    return (getKontoStand() - betrag >= 0) && abheben(betrag) && ziel.einzahlen(betrag);
  }

  @Override
  public void tagesAbschluss() {
    tagesZinsen += (getKontoStand() * zinssatz);
    abschluesse += 1.0;
  }

  @Override
  public void jahresAbschluss() {
    if (bankKonto.getKontoStand() - (tagesZinsen / abschluesse) >= 10000000.0) {
      double jahresZinsen = tagesZinsen / abschluesse;
      bankKonto.abheben(
          jahresZinsen); // notwendig, da in Konto.java ueberweisenAuf(...) {...} nicht implementiert ist
      einzahlen(jahresZinsen);
      tagesZinsen = 0;
      abschluesse = 0;
    }
  }
}
