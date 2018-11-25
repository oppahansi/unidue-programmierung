/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze.
 */
package com.oppahansi.ws1415.miniprojekt3;

import java.text.DecimalFormat;

// Implementierung der Aufgaben von Mark Kunze (c)
public class Mensa_A2 {

  Lebensmittel lebensmittel[] = new Lebensmittel[0];
  Speise_A2 haupt[] = new Speise_A2[16],
      staerke[] = new Speise_A2[16],
      gemuese[] = new Speise_A2[16];

  public static void main(String[] args) {
    Mensa_A2 m = new Mensa_A2();

    Speise_A2 s;
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
    m.anreichern();
    m.deveganisiere();
    m.zeigeSpeisen(m.haupt);
    m.rinderwahn();
    System.out.println("Enthalten: " + m.enthalten());

    m.zeigeSpeisen(m.haupt);
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

  public void zeigeSpeisen(Speise_A2 gruppe[]) {
    DecimalFormat fmt = new DecimalFormat("000.00");
    for (Speise_A2 k : gruppe) {
      if (k != null) {
        System.out.println("----------------------------------------");
        System.out.printf("%s (Kcal: %.1f)\n", k.name, k.getKcal());
        Zutat_A2 z = k.kopf;
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
  public Speise_A2 neueSpeise(Speise_A2[] gruppe, String name) {
    Speise_A2 neueSp = new Speise_A2(name); //initialisiert die neue Speise
    for (int i = 0; i < gruppe.length; i++) //geht das �bergebene Array durch...
    {
      if (gruppe[i] == null) { //falls eine freie Stelle gefunden...
        gruppe[i] = neueSp; //setze dort die neue Speise
        return neueSp; //und beende Proc mit der Ausgabe
      }
    }
    return neueSp; //Array ist voll trotzdem R�ckgabe der Speise
  } //end of proc

  // Aufgabe
  public void loescheSpeise(Speise_A2[] gruppe, Speise_A2 speise) {
    for (int i = 0; i < gruppe.length; i++) //geht das �bergebene Array durch
    {
      if (gruppe[i] == speise) //falls zu l�schende Speise gefunden
      {
        gruppe[i] = null; //�berschreibe mit NULL
      }
    }
  } //end of proc

  // Aufgabe
  public void anreichern() {
    for (Speise_A2 s : staerke) //geht die St�rkespeisen durch
    {
      if (s != null) //abfang von NULL-Pointer!
      {
        if (s.getKcal() < 300) //falls anreichern n�tig
        {
          s.neueZutat(
              Lebensmittel.Oel,
              ((300 - s.getKcal()) / 9.3)); // mit �l und passender Menge anreichern
        }
      }
    }
    for (Speise_A2 g : gemuese) //s.o.
    {
      if (g != null) {
        if (g.getKcal() < 200) {
          g.neueZutat(
              Lebensmittel.Margarine,
              ((200 - g.getKcal())
                  / (Lebensmittel.Margarine.fett * 0.093
                      + Lebensmittel.Margarine.kohlenhydrat * 0.041
                      + Lebensmittel.Margarine.protein * 0.041)));
        }
      }
    }
  } //end of proc

  // Aufgabe
  public void deveganisiere() {
    Speise_A2[][] gerichte = {
      haupt, staerke, gemuese
    }; //speichert die 3 Arten von Speisen in einem Array (2-Dimensional)
    for (Speise_A2[] a : gerichte) //geht die Arten (Arrays) nach und nach durch
    {
      for (Speise_A2 b : a) //geht die Speisen der Arten nach und nach durch
      {
        if (b != null) { //NULL-Pointer! Speise evtl. nicht vorhanden
          b.ersetze(
              Lebensmittel.Kaese,
              Lebensmittel.Analogkaese,
              1.0); //ersetze ANALOGK�SE mit K�SE Menge (100%)
          b.ersetze(Lebensmittel.Schweinefleisch, Lebensmittel.Sojagranulat, 1.0);
          b.ersetze(Lebensmittel.Rindfleisch, Lebensmittel.Sojaschnetzel, 1.0);
          b.ersetze(Lebensmittel.Ei, Lebensmittel.Sojamehl, 3.0); //Menge 300%
          b.ersetze(Lebensmittel.Milch, Lebensmittel.Sojamilch, 1.0);
        } //end of if
      }
    }
  } //end of proc

  // Aufgabe
  public void veganisiere() { //siehe deveganisiere
    Speise_A2[][] gerichte = {haupt, staerke, gemuese};
    for (Speise_A2[] a : gerichte) {
      for (Speise_A2 b : a) {
        if (b != null) {
          b.ersetze(Lebensmittel.Analogkaese, Lebensmittel.Kaese, 1.0);
          b.ersetze(Lebensmittel.Sojaschnetzel, Lebensmittel.Rindfleisch, 1.0);
          b.ersetze(Lebensmittel.Sojagranulat, Lebensmittel.Haenchenfleisch, 1.0);
          b.ersetze(Lebensmittel.Sojagranulat, Lebensmittel.Schweinefleisch, 1.0);
          b.ersetze(Lebensmittel.Sojamehl, Lebensmittel.Ei, 0.33); //Menge 33%
          b.ersetze(Lebensmittel.Sojamilch, Lebensmittel.Milch, 1.0);
          b.ersetze(Lebensmittel.Tofu, Lebensmittel.Haenchenbrustfilet, 1.0);
          b.ersetze(Lebensmittel.Tofu, Lebensmittel.Seelachsfilet, 1.0);
          b.ersetze(Lebensmittel.Oel, Lebensmittel.Margarine, 1.0);
          b.ersetze(Lebensmittel.Oel, Lebensmittel.Butter, 1.0);
        } //end of if
      }
    }
  } //end of proc

  // Aufgabe
  public void rinderwahn() {
    Speise_A2[][] gerichte = {
      haupt, staerke, gemuese
    }; //speichert die 3 Arten von Speisen in einem Array (2-Dimensional)
    for (Speise_A2[] a : gerichte) //geht Arten von Speisen durch
    {
      for (int i = 0; i < a.length; i++) //geht Speisen durch
      {
        if (a[i] != null
            && a[i].findeZutat(Lebensmittel.Rindfleisch)) //falls Rindfleisch gefunden wurde ...
        {
          a[i] = null; //�berschreibe Speise mit NULL
        }
      }
    }
  } //end of proc

  // Aufgabe
  public boolean istAusgewogen(Speise_A2 h, Speise_A2 s, Speise_A2 g) {
    double proteine =
        h.getPgehalt() + s.getPgehalt() + g.getPgehalt(); //speichert die Kalorien der Proteine
    double fett =
        h.getFgehalt() + s.getFgehalt() + g.getFgehalt(); //speichert die Kalorien des Fett
    double kohlenhydrat =
        h.getKgehalt() + s.getKgehalt() + g.getKgehalt(); //speichert die Kalorien der Kohlenhydrate
    double gesamtgehalt = proteine + fett + kohlenhydrat; //speichert die Gesamtkalorien
    proteine /= gesamtgehalt; //Speichert den prozentualen Anteil an Kalorien
    fett /= gesamtgehalt; //s.o.
    kohlenhydrat /= gesamtgehalt; //s.o.
    return (((proteine >= 0.25) && (proteine <= 0.35))
        && //25%<=proteine<=35%
        ((kohlenhydrat >= 0.45) && (kohlenhydrat <= 0.55))
        && //45%<=proteine<=55%
        ((fett >= 0.15) && (fett <= 0.25))); //15%<=proteine<=25%
  } //end of proc

  // Aufgabe
  int enthalten() {
    int anzahl = 0; //initialisiert anzahl mit 0
    for (Speise_A2 a : haupt) //geht alle Hauptspeisen durch...
    {
      for (Speise_A2 b : haupt) //um Sie mit allen Hauptspeisen zu verlgiechen...
      {
        if (a != null && b != null && a != b) //au�er sich selbst ... (Achtung NULL Pointer!)
        {
          if (a.enthalten(b)) //Wenn Zutaten von 'a' in 'b' enthalten ...
          {
            anzahl += 1; //erh�he um 1
          }
        }
      }
    }
    return anzahl; //Ausgabe
  } //end of proc
}
