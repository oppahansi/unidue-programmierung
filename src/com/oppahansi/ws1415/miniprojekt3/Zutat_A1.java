/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by oppahansi.
 */
package com.oppahansi.ws1415.miniprojekt3;

public class Zutat_A1 {

  // Aufgabe
  // Konstante hinzufuegen für kcal-Berechnungen pro 1g
  private final double FETTKCAL = 9.3;
  private final double KOHLENKCAL = 4.1;
  private final double PROTEINKCAL = 4.1;
  public Lebensmittel lebensmittel;
  public double menge; // Menge in g
  public Zutat_A1 nachfolger;

  public Zutat_A1(Lebensmittel lebensmittel, double menge) {
    super();
    this.lebensmittel = lebensmittel;
    this.menge = menge;
  }

  public double getKcal() {
    return this.getKcalProtein() + this.getKcalFett() + this.getKcalKohle();
  }

  public double getKcalProtein() {
    return (lebensmittel.protein * PROTEINKCAL) * (menge / 100);
  }

  public double getKcalKohle() {
    return (lebensmittel.kohlenhydrat * KOHLENKCAL) * (menge / 100);
  }

  public double getKcalFett() {
    return (lebensmittel.fett * FETTKCAL) * (menge / 100);
  }

  public Lebensmittel getLebensmittel() {
    return lebensmittel;
  }

  public void setLebensmittel(Lebensmittel lebensmittel) {
    this.lebensmittel = lebensmittel;
  }

  public double getMenge() {
    return menge;
  }

  public void setMenge(double menge) {
    this.menge = menge;
  }
}
