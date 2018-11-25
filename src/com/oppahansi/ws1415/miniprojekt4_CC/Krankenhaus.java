/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Krankenhaus {

  private Patient[] patienten;
  private Station[] stationen;
  private int maxBetten;

  public Krankenhaus(String name, int maxBetten) {
    this.maxBetten = maxBetten;
    patienten = new Patient[maxBetten];
  }

  public boolean nehmeNeuenPatientAuf(Patient patient) {
    /* wieos boolean? */
    return false;
  }

  public void patientenInfoAusgabe() {
    int zeahler = 0;
    while (patienten[zeahler] != null) {
      patienten[zeahler].patientenInfoAusgabe();
      zeahler++;
    }
  }

  public void setStationen(Station[] stationen) {
    this.stationen = stationen;
  }

  public double getStationsAuslastung(Station station) {
    return 0.0;
  }

  public String getPatientenMitLaengstemAufenthalt() {
    return "";
  }

  public double getKostenFuerPatientenID(int patientenID) {
    return 0.0;
  }

  public Patient getPatienten(int patientenIndex) {
    return patienten[patientenIndex];
  }

  public Station getStation(int stationIndex) {
    return stationen[stationIndex];
  }
}
