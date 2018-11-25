/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Tthe K.
 */
package com.oppahansi.ws1415.miniprojekt4_A2;

public class Station {

  int stationsnummer, kapazitaetP, kapazitaetG;
  int freiP, freiG;

  String fachabteilung;

  /*
   * Konstruktor
   */
  public Station(int stationsnummer, String fachabteilung, int kapazitaetG, int kapazitaetP) {
    this.stationsnummer = stationsnummer;
    this.kapazitaetG = freiG = kapazitaetG;
    this.kapazitaetP = freiP = kapazitaetP;
    this.fachabteilung = fachabteilung;
  }

  //Getter
  int getfreiP() {
    return this.freiP;
  }

  int getfreiG() {
    return this.freiG;
  }

  int getKapazitaetP() {
    return this.kapazitaetP;
  }

  int getKapazitaetG() {
    return this.kapazitaetG;
  }

  /*
   * Aufnahme des �bergeben Patienten
   */

  public boolean aufnehmen(Patient p) {
    //Aufgabe 4
    if (p.getVersArt() == 'P') {
      if (freiP > 0) {
        freiP--;
        return true;
      } else {
        return false;
      }
    }
    if (p.getVersArt() == 'G') {
      if (freiG > 0) {
        freiG--;
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  /*
   * gibt Infos der Station aus
   */
  public void ausgabe() {
    System.out.println("Stationsnummer:            " + stationsnummer);
    System.out.println("Fachabteilung:             " + fachabteilung);
    System.out.println("#Betten fuer P:            " + freiP);
    System.out.println("#Betten fuer G:            " + freiG);
    System.out.println();
  }
}
