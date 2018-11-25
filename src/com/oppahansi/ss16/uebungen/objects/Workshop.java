/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.objects;
/*
 * In dieser Aufgabe soll das Zusammenspiel von allen Ihnen bislang bekannten Komponenten geuebt
 * werden. Das umfasst Objekte, Kontrollstrukturen (if, for) und Arrays. Diese von Ihnen zu
 * implementierende Klasse soll eine Werkstatt simulieren. Die Ihnen bereits aus der Aufgabe
 * FavouriteCar bekannte Klasse Car findet hier ebenfalls Verwendung, soll aber nicht weiter
 * bearbeitet werden. Die Werkstatt hat eine begrenzte Zahl Plaetze fuer Autos. Die Plaetze sind mit
 * dem Array cars gegeben.
 *
 * <p>ALLGEMEINE HINWEISE: - Machen Sie Sich mit der Klasse Car vertraut, damit Sie diese Aufgabe
 * loesen koennen. - Objektvariablen koennen auf null geprueft und gesetzt werden um festzu-
 * stellen, ob eine Variable tatsaechlich auf ein Objekt verweist, bzw. um eine Objektvariable auf
 * kein Objekt mehr zeigen zu lassen. - Es ist moeglicherweise notwendig der Klasse Workshop weitere
 * Felder hinzuzufuegen, um die Aufgabe korrekt loesen zu koennen. Sie koennen dieser Klasse soviele
 * Felder beliebigen Typs hinzufuegen, wie Sie wollen.
 */

/*
 * ALLGEMEINE HINWEISE: - Machen Sie Sich mit der Klasse Car vertraut, damit Sie diese Aufgabe
 * loesen koennen. - Objektvariablen koennen auf null geprueft und gesetzt werden um festzu-
 * stellen, ob eine Variable tatsaechlich auf ein Objekt verweist, bzw. um eine Objektvariable auf
 * kein Objekt mehr zeigen zu lassen. - Es ist moeglicherweise notwendig der Klasse Workshop weitere
 * Felder hinzuzufuegen, um die Aufgabe korrekt loesen zu koennen. Sie koennen dieser Klasse soviele
 * Felder beliebigen Typs hinzufuegen, wie Sie wollen.
 */

/*
 * DESIGN: Waehrend der Implementierung wird Ihnen moeglicherweise auffallen, dass das vorgegebene
 * Design der Klassen Car und Workshop Probleme erzeugt. Ueberlegen Sie, welche Schwaechen das
 * Design hat und wie das Design verbessert werden koennte.
 */
public class Workshop {

  public int money;
  public Car[] cars;
  public int repairedCarsPerDay;

  // Im Konstruktor muessen die Plaetze fuer Autos, das Array cars,
  // initialisiert werden.
  // Der Parameter capacity gibt an, wieviele Autos die Werkstatt fassen soll.
  // Der Parameter speed soll angeben, wieviele Autos am Tag die Werkstatt
  // reparieren kann (siehe repairedCarsPerDay).
  // Das Geld der Werkstatt soll zu Beginn 1000 betragen.
  public Workshop(int capacity, int speed) {}

  public static void main(String[] args) {
    // Hier kommt ihr Testcode hin
  }

  // Mittels dieser Methode sollen andere Objekte von aussen (zB Personen)
  // Autos der Werkstatt zur Reparatur ueberlassen. Die Werkstatt soll Autos
  // nur dann annehmen, wenn ein Platz in der Werkstatt frei ist und das Auto
  // tatsaechlich beschaedigt ist. Wird das Auto angenommen, muss es in einem
  // der freien Plaetze der Variable cars eingeordnet werden und die Methode
  // gibt true zurueck. Wird das Auto hingegen nicht angenommen, soll der
  // Rueckgabewert false sein und sonst nichts weiter passieren.
  public boolean acceptCar(Car car) {
    return false;
  }

  // Diese Methode soll dafuer sorgen, dass in der Werkstatt ein Arbeitstag
  // vergeht und soviele Autos repariert werden, wie in dem Feld
  // repairedCarsPerDay vorgegeben ist. Die reparierten Autos sollen auf die
  // Anfrage isDamaged() false zurueckgeben. Beachten Sie, dass Sie sich die
  // Reparaturkosten, die Sie fuer die Methode retrieveCar(Car car)
  // benoetigen, irgendwie merken muessen.
  public void nextDay() {}

  // Mittels dieser Methode soll ein in der Werkstatt untergebrachtes Auto
  // vom Aufrufer der Methode wieder abgeholt werden. Wenn das Auto bereits
  // repariert wurde, sollen drei Dinge geschehen:
  // - Das Auto soll aus der Autoliste cars entfernt werden.
  // - Das Geld der Werkstatt (money) soll um ein Fuenftel der Reparatur-
  //   kosten erhoeht werden.
  // - Der Rueckgabewert soll den vollen Reparaturkosten des Autos
  //   entsprechen (nicht dem Teilbetrag den die Werkstatt erhaelt).
  // Ist das Auto hingegen noch nicht repariert soll die Methode den Wert 0
  // zurueckgeben. Das Auto verbleibt weiter auf seinem Platz in der
  // Werkstatt.
  // Ist das geforderte Auto nicht in der Werkstatt soll auch 0 zurueck-
  // gegeben werden.
  public int retrieveCar(Car car) {
    return -1;
  }

  public int getMoney() {
    return money;
  }
}
