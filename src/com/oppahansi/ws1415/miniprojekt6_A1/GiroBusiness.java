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

public class GiroBusiness extends GiroKonto {

  private final double KNT_FUEHRUNGS_GEBUEHREN = 20.0;
  private final double TAGES_KREDITZINS = 0.1;
  private final double GEB_ABHEBEN = 0.02;
  private final double GEB_ABHEBEN_MIN = 2.0;
  private final double GEB_UEBERW = 0.01;
  private final double GEB_UEBERW_MIN = 1.0;

  private double maxNeuerKontoStand;
  private double gebuehren;
  private double ueberweisungen;
  private double kreditZinsen;
  private double abschluesse;

  public GiroBusiness(int kontoNr, double kontoStand, Konto bankKonto) {
    super(kontoNr, kontoStand, bankKonto, kontoStand * 5.0);
    this.maxNeuerKontoStand = getKontoStand();
  }

  @Override
  public boolean einzahlen(double betrag) {
    double neuerKontoStand = getKontoStand() + betrag;
    if (this.maxNeuerKontoStand < neuerKontoStand) {
      this.maxNeuerKontoStand = neuerKontoStand;
      this.setKreditlimit(neuerKontoStand * 5.0);
    }
    return super.einzahlen(betrag);
  }

  @Override
  public boolean abheben(double betrag) {
    if (getKontoStand() + getKreditlimit() >= betrag + berechneAbhebeGebuehren(betrag)) {
      gebuehren += berechneAbhebeGebuehren(betrag);
      return super.abheben(betrag);
    } else {
      return false;
    }
  }

  private double berechneAbhebeGebuehren(double betrag) {
    return (betrag * GEB_ABHEBEN <= GEB_ABHEBEN_MIN) ? GEB_ABHEBEN_MIN : betrag * GEB_ABHEBEN;
  }

  @Override
  public boolean ueberweisenAuf(Konto ziel, double betrag) {
    if (ueberweisungen == 5) {
      ueberweisungen = 0;
      return getKontoStand() + getKreditlimit() >= betrag
          && super.abheben(betrag)
          && ziel.einzahlen(betrag);
    } else {
      if (getKontoStand() + getKreditlimit() >= betrag + berechneUeberwGebuehren(betrag)) {
        gebuehren += berechneUeberwGebuehren(betrag);
        ueberweisungen++;
        return super.abheben(betrag) && ziel.einzahlen(betrag);
      } else {
        return false;
      }
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
    super.abheben(KNT_FUEHRUNGS_GEBUEHREN);
    bankKonto.einzahlen(KNT_FUEHRUNGS_GEBUEHREN);
  }
}
