/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 2
 */
package com.oppahansi.ws1415.miniprojekt2;

public class Miniprojekt2_A2 {

  private final int FREI = 0;
  private final int BEZAHLT = Integer.MAX_VALUE;
  private final int ASCII = 65;
  // ab hier bitte keine Änderungen vornehmen
  int[][] kinosaal;
  private int reservierungsNummer = 0;

  // bis hier bitte keine Änderungen vornehmen
  // hier beginnt der zu bearbeitende Teil

  public Miniprojekt2_A2(int anzahlReihen, int anzahlProReihe) {
    this.kinosaal = new int[anzahlReihen][anzahlProReihe];
  }

  public static void main(String[] args) {
    Miniprojekt2_A2 demo = new Miniprojekt2_A2(3, 5);
    System.out.println("Der leere Saal sieht so aus (- frei, B bezahlt, R reserviert):");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert fuer den existierenden Platz C 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode platzBelegt liefert fuer den nicht existierenden Platz  Q 23: "
            + demo.platzBelegt('Q', 23));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert fuer Reihe C Plaetze 3-7 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 3, 7));
    System.out.println("Nach der Reservierung der Plaetze 3,4,5,6 und 7 in der Reihe C:");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert fuer den reservierten Platz C 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert fuer Reihe C Plaetze 1-3 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 1, 3));
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert fuer Reihe D Plaetze 7-5 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 7, 5));
    demo.debugPrint();
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert fuer Reihe D Plaetze 1-2 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 1, 2));
    demo.debugPrint();
    System.out.println(
        "Der Anteil der freien Plaetze ist: " + demo.anteilFreiePlaetze() * 100 + "%");
    System.out.println(
        "Die Methode bezahleReservierung liefert fuer Reservierung 7: "
            + demo.bezahleReservierung(7));
    System.out.println(
        "Die Methode bezahleReservierung liefert fuer Reservierung 1: "
            + demo.bezahleReservierung(1));
    demo.debugPrint();
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode effizienteReservierung liefert fuer 6 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(6));
    demo.festePlaetzeReservieren('A', 1, 2);
    System.out.println("TEST " + demo.effizienteReservierung(3));
    System.out.println("TEST " + demo.effizienteReservierung(2));
    demo.debugPrint();
    System.out.println(
        "Die Methode effizienteReservierung liefert fuer 100 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(100));
    demo.debugPrint();
    System.out.println(
        "Nach dem Aufruf der Methode neueVorstellungVorbereiten sieht der Kinosaal wieder so aus:");
    demo.neueVorstellungVorbereiten();
    demo.debugPrint();
    System.out.println("Nach zwei Reservierungen:");
    demo.festePlaetzeReservieren('B', 5, 5);
    demo.festePlaetzeReservieren('A', 1, 1);
    demo.festePlaetzeReservieren('A', 2, 2);
    demo.festePlaetzeReservieren('A', 5, 5);
    //demo.festePlaetzeReservieren('D', 4, 7);
    System.out.println(
        "Die Methode knoblauchReservierung liefert fuer 3 Leute die Reservierungsnummer: "
            + demo.knoblauchReservierung(4));
    demo.debugPrint();
  }

  int[][] getKinosaal() {
    return kinosaal;
  }

  void setKinosaal(int[][] kinosaal) {
    this.kinosaal = kinosaal;
  }

  private void debugPrint() {
    System.out.print("   1");
    for (int i = 1; i < kinosaal[0].length - 1; i++) {
      System.out.print("  ");
    }
    System.out.println(" " + kinosaal[0].length);
    for (int i = 0; i < kinosaal.length; i++) {
      System.out.print((char) ('A' + i) + ":");
      for (int j = 0; j < kinosaal[i].length; j++) {
        if (kinosaal[i][j] == 0) {
          System.out.print(" -");
        } else if (kinosaal[i][j] > 0 && kinosaal[i][j] < Integer.MAX_VALUE) {
          System.out.print(" R");
        } else {
          System.out.print(" B");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public void neueVorstellungVorbereiten() {
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzInReihe = 0; platzInReihe < kinosaal[reihenNummer].length; platzInReihe++) {
        kinosaal[reihenNummer][platzInReihe] = FREI;
      }
    }
    setReservierungsNummer(0);
  }

  public int naechsteReservierungsnummer() {
    int groessteReservierungsNummer = 0;
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzInReihe = 0; platzInReihe < kinosaal[0].length; platzInReihe++) {
        if (kinosaal[reihenNummer][platzInReihe] >= groessteReservierungsNummer
            && kinosaal[reihenNummer][platzInReihe] != BEZAHLT) {
          groessteReservierungsNummer = kinosaal[reihenNummer][platzInReihe];
        }
      }
    }
    return groessteReservierungsNummer + 1;
  }

  public int getReservierungsNummer() {
    return reservierungsNummer;
  }

  public void setReservierungsNummer(int neueReservierungsNummer) {
    this.reservierungsNummer = neueReservierungsNummer;
  }

  public boolean platzBelegt(char reihe, int platz) {
    if (getReiheAusChar(reihe) < 0
        || getReiheAusChar(reihe) >= kinosaal.length
        || platz < 0
        || platz > kinosaal[0].length) {
      return false;
    } else {
      if (kinosaal[getReiheAusChar(reihe)][platz - 1] != FREI) {
        return true;
      } else {
        return false;
      }
    }
  }

  public boolean platzBelegt(int reihe, int platz) {
    if (reihe < 0 || reihe >= kinosaal.length || platz <= 0 || platz > kinosaal[0].length) {
      return false;
    } else {
      if (kinosaal[reihe][platz - 1] != FREI) {
        return true;
      } else {
        return false;
      }
    }
  }

  public int getReiheAusChar(char reiheCharWert) {
    return (int) reiheCharWert - ASCII;
  }

  public int festePlaetzeReservieren(char reihe, int start, int ende) {
    if (getReiheAusChar(reihe) < 0
        || getReiheAusChar(reihe) >= kinosaal.length
        || start < 0
        || start > kinosaal[0].length
        || ende < 0
        || ende > kinosaal[0].length
        || start > ende) {
      return -1;
    } else {
      for (int platzNummer = start - 1; platzNummer < ende; platzNummer++) {
        if (platzBelegt(reihe, platzNummer + 1)) {
          return -1;
        }
      }
      int reservierung = naechsteReservierungsnummer();
      for (int platzNummer = start - 1; platzNummer < ende; platzNummer++) {
        kinosaal[getReiheAusChar(reihe)][platzNummer] = reservierung;
      }
      setReservierungsNummer(reservierung);
      return getReservierungsNummer();
    }
  }

  public boolean bezahleReservierung(int nummer) {
    return reservierungPruefen(nummer);
  }

  private boolean reservierungPruefen(int nummer) {
    boolean vorhanden = false;
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzNummer = 0; platzNummer < kinosaal[0].length; platzNummer++) {
        if (kinosaal[reihenNummer][platzNummer] == nummer) {
          vorhanden = true;
        }
      }
    }
    if (vorhanden) {
      for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
        for (int platzNummer = 0; platzNummer < kinosaal[0].length; platzNummer++) {
          if (kinosaal[reihenNummer][platzNummer] == nummer) {
            kinosaal[reihenNummer][platzNummer] = BEZAHLT;
          }
        }
      }
    }
    return vorhanden;
  }

  public float anteilFreiePlaetze() {
    return (float) getAnzFreiePlaetze() / (kinosaal.length * kinosaal[0].length);
  }

  public int getAnzFreiePlaetze() {
    int anzFreiePlaetze = 0;
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzNummer = 0; platzNummer < kinosaal[0].length; platzNummer++) {
        if (kinosaal[reihenNummer][platzNummer] == FREI) {
          anzFreiePlaetze++;
        }
      }
    }
    return anzFreiePlaetze;
  }

  public int effizienteReservierung(int anzalLeute) {
    if (anzalLeute > kinosaal[0].length) {
      return -1;
    } else {
      int verbleibendeLeute = anzalLeute;
      for (int reihenNummer = kinosaal.length - 1; reihenNummer >= 0; reihenNummer--) {
        if (reiheOk(reihenNummer, anzalLeute)) {
          int reservierung = naechsteReservierungsnummer();
          for (int platzInReihe = kinosaal[0].length - 1;
              platzInReihe >= 0 && verbleibendeLeute > 0;
              platzInReihe--) {
            if (kinosaal[reihenNummer][platzInReihe] == FREI) {
              kinosaal[reihenNummer][platzInReihe] = reservierung;
              verbleibendeLeute--;
            }
          }
          setReservierungsNummer(reservierung);
          return getReservierungsNummer();
        }
      }
      return -1;
    }
  }

  private boolean reiheOk(int reihe, int anzahlLeute) {
    int zaehler = 0;
    int verbleibendePlaetze = anzahlLeute;
    for (int platzInReihe = kinosaal[0].length - 1;
        platzInReihe >= 0 && verbleibendePlaetze > 0;
        platzInReihe--) {
      if (kinosaal[reihe][platzInReihe] == FREI) {
        zaehler++;
        verbleibendePlaetze--;
      } else if (kinosaal[reihe][platzInReihe] > 0) {
        zaehler = 0;
      }
    }
    return (zaehler >= anzahlLeute) ? true : false;
  }

  public int knoblauchReservierung(int anzalLeute) {
    if (anzalLeute > kinosaal[0].length) {
      return -1;
    } else {
      for (int reihenNummer = kinosaal.length - 1; reihenNummer >= 0; reihenNummer--) {
        if (reiheOk(reihenNummer, anzalLeute)) {
          for (int platzInReihe = kinosaal[0].length - 1; platzInReihe >= 0; platzInReihe--) {
            boolean gueltigePlaetze = false;
            int verbleibendeLeute = anzalLeute;
            if (kinosaal[reihenNummer][platzInReihe] == FREI) {
              if (!platzBelegt(reihenNummer, platzInReihe + 1)
                  && !platzBelegt(reihenNummer, platzInReihe - anzalLeute)
                  && !platzBelegt(reihenNummer + 1, platzInReihe + 1 + 1)
                  && !platzBelegt(reihenNummer - 1, platzInReihe + 1 + 1)
                  && !platzBelegt(reihenNummer + 1, platzInReihe - anzalLeute + 1)
                  && !platzBelegt(reihenNummer - 1, platzInReihe - anzalLeute + 1)) {

                for (int pruefZaehler = platzInReihe;
                    pruefZaehler >= platzInReihe - (anzalLeute - 1)
                        && platzInReihe - (anzalLeute - 1) >= 0;
                    pruefZaehler--) {
                  if (!platzBelegt(reihenNummer, pruefZaehler + 1)
                      && !platzBelegt(reihenNummer + 1, pruefZaehler + 1)
                      && !platzBelegt(reihenNummer - 1, pruefZaehler + 1)) {
                    verbleibendeLeute--;
                  }
                }
                if (verbleibendeLeute == 0) {
                  gueltigePlaetze = true;
                }
              } else {
                gueltigePlaetze = false;
              }
            }
            if (gueltigePlaetze) {
              int reservierung = naechsteReservierungsnummer();
              for (int zaehler = platzInReihe;
                  zaehler >= platzInReihe - (anzalLeute - 1);
                  zaehler--) {
                kinosaal[reihenNummer][zaehler] = reservierung;
              }
              setReservierungsNummer(reservierung);
              return getReservierungsNummer();
            }
          }
        }
      }
      return -1;
    }
  }
}
