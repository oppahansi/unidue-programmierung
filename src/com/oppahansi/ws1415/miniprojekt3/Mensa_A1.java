/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by oppahansi.
 */
package com.oppahansi.ws1415.miniprojekt3;

import java.text.DecimalFormat;

public class Mensa_A1 {

  //
  private final double FETTKCAL = 9.3;
  private final double KOHLENKCAL = 4.1;
  private final double PROTEINKCAL = 4.1;
  Lebensmittel lebensmittel[] = new Lebensmittel[0];
  Speise_A1 haupt[] = new Speise_A1[16],
      staerke[] = new Speise_A1[16],
      gemuese[] = new Speise_A1[16];

  public static void main(String[] args) {
    Mensa_A1 m = new Mensa_A1();

    Speise_A1 s;
    s = m.neueSpeise(m.haupt, "Puszta-Frikadelle�[a, c, g, i]�(G)�(9)");
    s.neueZutat(Lebensmittel.Broetchen, 6.25);
    s.neueZutat(Lebensmittel.Paprika, 93.75);
    s.neueZutat(Lebensmittel.Oel, 3.75);
    s.neueZutat(Lebensmittel.Zwiebel, 18.75);
    s.neueZutat(Lebensmittel.Rindfleisch, 31.25);
    s.neueZutat(Lebensmittel.Schweinefleisch, 31.25);
    s.neueZutat(Lebensmittel.Ei, 8.75);
    s.neueZutat(Lebensmittel.Senf, 1.25);
    s.neueZutat(Lebensmittel.Gewuerze, 3.0);

    s = m.neueSpeise(m.haupt, "Gem�se-Lasagne -vegan-�(mit Analogkaese) [a, f, i]�(VEG)");
    s.neueZutat(Lebensmittel.Analogkaese, 20);
    s.neueZutat(Lebensmittel.Zucchini, 114);
    s.neueZutat(Lebensmittel.Oliven, 23);
    s.neueZutat(Lebensmittel.Nudeln, 50);
    s.neueZutat(Lebensmittel.Tomaten, 120);
    s.neueZutat(Lebensmittel.Hefeflocken, 16);
    s.neueZutat(Lebensmittel.Sojamehl, 4.5);
    s.neueZutat(Lebensmittel.Oel, 10);
    s.neueZutat(Lebensmittel.Senf, 2.5);
    s.neueZutat(Lebensmittel.Gewuerze, 15);

    s = m.neueSpeise(m.haupt, "Ravioli mit Sojacurry[a,c,f,g,i]");
    s.neueZutat(Lebensmittel.Sojamehl, 66.7);
    s.neueZutat(Lebensmittel.Essig, 3);
    s.neueZutat(Lebensmittel.Oel, 16.6);
    s.neueZutat(Lebensmittel.Blattspinat, 83.3);
    s.neueZutat(Lebensmittel.Hefeflocken, 6.6);
    s.neueZutat(Lebensmittel.Oel, 3.4);
    s.neueZutat(Lebensmittel.Sojamilch, 6.6);

    s.neueZutat(Lebensmittel.Sojaschnetzel, 12.5);
    s.neueZutat(Lebensmittel.Currysauce, 25);
    s.neueZutat(Lebensmittel.Gewuerze, 15);

    s =
        m.neueSpeise(
            m.haupt,
            "H�hnchenbrust \"Tandoori\"�mit Chili-Ingwer-Sauce [a, c, e, f, g, h, i, j, k](G)");
    s.neueZutat(Lebensmittel.Haenchenbrustfilet, 200.0);
    s.neueZutat(Lebensmittel.Zwiebel, 150);
    s.neueZutat(Lebensmittel.Kaese, 50.0);
    s.neueZutat(Lebensmittel.Joghurt, 200);
    s.neueZutat(Lebensmittel.Gewuerze, 3);

    s = m.neueSpeise(m.haupt, "Haehnchenschnitzel \"Piccata Milanese\" mit Tomatencauce");
    s.neueZutat(Lebensmittel.Haenchenfleisch, 150.0);
    s.neueZutat(Lebensmittel.Paniermehl, 10.0);
    s.neueZutat(Lebensmittel.Tomaten, 150);
    s.neueZutat(Lebensmittel.Ei, 50);
    s.neueZutat(Lebensmittel.Mehl, 37.5);
    s.neueZutat(Lebensmittel.Butter, 12.5);
    s.neueZutat(Lebensmittel.Gewuerze, 3);

    s = m.neueSpeise(m.staerke, "Rosmarinkartoffeln");
    s.neueZutat(Lebensmittel.Kartoffeln, 200);
    s.neueZutat(Lebensmittel.Oel, 5);
    s.neueZutat(Lebensmittel.Gewuerze, 4);

    s = m.neueSpeise(m.staerke, "Nudeln");
    s.neueZutat(Lebensmittel.Nudeln, 50);

    s = m.neueSpeise(m.staerke, "Reis");
    s.neueZutat(Lebensmittel.Nudeln, 50);

    s = m.neueSpeise(m.gemuese, "Bunte Karotten");
    s.neueZutat(Lebensmittel.Karotten, 75); //Orange
    s.neueZutat(Lebensmittel.Karotten, 75); //Gelb

    s = m.neueSpeise(m.gemuese, "Paprika-Maisgem�se");
    s.neueZutat(Lebensmittel.Paprika, 75);
    s.neueZutat(Lebensmittel.Mais, 75);

    s = m.neueSpeise(m.gemuese, "Broccoli");
    s.neueZutat(Lebensmittel.Broccoli, 150);

    s = m.neueSpeise(m.gemuese, "Romanobohnen");
    s.neueZutat(Lebensmittel.Bohnen, 75);
    s.neueZutat(Lebensmittel.Oel, 3);

    // ---
    m.zeigeLebensmittel();

    System.out.println("-- Hauptspeisen --");
    m.zeigeSpeisen(m.haupt);
    System.out.println("-- Staerkebeilagen --");
    m.zeigeSpeisen(m.staerke);
    System.out.println("-- Gemuese --");
    m.zeigeSpeisen(m.gemuese);

    // ---
    System.out.println("-----------------------------------");
    System.out.println("NACH ANREICHERN");
    m.anreichern();
    System.out.println();
    System.out.println("-- Staerkebeilagen --");
    m.zeigeSpeisen(m.staerke);
    System.out.println("-- Gemuese --");
    m.zeigeSpeisen(m.gemuese);
    System.out.println("-----------------------------------");

    System.out.println("-----------------------------------");
    System.out.println("NACH DEVEGANISIEREN");
    m.deveganisiere();
    System.out.println("-- Hauptspeisen --");
    m.zeigeSpeisen(m.haupt);
    System.out.println("-- Staerkebeilagen --");
    m.zeigeSpeisen(m.staerke);
    System.out.println("-- Gemuese --");
    m.zeigeSpeisen(m.gemuese);
    System.out.println("-----------------------------------");

    System.out.println("-----------------------------------");
    System.out.println("NACH RINDERWAHN");
    m.rinderwahn();
    System.out.println("-- Hauptspeisen --");
    m.zeigeSpeisen(m.haupt);
    System.out.println("-- Staerkebeilagen --");
    m.zeigeSpeisen(m.staerke);
    System.out.println("-- Gemuese --");
    m.zeigeSpeisen(m.gemuese);
    System.out.println("-----------------------------------");

    // ...
  }

  public void zeigeLebensmittel() {
    for (Lebensmittel l : Lebensmittel.AlleLebensmittel) {
      System.out.println("----------------------------------------");
      System.out.println("Name         : " + l.name);
      System.out.println("Protein      : " + l.protein);
      System.out.println("Kohlenhydrate: " + l.kohlenhydrat);
      System.out.println("Fett         : " + l.fett);
      System.out.println(
          "Kcal/100g    : " + ((l.fett * 9.3 + l.kohlenhydrat * 4.1 + l.protein * 4.1)));
    }
  }

  public void zeigeSpeisen(Speise_A1 gruppe[]) {
    DecimalFormat fmt = new DecimalFormat("000.00");
    for (Speise_A1 k : gruppe) {
      if (k != null) {
        System.out.println("----------------------------------------");
        System.out.printf("%s (Kcal: %.1f)\n", k.name, k.getKcal());
        Zutat_A1 z = k.kopf;
        while (z != null) {
          System.out.printf(
              "%sg | %s\n",
              fmt.format(z.menge), z.lebensmittel != null ? z.lebensmittel.name : "NULL");
          z = z.nachfolger;
        }
      }
    }
  }

  // Aufgabe
  public Speise_A1 neueSpeise(Speise_A1[] gruppe, String name) {
    Speise_A1 neueSpeise = new Speise_A1(name);
    for (int i = 0; i < gruppe.length; i++) {
      if (gruppe[i] == null) {
        gruppe[i] = neueSpeise;
        break;
      }
    }
    return neueSpeise;
  }

  // Aufgabe
  public void loescheSpeise(Speise_A1[] gruppe, Speise_A1 speise) {
    for (int i = 0; i < gruppe.length; i++) {
      if (gruppe[i] != null && gruppe[i].equals(speise)) {
        gruppe[i] = null;
        break;
      }
    }
  }

  // Aufgabe
  public void anreichern() {
    for (int i = 0; i < staerke.length; i++) {
      if (staerke[i] != null && staerke[i].getKcal() < 300) {
        double differenz = 300 - staerke[i].getKcal();
        staerke[i].neueZutat(Lebensmittel.Oel, getMengeAnreicherung(differenz, Lebensmittel.Oel));
      }
      if (gemuese[i] != null && gemuese[i].getKcal() < 300) {
        double differenz = 200 - gemuese[i].getKcal();
        gemuese[i].neueZutat(
            Lebensmittel.Margarine, getMengeAnreicherung(differenz, Lebensmittel.Margarine));
      }
    }
  }

  private double getMengeAnreicherung(double kcalDifferenz, Lebensmittel lebensmitte1) {
    return kcalDifferenz
        * (100
            / (lebensmitte1.fett * FETTKCAL
                + lebensmitte1.kohlenhydrat * KOHLENKCAL
                + lebensmitte1.protein * PROTEINKCAL));
  }

  // Aufgabe
  public void deveganisiere() {
    for (int i = 0; i < haupt.length; i++) {
      if (haupt[i] != null
          && (haupt[i].enthaeltZutat(Lebensmittel.Analogkaese)
              || haupt[i].enthaeltZutat(Lebensmittel.Sojagranulat)
              || haupt[i].enthaeltZutat(Lebensmittel.Sojaschnetzel)
              || haupt[i].enthaeltZutat(Lebensmittel.Sojamehl)
              || haupt[i].enthaeltZutat(Lebensmittel.Sojamilch))) {
        haupt[i].ersetzeVeggieZutaten();
      }
      if (staerke[i] != null
          && (staerke[i].enthaeltZutat(Lebensmittel.Analogkaese)
              || staerke[i].enthaeltZutat(Lebensmittel.Sojagranulat)
              || staerke[i].enthaeltZutat(Lebensmittel.Sojaschnetzel)
              || staerke[i].enthaeltZutat(Lebensmittel.Sojamehl)
              || staerke[i].enthaeltZutat(Lebensmittel.Sojamilch))) {
        staerke[i].ersetzeVeggieZutaten();
      }
      if (gemuese[i] != null
          && (gemuese[i].enthaeltZutat(Lebensmittel.Analogkaese)
              || gemuese[i].enthaeltZutat(Lebensmittel.Sojagranulat)
              || gemuese[i].enthaeltZutat(Lebensmittel.Sojaschnetzel)
              || gemuese[i].enthaeltZutat(Lebensmittel.Sojamehl)
              || gemuese[i].enthaeltZutat(Lebensmittel.Sojamilch))) {
        gemuese[i].ersetzeVeggieZutaten();
      }
    }
  }

  // Aufgabe
  public void veganisiere() {
    for (int i = 0; i < haupt.length; i++) {
      if (haupt[i] != null
          && (haupt[i].enthaeltZutat(Lebensmittel.Kaese)
              || haupt[i].enthaeltZutat(Lebensmittel.Rindfleisch)
              || haupt[i].enthaeltZutat(Lebensmittel.Haenchenfleisch)
              || haupt[i].enthaeltZutat(Lebensmittel.Schweinefleisch)
              || haupt[i].enthaeltZutat(Lebensmittel.Ei)
              || haupt[i].enthaeltZutat(Lebensmittel.Milch)
              || haupt[i].enthaeltZutat(Lebensmittel.Haenchenbrustfilet)
              || haupt[i].enthaeltZutat(Lebensmittel.Seelachsfilet)
              || haupt[i].enthaeltZutat(Lebensmittel.Margarine)
              || haupt[i].enthaeltZutat(Lebensmittel.Butter))) {
        haupt[i].ersetzeNichtVeggieZutaten();
      }
      if (staerke[i] != null
          && (staerke[i].enthaeltZutat(Lebensmittel.Kaese)
              || staerke[i].enthaeltZutat(Lebensmittel.Rindfleisch)
              || staerke[i].enthaeltZutat(Lebensmittel.Haenchenfleisch)
              || staerke[i].enthaeltZutat(Lebensmittel.Schweinefleisch)
              || staerke[i].enthaeltZutat(Lebensmittel.Ei)
              || staerke[i].enthaeltZutat(Lebensmittel.Milch)
              || staerke[i].enthaeltZutat(Lebensmittel.Haenchenbrustfilet)
              || staerke[i].enthaeltZutat(Lebensmittel.Seelachsfilet)
              || staerke[i].enthaeltZutat(Lebensmittel.Margarine)
              || staerke[i].enthaeltZutat(Lebensmittel.Butter))) {
        staerke[i].ersetzeNichtVeggieZutaten();
      }
      if (gemuese[i] != null
          && (gemuese[i].enthaeltZutat(Lebensmittel.Kaese)
              || gemuese[i].enthaeltZutat(Lebensmittel.Rindfleisch)
              || gemuese[i].enthaeltZutat(Lebensmittel.Haenchenfleisch)
              || gemuese[i].enthaeltZutat(Lebensmittel.Schweinefleisch)
              || gemuese[i].enthaeltZutat(Lebensmittel.Ei)
              || gemuese[i].enthaeltZutat(Lebensmittel.Milch)
              || gemuese[i].enthaeltZutat(Lebensmittel.Haenchenbrustfilet)
              || gemuese[i].enthaeltZutat(Lebensmittel.Seelachsfilet)
              || gemuese[i].enthaeltZutat(Lebensmittel.Margarine)
              || gemuese[i].enthaeltZutat(Lebensmittel.Butter))) {
        gemuese[i].ersetzeNichtVeggieZutaten();
      }
    }
  }

  // Aufgabe
  public void rinderwahn() {
    for (int i = 0; i < haupt.length; i++) {
      if (haupt[i] != null && haupt[i].enthaeltZutat(Lebensmittel.Rindfleisch)) {
        haupt[i] = null;
      }
      if (staerke[i] != null && staerke[i].enthaeltZutat(Lebensmittel.Rindfleisch)) {
        staerke[i] = null;
      }
      if (gemuese[i] != null && gemuese[i].enthaeltZutat(Lebensmittel.Rindfleisch)) {
        gemuese[i] = null;
      }
    }
  }

  // Aufgabe
  public boolean istAusgewogen(Speise_A1 h, Speise_A1 s, Speise_A1 g) {
    double kcalSumme = h.getKcal() + s.getKcal() + g.getKcal();
    double proteine = h.getKcalProtein() + s.getKcalProtein() + g.getKcalProtein();
    double kohle = h.getKcalKohle() + s.getKcalKohle() + g.getKcalKohle();
    double fett = h.getKcalFett() + s.getKcalFett() + g.getKcalFett();

    boolean kombinationA = ((proteine /= kcalSumme) >= 0.25 && (proteine) <= 0.35);
    boolean kombinationB = ((kohle /= kcalSumme) >= 0.45 && (kohle) <= 0.55);
    boolean kombinationC = ((fett /= kcalSumme) >= 0.15 && (fett) <= 0.25);

    if (kombinationA && kombinationB && kombinationC) {
      return true;
    } else {
      return false;
    }
  }

  // Aufgabe
  int enthalten() {
    int zaehler = 0;
    for (Speise_A1 speiseA : haupt) {
      for (Speise_A1 speiseB : haupt) {
        if (speiseA != null && speiseB != null && !speiseA.equals(speiseB)) {
          if (speiseA.kannGekochtWerdenVon(speiseB)) {
            zaehler++;
          }
        }
      }
    }
    return zaehler;
  }
}
