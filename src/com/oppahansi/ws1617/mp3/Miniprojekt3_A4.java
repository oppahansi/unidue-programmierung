/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Miniprojekt3_A4 {

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
    Miniprojekt3_A4 m = new Miniprojekt3_A4();

    // Beispielroute
    RElement r =
        new RElement(
            new Piste[] {pZinsbergAbfahrt},
            new Lift[] {lGondelbahnAuf, lZinsbergLift, lGondelbahnAb},
            new boolean[] {false, false, true, false});
    RElement r1 =
        new RElement(
            new Piste[] {pZinsbergAbfahrt}, new Lift[] {lZinsbergLift}, new boolean[] {false});

    // An dieser Stelle k�nnen Sie unabh�ngig von JACK Ihre Methoden testen.
    // Anhand der Skizze auf dem Aufgabenblatt sowie den oben in der Klasse Miniprojekt3
    // erstellten Objekten f�r Lifte, Stationen und Pisten (erg�nzen Sie bei Bedarf die
    // Skizze um H�henangaben etc.) k�nnen Sie leicht von Hand ermitteln, welche Ergebnisse
    // Ihre Methoden f�r bestimmte Parameterwerte liefern m�ssten.
    //
    m.zeigeSkigebiet(skigebiet);
    m.zeigeRoute(r);
    System.out.println(m.offeneLifte(skigebiet));
    System.out.println(m.anzahlHuetten(r));
    System.out.println(m.pistenMeter(skigebiet));
    System.out.println(m.verbrauchtePunkte(r));
    System.out.println(m.maxFarbe(r));
    System.out.println(m.maxHoehe(r));
    System.out.println(m.anzahlHuetten(r));
    System.out.println(m.parallelePistenVon(sSeidlalm));
    System.out.println(m.keinLiftAbwaertsZu(skigebiet, sSeidlalm));
    System.out.println(m.hatAnfaengerRoute(sZinsberg));
    System.out.println(m.befahrbarBis(r));
    System.out.println(m.sindDisjunkt(r, r1));
  }

  public void zeigeSkigebiet(Station[] skigebiet) {
    // Gib das ganze Skigebiet zeilenweise in Textform aus. Durchlaufe hierf�r das Array
    // skigebiet und gib f�r jede Station alle dort ausgehenden Liftverbindung (Array lifte) und
    // alle dort ausgehenden Pisten (Array pisten) mit ihrem jeweiligen Ziel aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!

    for (int i = 0; i < skigebiet.length; i++) {
      System.out.println(skigebiet[i].name);
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          System.out.println(skigebiet[i].lifte[j].name + "->" + skigebiet[i].lifte[j].ziel.name);
        }
      }
      if (skigebiet[i].pisten != null) {
        for (int a = 0; a < skigebiet[i].pisten.length; a++) {
          System.out.println(skigebiet[i].pisten[a].name + "->" + skigebiet[i].pisten[a].ziel.name);
        }
      }
    }
  }

  public void zeigeRoute(RElement r) {
    // Gib zeilenweise alle Lifte und Pisten auf der Route r in der gegebenen Reihenfolge aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    RElement a = r;
    System.out.println("** ROUTE **");
    while (a != null) {
      if (a.piste != null) {
        System.out.println(a.piste.name);
      } else {
        System.out.println(a.lift.name);
      }
      a = a.nF;
    }
  }

  public int offeneLifte(Station[] skigebiet) {
    // Z�hle, wie viele derzeit offene Lifte es im Skigebiet gibt und liefere
    // diesen Wert zur�ck.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    int aus = 0;
    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          if (skigebiet[i].lifte[j].status) {
            aus++;
          }
        }
      }
    }

    return aus;
  }

  public int pistenMeter(Station[] skigebiet) {
    // Liefere die insgesamt vorhandenen Pistenmeter im Skigebiet (unabh�ngig davon, ob
    // die Pisten gesperrt oder offen sind).
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!

    int aus = 0;
    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].pisten != null) {
        for (int j = 0; j < skigebiet[i].pisten.length; j++) {
          aus = aus + skigebiet[i].pisten[j].laenge;
        }
      }
    }
    return aus;
  }

  public int verbrauchtePunkte(RElement r) {
    // Liefere die auf der Route r verbrauchten Liftpunkte.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    int punkte = 0;
    RElement anfang = r;
    while (anfang != null) {
      if (anfang.lift != null) {
        punkte += anfang.lift.punkte;
      }
      anfang = anfang.nF;
    }
    return punkte;
  }

  public char maxFarbe(RElement r) {
    // Liefere die auf der Route r maximal vorkommende Pisten-Schwierigkeit, entsprechend
    // ihrer Farbe: b)lau = leicht, r)ot = mittel, s)chwarz = schwer.
    // Hinweis: Da 'b' im Alphabet vor 'r' kommt und 'r' vor 's', k�nnen Sie die
    // Vergleichsoperatoren <, >, = f�r den character-Wert "farbe" genau wie beim Vergleich
    // von Zahlen verwenden!
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    int bl = 0, ro = 0, sw = 0;
    RElement x = r;
    while (x != null) {
      if (x.piste != null) {
        if (x.piste.farbe == 'b') {
          bl++;
        }
        if (x.piste.farbe == 'r') {
          ro++;
        }
        if (x.piste.farbe == 's') {
          sw++;
        }
      }
      x = x.nF;
    }
    if (bl > ro && bl > sw) {
      return 'b';
    } else {
      if (ro > bl && ro > sw) {
        return 'r';
      } else {
        return 's';
      }
    }
  }

  public int maxHoehe(RElement r) {

    // Liefere die maximal auf der Route r erreichte H�he ALS DIFFERENZ VOM START DER ROUTE AUS
    // GEMESSEN.
    // Achtung: Dieser Wert h�ngt sowohl von den gefahrenen Pisten als auch von den benutzten
    // Liften ab!
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!

    int index = 0;
    RElement x = r;
    while (x != null) {
      x = x.nF;
      index++;
    }
    int[] arr = new int[index];
    int i = 0;
    RElement a = r;
    while (a != null) {
      if (a.lift != null) {
        arr[i] = a.lift.hdiff;
      } else {
        arr[i] = a.piste.hdiff;
      }
      a = a.nF;
      i++;
    }
    int max = 0;
    int min = 0;
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] > 0 && arr[j] >= -min) {
        max = max + arr[j] + min;
        min = 0;
      } else {
        min = min + arr[j];
      }
    }

    return max;
  }

  public int anzahlHuetten(RElement r) {
    // Liefere die Anzahl aller auf der Route r erreichten H�tten.
    // Bitte beachten Sie:
    // *) Die Startstation kann ignoriert werden.
    // *) Wenn die Route an einer bereits zuvor erreichten H�tte erneut vorbeif�hrt,
    //    treten Mehrfachz�hlungen auf. Das ist im Kontext dieser Aufgabe ok!
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    int aus = 0;
    RElement x = r;
    while (x != null) {
      if (x.lift != null) {
        if (x.lift.ziel.huette) {
          aus++;
        }
      } else {
        if (x.piste.ziel.huette) {
          aus++;
        }
      }
      x = x.nF;
    }
    return aus;
  }

  public boolean parallelePistenVon(Station s) {
    // Pr�fe, ob es von Station s AUSGEHEND mindestens zwei Pisten mit gleichem Ziel gibt.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    boolean aus = false;
    if (s.pisten != null && s.pisten.length > 1) {
      for (int i = 0; i < s.pisten.length; i++) {
        for (int j = i + 1; j < s.pisten.length; j++) {
          if (s.pisten[i].ziel == s.pisten[j].ziel) {
            aus = true;
          }
        }
      }
    }
    return aus;
  }

  public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
    // Liefert true, wenn kein zu Station s HINF�HRENDER Lift abw�rts geht (hdiff < 0).
    // Bitte durch Ihre L�sung ersetzen!
    boolean aus = true;
    for (int i = 0; i < skigebiet.length; i++) {
      if (skigebiet[i].lifte != null) {
        for (int j = 0; j < skigebiet[i].lifte.length; j++) {
          if (skigebiet[i].lifte[j].ziel == s && skigebiet[i].lifte[j].hdiff < 0) {
            aus = false;
          }
        }
      }
    }
    return aus;
  }

  public boolean hatAnfaengerRoute(Station s) {
    // Liefert true, falls es von Station s ausgehend einen Lift gibt, an dessen Ziel
    // eine blaue Piste beginnt, die wiederum direkt zu s zur�ckf�hrt ODER umgekehrt.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!

    boolean aus = false;
    if (s.lifte != null) {
      for (int i = 0; i < s.lifte.length; i++) {
        if (s.lifte[i].ziel.pisten != null) {
          for (int j = 0; j < s.lifte[i].ziel.pisten.length; j++) {
            if (s.lifte[i].ziel.pisten[j].ziel == s && s.lifte[i].ziel.pisten[j].farbe == 'b') {
              aus = true;
            }
          }
        }
      }
    }
    if (s.pisten != null) {
      for (int i = 0; i < s.pisten.length; i++) {
        if (s.pisten[i].ziel.lifte != null && s.pisten[i].farbe == 'b') {
          for (int j = 0; j < s.pisten[i].ziel.lifte.length; j++) {
            if (s.pisten[i].ziel.lifte[j].ziel == s) {
              aus = true;
            }
          }
        }
      }
    }

    return aus;
  }

  public int befahrbarBis(RElement r) {
    // Liefere die Anzahl der Pistenmeter, bis zu der die Route r befahrbar (also nicht
    // gesperrt) ist.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!

    int aus = 0;
    RElement s = r;
    while (s != null) {
      if (s.piste != null) {
        if (!s.piste.status) {
          break;
        } else {
          aus += s.piste.laenge;
        }
      } else {
        if (s.lift != null) {
          if (!s.lift.status) {
            break;
          }
        }
      }
      s = s.nF;
    }
    return aus;
  }

  public boolean sindDisjunkt(RElement r1, RElement r2) {
    // Liefere true, falls die beiden Routen r1 und r2 disjunkt sind, d. h. kein Lift sowohl
    // in r1 und r2 vorkommt und keine Piste sowohl in r1 als auch r2 vorkommt.
    // Bitte ersetzen Sie diese Zeile durch Ihre L�sung!
    boolean aus = true;
    RElement x = r1;

    while (x != null) {
      if (x.lift != null) {
        RElement y = r2;
        while (y != null) {
          if (x.lift == y.lift) {
            aus = false;
            break;
          }
          y = y.nF;
        }
      } else {
        RElement y = r2;
        while (y != null) {
          if (x.piste == y.piste) {
            aus = false;
            break;
          }
          y = y.nF;
        }
      }
      x = x.nF;
    }
    return aus;
  }
}
