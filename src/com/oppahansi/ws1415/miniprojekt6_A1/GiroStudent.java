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

public class GiroStudent extends GiroKonto {

  private final double KNT_FUEHRUNGS_GEBUEHREN = 50.0;
  private final double TAGES_KREDITZINS = 0.2;
  private final double GEB_ABHEBEN = 0.04;
  private final double GEB_ABHEBEN_MIN = 4.0;
  private final double GEB_UEBERW = 0.02;
  private final double GEB_UEBERW_MIN = 2.0;

  private double gebuehren;
  private double kreditZinsen;
  private double abschluesse;
  private double jahresAbschluesse;
  private boolean studentenKonto;

  public GiroStudent(int kontoNr, double kontoStand, Konto bankKonto) {
    super(kontoNr, kontoStand, bankKonto, 500.0);
    studentenKonto = true;
  }

  @Override
  public boolean einzahlen(double betrag) {
    super.einzahlen(betrag);
    ueberpruefeKonto();
    return true;
  }

  private void ueberpruefeKonto() {
    if (getKontoStand() >= 5000 || jahresAbschluesse == 10) {
      studentenKonto = false;
    }
  }

  @Override
  public boolean abheben(double betrag) {
    if (!studentenKonto
        && getKontoStand() + getKreditlimit() >= betrag + berechneAbhebeGebuehren(betrag)) {
      gebuehren += berechneAbhebeGebuehren(betrag);
      return super.abheben(betrag);
    } else {
      return getKontoStand() + getKreditlimit() >= betrag && super.abheben(betrag);
    }
  }

  private double berechneAbhebeGebuehren(double betrag) {
    return (betrag * GEB_ABHEBEN <= GEB_ABHEBEN_MIN) ? GEB_ABHEBEN_MIN : betrag * GEB_ABHEBEN;
  }

  @Override
  public boolean ueberweisenAuf(Konto ziel, double betrag) {
    if (!studentenKonto
        && getKontoStand() + getKreditlimit() >= betrag + berechneUeberwGebuehren(betrag)) {
      gebuehren += berechneUeberwGebuehren(betrag);
      return super.abheben(betrag) && ziel.einzahlen(betrag);
    } else {
      return getKontoStand() + getKreditlimit() >= betrag
          && super.abheben(betrag)
          && ziel.einzahlen(betrag);
    }
  }

  private double berechneUeberwGebuehren(double betrag) {
    return (betrag * GEB_UEBERW <= GEB_UEBERW_MIN) ? GEB_UEBERW_MIN : betrag * GEB_UEBERW;
  }

  @Override
  public void tagesAbschluss() {
    if (getKontoStand() < 0) {
      kreditZinsen += Math.abs(getKontoStand() * TAGES_KREDITZINS);
    }
    abschluesse += 1.0;
  }

  @Override
  public void monatsAbschluss() {
    double monatsKreditzinsen = kreditZinsen / abschluesse;
    super.abheben(monatsKreditzinsen + gebuehren);
    bankKonto.einzahlen(monatsKreditzinsen + gebuehren);
    kreditZinsen = 0;
    abschluesse = 0;
    gebuehren = 0;
  }

  @Override
  public void jahresAbschluss() {
    if (!studentenKonto) {
      super.abheben(KNT_FUEHRUNGS_GEBUEHREN);
      bankKonto.einzahlen(KNT_FUEHRUNGS_GEBUEHREN);
    }
    jahresAbschluesse++;
    ueberpruefeKonto();
  }
}
