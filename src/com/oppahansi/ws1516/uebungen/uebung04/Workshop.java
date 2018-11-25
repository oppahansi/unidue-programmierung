/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung04;
/*
 * In dieser Aufgabe soll das Zusammenspiel von allen Ihnen bislang bekannten
 * Komponenten geuebt werden. Das umfasst Objekte, Kontrollstrukturen (if, for)
 * und Arrays.
 * Diese von Ihnen zu implementierende Klasse soll eine Werkstatt simulieren.
 * Die Ihnen bereits aus der Aufgabe FavouriteCar bekannte Klasse Car findet
 * hier ebenfalls Verwendung, soll aber nicht weiter bearbeitet werden. Die
 * Werkstatt hat eine begrenzte Zahl Plaetze fuer Autos. Die Plaetze sind mit
 * dem Array cars gegeben.
 */

/*
 * ALLGEMEINE HINWEISE:
 * - Machen Sie Sich mit der Klasse Car vertraut, damit Sie diese Aufgabe loesen
 *   koennen.
 * - Objektvariablen koennen auf null geprueft und gesetzt werden um festzu-
 *   stellen, ob eine Variable tatsaechlich auf ein Objekt verweist, bzw. um
 *   eine Objektvariable auf kein Objekt mehr zeigen zu lassen.
 * - Es ist moeglicherweise notwendig der Klasse Workshop weitere Felder
 *   hinzuzufuegen, um die Aufgabe korrekt loesen zu koennen. Sie koennen dieser
 *   Klasse soviele Felder beliebigen Typs hinzufuegen, wie Sie wollen.
 */

/*
 * DESIGN:
 * Waehrend der Implementierung wird Ihnen moeglicherweise auffallen, dass das
 * vorgegebene Design der Klassen Car und Workshop Probleme erzeugt. Ueberlegen
 * Sie, welche Schwaechen das Design hat und wie das Design verbessert werden
 * koennte.
 */

public class Workshop {

  private double money;
  private Car[] cars;
  private double[] repCosts;
  private int repairedCarsPerDay;

  // Im Konstruktor muessen die Plaetze fuer Autos, das Array cars,
  // initialisiert werden.
  // Der Parameter capacity gibt an, wieviele Autos die Werkstatt fassen soll.
  // Der Parameter speed soll angeben, wieviele Autos am Tag die Werkstatt
  // reparieren kann (siehe repairedCarsPerDay).
  // Das Geld der Werkstatt soll zu Beginn 1000 betragen.
  public Workshop(int capacity, int speed) {
    this.cars = new Car[capacity];
    this.repairedCarsPerDay = speed;
    this.money = 1000;
    this.repCosts = new double[capacity];
  }

  public static void main(String[] args) {
    // Main-Methode geschrieben von Oppa Hansi.

    //Hilfsvariablen für die Übersicht
    int capacityWs = 5;
    int speedWs = 5;

    int capacityWs2 = 4;
    int speedWs2 = 2;

    // Anlegen von zwei Werkstätten.
    Workshop ws = new Workshop(capacityWs, speedWs);
    Workshop ws2 = new Workshop(capacityWs2, speedWs2);

    // Anlegen neuer Car-Objekte für die Werkstatt ws.
    Car c0 = new Car();
    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = new Car();
    Car c4 = new Car();

    // Anlegen neuer Car-Objekte für die Werkstatt ws2.
    Car d0 = new Car();
    Car d1 = new Car();
    Car d2 = new Car();
    Car d3 = new Car();

    // Die value-Variablen der Autos neu setzen. Geldwerte verändern.
    // Jeweils nur 4 und 3, da der Standartwert bei 1000 liegt.
    c1.setValue(1100);
    c2.setValue(1400);
    c3.setValue(1600);
    c4.setValue(1800);

    d1.setValue(1100);
    d2.setValue(1400);
    d3.setValue(1600);

    // Hier erleiden die Autos den Schaden. isDamaged(); gibt true zurück!
    c0.crash();
    c1.crash();
    c3.crash();
    c4.crash();

    d0.crash();
    d1.crash();
    d3.crash();

    // Testaufruf der acceptCar()-Methode

    System.out.println("Die Werte der acceptCar()-Methode, deine Ergebnisse:");
    System.out.println("c0: " + ws.acceptCar(c0));
    System.out.println("c1: " + ws.acceptCar(c1));
    System.out.println("c2: " + ws.acceptCar(c2));
    System.out.println("c3: " + ws.acceptCar(c3));
    System.out.println("c4: " + ws.acceptCar(c4));
    System.out.println();
    System.out.println("d0: " + ws2.acceptCar(d0));
    System.out.println("d1: " + ws2.acceptCar(d1));
    System.out.println("d2: " + ws2.acceptCar(d2));
    System.out.println("d3: " + ws2.acceptCar(d3));
    System.out.println();
    System.out.println("Die erwarteten Werte der acceptCar()-Methode:");
    System.out.println("c0: true");
    System.out.println("c1: true");
    System.out.println("c2: false");
    System.out.println("c3: true");
    System.out.println("c4: true");
    System.out.println();
    System.out.println("d0: true");
    System.out.println("d1: true");
    System.out.println("d2: false");
    System.out.println("d3: true");
    System.out.println();

    // Aufruf der nextDay()-Methode - Wir lassen einen Tag vergehen,
    // Werkstatt 1 hat 5 Autos reparieren, Werkstatt 2 nur 2 pro Tag.
    ws.nextDay();
    ws2.nextDay();

    // Testen der repCosts[] für die Autos, die nach einem Tag repariert wurden.
    System.out.println(
        "Die Kosten für die Reparaturen von der ersten Werkstatt, deine Ergebnisse:");
    System.out.println("1. Stelle im ws.repCosts[0]: " + ws.getRepCosts()[0]);
    System.out.println("2. Stelle im ws.repCosts[1]: " + ws.getRepCosts()[1]);
    System.out.println("3. Stelle im ws.repCosts[2]: " + ws.getRepCosts()[2]);
    System.out.println("4. Stelle im ws.repCosts[3]: " + ws.getRepCosts()[3]);
    System.out.println("5. Stelle im ws.repCosts[4]: " + ws.getRepCosts()[4]);
    System.out.println();
    System.out.println("Die erwarteten Kosten für die Reparaturen in ws:");
    System.out.println("1. Stelle im ws.repCosts[0]: 500");
    System.out.println("2. Stelle im ws.repCosts[1]: 550");
    System.out.println("3. Stelle im ws.repCosts[2]: 800");
    System.out.println("4. Stelle im ws.repCosts[3]: 900");
    System.out.println("5. Stelle im ws.repCosts[4]: 0");
    System.out.println();
    System.out.println(
        "Die Kosten für die Reparaturen von der zweiten Werkstatt, deine Ergebnisse:");
    System.out.println("1. Stelle im ws2.repCosts[0]: " + ws2.getRepCosts()[0]);
    System.out.println("2. Stelle im ws2.repCosts[1]: " + ws2.getRepCosts()[1]);
    System.out.println("3. Stelle im ws2.repCosts[2]: " + ws2.getRepCosts()[2]);
    System.out.println("4. Stelle im ws2.repCosts[3]: " + ws2.getRepCosts()[3]);
    System.out.println();
    System.out.println("Die erwarteten Kosten für die Reparaturen in ws2:");
    System.out.println("1. Stelle im ws2.repCosts[0]: 500");
    System.out.println("2. Stelle im ws2.repCosts[1]: 550");
    System.out.println("3. Stelle im ws2.repCosts[2]: 0");
    System.out.println("4. Stelle im ws2.repCosts[3]: 0");
    System.out.println();

    // retrieveCar()-Methode Testaufrufe / Testen der Werte
    System.out.println("Die Werte der retrieveCar()-Methode der ws, deine Ergebnisse:");
    System.out.println("retrieveCar(c0): " + ws.retrieveCar(c0));
    System.out.println("retrieveCar(c1): " + ws.retrieveCar(c1));
    System.out.println("retrieveCar(c2): " + ws.retrieveCar(c2));
    System.out.println("retrieveCar(c3): " + ws.retrieveCar(c3));
    System.out.println("retrieveCar(c4): " + ws.retrieveCar(c4));
    System.out.println();
    System.out.println("Die erwarteten Werte der retrieveCar()-Methode der ws:");
    System.out.println("retrieveCar(c0): 500");
    System.out.println("retrieveCar(c0): 550");
    System.out.println("retrieveCar(c0): 0");
    System.out.println("retrieveCar(c0): 800");
    System.out.println("retrieveCar(c0): 900");
    System.out.println();
    System.out.println("Die Werte der retrieveCar()-Methode der ws2, deine Ergebnisse:");
    System.out.println("retrieveCar(d0): " + ws2.retrieveCar(d0));
    System.out.println("retrieveCar(d1): " + ws2.retrieveCar(d1));
    System.out.println("retrieveCar(d2): " + ws2.retrieveCar(d2));
    System.out.println("retrieveCar(d3): " + ws2.retrieveCar(d3));
    System.out.println();
    System.out.println("Die erwarteten Werte der retrieveCar()-Methode der ws2:");
    System.out.println("retrieveCar(d0): 500");
    System.out.println("retrieveCar(d1): 550");
    System.out.println("retrieveCar(d2): 0");
    System.out.println("retrieveCar(d3): 0");
    System.out.println();

    // Ausgabe des Geldes der Werkstätten nach einem Tag:
    System.out.println("Geld der 1. Werkstatt, dein Ergebnis:");
    System.out.println("ws.getMoney(): " + ws.getMoney());
    System.out.println();
    System.out.println("Erwaretes Geld der 1. Werkstatt:");
    System.out.println("ws.getMoney(): 1550");
    System.out.println();
    System.out.println("Geld der 2. Werkstatt, dein Ergebnis:");
    System.out.println("ws2.getMoney(): " + ws2.getMoney());
    System.out.println();
    System.out.println("Erwaretes Geld der 2. Werkstatt:");
    System.out.println("ws2.getMoney(): 1210");
  }

  // Mittels dieser Methode sollen andere Objekte von aussen (zB Personen)
  // Autos der Werkstatt zur Reparatur ueberlassen. Die Werkstatt soll Autos
  // nur dann annehmen, wenn ein Platz in der Werkstatt frei ist und das Auto
  // tatsaechlich beschaedigt ist. Wird das Auto angenommen, muss es in einem
  // der freien Plaetze der Variable cars eingeordnet werden und die Methode
  // gibt true zurueck. Wird das Auto hingegen nicht angenommen, soll der
  // Rueckgabewert false sein und sonst nichts weiter passieren.
  public boolean acceptCar(Car car) {
    if (isAcceptableCar(car)) {
      checkInCar(car);
      return true;
    } else {
      return false;
    }
  }

  private boolean isAcceptableCar(Car car) {
    return car.isDamaged() && workshopHasAFreeSlot();
  }

  private boolean workshopHasAFreeSlot() {
    for (Car currentCar : cars) {
      if (currentCar == null) {
        return true;
      }
    }
    return false;
  }

  private void checkInCar(Car car) {
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] == null) {
        cars[i] = car;
        break;
      }
    }
  }

  // Diese Methode soll dafuer sorgen, dass in der Werkstatt ein Arbeitstag
  // vergeht und soviele Autos repariert werden, wie in dem Feld
  // repairedCarsPerDay vorgegeben ist. Die reparierten Autos sollen auf die
  // Anfrage isDamaged() false zurueckgeben. Beachten Sie, dass Sie sich die
  // Reparaturkosten, die Sie fuer die Methode retrieveCar(Car car)
  // benoetigen, irgendwie merken muessen.
  public void nextDay() {
    int startingSlot = getFirstUnrepairedSlot();

    if (startingSlot != -1) {
      for (int i = startingSlot; i < startingSlot + repairedCarsPerDay && i < cars.length; i++) {
        if (cars[i] != null && cars[i].isDamaged()) {
          repCosts[i] = cars[i].repair();
        }
      }
    }
  }

  private int getFirstUnrepairedSlot() {
    for (int i = 0; i < cars.length; i++) {
      if (cars[i].isDamaged()) {
        return i;
      }
    }
    return -1;
  }

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
  public double retrieveCar(Car car) {
    Car customerCar = getCarFromWorkshop(car);

    if ((customerCar == null) || (customerCar.isDamaged())) {
      return 0;
    } else {
      int carSlot = getCarSlot(car);
      if (carSlot != -1) {
        setMoney(getMoney() + repCosts[carSlot] / 5);
        removeCarFromWorkshop(car);
        return repCosts[carSlot];
      } else {
        return 0;
      }
    }
  }

  private Car getCarFromWorkshop(Car car) {
    for (Car currentCar : cars) {
      if (currentCar != null && currentCar.equals(car)) {
        return currentCar;
      }
    }
    return null;
  }

  private void removeCarFromWorkshop(Car car) {
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] != null && cars[i].equals(car)) {
        cars[i] = null;
        break;
      }
    }
  }

  private int getCarSlot(Car car) {
    for (int i = 0; i < cars.length; i++) {
      if (cars[i] != null && cars[i].equals(car)) {
        return i;
      }
    }
    return -1;
  }

  public double getMoney() {
    return money;
  }

  private void setMoney(double money) {
    this.money = money;
  }

  public double[] getRepCosts() {
    return repCosts;
  }
}
