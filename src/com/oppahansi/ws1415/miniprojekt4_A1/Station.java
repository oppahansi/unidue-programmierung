/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze
 */
package com.oppahansi.ws1415.miniprojekt4_A1;

public class Station {

  int stationsnummer, kapazitaetP, kapazitaetG;
  int freiP, freiG;

  String fachabteilung;

  /*
   * Konstruktor
   */
  public Station(int stationsnummer, String fachabteilung, int kapazitaetG, int kapazitaetP) {
    this.stationsnummer = stationsnummer; //Selbsterkl�rend?
    this.kapazitaetG = freiG = kapazitaetG;
    this.kapazitaetP = freiP = kapazitaetP;
    this.fachabteilung = fachabteilung;
  } //end proc

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

  public boolean aufnehmen(
      Patient
          p) { //Scheinbar sollen auch Leute ohne Versicherung aufgenommen werden! Deshalb pr�fen auf ungleich!
    if ((p.versArt != 'P')
        && (this.freiG > 0)) { //Falls Patient nicht Privat und Betten f�r Gesetzliche frei dann
      this.freiG--; //vermindere freie
      return true; //und gebe wahr zur�ck
    }
    if ((p.versArt != 'G') && (this.freiP > 0)) { //s.o.
      this.freiP--;
      return true;
    }
    return false;
  } //end proc
  //Scheinbar ist es besser keine Versicherung zu haben:D Sollten alle "G" Betten besetzt sein so...
  //bekommt man kein Bett... Als Vers.-loser schon :D. Naja Jack wollte es so haben

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
