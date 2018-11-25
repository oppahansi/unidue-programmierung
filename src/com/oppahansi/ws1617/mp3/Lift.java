/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Lift {

  String name; // Bezeichnung des Lifts
  int laenge; // in Metern
  int hdiff; // H�hendifferenz (positive Zahl falls aufw�rts, negative Zahl falls abw�rts)
  int punkte; // f�r Liftbenutzung
  boolean status; // offen (true) oder geschlossen (false)

  Station ziel; // wohin f�hrt der Lift?

  Lift() {
    // bleibt leer
  }

  public Lift(String name, int punkte, int laenge, int hdiff, boolean status, Station ziel) {
    // erzeuge ein Objekt der Klasse Lift mit den �bergebenen Werten

    this.name = name;
    this.laenge = laenge;
    this.hdiff = hdiff;
    this.punkte = punkte;
    this.status = status;
    this.ziel = ziel;
  }
}
