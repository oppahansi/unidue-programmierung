/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 3 100/100 In JACK.
 */
package com.oppahansi.ws1415.miniprojekt2;

public class Miniprojekt2_A3 {

  // ab hier bitte keine �nderungen vornehmen
  int[][] kinosaal;

  public Miniprojekt2_A3(int anzahlReihen, int anzahlProReihe) {
    this.kinosaal = new int[anzahlReihen][anzahlProReihe];
  }

  public static void main(String[] args) {
    Miniprojekt2_A3 demo = new Miniprojekt2_A3(4, 7);
    System.out.println("Der leere Saal sieht so aus (- frei, B bezahlt, R reserviert):");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert f�r den existierenden Platz D 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode platzBelegt liefert f�r den nicht existierenden Platz  Q 23: "
            + demo.platzBelegt('Q', 23));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert f�r Reihe C Pl�tze 3-7 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 3, 7));
    System.out.println("Nach der Reservierung der Pl�tze 3,4,5,6 und 7 in der Reihe C:");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert f�r den reservierten Platz C 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert f�r Reihe C Pl�tze 1-3 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 1, 3));
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert f�r Reihe D Pl�tze 7-5 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 7, 5));
    demo.debugPrint();
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert f�r Reihe D Pl�tze 1-2 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 1, 2));
    demo.debugPrint();
    System.out.println(
        "Der Anteil der freien Pl�tze ist: " + demo.anteilFreiePlaetze() * 100 + "%");
    System.out.println(
        "Die Methode bezahleReservierung liefert f�r Reservierung 7: "
            + demo.bezahleReservierung(7));
    System.out.println(
        "Die Methode bezahleReservierung liefert f�r Reservierung 1: "
            + demo.bezahleReservierung(1));
    demo.debugPrint();
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode effizienteReservierung liefert f�r 6 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(6));
    demo.debugPrint();
    System.out.println(
        "Die Methode effizienteReservierung liefert f�r 100 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(100));
    demo.debugPrint();
    System.out.println(
        "Nach dem Aufruf der Methode neueVorstellungVorbereiten sieht der Kinosaal wieder so aus:");
    demo.neueVorstellungVorbereiten();
    System.out.println("Nach zwei Reservierungen:");
    demo.festePlaetzeReservieren('A', 1, 3);
    demo.festePlaetzeReservieren('D', 4, 7);
    demo.debugPrint();
    System.out.println(
        "Die Methode knoblauchReservierung liefert f�r 3 Leute die Reservierungsnummer: "
            + demo.knoblauchReservierung(3));
    demo.debugPrint();
    demo.knoblauchReservierung(2);
    demo.debugPrint();
  }

  int[][] getKinosaal() {
    return kinosaal;
  }

  void setKinosaal(int[][] kinosaal) {
    this.kinosaal = kinosaal;
  }

  // bis hier bitte keine �nderungen vornehmen
  // hier beginnt der zu bearbeitende Teil

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
    kinosaal = new int[kinosaal.length][kinosaal[0].length];
  }

  public int naechsteReservierungsnummer() {
    int resNo = 0;

    for (int r = 0; r < kinosaal.length; r++) {
      for (int p = 0; p < kinosaal[0].length; p++) {
        if (kinosaal[r][p] > resNo && kinosaal[r][p] != Integer.MAX_VALUE) {
          resNo = kinosaal[r][p];
        }
      }
    }

    return resNo + 1;
  }

  public boolean platzBelegt(char reihe, int platz) {
    int r = reihe - 'A';
    int p = platz - 1;

    if (r < 0 || r >= kinosaal.length || p < 0 || p >= kinosaal[0].length) {
      return false;
    }

    return kinosaal[r][p] != 0;
  }

  public int festePlaetzeReservieren(char reihe, int start, int ende) {
    if (start > ende || start < 1 || ende > kinosaal[0].length) {
      return -1;
    }

    for (int platz = start; platz <= ende; platz++) {
      if (platzBelegt(reihe, platz)) {
        return -1;
      }
    }

    int resNo = naechsteReservierungsnummer();
    for (int platz = start; platz <= ende; platz++) {
      kinosaal[reihe - 'A'][platz - 1] = resNo;
    }

    return resNo;
  }

  public boolean bezahleReservierung(int nummer) {
    boolean paid = false;
    for (int r = 0; r < kinosaal.length; r++) {
      for (int p = 0; p < kinosaal[0].length; p++) {
        if (kinosaal[r][p] == nummer) {
          kinosaal[r][p] = Integer.MAX_VALUE;
          paid = true;
        }
      }
    }

    return paid;
  }

  public float anteilFreiePlaetze() {
    int free = 0;
    for (int r = 0; r < kinosaal.length; r++) {
      for (int p = 0; p < kinosaal[0].length; p++) {
        if (kinosaal[r][p] == 0) {
          free++;
        }
      }
    }

    return (float) free / (kinosaal.length * kinosaal[0].length);
  }

  public int effizienteReservierung(int anzalLeute) {
    for (int r = kinosaal.length - 1; r > -1; r--) {
      int free = 0;
      for (int p = kinosaal[0].length - 1; p > -1; p--) {
        if (kinosaal[r][p] == 0) {
          free++;
        } else {
          free = 0;
        }

        if (free == anzalLeute) {
          return festePlaetzeReservieren((char) (r + 'A'), p + 1, p + anzalLeute);
        }
      }
    }

    return -1;
  }

  public int knoblauchReservierung(int anzalLeute) {
    for (int r = 'A'; r < kinosaal.length + 'A'; r++) {
      int free = 0;
      for (int p = 0; p < kinosaal[0].length + 2; p++) {
        if (platzBelegt((char) (r - 1), p)
            || platzBelegt((char) r, p)
            || platzBelegt((char) (r + 1), p)) {
          free = 0;
        } else {
          free++;
        }

        if (free == anzalLeute + 2) {
          return festePlaetzeReservieren((char) r, p - anzalLeute, p - 1);
        }
      }
    }

    return -1;
  }
}
