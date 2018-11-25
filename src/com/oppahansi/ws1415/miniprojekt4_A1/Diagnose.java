/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt4_A1;

public class Diagnose {

  String diagS;
  String diagA;
  int laborU;
  int operations;
  Medikament[] mediList;

  /*
   * Konstruktor
   */
  public Diagnose(String diagS, String diagA, int laborU, int operations) {
    this.diagS = diagS;
    this.diagA = diagA;
    this.laborU = laborU;
    this.operations = operations;
    this.mediList = new Medikament[20];
  }

  //Getter
  String getDiags() {
    return diagS;
  }

  String getDiagA() {
    return diagA;
  }

  int getLaborU() {
    return laborU;
  }

  int getOperations() {
    return operations;
  }

  Medikament[] getMediList() {
    return mediList;
  }

  /*
   * f�gt ein neues Medikament zur Liste der Medikamente hinzu
   */
  public void neuesMedikament(Medikament medi) {
    int counter = 0;
    if (medi == null) {
      return;
    }
    while (mediList[counter] != null) {
      counter++;
    }
    mediList[counter] = medi;
  }

  /*
   * gibt Infos der Diagnose aus
   */
  public void ausgabe() {
    System.out.println("                           Diagnoseschluessel:        " + diagS);
    System.out.println("                           Diagnosearzt:              " + diagA);
    System.out.println("                           Laboruntersuchungen:       " + laborU);
    System.out.println("                           Chirurgische Eingriffe:    " + operations);
    System.out.println(
        "                                                      +------------------------+");
    System.out.println(
        "                                                      |       Medikamente      |");
    System.out.println(
        "                                                      +------------------------+");
    for (int i = 0; i < mediList.length; i++) {
      if (mediList[i] != null) {
        System.out.println("                                                      " + mediList[i]);
      }
    }
  }
}
