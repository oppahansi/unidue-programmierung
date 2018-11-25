package com.oppahansi.ss14.woche8;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Diese Implementierung soll die Verwendung des Interfaces Comparable zeigen.
 * Dazu steht in der Klassendeklaration der Zusatz "implements Comparable".
 * Durch diesem Zusatz weiss Java, dass die Klasse die Methoden, die durch das
 * Interface Comparable gegeben sind, implementiert.
 * Im Falle des Interfaces Comparable ist das genau eine Methode, naemlich
 * compareTo(Object o).
 * Wenn Sie einer Klasse durch das Schluesselwort "implements" Interfaces
 * hinzufuegen (eine Klasse kann auch mehr als ein Interface implementieren),
 * erscheint, solange nicht alle geforderten Methodenkoepfe zu finden sind, eine
 * rote Fehlermarkierung unter dem Klassennamen. Wenn Sie in Eclipse die Maus
 * darueber halten, haben Sie mittels "Add unimplemented methods" die einfache
 * Moeglichkeit die Koepfe aller fehlenden Methoden automatisch in Ihren Code
 * einzufuegen. Die Implementierung muessen Sie dann natuerlich immer noch
 * selbst vornehmen.
 */
public class Zahl implements Comparable {

  private int zahl;

  public Zahl(int zahl) {
    this.zahl = zahl;
  }

  public static void main(String[] args) {
    ArrayList<Zahl> zahlen = new ArrayList<Zahl>();
    zahlen.add(new Zahl(5));
    zahlen.add(new Zahl(27));
    zahlen.add(new Zahl(187));
    zahlen.add(new Zahl(33));
    zahlen.add(new Zahl(40));
    zahlen.add(new Zahl(1));
    // Liste ausgeben
    for (int i = 0; i < zahlen.size(); i++) {
      System.out.println(zahlen.get(i).getZahl());
    }
    System.out.println();
    // Liste sortieren und nochmal ausgeben
    Collections.sort(zahlen);
    for (int i = 0; i < zahlen.size(); i++) {
      System.out.println(zahlen.get(i).getZahl());
    }
  }

  public int getZahl() {
    return zahl;
  }

  public void setZahl(int zahl) {
    this.zahl = zahl;
  }

  /*
   * Hier ist die vom Interface geforderte Methode. Als Parameter wird ein
   * Objekt des Typs Object uebergeben. Da alle Klassen automatisch vom der
   * Klasse Object abgeleitet sind, kann diese Methode fuer beliebige
   * Klassen verwendet werden. Wir koennen davon ausgehen, dass wenn die
   * Methode auf einem Objekt der Klasse Zahl aufgerufen wird, das uebergebene
   * Objekt o auch vom Typ Zahl sein wird. Aus diesem Grund koennen wir Java
   * mit einem Typecast zusichern, dass o tatsaechlich vom Typ Zahl ist.
   * (Zahl)o ist genau dieser Typecast. Mit Hilfe einer weiteren Klammer
   * koennen wir dann auf die Methoden und Felder von o zugreifen:
   * ((Zahl)o).methode
   * Wenn unser aktuelles Objekt kleiner ist als das als Parameter
   * uebergebene Projekt, soll -1, wenn es groesser ist 1 und bei Gleichheit
   * 0 zurueckgegeben werden.
   */
  @Override
  public int compareTo(Object o) {
    if (this.zahl < ((Zahl) o).getZahl()) {
      return -1;
    } else if (this.zahl > ((Zahl) o).getZahl()) {
      return 1;
    } else {
      return 0;
    }
  }
}
