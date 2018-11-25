package com.oppahansi.ss14.extra;

public class Sleigh {

  private Trailer head;

  //AUFGABE 1: Alle Geschenke so verteilen, dass vorderen Schlitten maximal beladen sind

  public static void main(String[] args) {
    final Trailer trailer1 = new Trailer("Rudolfs Roter Raser", 20, 5);
    final Trailer trailer2 = new Trailer("Santas Schlitten", 20, 20);
    final Trailer trailer3 = new Trailer("Wichtelwaggon", 20, 10);
    final Trailer trailer4 = new Trailer("Weihnachtswagen", 20, 20);
    final Trailer trailer5 = new Trailer("Christkind-Karre", 20, 10);

    final Sleigh sleigh = new Sleigh();
    sleigh.head = trailer1;
    trailer1.setNext(trailer2);
    trailer2.setNext(trailer3);
    trailer3.setNext(trailer4);
    trailer4.setNext(trailer5);

    System.out.println(sleigh);

    sleigh.sortGiftsToFront();
    System.out.println("\nGeschenke wurden sortiert (Aufgabe 1):");
    System.out.println(sleigh);

    sleigh.removeEmptyTrailers();
    System.out.println("\nLeere Waggons wurden entfernt (Aufgabe 2):");
    System.out.println(sleigh);

    System.out.println("\n--------------- Weiterer Testfall für Aufgabe 2 ---------------");
    final Sleigh sleigh2 = new Sleigh();
    final Trailer t1 = new Trailer("#1", 40, 0);
    final Trailer t2 = new Trailer("#2", 40, 10);
    final Trailer t3 = new Trailer("#3", 40, 0);
    final Trailer t4 = new Trailer("#4", 40, 15);
    final Trailer t5 = new Trailer("#5", 40, 0);
    sleigh2.head = t1;
    t1.setNext(t2);
    t2.setNext(t3);
    t3.setNext(t4);
    t4.setNext(t5);

    System.out.println(sleigh2);
    sleigh2.removeEmptyTrailers();
    System.out.println("\nLeere Waggons wurden entfernt (Aufgabe 2):");
    System.out.println(sleigh2);
  }

  public void sortGiftsToFront() {

    //Knoten definieren, der am Listenanfang beginnt
    //Zaehlvariable definieren, die erst einmal alle vorhandenen Geschenke zaehlt

    Trailer knoten = head;
    int geschenke = 0; //Summe aller Geschenke

    //Alle Schlitten durchgehen, Anzahl der Geschenke zaehlen und in der Zaehlvariable speichern
    //Sobald alle Geschenke eines Schlittens gezahelt sind, werden alle Geschenke des Schlittens auf 0 gesetzt

    while (knoten != null) {

      geschenke = geschenke + knoten.getGifts();
      knoten.setGifts(0);

      knoten = knoten.getNext();
    }

    //Knoten wieder an Beginn der Liste setzen (nach der vorherigen while-Schleife, befindet sich "knoten"
    //derzeit auf Position "null"

    knoten = head;

    //Zweite while-Schleife, die wieder vorne beim ersten Schlitten beginnt
    //Sofern die vorhandenen Schlittenkapazitaeten kleiner als die Gesamtzahl der Geschenke sind
    //wird der Schlitten voll beladen
    //Zaehlvariable f�r vorhandene Geschenke wird danach verkleinert (abzueglich der bepackten Geschenke)

    while (knoten != null) {

      if (knoten.getCapacity() <= geschenke) {
        knoten.setGifts(knoten.getCapacity());
        geschenke = geschenke - knoten.getCapacity();
      }

      //Sind die vorhandenen Kapazitaeten groesser als Gesamtzahl der verfuegbaren Geschenke,
      //werden die restlichen Geschenke verladen
      //Anschliessend wird unsere Geschenke-Variable = 0 gesetzt, da keine Geschenke mehr auf Lager sind.

      else {
        knoten.setGifts(geschenke);
        geschenke = 0;
      }

      //Nachdem if oder else-Kriterium erf�llt wurde, wechseln wir in den naechsten Schlitten.
      //Schleife laeuft, bis wir am Ende der Liste angekommen sind (== null)

      knoten = knoten.getNext();
    }
  }

  public void removeEmptyTrailers() {

    Trailer node = head;

    while (node != null) {
      if (node.getGifts() == 0 && node.equals(head)) {
        head = head.getNext();
        node = head;
        continue;
      } else if (node.getGifts() == 0) {

      }
    }
  }

  @Override
  public String toString() {
    if (head == null) {
      return "Leerer Schlitten";
    } else {
      return head.toString();
    }
  }
}
