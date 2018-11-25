/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze
 */
package com.oppahansi.ws1415.miniprojekt4_A1;

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
    for (int i = 0; i < patienten.length; i++) {
      if (patienten[i] == null) { //freie Stelle gefunden
        p.setID(i + 1); //ID setzen
        patienten[i] = p; //Patient an Platz "verweisen"
        return true; //mit true beenden
      } //end of if
    }
    return false; //Kein freien Platz gefunden
  } //end proc

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
  public double stationsauslastung(Station s) { //Auslastung = (BELEGTE BETTEN-KAPAZIT�T)
    return ((double) ((s.kapazitaetG + s.kapazitaetP) - (s.freiG + s.freiP))
            / (s.kapazitaetG + s.kapazitaetP))
        * 100;
  } //end proc

  /*
   * Liefert den Namen und Vornamen des Patienten
   * zur�ck, der die l�ngste Aufenthalt aufweist
   */
  public String laengste_Aufenthalt() {
    Patient max = null; //max Wert
    for (Patient p : patienten) {
      if (p != null && max == null) {
        max = p; //Erste Person gefunden!
      }
      if (p != null && p.aufDauer >= max.aufDauer) {
        max = p; //Person war l�nger oder gleich lang im KH
      }
    } //end of for
    return (max == null)
        ? null
        : max.name + ' ' + max.vorname; //Keine Person gefunden dann null ansonsten Name + vorname
  } //end proc

  /*
   * Liefert die Kosten des �bergebenen Patienten zur�ck
   */
  public double berechnekosten(int ID) {
    Patient p = patienten[ID - 1]; //Patient
    float kostenmedi = 0.0f; //Kosten der Medikamente
    int kosten = 0; //andere Kosten
    if (p != null) { //Person vorhanden?
      kosten += (p.aufDauer * 120); //Pauschale pro Tag
      for (Diagnose d : p.diagnosen) //Diagnosen
      {
        if (d != null) {
          kosten += (d.laborU * 50); //50� pro Laboruntersuchen (je Diagnose unterschiedlich)
          kosten += (d.operations * 1200); //1200� pro OP (je Diagnose unterschiedlich)
          for (Medikament m : d.mediList) //geht alle Medikamente je Diagnose durch
          {
            if (m != null) {
              kostenmedi += m.preis; //Speichert Preis in extra Variable
            }
          }
        } //end of if d
      }
    } //end of if p
    return (kosten + kostenmedi); //Ausgabe!
  } //end proc
}
