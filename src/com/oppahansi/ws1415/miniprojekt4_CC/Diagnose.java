/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Diagnose {

  private int laborUntersuchungen;
  private int operationen;
  private String diagnose;
  private String diagnoseArzt;
  private Medikament[] medikamente;

  public Diagnose(String diagnose, String diagnoseArzt, int laborUntersuchungen, int operationen) {
    this.diagnose = diagnose;
    this.diagnoseArzt = diagnoseArzt;
    this.laborUntersuchungen = laborUntersuchungen;
    this.operationen = operationen;
    this.medikamente = new Medikament[20];
  }

  public String getDiagnose() {
    return diagnose;
  }

  public String getDiagnoseArzt() {
    return diagnoseArzt;
  }

  public int getLaborUntersuchungen() {
    return laborUntersuchungen;
  }

  public int getOperationen() {
    return operationen;
  }

  public Medikament[] getMedikamente() {
    return medikamente;
  }

  public void fuegeMedikamentHinzu(Medikament medikament) {
    int zaehler = 0;
    if (medikament == null) {
      return;
    }
    while (medikamente[zaehler] != null) {
      zaehler++;
    }
    medikamente[zaehler] = medikament;
  }

  public void diagnosenInfoAusgabe() {
    System.out.println("                           Diagnoseschluessel:        " + diagnose);
    System.out.println("                           Diagnosearzt:              " + diagnoseArzt);
    System.out.println(
        "                           Laboruntersuchungen:       " + laborUntersuchungen);
    System.out.println("                           Chirurgische Eingriffe:    " + operationen);
    System.out.println(
        "                                                      +------------------------+");
    System.out.println(
        "                                                      |       Medikamente      |");
    System.out.println(
        "                                                      +------------------------+");
    for (int i = 0; i < medikamente.length; i++) {
      if (medikamente[i] != null) {
        System.out.println(
            "                                                      " + medikamente[i]);
      }
    }
  }
}
