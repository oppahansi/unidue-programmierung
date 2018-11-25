/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Station {

  String name; // Bezeichnung der Station
  boolean huette; // true, falls H�tte vorhanden

  Lift[] lifte; // von Station AUSGEHENDE Lifte
  Piste[] pisten; // von Station AUSGEHENDE Pisten

  Station() {
    // bleibt leer
  }

  Station(String name, boolean huette) {
    // erzeuge ein Objekt der Klasse Station mit den �bergebenen Werten

    this.name = name;
    this.huette = huette;
  }

  public void setzeAusgehendeLifte(Lift[] lifte) {
    // setze die von der Station AUSGEHENDEN Lifte entsprechend des �bergebenen Arrays

    this.lifte = lifte;
  }

  public void setzeAusgehendePisten(Piste[] pisten) {
    // setze die von der Station AUSGEHENDEN Pisten entsprechend des �bergebenen Arrays

    this.pisten = pisten;
  }
}
