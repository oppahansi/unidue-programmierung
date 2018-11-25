/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Tthe K.
 */
package com.oppahansi.ws1415.miniprojekt4_A2;

public class Krankenhaus {

  Patient[] patienten;
  Station[] stationen;
  int max;

  /*
   * Krankenhaus hat insgesamt max Betten
   */
  public Krankenhaus(String name, int max) {
    this.max = max;
    patienten = new Patient[max];
  }

  /*
   * Aufnahme eines neuen Patienten im Krankenhaus
   */
  public boolean neuerPatient(Patient p) {
    //Aufgabe 6
    if (p != null) {

      int i = 0;
      while (patienten[i] != null) { // && i < this.max){
        i++;

        if (i + 1 > this.max) {
          return false;
        }
      }

      patienten[i] = p; //Reihenfolge wichtig
      patienten[i].setID(i + 1);

      return true;
    }
    return false;
  }

  /*
   * Gibt s�mtliche Patientendat aus
   */
  public void ausgabe() {
    int counter = 0;
    while (patienten[counter] != null) {
      patienten[counter].ausgabe();
      counter++;
    }
  }

  /*
   * Liefert die Auslastung der Station s zur�ck
   */
  public double stationsauslastung(Station s) {
    //Aufgabe 7

    double gesamtKap = s.kapazitaetG + s.kapazitaetP;
    double gesamtFrei = s.freiG + s.freiP;
    double gesamtBel = gesamtKap - gesamtFrei;

    return (gesamtBel / gesamtKap) * 100;
  }

  /*
   * Liefert den Namen und Vornamen des Patienten
   * zur�ck, der die l�ngste Aufenthalt aufweist
   */
  public String laengste_Aufenthalt() {
    //Aufgabe 8

    int dauer = 0;

    for (int i = 0; i < patienten.length; i++) {
      if (patienten[i] != null) {
        if (dauer <= patienten[i].aufDauer) {
          dauer = patienten[i].aufDauer;
        }
      }
    }
    for (int i = 0; i < patienten.length; i++) {
      if (patienten[i].aufDauer == dauer) {

        return patienten[i].name + " " + patienten[i].vorname;
      }
    }
    return "";
  }

  /*
   * Liefert die Kosten des �bergebenen Patienten zur�ck
   */
  public double berechnekosten(int ID) {
    //Aufgabe 9

    for (int i = 0; i < patienten.length; i++) {
      if (patienten[i].getid() == ID) {
        Patient p = patienten[i];

        if (p == null) {
          return 0;
        } else {
          double kosten = p.aufDauer * 120;
          for (int j = 0; j < p.getDiagnosen().length; j++) {
            if (p.getDiagnosen()[j] != null) {
              kosten += p.getDiagnosen()[j].getLaborU() * 50;
              kosten += p.getDiagnosen()[j].getOperations() * 1200;

              for (int q = 0; q < p.diagnosen[j].getMediList().length; q++) {
                if (p.diagnosen[j].getMediList()[q] != null) {
                  kosten += p.diagnosen[j].getMediList()[q].getPreis();
                }
              }
            }
          }
          return kosten;
        }
      }
    }
    return 0.0;
  }
}
