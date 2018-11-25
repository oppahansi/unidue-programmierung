/*
 * ANMERKUNG BITTE LESEN
 *
 * Diese Klausurloesungen wurden nicht von mir (oppahansi) erstellt,
 * sondern von einem Kommilitonen - Khoa Trinh -
 *
 * Falls ich hier einige Sachen im nachhinein veraendere, werde ich es
 * auch kommentieren!
 *
 * Ein Dankeschoen an Khoa Trinh.
 */

package com.oppahansi.ss14.klausurss14Aufg1;

public class Coach {

  private Coach next;
  private int passengers;

  public Coach getNext() {
    return next;
  }

  public void setNext(Coach next) {
    this.next = next;
  }

  public int getPassengers() {
    return passengers;
  }

  public void setPassengers(int passengers) {
    this.passengers = passengers;
  }
}
