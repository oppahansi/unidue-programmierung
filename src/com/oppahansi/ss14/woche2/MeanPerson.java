package com.oppahansi.ss14.woche2;

/*
 * ACHTUNG:
 * Sollten FEHLERMELDUNGEN bezueglich einer nicht vorhandenen Klasse Car
 * auftauchen, liegt das vermutlich daran, dass die Datei Car.java aus der
 * Aufgabe in JACK nicht korrekt integriert haben. Laden Sie dazu die Datei
 * Car.java runter und integrieren Sie diese mittels des Dialogs
 * Rechtsklick auf ihr Javaprojekt->Import...  ->  General->Filesystem
 * bzw
 * Rechtsklick auf ihr Javaprojekt->Import...  ->  Allgemein->Dateisystem
 * Suchen Sie in diesem Dialog die von Ihnen runtergeladene Datei, machen Sie
 * ein H�ckchen davor und bestaetigen Sie den Dialog.
 */

/*
 * In dieser Aufgabe geht es darum mit verschachtelten Objekten zu arbeiten.
 * Die markierten Methoden der Klasse MeanPerson sollen von Ihnen implementiert
 * werden.
 * Die Loesung dieser Aufgabe erfordert die Kenntnis und Verwendung der
 * Klasse Car. Die Klasse Car soll jedoch NICHT bearbeitet werden.
 * Die Implementierungen der Klasse Car geben Ihnen vielleicht auch Ideen zur
 * Implementierung der Klasse MeanPerson.
 *
 * Hinweis: Beruecksichtigen Sie Faelle in denen eine Person keinen Freund
 * oder kein Auto hat.
 */

public class MeanPerson {

  private Car favouriteCar; // Lieblingsauto der Person
  private Car ownedCar; // Eigenes Auto der Person
  private MeanPerson friend; // "Freund" der Person
  private int money; // Kontostand der Person in Euro

  /*
   * Hier BEGINNT der zu bearbeitende Bereich
   */

  /*
   * Ergaenzen Sie den Konstruktor so, dass eine neue Person 10.000 Euro
   * besitzt. Sollte es Ihnen notwendig oder geschickt erscheinen, koennen
   * Sie auch weitere Initialisierungen im Konstruktor vornehmen.
   */
  public MeanPerson() {
    this.money = 10000;
  }

  // Testen Sie hier ob ihre Methoden wie gewuenscht funktionieren!
  public static void main(String[] args) {
    MeanPerson person = new MeanPerson();
    MeanPerson friend = new MeanPerson();
    Car car1 = new Car();
    Car car2 = new Car();
  }

  /*
   *  Diese Methode soll einen String zuruegeben, der Hersteller und Modell
   *  des eigenen Autos in der folgenden Form zurueck gibt:
   *               "Hersteller Modell"
   * Ist zB der Hersteller "Ludolf" und das Modell "Rostlaube 500" so soll die
   * Ausgabe "Ludolf Rostlaube 500" sein.
   */
  public String ownedCar() {
    return ownedCar.getManufacturer() + " " + ownedCar.getModel();
  }

  /*
   * Diese Methode soll, analog zur Methode ownedCar, einen String
   * zurueckgeben, der Hersteller und Namen des Lieblingsautos enthaelt.
   */
  public String favouriteCar() {
    return favouriteCar.getManufacturer() + " " + favouriteCar.getModel();
  }

  /*
   * Diese Methode soll, analog zu den Methoden ownedCar und favouriteCar,
   * einen String zurueckgeben, der Hersteller und Namen des Autos des
   * Freundes enthaelt.
   */
  public String friendsCar() {
    return friend.getOwnedCar().getManufacturer() + " " + friend.getOwnedCar().getModel();
  }

  /*
   * Diese Methode soll wahr(true) zurueck geben, wenn die Person gluecklich
   * ist, sonst falsch(false).
   * Die Person ist genau dann gluecklich, wenn Sie ihr Lieblingsauto besitzt
   * und dieses nicht beschaedigt ist.
   */
  public boolean isHappy() {
    if ((ownedCar.equals(favouriteCar)) && (ownedCar.isDamaged() == false)) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * Diese Methode soll wahr(true) zurueck geben, wenn die Person neidisch auf
   * ihren Freund ist, sonst falsch(false).
   * Die Person ist genau dann neidisch auf ihren Freund, wenn
   * der Freund ein wertvolleres Auto hat.
   * Hat die Person jedoch ihr Lieblingsauto und dieses ist unbeschaedigt, ist
   * sie auf keinen Fall neidisch.
   * (HINWEIS: Die letzte Bedingung taucht woanders schon auf!)
   */
  public boolean isEnvious() {
    if (isHappy()) {
      return false;
    } else if (ownedCar.getValue() < friend.ownedCar.getValue()) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * Diese Methode soll wahr(true) zurueck geben, wenn sich die Person
   * insgeheim ueber das Auto des Freundes kaputt lacht, sonst falsch(false).
   * Die Person lacht sich genau dann ueber das Auto des Freundes kaputt,
   * wenn das Auto des Freundes beschaedigt ist, oder der Hersteller des Autos
   * die Firma "Ludolf" ist.
   * (HINWEIS: Zur Loesung dieser Aufgabe benoetigen Sie die
   * Java-Standardmethode compareTo der Klasse String. Googeln Sie nach
   * "java string compareto", falls Sie die Methode nicht schon kennen
   */
  public boolean secretlyLaughsOverFriendsCar() {
    if ((friend.ownedCar.isDamaged() == true)
        || ((friend.ownedCar.getManufacturer().compareTo("Ludolf")) == 0)) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * In dieser Methode soll die Person ihr Auto reparieren.
   * Die Kosten der Reparatur sollen vom Geld der Person abgezogen werden.
   */
  public void repairCar() {
    money -= ownedCar.repair();
  }

  /*
   * Hier ENDET der zu bearbeitende Bereich
   */

  // Getter und Setter fuer die Klasse Person.
  // Die Getter und Setter sind bereits vollstaendig implementiert
  // und sollen fuer die Aufgabe NICHT veraendert werden!

  /*
   * Mit dieser Methode soll die Person ein neues, als Parameter uebergebenes
   * Auto erweben. Falls die Person ein altes Auto hat, wird dieses fuer den
   * aktuellen Wert in Zahlung gegeben. Sollte die Person ihr Konto fuer den
   * Handel ueberziehen muessen, darf der Handel nicht stattfinden und die
   * Person behaelt ihr altes Auto. Findet der Handel statt, soll das als
   * Parameter uebergebene Auto das neue ownedCar sein.
   */
  public void buyNewCar(Car newCar) {
    if ((money + ownedCar.getValue()) < newCar.getValue()) {
      return;
    } else {
      money = money + ownedCar.getValue() - newCar.getValue();
      ownedCar = newCar;
    }
  }

  public Car getFavouriteCar() {
    return favouriteCar;
  }

  public void setFavouriteCar(Car newFavouriteCar) {
    favouriteCar = newFavouriteCar;
  }

  public Car getOwnedCar() {
    return ownedCar;
  }

  public void setOwnedCar(Car newOwnedCar) {
    ownedCar = newOwnedCar;
  }

  public MeanPerson getFriend() {
    return friend;
  }

  public void setFriend(MeanPerson newFriend) {
    friend = newFriend;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int newMoney) {
    money = newMoney;
  }
}
