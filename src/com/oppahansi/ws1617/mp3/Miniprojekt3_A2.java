/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Mark K. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp3;

public class Miniprojekt3_A2 {

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
    Miniprojekt3_A2 m = new Miniprojekt3_A2();

    // Beispielroute
    RElement r =
        new RElement(
            new Piste[] {pZinsbergAbfahrt},
            new Lift[] {lGondelbahnAuf, lZinsbergLift, lGondelbahnAb},
            new boolean[] {false, false, true, false});

    // An dieser Stelle können Sie unabhängig von JACK Ihre Methoden testen.
    // Anhand der Skizze auf dem Aufgabenblatt sowie den oben in der Klasse Miniprojekt3
    // erstellten Objekten für Lifte, Stationen und Pisten (ergänzen Sie bei Bedarf die
    // Skizze um Höhenangaben etc.) können Sie leicht von Hand ermitteln, welche Ergebnisse
    // Ihre Methoden für bestimmte Parameterwerte liefern müssten.
    //
    m.zeigeSkigebiet(skigebiet);
    m.zeigeRoute(r);
    System.out.println(m.offeneLifte(skigebiet));
    System.out.println(m.pistenMeter(skigebiet));
    System.out.println(m.verbrauchtePunkte(r));
    System.out.println(m.maxFarbe(r));
    System.out.println(m.maxHoehe(r));
    System.out.println(m.anzahlHuetten(r));
    System.out.println(m.parallelePistenVon(sSeidlalm) ? "true" : "false");
    System.out.println(m.keinLiftAbwaertsZu(skigebiet, sBrixen) ? "true" : "false");
    System.out.println(m.hatAnfaengerRoute(sChoralpe) ? "true" : "false");
  }

  public void zeigeSkigebiet(Station[] skigebiet) {
    // Gib das ganze Skigebiet zeilenweise in Textform aus. Durchlaufe hierfür das Array
    // skigebiet und gib für jede Station alle dort ausgehenden Liftverbindung (Array lifte) und
    // alle dort ausgehenden Pisten (Array pisten) mit ihrem jeweiligen Ziel aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    System.out.println("*** Gesamtes Skigebiet ***");
    for (Station s : skigebiet) {
      System.out.println(s.name);
      if (s.lifte != null)
        for (Lift l : s.lifte) System.out.println(" " + l.name + " -> " + l.ziel.name);
      if (s.pisten != null)
        for (Piste p : s.pisten) System.out.println(" " + p.name + " -> " + p.ziel.name);
    }
    //return; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public void zeigeRoute(RElement r) {
    // Gib zeilenweise alle Lifte und Pisten auf der Route r in der gegebenen Reihenfolge aus.
    //
    // KEINE BEWERTUNG DURCH JACK
    System.out.println("*** ROUTE ***");
    while (r != null) {
      System.out.println((r).lift == null ? r.piste.name : r.lift.name);
      r = r.nF;
    }
    //return; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int offeneLifte(Station[] skigebiet) {
    // Zähle, wie viele derzeit offene Lifte es im Skigebiet gibt und liefere
    // diesen Wert zurück.
    int counter = 0;
    for (Station s : skigebiet) if (s.lifte != null) for (Lift l : s.lifte) if (l.status) counter++;
    return counter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int pistenMeter(Station[] skigebiet) {
    // Liefere die insgesamt vorhandenen Pistenmeter im Skigebiet (unabhängig davon, ob
    // die Pisten gesperrt oder offen sind).
    int meter = 0;
    for (Station s : skigebiet) if (s.pisten != null) for (Piste p : s.pisten) meter += p.laenge;
    return meter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int verbrauchtePunkte(RElement r) {
    // Liefere die auf der Route r verbrauchten Liftpunkte.
    int punkte = 0;
    while (r != null) {
      if (r.lift != null) punkte += r.lift.punkte;
      r = r.nF;
    }
    return punkte; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public char maxFarbe(RElement r) {
    // Liefere die auf der Route r maximal vorkommende Pisten-Schwierigkeit, entsprechend
    // ihrer Farbe: b)lau = leicht, r)ot = mittel, s)chwarz = schwer.
    // Hinweis: Da 'b' im Alphabet vor 'r' kommt und 'r' vor 's', können Sie die
    // Vergleichsoperatoren <, >, = für den character-Wert "farbe" genau wie beim Vergleich
    // von Zahlen verwenden!
    char max = 'a'; //default value "no color".
    while (r != null) {
      if (r.piste != null && r.piste.farbe > max) max = r.piste.farbe;
      r = r.nF;
    }
    return max; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int maxHoehe(RElement r) {
    // Liefere die maximal auf der Route r erreichte Höhe ALS DIFFERENZ VOM START DER ROUTE AUS
    // GEMESSEN.
    // Achtung: Dieser Wert hängt sowohl von den gefahrenen Pisten als auch von den benutzten
    // Liften ab!
    int hdiff = 0, max = 0;
    while (r != null) {
      if (r.piste != null) hdiff += r.piste.hdiff;
      else hdiff += r.lift.hdiff;
      if (hdiff > max) max = hdiff;
      r = r.nF;
    }
    return max; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int anzahlHuetten(RElement r) {
    // Liefere die Anzahl aller auf der Route r erreichten Hütten.
    // Bitte beachten Sie:
    // *) Die Startstation kann ignoriert werden.
    // *) Wenn die Route an einer bereits zuvor erreichten Hütte erneut vorbeiführt,
    //    treten Mehrfachzählungen auf. Das ist im Kontext dieser Aufgabe ok!
    int huts = 0;
    while (r != null) {
      if ((r.piste != null && r.piste.ziel.huette) || (r.lift != null && r.lift.ziel.huette))
        huts++;
      r = r.nF;
    }
    return huts; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean parallelePistenVon(Station s) {
    // Prüfe, ob es von Station s AUSGEHEND mindestens zwei Pisten mit gleichem Ziel gibt.
    if (s.pisten != null)
      for (Piste p1 : s.pisten)
        for (Piste p2 : s.pisten) if (p1 != p2 && p1.ziel == p2.ziel) return true;
    return false; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
    // Liefert true, wenn kein zu Station s HINFÜHRENDER Lift abwärts geht (hdiff < 0).
    for (Station s1 : skigebiet)
      if (s1.lifte != null) for (Lift l : s1.lifte) if (l.ziel == s && l.hdiff < 0) return false;
    return true; // Bitte durch Ihre Lösung ersetzen!
  }

  public boolean hatAnfaengerRoute(Station s) {
    // Liefert true, falls es von Station s ausgehend einen Lift gibt, an dessen Ziel
    // eine blaue Piste beginnt, die wiederum direkt zu s zurückführt ODER umgekehrt.
    if (s.pisten != null)
      for (Piste p : s.pisten)
        if (p.farbe == 'b' && p.ziel.lifte != null)
          for (Lift l : p.ziel.lifte) if (l.ziel == s) return true;
    if (s.lifte != null)
      for (Lift l : s.lifte)
        if (s.pisten != null)
          for (Piste p : l.ziel.pisten) if (p.farbe == 'b' && p.ziel == s) return true;
    return false; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public int befahrbarBis(RElement r) {
    // Liefere die Anzahl der Pistenmeter, bis zu der die Route r befahrbar (also nicht
    // gesperrt) ist.
    int meter = 0;
    while (r != null) {
      if (r.piste != null)
        if (r.piste.status) meter += r.piste.laenge;
        else break;
      else if (!r.lift.status) break;
      r = r.nF;
    }
    return meter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }

  public boolean sindDisjunkt(RElement r1, RElement r2) {
    // Liefere true, falls die beiden Routen r1 und r2 disjunkt sind, d. h. kein Lift sowohl
    // in r1 und r2 vorkommt und keine Piste sowohl in r1 als auch r2 vorkommt.

    while (r1 != null) {
      RElement tmp = r2;
      while (tmp != null) {
        if ((r1.lift != null && r1.lift == tmp.lift) || r1.piste != null && r1.piste == tmp.piste)
          return false;
        tmp = tmp.nF;
      }
      r1 = r1.nF;
    }
    return true; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
  }
}
