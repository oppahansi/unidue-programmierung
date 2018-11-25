/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.miniprojekt.mp3.a1;

import java.util.Arrays;

public class Miniprojekt3 {

  public Speise[] alleSpeisen = new Speise[5];
  public Getraenk[] alleGetraenke = new Getraenk[6];
  public Tisch[] alleTische = new Tisch[5];

  public static void main(String[] args) {
    Miniprojekt3 m = new Miniprojekt3();

    // Alle vorhandenen Speisen gelistet im Array 'alleSpeisen'.
    m.alleSpeisen[0] =
        new Speise(
            11,
            "PIZZA SCAMPI RUCOLA",
            11.50,
            new String[] {
              "Scampi", "Rucola", "schwarze Oliven", "hausgemachte Tomatensauce", "Mozzarella"
            });
    m.alleSpeisen[1] =
        new Speise(
            12,
            "PIZZA DIAVOLO",
            10.50,
            new String[] {
              "Scharfe Peperoni-Salami",
              "frische Paprika",
              "rote Zwiebeln",
              "hausgemachte Tomatensauce",
              "Mozzarella"
            });
    m.alleSpeisen[2] =
        new Speise(
            13,
            "PASTA SCAMPI",
            8.90,
            new String[] {
              "Gebratene Scampi",
              "Fruehlingszwiebeln",
              "frische Tomaten",
              "hausgemachte Tomatensauce"
            });
    m.alleSpeisen[3] =
        new Speise(
            14, "PASTA CARBONARA", 7.60, new String[] {"Speck", "Zwiebeln", "Sahnesauce", "Ei"});
    m.alleSpeisen[4] =
        new Speise(
            15,
            "SALAT MISTA PICCOLA",
            4.90,
            new String[] {"Blattsalate", "Kirschtomaten", "Karotten", "Grana Padano"});

    // Alle vorhandenen Getraenke gelistet im Array 'alleGetraenke'.

    m.alleGetraenke[0] = new Getraenk(10, "Cola", "0.2 Liter", 2.20);
    m.alleGetraenke[1] = new Getraenk(11, "Cola", "0.4 Liter", 3.20);
    m.alleGetraenke[2] = new Getraenk(12, "Pils", "0.3 Liter", 2.80);
    m.alleGetraenke[3] = new Getraenk(13, "Pils", "0.5 Liter", 4.80);
    m.alleGetraenke[4] = new Getraenk(14, "Wasser", "0.3 Liter", 1.80);
    m.alleGetraenke[5] = new Getraenk(15, "Weinschorle", "0.3 Liter", 4.20);

    // Tische erstellen.

    m.alleTische[0] = new Tisch(11, 5);
    m.alleTische[1] = new Tisch(12, 4);
    m.alleTische[2] = new Tisch(13, 10);
    m.alleTische[3] = new Tisch(14, 2);
    m.alleTische[4] = new Tisch(15, 4);

    // Personen/Gruppen an einem Tisch platzieren
    // m.plazieren(11, 4);
    // m.plazieren(12, 4);
    // m.plazieren(15, 2);
    m.alleTische[0].setAnzahlPersonen(4);
    m.alleTische[1].setAnzahlPersonen(4);
    m.alleTische[4].setAnzahlPersonen(2);

    // Speisen und Getraenke hinzufuegen.
    m.alleTische[0].hinzufuegenSpeise(m.alleSpeisen[0]);
    m.alleTische[0].hinzufuegenSpeise(m.alleSpeisen[1]);
    m.alleTische[0].hinzufuegenSpeise(m.alleSpeisen[2]);
    m.alleTische[0].hinzufuegenSpeise(m.alleSpeisen[3]);
    m.alleTische[0].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[0].hinzufuegenGetraenk(m.alleGetraenke[5]);
    m.alleTische[4].hinzufuegenSpeise(m.alleSpeisen[4]);
    m.alleTische[4].hinzufuegenSpeise(m.alleSpeisen[4]);
    m.alleTische[4].hinzufuegenSpeise(m.alleSpeisen[3]);
    m.alleTische[4].hinzufuegenSpeise(m.alleSpeisen[1]);
    m.alleTische[4].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[4].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[1].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[1].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[1].hinzufuegenGetraenk(m.alleGetraenke[4]);
    m.alleTische[1].hinzufuegenGetraenk(m.alleGetraenke[4]);
    // ...

    // Buchungen hinzufuegen... neuen Zeitwert erstellen mit:
    // new Time(int Stunde, int Minute, int Sekunde).
    m.alleTische[0].hinzufuegenTischbuchung(12, 14);
    m.alleTische[1].hinzufuegenTischbuchung(11, 14);
    m.alleTische[0].hinzufuegenTischbuchung(14, 16);
    m.alleTische[2].hinzufuegenTischbuchung(10, 12);
    m.alleTische[2].hinzufuegenTischbuchung(20, 24);
    // Ausgabe.
    System.out.println("################# Tischbelegungen #################" + '\n');
    m.ausgabe(m.alleTische);
    m.ausgabeBuchung(m.alleTische);
    System.out.println("#######################################" + '\n');

    // Aufgaben testen.
    // System.out.println("Platziere 7 Personen an Tisch 13.");
    System.out.printf("%-60s\n", "Platziere 7 Personen an Tisch 13.");
    m.plazieren(13, 7);
    // System.out.println("Tisch 13 bestellt Getraenk mit ArtNr: 10, 13, 14 und Speisen mit ArtNr: 12, 13.");
    System.out.printf("%-60s\n", "Tisch 13 bestellt Getraenk mit ArtNr: 10, 13, 14.");
    System.out.printf("%-60s\n", "Tisch 13 bestellt Speisen mit ArtNr: 12, 13.");
    m.hinzufuegenGetraenk(13, 10);
    m.hinzufuegenGetraenk(13, 13);
    m.hinzufuegenGetraenk(13, 14);
    m.hinzufuegenSpeise(13, 12);
    m.hinzufuegenSpeise(13, 13);

    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Verfuegbare Tische zum Zeitpunkt 10: ", m.nichtReserviert(10), "(richtig: 4)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Verfuegbare Tische von 11 bis 13: ", m.nichtReserviert(11, 13), "(richtig: 2)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Zum Zeitpunkt 11 belegte Tische: ",
        Arrays.toString(m.belegteTische(11)),
        "(richtig: [12, 13])");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Rechnungssumme von Tisch 11: ", m.summeRechnung(11), "(richtig: 44.5)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Naechste Reservierung f�r Tisch 13 zum Zeitpunkt 11: ",
        m.naechsteReservierung(13, 11),
        "(richtig: 20 bis 24)");
    System.out.printf("%-60s\n", "Tischbuchung: Tisch 13 von Zeitpunkt 14 bis 16 buchen.");
    m.TischReservieren(13, 14, 16);
    System.out.printf("%-60s\n", "Bon fuer Tisch 15 verwerfen.");
    m.verwerfenBon(15);
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Tisch mit der hoechsten Rechnung: ", m.teuersterTisch(), "(richtig: 11)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Tische an denen nur Getraenke bestellt wurden: ",
        Arrays.toString(m.nurGetraenkeBestellt()),
        "(richtig: [12])");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Tische an denen noch zusaetzlich 2 Personen platz haben: ",
        Arrays.toString(m.extraFreiePlaetze(2)),
        "(richtig: [13, 15])");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Tisch mit der meisten Anzahl an Artikeln: ", m.maxArtikel(), "(richtig: 11)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Anzahl freier Pl�tze (belegte und nicht belegte Tische): ",
        m.freiePlaetze(),
        "(richtig: 8)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Aufteilen einer Gruppe (2 Personen) auf alle freien Tische: ",
        m.platzierenMoeglich(2),
        "(richtig: true)");
    System.out.printf(
        "%-60s%-15s%-20s\n",
        "Am h�ufigsten bestellte Getraenk ArtNr.: ", m.meisteGetraenk(), "(richtig: 14)");

    // System.out.println('\n' +
    // "############### neue Tischbelegungen ###############" +'\n');
    // m.ausgabe(m.alleTische);
    // m.ausgabeBuchung(m.alleTische);
    System.out.println("#######################################" + '\n');
  }

  /*
   * Gibt fuer alle Tische die momentan gebuchten Speisen und Getraenke aus.
   */
  public void ausgabe(Tisch[] tische) {
    for (int i = 0; i < tische.length; i++) {
      if (tische[i] != null) {
        System.out.println(
            "Tisch: "
                + tische[i].getTischnummer()
                + "  belegt mit "
                + tische[i].getAnzahlPersonen()
                + " von max. "
                + tische[i].getMaxAnzahlPersonen()
                + " Personen."
                + '\n');
        System.out.println("Speisen:");
        System.out.printf("%-12s%-24s%-12s\n", "ArtNr.", "Name", "Preis");
        Speise tempSpeise = tische[i].getSpeisen();
        while (tempSpeise != null) {
          System.out.printf(
              "%-12d%-24s%-12s\n",
              tempSpeise.getArtNr(), tempSpeise.getName(), tempSpeise.getPreis());
          tempSpeise = tempSpeise.getNachfolger();
        }
        System.out.println('\n' + "Getraenke:");
        System.out.printf("%-12s%-12s%-12s%-12s\n", "ArtNr.", "Name", "Groesse", "Preis");
        Getraenk tempGetraenk = tische[i].getGetraenke();
        while (tempGetraenk != null) {
          System.out.printf(
              "%-12s%-12s%-12s%-12s\n",
              tempGetraenk.getArtNr(),
              tempGetraenk.getName(),
              tempGetraenk.groesse,
              tempGetraenk.getPreis());
          tempGetraenk = tempGetraenk.getNachfolger();
        }
        System.out.println('\n');
      }
    }
  }

  /*
   * Gibt fuer alle Tische die momentanen Buchungen aus.
   */
  public void ausgabeBuchung(Tisch[] tische) {
    System.out.println("Momentane Tisch-Buchungen:" + '\n');
    for (int i = 0; i < tische.length; i++) {
      if (tische[i] != null) {
        System.out.println("Tisch: " + tische[i].getTischnummer());
        Tischbuchung tempBuchung = tische[i].getTischbuchungen();
        while (tempBuchung != null) {
          System.out.println(tempBuchung.getStart() + " bis " + tempBuchung.getEnde());
          tempBuchung = tempBuchung.getNachfolger();
        }
        System.out.println('\n');
      }
    }
  }

  // Aufgaben...
  // 1
  public void plazieren(int Tischnummer, int AnzahlPersonen) {
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        aktuellerTisch.setAnzahlPersonen(AnzahlPersonen);
        break;
      }
    }
  }

  // 2
  public void hinzufuegenSpeise(int Tischnummer, int SpeiseArtNr) {
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        for (Speise aktuelleSpeise : alleSpeisen) {
          if (aktuelleSpeise.getArtNr() == SpeiseArtNr) {
            aktuellerTisch.hinzufuegenSpeise(aktuelleSpeise);
            break;
          }
        }
        break;
      }
    }
  }

  public void hinzufuegenGetraenk(int Tischnummer, int GetraenkArtNr) {
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        for (Getraenk aktuellesGetraenk : alleGetraenke) {
          if (aktuellesGetraenk.getArtNr() == GetraenkArtNr) {
            aktuellerTisch.hinzufuegenGetraenk(aktuellesGetraenk);
            break;
          }
        }
        break;
      }
    }
  }

  // 3
  public int nichtReserviert(int Zeitpunkt) {
    int verfuegbareTische = 0;

    for (Tisch aktuellerTisch : alleTische) {
      Tischbuchung aktuelleTischbuchung = aktuellerTisch.getTischbuchungen();

      if (aktuelleTischbuchung == null) {
        verfuegbareTische++;
      } else {
        boolean verfuegbar = true;

        while (aktuelleTischbuchung != null) {
          if (Zeitpunkt >= aktuelleTischbuchung.getStart()
              && Zeitpunkt < aktuelleTischbuchung.getEnde()) {
            verfuegbar = false;
            break;
          }
          aktuelleTischbuchung = aktuelleTischbuchung.getNachfolger();
        }

        if (verfuegbar) {
          verfuegbareTische++;
        }
      }
    }

    return verfuegbareTische;
  }

  public int nichtReserviert(int BelegtStart, int BelegtEnde) {
    int verfuegbareTische = 0;

    for (Tisch aktuellerTisch : alleTische) {
      Tischbuchung aktuelleTischbuchung = aktuellerTisch.getTischbuchungen();

      if (aktuelleTischbuchung == null) {
        verfuegbareTische++;
      } else {
        boolean verfuegbar = true;

        while (aktuelleTischbuchung != null) {
          if ((BelegtStart >= aktuelleTischbuchung.getStart()
                  && BelegtStart < aktuelleTischbuchung.getEnde())
              || (BelegtEnde >= aktuelleTischbuchung.getStart()
                  && BelegtEnde < aktuelleTischbuchung.getEnde())
              || (BelegtStart < aktuelleTischbuchung.getStart()
                  && BelegtEnde >= aktuelleTischbuchung.getEnde())) {
            verfuegbar = false;
            break;
          }
          aktuelleTischbuchung = aktuelleTischbuchung.getNachfolger();
        }

        if (verfuegbar) {
          verfuegbareTische++;
        }
      }
    }

    return verfuegbareTische;
  }

  // 4
  public int[] belegteTische(int Zeitpunkt) {
    int[] belegteTische = new int[alleTische.length - nichtReserviert(Zeitpunkt)];
    int index = 0;

    for (Tisch aktuellerTisch : alleTische) {
      Tischbuchung aktuelleTischbuchung = aktuellerTisch.getTischbuchungen();

      while (aktuelleTischbuchung != null) {
        if (Zeitpunkt >= aktuelleTischbuchung.getStart()
            && Zeitpunkt < aktuelleTischbuchung.getEnde()) {
          belegteTische[index] = aktuellerTisch.getTischnummer();
          index++;
          break;
        }
        aktuelleTischbuchung = aktuelleTischbuchung.getNachfolger();
      }
    }

    return belegteTische;
  }

  // 5
  public double summeRechnung(int Tischnummer) {
    double rechnungsSumme = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        Speise aktuelleSpeise = aktuellerTisch.getSpeisen();
        Getraenk aktuellesGetraenk = aktuellerTisch.getGetraenke();

        while (aktuelleSpeise != null || aktuellesGetraenk != null) {
          if (aktuelleSpeise != null) {
            rechnungsSumme += aktuelleSpeise.getPreis();
            aktuelleSpeise = aktuelleSpeise.getNachfolger();
          }
          if (aktuellesGetraenk != null) {
            rechnungsSumme += aktuellesGetraenk.getPreis();
            aktuellesGetraenk = aktuellesGetraenk.getNachfolger();
          }
        }

        break;
      }
    }

    return rechnungsSumme;
  }

  // 6
  public String naechsteReservierung(int Tischnummer, int Zeitpunkt) {
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        Tischbuchung aktuelleTischbuchung = aktuellerTisch.getTischbuchungen();

        while (aktuelleTischbuchung != null) {
          if (Zeitpunkt <= aktuelleTischbuchung.getStart()) {
            return "" + aktuelleTischbuchung.getStart() + " bis " + aktuelleTischbuchung.getEnde();
          }
          aktuelleTischbuchung = aktuelleTischbuchung.getNachfolger();
        }
      }
    }

    return null;
  }

  // 7
  public void TischReservieren(int Tischnummer, int BelegtStart, int BelegtEnde) {
    // hier die Loesung eintragen...
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        aktuellerTisch.hinzufuegenTischbuchung(BelegtStart, BelegtEnde);
        break;
      }
    }
  }

  // 8
  public void verwerfenBon(int Tischnummer) {
    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getTischnummer() == Tischnummer) {
        aktuellerTisch.speisen = null;
        aktuellerTisch.getraenke = null;
        break;
      }
    }
  }

  // 9
  public int teuersterTisch() {
    double hoechsteRechnung = 0;
    int tischNummer = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (hoechsteRechnung < summeRechnung(aktuellerTisch.getTischnummer())) {
        hoechsteRechnung = summeRechnung(aktuellerTisch.getTischnummer());
        tischNummer = aktuellerTisch.getTischnummer();
      }
    }

    return tischNummer;
  }

  // 10
  public int[] nurGetraenkeBestellt() {
    int[] tischeOhneSpeisen = new int[getAnzTischeOhneSpeisen()];
    int index = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getSpeisen() == null && aktuellerTisch.getGetraenke() != null) {
        tischeOhneSpeisen[index] = aktuellerTisch.getTischnummer();
        index++;
      }
    }

    return tischeOhneSpeisen;
  }

  private int getAnzTischeOhneSpeisen() {
    int anzTischeOhneSpeisen = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getSpeisen() == null && aktuellerTisch.getGetraenke() != null) {
        anzTischeOhneSpeisen++;
      }
    }

    return anzTischeOhneSpeisen;
  }

  // 11
  public int[] extraFreiePlaetze(int AnzahlPersonen) {
    int[] tischeMitFreienPlaetzen = new int[getAnzTischeMitFreienPlaetzen(AnzahlPersonen)];
    int index = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getAnzahlPersonen() > 0
          && aktuellerTisch.getMaxAnzahlPersonen() - aktuellerTisch.getAnzahlPersonen()
              >= AnzahlPersonen) {
        tischeMitFreienPlaetzen[index] = aktuellerTisch.getTischnummer();
        index++;
      }
    }

    return tischeMitFreienPlaetzen;
  }

  private int getAnzTischeMitFreienPlaetzen(int anzahlPersonen) {
    int anzTischeMitFreienPlaetzen = 0;

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getAnzahlPersonen() > 0
          && aktuellerTisch.getMaxAnzahlPersonen() - aktuellerTisch.getAnzahlPersonen()
              >= anzahlPersonen) {
        anzTischeMitFreienPlaetzen++;
      }
    }

    return anzTischeMitFreienPlaetzen;
  }

  // 12
  public int maxArtikel() {
    int tischNummer = 0;
    int meisteArtikeln = 0;

    for (Tisch aktuellerTisch : alleTische) {
      Speise aktuelleSpeise = aktuellerTisch.getSpeisen();
      Getraenk aktuellesGetraenk = aktuellerTisch.getGetraenke();

      int artikelkZaehler = 0;

      while (aktuelleSpeise != null || aktuellesGetraenk != null) {
        if (aktuelleSpeise != null) {
          aktuelleSpeise = aktuelleSpeise.getNachfolger();
          artikelkZaehler++;
        }
        if (aktuellesGetraenk != null) {
          aktuellesGetraenk = aktuellesGetraenk.getNachfolger();
          artikelkZaehler++;
        }
      }

      if (meisteArtikeln < artikelkZaehler) {
        meisteArtikeln = artikelkZaehler;
        tischNummer = aktuellerTisch.getTischnummer();
      }
    }

    return tischNummer;
  }

  // 13
  public int freiePlaetze() {
    int freiePlaetze = 0;

    for (Tisch aktuellerTisch : alleTische) {
      freiePlaetze += (aktuellerTisch.getMaxAnzahlPersonen() - aktuellerTisch.getAnzahlPersonen());
    }

    return freiePlaetze;
  }

  // 14
  public boolean platzierenMoeglich(int AnzahlPersonen) {
    return freiePlaetze() >= AnzahlPersonen;
  }

  // 15
  public int meisteGetraenk() {
    int[] getraenkeHaeufigkeiten = new int[alleGetraenke.length];

    for (Tisch aktuellerTisch : alleTische) {
      if (aktuellerTisch.getGetraenke() != null) {
        Getraenk aktuellesGetraenk = aktuellerTisch.getGetraenke();

        while (aktuellesGetraenk != null) {
          if (aktuellesGetraenk.getArtNr() == 10) {
            getraenkeHaeufigkeiten[0]++;
          } else if (aktuellesGetraenk.getArtNr() == 11) {
            getraenkeHaeufigkeiten[1]++;
          } else if (aktuellesGetraenk.getArtNr() == 12) {
            getraenkeHaeufigkeiten[2]++;
          } else if (aktuellesGetraenk.getArtNr() == 13) {
            getraenkeHaeufigkeiten[3]++;
          } else if (aktuellesGetraenk.getArtNr() == 14) {
            getraenkeHaeufigkeiten[4]++;
          } else {
            getraenkeHaeufigkeiten[5]++;
          }

          aktuellesGetraenk = aktuellesGetraenk.getNachfolger();
        }
      }
    }
    return getHaeufigsteGetraenk(getraenkeHaeufigkeiten);
  }

  private int getHaeufigsteGetraenk(int[] haeufigkeiten) {
    int max = 0;
    int index = 0;

    for (int i = 0; i < haeufigkeiten.length; i++) {
      if (max < haeufigkeiten[i]) {
        max = haeufigkeiten[i];
        index = i;
      }
    }

    return alleGetraenke[index].getArtNr();
  }
}
