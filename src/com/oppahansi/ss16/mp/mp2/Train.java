/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

/* Loesung siehe WS1516 MP3 */
package com.oppahansi.ss16.mp.mp2;

public class Train {

  // Kann für die Ausgabe verwendet werden
  private static final String LOCOMOTIVE = "<___|o|";

  private Waggon head;

  public int getSize() {
    return -1;
  }

  public int getPassengerCount() {
    return -1;
  }

  public int getCapacity() {
    return -1;
  }

  public void appendWaggon(Waggon waggon) {}

  public void boardPassengers(int numberOfPassengers) {}

  public Train uncoupleWaggons(int index) {
    return new Train();
  }

  public void insertWaggon(Waggon waggon, int index) {}

  public void turnOver() {}

  public void removeWaggon(Waggon waggon) {}

  public Waggon getWaggonAt(int index) {
    return null;
  }

  @Override
  public String toString() {
    if (getSize() == 0) {
      return LOCOMOTIVE;
    }

    StringBuilder str = new StringBuilder(LOCOMOTIVE);

    Waggon pointer = head;
    while (pointer != null) {
      str.append(" <---> ");
      str.append(pointer.getName());
      pointer = pointer.getNext();
    }

    return str.toString();
  }
}
