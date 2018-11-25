/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Station {

  private int stationsNummer;
  private int kapazitaetPrivat;
  private int kapazitaetGesetz;
  private int freiePlaetzePrivat;
  private int freuePlaetzeGesetz;
  private String fachabteilung;

  public Station(
      int stationsNummer, String fachabteilung, int kapazitaetGesetz, int kapazitaetPrivat) {
    this.stationsNummer = stationsNummer;
    this.kapazitaetGesetz = freuePlaetzeGesetz = kapazitaetGesetz;
    this.kapazitaetPrivat = freiePlaetzePrivat = kapazitaetPrivat;
    this.fachabteilung = fachabteilung;
  }

  /*
   * AUFGABE
   *
   * Aufnahme des �bergeben Patienten
   */
  public boolean neuenPatientenAufnehmen(Patient patient) {
    /* wieso boolean? */
    return false;
  }

  public int getFreiePlaetzePrivat() {
    return freiePlaetzePrivat;
  }

  public int getFreuePlaetzeGesetz() {
    return freuePlaetzeGesetz;
  }

  public int getKapazitaetP() {
    return kapazitaetPrivat;
  }

  public int getKapazitaetG() {
    return kapazitaetGesetz;
  }

  public void stationsInfoAusgabe() {
    System.out.println("Stationsnummer:            " + stationsNummer);
    System.out.println("Fachabteilung:             " + fachabteilung);
    System.out.println("#Betten fuer P:            " + freiePlaetzePrivat);
    System.out.println("#Betten fuer G:            " + freuePlaetzeGesetz);
    System.out.println();
  }
}
