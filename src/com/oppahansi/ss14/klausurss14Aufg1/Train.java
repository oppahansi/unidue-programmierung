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

public class Train {

  private Coach firstCoach;
  private Coach lastCoach;

  /*
   * Teilaufgabe a)
   *
   * Wie aendert sich die Liste von der Datenstruktur her,
   * wenn die append Methode ausgefuehrt wird?  ( 6 punkte )
   *
   * Im Falle, dass die Liste leer ist, wird der firstCoach und
   * der lastCoach  gleich dem einzufuegenden "coach" gesetzt und
   * die liste ist genau 1 element lang.
   * Im falle, dass die liste nicht leer ist, wird der einzufuegende
   * coach an das ende der liste eingefuegt und die liste wird um 1 element groesser.
   */

  public void append(Coach coach) {
    if (firstCoach == null) {
      firstCoach = coach = lastCoach;
    } else {
      Coach node = firstCoach;
      while (node.getNext() != null) {
        node = node.getNext();
      }
      node.setNext(coach);
    }
  }

  // Hilfsmethode um bestimmten Coach anhand einer Position zu kriegen
  public Coach getCoachAt(int index) {
    if (index >= 0) {
      Coach node = firstCoach;
      for (int curPos = 0; curPos < index && node != null; curPos++) {
        node = node.getNext();
      }
      return node;
    } else {
      return null;
    }
  }

  /*
   * Teilaufgabe b)
   *
   * Implementiere die getPassengers Methode so, dass sie die Anzahl aller
   * Passagiere vom Zug wiedergibt. ( 6 Punkte )
   */
  public int getPassengers() {
    int sum = 0;
    Coach node = firstCoach;
    while (node != null) {
      sum = sum + node.getPassengers();
      node = node.getNext();
    }
    return sum;
  }

  /*
   * Teilaufgabe c)
   *
   * Implementiere die split Methode so, dass sie den Zug abkoppelt und die Elemente
   * im train, die NACH der Variable position vorkommen, in einen zweiten Zug einfuegt
   * ( 12 punkte )
   */
  public void split(int position) {
    Train train = new Train();
    Coach node = firstCoach;
    int counter = 1;
    while (node != null && counter < position) {
      counter++;
      node = node.getNext();
    }
    Coach node1 = node;
    while (node1 != null) {
      train.append(node);
      node = node.getNext();
    }
  }

  /*
   * Teilaufgabe d)
   *
   * Zeichne den neuen Zug, der dadurch entstanden ist, vorher und nachher. ( 6 punkte )
   *
   * Hier muss ich erwaehnen, dass die train Klasse natuerlich eine main Methode hatte,
   * die 5 Elemente an den train angehaengt hat, man sollte hier einfach den Zustand
   * des trains VOR der Ausfuehrung der Methode split(2) zeichnen, und einmal nach der
   * Ausfuehrung der methode split(2), also der neue Zug fing einfach ab Element 3 an.
   * Vorher natuerlich einfach den Zug mit den 5 Elementen aufzeichnen.
   */

  /*
   * Teilaufgabe e)
   *
   * Wir haben ein int[] passengers array, das wir mit der Liste vergleichen sollen.
   * Hat das array mehr Zellen als die Liste, return false, hat die Liste in einem Waggon
   * weniger freien Platz (50 ist die Kapazitaet) als im array, return false. Sonst true .( 12 punkte )
   *
   * Hier muss ich vorbemerkt sagen, dass die folgende Loesung meine eigene ist und ich dafuer nur die Haelfte
   * der Punktzahl erhalten habe, sie ist also unkomplett der Professor war leider auch nicht in der Lage,
   * sie mir korrekt zu loesen, nutzt also meine Loesung als Denkanstoss, ne Komplettloesung hab ich hier
   * leider nicht, Programmierberatung etc. koennen weiterhelfen...
   */
  public boolean ListenAufgabe(int[] passengers) {
    if (size() * 50 - getPassengers() < getAllPassengers(passengers)) {
      return false;
    }

    for (int i = 0; i < passengers.length; i++) {
      Coach node = firstCoach;

      while (node != null) {
        int freeSpace = 50 - node.getPassengers();
        if (passengers[i] > freeSpace) {
          return false;
        }

        node = node.getNext();
      }
    }

    return true;
  }

  private int getAllPassengers(int[] passengers) {
    int sum = 0;

    for (int i = 0; i < passengers.length; i++) {
      sum += passengers[i];
    }

    return sum;
  }

  // Oppahansi's Vorschlag, anhand gegebener Aufgabenstellung
  public boolean listenAufgabe(int[] passengers) {
    Coach node = firstCoach;

    // 1. Bedingung -> Array hat mehr Zellen als der freie Plaetze im Zug
    if (size() * 50 - getPassengers() < passengers.length) {
      return false;
    }

    while (node != null) {
      // 2. Bedingung -> Ein Waggon hat weniger freie Plaetze als Array's Laenge/Groesse
      if (50 - node.getPassengers() < passengers.length) {
        return false;
      }
    }

    return true;
  }

  // Anzahl der Waggons im Zug.
  private int size() {
    Coach node = firstCoach;
    int size = 0;

    while (node != null) {
      size++;
      node = node.getNext();
    }

    return size;
  }
}
