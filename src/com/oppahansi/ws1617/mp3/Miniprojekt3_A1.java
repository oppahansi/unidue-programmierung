/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Manuel B. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Miniprojekt3_A1 {

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
    Miniprojekt3_A1 m = new Miniprojekt3_A1();

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
    m.zeigeSkigebiet(skigebiet);
    m.zeigeRoute(r);
    System.out.println(m.offeneLifte(skigebiet));
    System.out.println(m.pistenMeter(skigebiet));
    System.out.println(m.anzahlHuetten(r));
  }

  public void zeigeSkigebiet(Station[] skigebiet) {
    // Gib das ganze Skigebiet zeilenweise in Textform aus. Durchlaufe hierf�r das Array
    // skigebiet und gib f�r jede Station alle dort ausgehenden Liftverbindung (Array lifte) und
    // alle dort ausgehenden Pisten (Array pisten) mit ihrem jeweiligen Ziel aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    System.out.println("*** Gesamtes Skigebiet ***");
    for (Station aktuelleStation : skigebiet) {
      System.out.println(aktuelleStation.name);
      if (aktuelleStation.lifte != null) {
        for (Lift aktuellerLift : aktuelleStation.lifte) {
          System.out.println("   " + aktuellerLift.name + "   ->   " + aktuellerLift.ziel.name);
        }
      }
      if (aktuelleStation.pisten != null) {
        for (Piste aktuellePiste : aktuelleStation.pisten) {
          System.out.println("   " + aktuellePiste.name + "   ->   " + aktuellePiste.ziel.name);
        }
      }
    }
    System.out.println("");
  }

  public void zeigeRoute(RElement r) {
    // Gib zeilenweise alle Lifte und Pisten auf der Route r in der gegebenen Reihenfolge aus.
    //
    // KEINE BEWERTUNG DURCH JACK

    System.out.println("*** ROUTE ***");
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.lift != null) {
        System.out.println(aktuellesElement.lift.name);
      }
      if (aktuellesElement.piste != null) {
        System.out.println(aktuellesElement.piste.name);
      }
      aktuellesElement = aktuellesElement.nF;
    }
    System.out.println("");
  }

  public int offeneLifte(Station[] skigebiet) {
    // Z�hle, wie viele derzeit offene Lifte es im Skigebiet gibt und liefere
    // diesen Wert zur�ck.

    int counter = 0;
    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.lifte != null) {
        for (Lift aktuellerLift : aktuelleStation.lifte) {
          if (aktuellerLift.status) {
            counter++;
          }
        }
      }
    }
    return counter;
  }

  public int pistenMeter(Station[] skigebiet) {
    // Liefere die insgesamt vorhandenen Pistenmeter im Skigebiet (unabh�ngig davon, ob
    // die Pisten gesperrt oder offen sind).
    int counter = 0;
    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.pisten != null) {
        for (Piste aktuellePiste : aktuelleStation.pisten) {
          counter += aktuellePiste.laenge;
        }
      }
    }
    return counter;
  }

  public int verbrauchtePunkte(RElement r) {
    // Liefere die auf der Route r verbrauchten Liftpunkte.

    int counter = 0;
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.lift != null) {
        counter += aktuellesElement.lift.punkte;
      }
      aktuellesElement = aktuellesElement.nF;
    }
    return counter;
  }

  public char maxFarbe(RElement r) {
    // Liefere die auf der Route r maximal vorkommende Pisten-Schwierigkeit, entsprechend
    // ihrer Farbe: b)lau = leicht, r)ot = mittel, s)chwarz = schwer.
    // Hinweis: Da 'b' im Alphabet vor 'r' kommt und 'r' vor 's', k�nnen Sie die
    // Vergleichsoperatoren <, >, = f�r den character-Wert "farbe" genau wie beim Vergleich
    // von Zahlen verwenden!
    char result = 'b';
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.piste != null) {
        if (aktuellesElement.piste.farbe > result) {
          result = aktuellesElement.piste.farbe;
        }
      }
      aktuellesElement = aktuellesElement.nF;
    }
    return result;
  }

  public int maxHoehe(RElement r) {
    // Liefere die maximal auf der Route r erreichte H�he ALS DIFFERENZ VOM START DER ROUTE AUS
    // GEMESSEN.
    // Achtung: Dieser Wert h�ngt sowohl von den gefahrenen Pisten als auch von den benutzten
    // Liften ab!

    int result = Integer.MIN_VALUE;
    int differenz = 0;
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.lift != null) {
        differenz += aktuellesElement.lift.hdiff;
      }
      if (aktuellesElement.piste != null) {
        differenz += aktuellesElement.piste.hdiff;
      }
      if (result <= differenz) {
        result = differenz;
      }
      aktuellesElement = aktuellesElement.nF;
    }
    return result;
  }

  public int anzahlHuetten(RElement r) {
    // Liefere die Anzahl aller auf der Route r erreichten H�tten.
    // Bitte beachten Sie:
    // *) Die Startstation kann ignoriert werden.
    // *) Wenn die Route an einer bereits zuvor erreichten H�tte erneut vorbeif�hrt,
    //    treten Mehrfachz�hlungen auf. Das ist im Kontext dieser Aufgabe ok!

    int counter = 0;
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.lift != null) {
        if (aktuellesElement.lift.ziel.huette) {
          counter++;
        }
      } else {
        if (aktuellesElement.piste.ziel.huette) {
          counter++;
        }
      }
      aktuellesElement = aktuellesElement.nF;
    }
    return counter;
  }

  public boolean parallelePistenVon(Station s) {
    // Pr�fe, ob es von Station s AUSGEHEND mindestens zwei Pisten mit gleichem Ziel gibt.
    Station aktuell = s;
    if (aktuell.pisten != null) {
      for (int i = 0; i < aktuell.pisten.length; i++) {
        for (int j = i + 1; j < aktuell.pisten.length; j++) {
          if (aktuell.pisten[i].ziel == aktuell.pisten[j].ziel) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
    // Liefert true, wenn kein zu Station s HINF�HRENDER Lift abw�rts geht (hdiff < 0).

    for (Station aktuelleStation : skigebiet) {
      if (aktuelleStation.lifte != null) {
        for (Lift aktuellerLift : aktuelleStation.lifte) {
          if (aktuellerLift.hdiff < 0 && aktuellerLift.ziel == s) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean hatAnfaengerRoute(Station s) {
    // Liefert true, falls es von Station s ausgehend einen Lift gibt, an dessen Ziel
    // eine blaue Piste beginnt, die wiederum direkt zu s zur�ckf�hrt ODER umgekehrt.
    if (s.lifte != null) {
      for (Lift aktuellerLift : s.lifte) {
        if (aktuellerLift.ziel.pisten != null) {
          for (Piste aktuellePiste : aktuellerLift.ziel.pisten) {
            if (aktuellePiste.farbe == 'b' && aktuellePiste.ziel == s) return true;
          }
        }
      }
    }
    if (s.pisten != null) {
      for (Piste aktuellePiste : s.pisten) {
        if (aktuellePiste.farbe == 'b' && aktuellePiste.ziel.lifte != null) {
          for (Lift aktuellerLift : aktuellePiste.ziel.lifte) {
            if (aktuellerLift.ziel == s) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public int befahrbarBis(RElement r) {
    // Liefere die Anzahl der Pistenmeter, bis zu der die Route r befahrbar (also nicht
    // gesperrt) ist.
    int counter = 0;
    RElement aktuellesElement = r;
    while (aktuellesElement != null) {
      if (aktuellesElement.piste != null) {
        if (aktuellesElement.piste.status) {
          counter += aktuellesElement.piste.laenge;
        } else {
          break;
        }
      }
      if (aktuellesElement.lift != null) {
        if (aktuellesElement.lift.status) {

        } else {
          break;
        }
      }
      aktuellesElement = aktuellesElement.nF;
    }
    return counter;
  }

  public boolean sindDisjunkt(RElement r1, RElement r2) {
    int laenger1 = laenge(r1);
    int laenger2 = laenge(r2);
    for (int i = 0; i < laenger1; i++) {
      for (int j = 0; j < laenger2; j++) {
        if (ElementAufrufer(i, r1).lift != null && ElementAufrufer(j, r2).lift != null) {
          if (ElementAufrufer(i, r1).lift.name.equals(ElementAufrufer(j, r2).lift.name)) {
            return false;
          }
        }
        if (ElementAufrufer(i, r1).piste != null && ElementAufrufer(j, r2).piste != null) {
          if (ElementAufrufer(i, r1).piste.name.equals(ElementAufrufer(j, r2).piste.name)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private RElement ElementAufrufer(int index, RElement r) {
    if (index == 0 || r == null) {
    } else {
      for (int i = 0; i < index; i++) {
        r = r.nF;
      }
    }
    return r;
  }

  private int laenge(RElement r) {
    int counter = 0;
    if (r != null) {
      while (r != null) {
        counter++;
        r = r.nF;
      }
    }
    return counter;
  }
}
