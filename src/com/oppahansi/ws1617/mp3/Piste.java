/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Piste {

  String name; // Bezeichnung der Piste
  int laenge; // in Metern
  int hdiff; // H�hendifferenz (positive Zahl falls aufw�rts, negative Zahl falls abw�rts)
  char farbe; // b)lau, r)ot oder s)chwarz
  boolean status; // offen (true) oder gesperrt (false)

  Station ziel; // wohin f�hrt die Piste?

  Piste() {
    // bleibt leer
  }

  public Piste(String name, char farbe, int laenge, int hdiff, boolean status, Station ziel) {
    // erzeuge ein Objekt der Klasse Piste mit den �bergebenen Werten

    this.name = name;
    this.laenge = laenge;
    this.hdiff = hdiff;
    this.farbe = farbe;
    this.status = status;
    this.ziel = ziel;
  }
}
