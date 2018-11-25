/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.ifs;

public class Schaltjahr {

  /*
   * Diese Methode soll zurueckgeben, ob es sich bei dem gegebenen Jahr um ein Schaltjahr handelt.
   * Da die Erde fuer eine Umrundung der Sonne ca. 365 Tage 5 Stunden 49 Minuten 12 Sekunden
   * braucht, dauert ein Jahr nicht immer genau 365 Tage, sondern es gibt Schaltjahre mit 366 Tagen,
   * um diese Zeit auszugleichen. Jedes Jahr, welches durch 4 teilbar ist, ist ein Schaltjahr. Alle
   * 100 Jahre faellt ein Schaltjahr aus, also ist ein Jahr kein Schaltjahr, wenn es durch 100
   * teilbar ist. Alle 400 Jahre findet das Schaltjahr statt ohne auszufallen.
   *
   * <p>Beispiele: 2016 ist ein Schaltjahr. 2004 ist ein Schaltjahr. 2000 ist ein Schaltjahr. 2015
   * ist kein Schaltjahr. 2003 ist kein Schaltjahr. 1900 ist kein Schaltjahr.
   */
  public static boolean schaltjahr(int jahr) {
    if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
      return true;
    } else {
      return false;
    }

    // return jahr % 100 == 0 && (jahr % 100) % 4 == 0;  -  Kurze Variante.
  }

  //In der Main Methode kannst du eigene Testfaelle schreiben und testen.
  public static void main(String[] args) {
    System.out.println("2016 ist ein Schaltjahr: " + schaltjahr(2016) + " (true waere richtig)");
    System.out.println("2004 ist ein Schaltjahr: " + schaltjahr(2004) + " (true waere richtig)");
    System.out.println("2000 ist ein Schaltjahr: " + schaltjahr(2000) + " (true waere richtig)");
    System.out.println("2015 ist ein Schaltjahr: " + schaltjahr(2015) + " (false waere richtig)");
    System.out.println("2003 ist ein Schaltjahr: " + schaltjahr(2003) + " (false waere richtig)");
    System.out.println("1900 ist ein Schaltjahr: " + schaltjahr(1900) + " (false waere richtig)");
  }
}
