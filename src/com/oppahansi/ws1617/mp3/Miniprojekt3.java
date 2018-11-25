/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Miniprojekt3 {

  public static void main(String[] args) {
    // alle Stationen
    Station sBrixen = new Station("Brixen", false);
    Station sChoralpe = new Station("Choralpe", true);
    Station sFilzboden = new Station("Filzboden", false);
    Station sOberberg = new Station("Oberberg", false);
    Station sZinsberg = new Station("Zinsberg", false);
    Station sSeidlalm = new Station("Seidlalm", true);

    // alle Pisten
    Piste pQuerverbindung = new Piste("Querverbindung", 'r', 800, -200, true, sFilzboden);
    Piste pBuckelpiste = new Piste("Buckelpiste", 's', 500, -200, false, sZinsberg);
    Piste pZinsbergAbfahrt = new Piste("Zinsberg-Abfahrt", 'b', 800, -300, false, sChoralpe);
    Piste pSeidlalmAbfahrt = new Piste("Seidlalm-Abfahrt", 'r', 3800, -400, true, sSeidlalm);
    Piste pTalabfahrtMittel = new Piste("Talabfahrt (mittel)", 'r', 4000, -600, true, sBrixen);
    Piste pTalabfahrtLeicht = new Piste("Talabfahrt (leicht)", 'b', 4200, -600, true, sBrixen);

    // alle Lifte
    Lift lGondelbahnAuf = new Lift("Gondelbahn (auf)", 30, 1800, 500, true, sChoralpe);
    Lift lGondelbahnAb = new Lift("Gondelbahn (ab)", 30, 1800, -500, true, sBrixen);
    Lift lOberbergLift = new Lift("Oberberg-Lift", 16, 1700, 700, true, sOberberg);
    Lift lZinsbergLift = new Lift("Zinsberg-Lift", 14, 400, 300, false, sZinsberg);

    // ausgehende Lifte und Pisten pro Station
    Lift[] alBrixen = new Lift[] {lGondelbahnAuf};
    Piste[] apBrixen = null;
    Lift[] alChoralpe = new Lift[] {lZinsbergLift, lGondelbahnAb};
    Piste[] apChoralpe = new Piste[] {pQuerverbindung};
    Lift[] alZinsberg = null;
    Piste[] apZinsberg = new Piste[] {pZinsbergAbfahrt};
    Lift[] alFilzboden = new Lift[] {lOberbergLift};
    Piste[] apFilzboden = null;
    Lift[] alOberberg = null;
    Piste[] apOberberg = new Piste[] {pBuckelpiste, pSeidlalmAbfahrt};
    Lift[] alSeidlalm = null;
    Piste[] apSeidlalm = new Piste[] {pTalabfahrtMittel, pTalabfahrtLeicht};

    // ausgehende Lifte und Pisten f�r alle Stationen
    Lift[][] ausgLifte =
        new Lift[][] {alBrixen, alChoralpe, alZinsberg, alFilzboden, alOberberg, alSeidlalm};
    Piste[][] ausgPisten =
        new Piste[][] {apBrixen, apChoralpe, apZinsberg, apFilzboden, apOberberg, apSeidlalm};

    // erstelle Skigebiet als Array aller Stationen und setze ausgehende Lifte und Pisten f�r jede Station
    Station[] skigebiet =
        new Station[] {sBrixen, sChoralpe, sZinsberg, sFilzboden, sOberberg, sSeidlalm};
    for (int is = 0; is < skigebiet.length; is++) {
      skigebiet[is].setzeAusgehendeLifte(ausgLifte[is]);
      skigebiet[is].setzeAusgehendePisten(ausgPisten[is]);
    }

    // erstelle Miniprojekt
    Miniprojekt3 m = new Miniprojekt3();

    // Beispielroute
    RElement r =
        new RElement(
            new Piste[] {pZinsbergAbfahrt},
            new Lift[] {lGondelbahnAuf, lZinsbergLift, lGondelbahnAb},
            new boolean[] {false, false, true, false});

    // An dieser Stelle k�nnen Sie unabh�ngig von JACK Ihre Methoden testen.
    // Anhand der Skizze auf dem Aufgabenblatt sowie den oben in der Klasse Miniprojekt3
    // erstellten Objekten f�r Lifte, Stationen und Pisten (erg�nzen Sie bei Bedarf die
    // Skizze um H�henangaben etc.) k�nnen Sie leicht von Hand ermitteln, welche Ergebnisse
    // Ihre Methoden f�r bestimmte Parameterwerte liefern m�ssten.
    //
    System.out.println("Aufgabe 1:)");
    m.zeigeSkigebiet(skigebiet);
    System.out.println("\nAufgabe 2:)");
    m.zeigeRoute(r);
    System.out.println("\nAufgabe 3:)");
    System.out.println("Offene Lifte: " + m.offeneLifte(skigebiet)); // erwartet 3
    System.out.println("\nAufgabe 4:)");
    System.out.println("Gesamtlaenge der Pisten: " + m.pistenMeter(skigebiet)); // erwartet 14100
    System.out.println("\nAufgabe 5:)");
    System.out.println(
        "Verbrauchte Liftenpunkte auf der Route: " + m.verbrauchtePunkte(r)); // erwartet 74
    System.out.println("\nAufgabe 6:)");
    System.out.println("Max Farbe: " + m.maxFarbe(r)); // erwartet b
    System.out.println("\nAufgabe 7:)");
    System.out.println("Max erreichte Hoehe: " + m.maxHoehe(r)); // erwartet 800
    System.out.println("\nAufgabe 8:)");
    System.out.println("Huetten auf der Route erreicht: " + m.anzahlHuetten(r)); // erwartet 2
    System.out.println("\nAufgabe 9:)");
    System.out.println(
        "Station Seidlalm hat parallele Pisten: "
            + m.parallelePistenVon(sSeidlalm)); // erwartet true
    System.out.println(
        "Station Oberberg hat parallele Pisten: "
            + m.parallelePistenVon(sOberberg)); // erwartet false
    System.out.println("\nAufgabe 10:)");
    System.out.println(
        "Keine Lifte abwaerts zu Brixen? : "
            + m.keinLiftAbwaertsZu(skigebiet, sBrixen)); // erwartet false
    System.out.println(
        "Keine Lifte abwaerts zu Oberberg? : "
            + m.keinLiftAbwaertsZu(skigebiet, sOberberg)); // erwartet true
    System.out.println("\nAufgabe 11:)");
    System.out.println(
        "Hat Station Choralpe eine Anfaengerroute? : "
            + m.hatAnfaengerRoute(sChoralpe)); // erwartet true
    System.out.println(
        "Hat Station Zinsberg eine Anfaengerroute? : "
            + m.hatAnfaengerRoute(sZinsberg)); // erwartet true
    System.out.println(
        "Hat Station Filzboden eine Anfaengerroute? : "
            + m.hatAnfaengerRoute(sFilzboden)); // erwartet false
    System.out.println("\nAufgabe 12:)");
    System.out.println(
        "Befahrbare Pistenmeter auf der strecke r : " + m.befahrbarBis(r)); // erwartet 0
    System.out.println("\nAufgabe 13:)");
    System.out.println("Disjunkt? : " + m.sindDisjunkt(r, r)); // erwartet false
  }

  public void zeigeSkigebiet(Station[] skigebiet) {
    for (int i = 0; i < skigebiet.length; i++) {
      System.out.println(skigebiet[i].name);
      if (skigebiet[i].pisten != null) {
        for (int j = 0; j < skigebiet[i].pisten.length; j++) {
          System.out.println(
              "\t" + skigebiet[i].pisten[j].name + " -> " + skigebiet[i].pisten[j].ziel.name);
        }
      }
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          System.out.println(
              "\t" + skigebiet[i].lifte[j].name + " -> " + skigebiet[i].lifte[j].ziel.name);
        }
      }
    }
  }

  public void zeigeRoute(RElement r) {
    RElement aktuellerPunkt = r;
    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.lift != null) {
        System.out.println(aktuellerPunkt.lift.name);
      }
      if (aktuellerPunkt.piste != null) {
        System.out.println(aktuellerPunkt.piste.name);
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }
  }

  public int offeneLifte(Station[] skigebiet) {
    int offeneLifte = 0;

    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.lifte != null) {
        for (Lift aktuellerLift : aktuelleStation.lifte) {
          if (aktuellerLift.status) {
            offeneLifte++;
          }
        }
      }
    }

    return offeneLifte;
  }

  public int pistenMeter(Station[] skigebiet) {
    int gesamtLaengePisten = 0;

    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.pisten != null) {
        for (Piste aktuellePiste : aktuelleStation.pisten) {
          gesamtLaengePisten += aktuellePiste.laenge;
        }
      }
    }

    return gesamtLaengePisten;
  }

  public int verbrauchtePunkte(RElement r) {
    RElement aktuellerPunkt = r;
    int verbrauchtePunkte = 0;

    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.lift != null) {
        verbrauchtePunkte += aktuellerPunkt.lift.punkte;
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }

    return verbrauchtePunkte;
  }

  public char maxFarbe(RElement r) {
    RElement aktuellerPunkt = r;
    char maxFarbe = 'a';

    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.piste != null) {
        if (aktuellerPunkt.piste.farbe > maxFarbe) {
          maxFarbe = aktuellerPunkt.piste.farbe;
        }
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }

    return maxFarbe;
  }

  public int maxHoehe(RElement r) {
    RElement aktuellerPunkt = r;
    int hoehenDifferenz = 0;
    int ergebnis = 0;

    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.lift != null) {
        hoehenDifferenz += aktuellerPunkt.lift.hdiff;
      }
      if (aktuellerPunkt.piste != null) {
        hoehenDifferenz += aktuellerPunkt.piste.hdiff;
      }

      if (ergebnis <= hoehenDifferenz) {
        ergebnis = hoehenDifferenz;
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }

    return ergebnis;
  }

  public int anzahlHuetten(RElement r) {
    RElement aktuellerPunkt = r;
    int anzahlHuetten = 0;

    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.piste != null) {
        anzahlHuetten +=
            aktuellerPunkt.piste.ziel != null ? aktuellerPunkt.piste.ziel.huette ? 1 : 0 : 0;
      }
      if (aktuellerPunkt.lift != null) {
        anzahlHuetten +=
            aktuellerPunkt.lift.ziel != null ? aktuellerPunkt.lift.ziel.huette ? 1 : 0 : 0;
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }

    return anzahlHuetten;
  }

  public boolean parallelePistenVon(Station s) {
    if (s.pisten != null) {
      for (int i = 0; i < s.pisten.length; i++) {
        for (int j = i + 1; j < s.pisten.length; j++) {
          if (s.pisten[i].ziel.name.compareTo(s.pisten[j].ziel.name) == 0) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.lifte != null) {
        for (Lift aktuellerLift : aktuelleStation.lifte) {
          if (aktuellerLift.hdiff < 0 && aktuellerLift.ziel.name.compareTo(s.name) == 0)
            return false;
        }
      }
    }

    return true;
  }

  public boolean hatAnfaengerRoute(Station s) {
    if (s.lifte != null) {
      for (Lift aktuellerLift : s.lifte) {
        if (aktuellerLift.ziel.pisten != null) {
          for (Piste aktuellePiste : aktuellerLift.ziel.pisten) {
            if (aktuellePiste.farbe == 'b' && aktuellePiste.ziel.name.compareTo(s.name) == 0) {
              return true;
            }
          }
        }
      }
    }
    if (s.pisten != null) {
      for (Piste aktuellePiste : s.pisten) {
        if (aktuellePiste.ziel.lifte != null) {
          for (Lift aktuellerLift : aktuellePiste.ziel.lifte) {
            if (aktuellePiste.farbe == 'b' && aktuellerLift.ziel.name.compareTo(s.name) == 0) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  public int befahrbarBis(RElement r) {
    RElement aktuellerPunkt = r;
    int befahrbarePistenMeter = 0;

    while (aktuellerPunkt != null) {
      if (aktuellerPunkt.piste != null) {
        befahrbarePistenMeter += aktuellerPunkt.piste.status ? aktuellerPunkt.piste.laenge : 0;
      }

      aktuellerPunkt = aktuellerPunkt.nF;
    }

    return befahrbarePistenMeter;
  }

  public boolean sindDisjunkt(RElement r1, RElement r2) {
    RElement aktuellR1 = r1;

    while (aktuellR1 != null) {
      RElement aktuellR2 = r2;

      while (aktuellR2 != null) {
        if ((aktuellR1.lift != null && aktuellR2.lift != null && aktuellR1.lift == aktuellR2.lift)
            || (aktuellR1.piste != null
                && aktuellR2.piste != null
                && aktuellR1.piste == aktuellR2.piste)) {
          return false;
        }

        aktuellR2 = aktuellR2.nF;
      }

      aktuellR1 = aktuellR1.nF;
    }

    return true;
  }
}
