/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

/* Loesung siehe WS1516 MP3 */
package com.oppahansi.ss16.mp.mp2;

public class Miniprojekt2 {

  public static void main(String[] args) {
    Train train = new Train();

    // Initialer Zug

    System.out.println(
        String.format(
            "Ein neuer Zug mit %d Waggon und %d von %d Passagieren.",
            train.getSize(), train.getPassengerCount(), train.getCapacity()));
    System.out.println(train.toString());

    Waggon waggon1 = new Waggon("Waggon-1", 40);
    Waggon waggon2 = new Waggon("Waggon-2", 30);
    Waggon waggon3 = new Waggon("Waggon-3", 20);
    Waggon waggon4 = new Waggon("Waggon-4", 20);

    // Wagen anhängen

    train.appendWaggon(waggon1);
    train.appendWaggon(waggon2);
    train.appendWaggon(waggon3);
    train.appendWaggon(waggon4);

    System.out.println(
        String.format(
            "Dem Zug wurden vier Waggons angehangen: %d Waggon und %d von %d Passagieren.",
            train.getSize(), train.getPassengerCount(), train.getCapacity()));

    System.out.println(train.toString());

    // Station Dortmund: Fahrgäste steigen ein

    final int passengersDortmund = 35;
    train.boardPassengers(passengersDortmund);

    System.out.println(
        String.format(
            "In Dortmund steigen %d Personen ein (aktuelle Auslastung: %d / %d).",
            passengersDortmund, train.getPassengerCount(), train.getCapacity()));

    printWaggonDetails(train);

    // Station Bochum: Fahrgäste steigen ein

    final int passengersBochum = 53;
    train.boardPassengers(passengersBochum);

    System.out.println(
        String.format(
            "In Bochum steigen %d Personen ein (aktuelle Auslastung: %d / %d).",
            passengersBochum, train.getPassengerCount(), train.getCapacity()));

    printWaggonDetails(train);

    // Station Essen: Fahrgäste steigen ein

    final int passengersEssen = 24;
    train.boardPassengers(passengersEssen);

    System.out.println(
        String.format(
            "In Essen steigen %d Personen ein (aktuelle Auslastung: %d / %d).",
            passengersEssen, train.getPassengerCount(), train.getCapacity()));

    printWaggonDetails(train);

    // Zugteilung
    Train train2 = train.uncoupleWaggons(2);

    System.out.println(train.toString());
    System.out.println(train2.toString());

    // Neue Wagen werden eingefügt

    final Waggon waggon5 = new Waggon("Waggon-5", 60);
    final Waggon waggon6 = new Waggon("Waggon-6", 35);
    train2.insertWaggon(waggon5, 0);
    train2.insertWaggon(waggon6, 2);

    printWaggonDetails(train2);

    // Zug 2 wird umgedreht

    train2.turnOver();
    System.out.println(train2.toString());

    // Waggons werden entfernt

    System.out.println("Waggon-6 wird entfernt.");
    train2.removeWaggon(waggon6);
    System.out.println(train2.toString());

    System.out.println("Der zweite Waggon wird entfernt.");
    final Waggon secondWaggon = train2.getWaggonAt(1);
    train2.removeWaggon(secondWaggon);
    System.out.println(train2.toString());
  }

  /* Hilfsmethode, die die Wagen mit Namen, aktueller Passagierzahl und Kapazität ausgibt */
  private static void printWaggonDetails(Train train) {
    StringBuilder str = new StringBuilder();

    str.append("Verteilung:");
    Waggon waggon = train.getWaggonAt(0);
    while (waggon != null) {
      str.append(
          String.format(
              " %s [%d / %d]", waggon.getName(), waggon.getPassengers(), waggon.getCapacity()));

      waggon = waggon.getNext();
    }

    System.out.println(str.toString());
  }
}
