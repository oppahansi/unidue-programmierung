/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze.
 */
package com.oppahansi.ws1415.miniprojekt3;

// Implementierung der Aufgaben von Mark Kunze (c)
public class Zutat_A2 {

  public Lebensmittel lebensmittel;
  public double menge; // Menge in g
  public Zutat_A2 nachfolger;

  public Zutat_A2(Lebensmittel lebensmittel, double menge) {
    super();
    this.lebensmittel = lebensmittel;
    this.menge = menge;
  }

  // Aufgabe
  public double getKcal() {
    return this.getFgehalt()
        + this.getKgehalt()
        + this.getPgehalt(); //gesamtkaloriengehalt der Zutat
  }

  public double getPgehalt() {
    return lebensmittel.protein * 4.1 * menge / 100; //Kaloriengehalt des Protein
  }

  public double getKgehalt() {
    return lebensmittel.kohlenhydrat * 4.1 * menge / 100; //Kaloriengehalt der Kohlenhydrate
  }

  public double getFgehalt() {
    return lebensmittel.fett * 9.3 * menge / 100; //Kaloriengehalt des Fett
  }
}
