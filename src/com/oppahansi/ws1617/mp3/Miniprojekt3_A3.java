/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Volkan T. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Miniprojekt3_A3 {

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
    Piste pSeidlalmAbfahrt = new Piste("Seidlalm-Abfahrt", 'r', 3800, -400, false, sSeidlalm);
    Piste pTalabfahrtMittel = new Piste("Talabfahrt (mittel)", 'r', 4000, -600, true, sBrixen);
    Piste pTalabfahrtLeicht = new Piste("Talabfahrt (leicht)", 'b', 4200, -600, false, sBrixen);

    // alle Lifte
    Lift lGondelbahnAuf = new Lift("Gondelbahn (auf)", 30, 1800, 500, false, sChoralpe);
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

    // ausgehende Lifte und Pisten für alle Stationen
    Lift[][] ausgLifte =
        new Lift[][] {alBrixen, alChoralpe, alZinsberg, alFilzboden, alOberberg, alSeidlalm};
    Piste[][] ausgPisten =
        new Piste[][] {apBrixen, apChoralpe, apZinsberg, apFilzboden, apOberberg, apSeidlalm};

    // erstelle Skigebiet als Array aller Stationen und setze ausgehende Lifte und Pisten für jede Station
    Station[] skigebiet =
        new Station[] {sBrixen, sChoralpe, sZinsberg, sFilzboden, sOberberg, sSeidlalm};
    for (int is = 0; is < skigebiet.length; is++) {
      skigebiet[is].setzeAusgehendeLifte(ausgLifte[is]);
      skigebiet[is].setzeAusgehendePisten(ausgPisten[is]);
    }

    // erstelle Miniprojekt
    Miniprojekt3_A3 m = new Miniprojekt3_A3();

    // Beispielroute
    RElement r =
        new RElement(
            new Piste[] {pZinsbergAbfahrt},
            new Lift[] {lGondelbahnAuf, lZinsbergLift, lGondelbahnAb},
            new boolean[] {false, false, true, false});

    RElement fahrer1 =
        new RElement(
            new Piste[] {pBuckelpiste, pZinsbergAbfahrt, pQuerverbindung},
            new Lift[] {lOberbergLift},
            new boolean[] {false, true, true, true});

    RElement fahrer2 =
        new RElement(
            new Piste[] {pSeidlalmAbfahrt, pTalabfahrtLeicht},
            new Lift[] {},
            new boolean[] {true, true});

    RElement fahrer3 =
        new RElement(
            new Piste[] {
              pSeidlalmAbfahrt, pTalabfahrtLeicht, pQuerverbindung, pBuckelpiste, pZinsbergAbfahrt
            },
            new Lift[] {lGondelbahnAuf, lGondelbahnAb, lOberbergLift},
            new boolean[] {true, true, false, true, false, true, true, false});

    // An dieser Stelle können Sie unabhängig von JACK Ihre Methoden testen.
    // Anhand der Skizze auf dem Aufgabenblatt sowie den oben in der Klasse Miniprojekt3
    // erstellten Objekten für Lifte, Stationen und Pisten (ergänzen Sie bei Bedarf die
    // Skizze um Höhenangaben etc.) können Sie leicht von Hand ermitteln, welche Ergebnisse
    // Ihre Methoden für bestimmte Parameterwerte liefern müssten.
    //

    // Aufgabe 1
    System.out.println("AUFGABE 1: ");
    m.zeigeSkigebiet(skigebiet);

    // Aufgabe 2
    System.out.println("\nAUFGABE 2: ");
    m.zeigeRoute(r);

    // Aufgabe 3
    System.out.println("\nAUFGABE 3: ");
    System.out.println("Anzahl offener Lifte: " + m.offeneLifte(skigebiet));

    // Aufgabe 4
    System.out.println("\nAUFGABE 4: ");
    System.out.println("Gesamte Laenge aller Pisten: " + m.pistenMeter(skigebiet) + "m");

    // Aufgabe 5
    System.out.println("\nAUFGABE 5: ");
    System.out.println("Verbrauchte Punke für Liftbenutzung: " + m.verbrauchtePunkte(r));

    // Aufgabe 6
    System.out.println("\nAUFGABE 6: ");
    System.out.println("Höchste Pisten Schwierigkeit auf der Route: " + m.maxFarbe(r));

    // Aufgabe 7
    System.out.println("\nAUFGABE 7: ");
    System.out.println("Differenz der Höehe: " + m.maxHoehe(r));

    // Aufgabe 8
    System.out.println("\nAUFGABE 8: ");
    System.out.println("Anzahl Huetten in der Route: " + m.anzahlHuetten(r));

    // Aufgabe 9
    System.out.println("\nAUFGABE 9: ");
    System.out.println("Haben zwei Pisten das gleiche Ziel? : " + m.parallelePistenVon(sSeidlalm));

    // Aufgabe 10
    System.out.println("\nAUFGABE 10: ");
    System.out.println("Kein lift Abwärts: " + m.keinLiftAbwaertsZu(skigebiet, sBrixen));

    // Aufgabe 11
    System.out.println("\nAUFGABE 11: ");
    System.out.println("Hat Anfängerroute: " + m.hatAnfaengerRoute(sBrixen));

    // Aufgabe 12
    System.out.println("\nAUFGABE 12: ");
    System.out.println("Route befahrbar für " + m.befahrbarBis(fahrer2) + "m");

    // Aufgabe 13
    System.out.println("\nAUFGABE 13: ");
    System.out.println("Sind beide Routen disjunkt ?: " + m.sindDisjunkt(fahrer1, fahrer2));
  }

  public void zeigeSkigebiet(Station[] skigebiet) {
    // Gib das ganze Skigebiet zeilenweise in Textform aus. Durchlaufe hierfür das Array
    // skigebiet und gib für jede Station alle dort ausgehenden Liftverbindung (Array lifte) und
    // alle dort ausgehenden Pisten (Array pisten) mit ihrem jeweiligen Ziel aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
    System.out.println("*** Gesamtes Skigebiet ***");
    for (int x = 0; x < skigebiet.length; x++) {
      System.out.println(skigebiet[x].name + ": ");
      if (skigebiet[x].lifte != null) {
        for (int i = 0; i < skigebiet[x].lifte.length; i++) {
          System.out.println(
              " " + skigebiet[x].lifte[i].name + " --> " + skigebiet[x].lifte[i].ziel.name + "   ");
        }
      }
      if (skigebiet[x].pisten != null) {
        for (int i = 0; i < skigebiet[x].pisten.length; i++) {
          System.out.println(
              " "
                  + skigebiet[x].pisten[i].name
                  + " --> "
                  + skigebiet[x].pisten[i].ziel.name
                  + "   ");
        }
      }
    }
  }

  public void zeigeRoute(RElement r) {
    // Gib zeilenweise alle Lifte und Pisten auf der Route r in der gegebenen Reihenfolge aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
    while (r != null) {
      if (r.lift != null) {
        System.out.println(r.lift.name);
      }
      if (r.piste != null) {
        System.out.println(r.piste.name);
      }
      r = r.nF;
    }
  }

  public int offeneLifte(Station[] skigebiet) {
    // Zähle, wie viele derzeit offene Lifte es im Skigebiet gibt und liefere
    // diesen Wert zurück.
    int zaehler = 0;

    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          if (skigebiet[i].lifte[j].status == true) {
            zaehler++;
          }
        }
      }
    }
    return zaehler; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int pistenMeter(Station[] skigebiet) {
    // Liefere die insgesamt vorhandenen Pistenmeter im Skigebiet (unabhängig davon, ob
    // die Pisten gesperrt oder offen sind).
    int laenge = 0;

    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].pisten != null) {
        for (int j = 0; j < skigebiet[i].pisten.length; j++) {
          laenge += skigebiet[i].pisten[j].laenge;
        }
      }
    }

    return laenge; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int verbrauchtePunkte(RElement r) {
    // Liefere die auf der Route r verbrauchten Liftpunkte.
    int zaehler = 0;

    while (r != null) {
      if (r.lift != null) {
        zaehler += r.lift.punkte;
      }
      r = r.nF;
    }
    return zaehler; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public char maxFarbe(RElement r) {
    // Liefere die auf der Route r maximal vorkommende Pisten-Schwierigkeit, entsprechend
    // ihrer Farbe: b)lau = leicht, r)ot = mittel, s)chwarz = schwer.
    // Hinweis: Da 'b' im Alphabet vor 'r' kommt und 'r' vor 's', können Sie die
    // Vergleichsoperatoren <, >, = für den character-Wert "farbe" genau wie beim Vergleich
    // von Zahlen verwenden!
    char ergebnis = 'X';

    while (r != null) {
      if (r.piste != null && ergebnis < r.piste.farbe) {
        ergebnis = r.piste.farbe;
      }
      r = r.nF;
    }
    return ergebnis; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int maxHoehe(RElement r) {
    // Liefere die maximal auf der Route r erreichte Höhe ALS DIFFERENZ VOM START DER ROUTE AUS
    // GEMESSEN.
    // Achtung: Dieser Wert hängt sowohl von den gefahrenen Pisten als auch von den benutzten
    // Liften ab!
    int zaehler = 0;
    RElement kopf = r;

    while (r != null) {
      if (r.piste != null) {
        zaehler++;
      }
      if (r.lift != null) {
        zaehler++;
      }
      r = r.nF;
    }
    int[] hoehe = new int[zaehler + 1];
    zaehler = 1;
    r = kopf;

    while (r != null) {
      if (r.piste != null) {
        hoehe[zaehler] += hoehe[zaehler - 1] + r.piste.hdiff;
        zaehler++;
        //System.out.println(r.piste.hdiff);
      }
      if (r.lift != null) {
        //System.out.println(r.lift.hdiff);
        hoehe[zaehler] += hoehe[zaehler - 1] + r.lift.hdiff;
        zaehler++;
      }
      r = r.nF;
    }
    int ergebnis = hoehe[0];

    for (int i = 0; i < hoehe.length; i++) {
      if (ergebnis < hoehe[i]) {
        ergebnis = hoehe[i];
      }
    }
    return ergebnis; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int anzahlHuetten(RElement r) {
    // Liefere die Anzahl aller auf der Route r erreichten Hütten.
    // Bitte beachten Sie:
    // *) Die Startstation kann ignoriert werden.
    // *) Wenn die Route an einer bereits zuvor erreichten Hütte erneut vorbeiführt,
    //    treten Mehrfachzählungen auf. Das ist im Kontext dieser Aufgabe ok!
    int zaehler = 0;

    while (r != null) {
      if (r.piste != null && r.piste.ziel.huette == true) {
        zaehler++;
      }
      if (r.lift != null && r.lift.ziel.huette == true) {
        zaehler++;
      }
      r = r.nF;
    }
    return zaehler; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean parallelePistenVon(Station s) {
    // Prüfe, ob es von Station s AUSGEHEND mindestens zwei Pisten mit gleichem Ziel gibt.
    if (s.pisten != null) {
      for (int i = 0; i < s.pisten.length; i++) {
        for (int j = 0; j < s.pisten.length; j++) {
          if (s.pisten[i].ziel == s.pisten[j].ziel && i != j) {
            return true;
          }
        }
      }
    }
    return false; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
    // Liefert true, wenn kein zu Station s HINFÜHRENDER Lift abwärts geht (hdiff < 0).
    boolean vergleich = true;

    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          if (skigebiet[i].lifte[j].ziel == s) {
            if (skigebiet[i].lifte[j].hdiff < 0) {
              vergleich = false;
              break;
            }
          }
        }
      }
    }

    return vergleich; // Bitte durch Ihre Lösung ersetzen!
  }

  public boolean hatAnfaengerRoute(Station s) {
    // Liefert true, falls es von Station s ausgehend einen Lift gibt, an dessen Ziel
    // eine blaue Piste beginnt, die wiederum direkt zu s zurückführt ODER umgekehrt.
    boolean checkRoute = false;

    if (s.pisten != null) {
      for (int i = 0; i < s.pisten.length; i++) {
        if (s.pisten[i].farbe == 'b') {
          if (s.pisten[i].ziel.lifte != null) {
            for (int j = 0; j < s.pisten[i].ziel.lifte.length; j++) {
              if (s.pisten[i].ziel.lifte[j].ziel == s) {
                checkRoute = true;
                break;
              }
            }
          }
        }
      }
    }

    if (s.lifte != null) {
      for (int i = 0; i < s.lifte.length; i++) {
        if (s.lifte[i].ziel.pisten != null) {
          for (int j = 0; j < s.lifte[i].ziel.pisten.length; j++) {
            if (s.lifte[i].ziel.pisten[j].ziel == s && s.lifte[i].ziel.pisten[j].farbe == 'b') {
              checkRoute = true;
              break;
            }
          }
        }
      }
    }

    return checkRoute; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int befahrbarBis(RElement r) {
    // Liefere die Anzahl der Pistenmeter, bis zu der die Route r befahrbar (also nicht
    // gesperrt) ist.
    int meterzaehler = 0;

    while (r != null) {
      if (r.piste != null) {
        if (r.piste.status == true) {
          meterzaehler += r.piste.laenge;
        }
      }
      r = r.nF;
    }

    return meterzaehler; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean sindDisjunkt(RElement r1, RElement r2) {
    // Liefere true, falls die beiden Routen r1 und r2 disjunkt sind, d. h. kein Lift sowohl
    // in r1 und r2 vorkommt und keine Piste sowohl in r1 als auch r2 vorkommt.
    boolean checksame = true;
    RElement kopfr2 = r2;

    while (r1 != null) {
      while (r2 != null) {
        if (r1.piste != null && r2.piste != null && r1.piste.name == r2.piste.name) {
          checksame = false;
          break;
        }
        if (r1.lift != null && r2.lift != null && r1.lift.name == r2.lift.name) {
          checksame = false;
          break;
        }
        r2 = r2.nF;
      }
      r2 = kopfr2;
      r1 = r1.nF;
    }

    return checksame; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }
}
