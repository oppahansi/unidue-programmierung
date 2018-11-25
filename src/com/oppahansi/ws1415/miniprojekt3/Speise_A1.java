/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by oppahansi.
 */
package com.oppahansi.ws1415.miniprojekt3;

public class Speise_A1 {

  public String name;
  public Zutat_A1 kopf;
  public Zutat_A1 fuss;

  public Speise_A1(String name) {
    super();
    this.name = name;
  }

  // Aufgabe
  public void neueZutat(Lebensmittel lebensmittel, double menge) { // Aufgabe
    Zutat_A1 neueZutat = new Zutat_A1(lebensmittel, menge);
    if (this.kopf == null) {
      this.kopf = neueZutat;
      this.kopf.nachfolger = fuss;
      this.fuss = kopf;
    } else {
      Zutat_A1 listenElement = this.kopf;
      boolean vorhanden = false;
      while (listenElement != null) {
        if (listenElement.lebensmittel.equals(neueZutat.lebensmittel)) {
          listenElement.menge += menge;
          vorhanden = true;
          break;
        }
        listenElement = listenElement.nachfolger;
      }
      if (!vorhanden) {
        this.fuss.nachfolger = neueZutat;
        this.fuss = neueZutat;
      }
    }
  }

  // Aufgabe
  public double getKcal() {
    if (this.kopf == null) {
      return 0;
    } else {
      double kcalSumme = 0;
      Zutat_A1 listenElement = this.kopf;
      while (listenElement != null) {
        kcalSumme += listenElement.getKcal();
        listenElement = listenElement.nachfolger;
      }
      return kcalSumme;
    }
  }

  public double getKcalProtein() {
    if (this.kopf == null) {
      return 0;
    } else {
      double kcalSumme = 0;
      Zutat_A1 listenElement = this.kopf;
      while (listenElement != null) {
        kcalSumme += listenElement.getKcalProtein();
        listenElement = listenElement.nachfolger;
      }
      return kcalSumme;
    }
  }

  public double getKcalKohle() {
    if (this.kopf == null) {
      return 0;
    } else {
      double kcalSumme = 0;
      Zutat_A1 listenElement = this.kopf;
      while (listenElement != null) {
        kcalSumme += listenElement.getKcalKohle();
        listenElement = listenElement.nachfolger;
      }
      return kcalSumme;
    }
  }

  public double getKcalFett() {
    if (this.kopf == null) {
      return 0;
    } else {
      double kcalProteinSumme = 0;
      Zutat_A1 listenElement = this.kopf;
      while (listenElement != null) {
        kcalProteinSumme += listenElement.getKcalFett();
        listenElement = listenElement.nachfolger;
      }
      return kcalProteinSumme;
    }
  }

  public boolean enthaeltZutat(Lebensmittel lebensmittel) {
    if (this.kopf == null) {
      return false;
    } else {
      Zutat_A1 listenElement = this.kopf;
      while (listenElement != null) {
        if (listenElement.getLebensmittel().equals(lebensmittel)) {
          return true;
        }
        listenElement = listenElement.nachfolger;
      }
      return false;
    }
  }

  public boolean kannGekochtWerdenVon(Speise_A1 speise) {
    if (speise == null) {
      return false;
    } else {
      Zutat_A1 aktuelleSpeisenZutat = this.kopf;
      Zutat_A1 speisenElement;
      while (aktuelleSpeisenZutat != null) {
        speisenElement = speise.kopf;
        while (speisenElement != null) {
          if (speisenElement.getLebensmittel() == aktuelleSpeisenZutat.getLebensmittel()
              && speisenElement.getMenge() >= aktuelleSpeisenZutat.getMenge()) {
            break;
          }
          speisenElement = speisenElement.nachfolger;
        }
        if (speisenElement == null) {
          return false;
        }
        aktuelleSpeisenZutat = aktuelleSpeisenZutat.nachfolger;
      }
      return true;
    }
  }

  public void ersetzeVeggieZutaten() {
    Zutat_A1 listenElement = this.kopf;

    while (listenElement != null) {
      if (listenElement.getLebensmittel().equals(Lebensmittel.Analogkaese)) {
        listenElement.setLebensmittel(Lebensmittel.Kaese);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Sojagranulat)) {
        listenElement.setLebensmittel(Lebensmittel.Schweinefleisch);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Sojaschnetzel)) {
        listenElement.setLebensmittel(Lebensmittel.Rindfleisch);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Sojamehl)) {
        listenElement.setLebensmittel(Lebensmittel.Ei);
        listenElement.setMenge(listenElement.getMenge() * 3);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Sojamilch)) {
        listenElement.setLebensmittel(Lebensmittel.Milch);
      }
      listenElement = listenElement.nachfolger;
    }
  }

  public void ersetzeNichtVeggieZutaten() {
    Zutat_A1 listenElement = this.kopf;

    while (listenElement != null) {
      if (listenElement.getLebensmittel().equals(Lebensmittel.Kaese)) {
        listenElement.setLebensmittel(Lebensmittel.Analogkaese);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Rindfleisch)) {
        listenElement.setLebensmittel(Lebensmittel.Sojaschnetzel);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Haenchenfleisch)) {
        listenElement.setLebensmittel(Lebensmittel.Sojagranulat);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Schweinefleisch)) {
        listenElement.setLebensmittel(Lebensmittel.Sojagranulat);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Ei)) {
        listenElement.setLebensmittel(Lebensmittel.Sojamehl);
        listenElement.setMenge(listenElement.getMenge() * 0.33);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Milch)) {
        listenElement.setLebensmittel(Lebensmittel.Sojamilch);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Haenchenbrustfilet)) {
        listenElement.setLebensmittel(Lebensmittel.Tofu);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Seelachsfilet)) {
        listenElement.setLebensmittel(Lebensmittel.Tofu);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Margarine)) {
        listenElement.setLebensmittel(Lebensmittel.Oel);
      }
      if (listenElement.getLebensmittel().equals(Lebensmittel.Butter)) {
        listenElement.setLebensmittel(Lebensmittel.Oel);
      }
      listenElement = listenElement.nachfolger;
    }
  }
}
