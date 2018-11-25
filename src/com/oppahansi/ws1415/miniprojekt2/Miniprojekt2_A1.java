/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.miniprojekt2;

public class Miniprojekt2_A1 {

  // HINWEIS das programm wurde noch mit dem ersten auf jack zum download bereit gestellen grüßt erstellt.
  // eventuelle abweichungen sind daher möglich. auch wurde die main verändert um weitere reservierungen zu
  // simulieren (fehlersuche). da jack aber nur die funktion der methoden prüft ist egal was in der main
  // steht. das programm erreicht trotzdem 100 punkte.

  // ab hier bitte keine Änderungen vornehmen
  int[][] kinosaal;

  public Miniprojekt2_A1(int anzahlReihen, int anzahlProReihe) {
    this.kinosaal = new int[anzahlReihen][anzahlProReihe];
  }

  public static void main(String[] args) {
    Miniprojekt2_A1 demo = new Miniprojekt2_A1(4, 7);
    System.out.println("Der leere Saal sieht so aus (- frei, B bezahlt, R reserviert):");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert für den existierenden Platz D 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode platzBelegt liefert für den nicht existierenden Platz  Q 23: "
            + demo.platzBelegt('Q', 23));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert für Reihe C Plätze 3-7 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 3, 7));
    System.out.println("Nach der Reservierung der Plätze 3,4,5,6 und 7 in der Reihe C:");
    demo.debugPrint();
    System.out.println(
        "Die Methode platzBelegt liefert für den reservierten Platz D 7: "
            + demo.platzBelegt('C', 7));
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert für Reihe C Plätze 1-3 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('C', 1, 3));
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert für Reihe D Plätze 7-5 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 7, 5));
    demo.debugPrint();
    System.out.println(
        "Die Methode festePlaetzeReservieren liefert für Reihe D Plätze 1-2 die Reservierungsnummer: "
            + demo.festePlaetzeReservieren('D', 1, 2));
    demo.debugPrint();
    System.out.println(
        "Der Anteil der freien Plätze ist: " + demo.anteilFreiePlaetze() * 100 + "%");
    System.out.println(
        "Die Methode bezahleReservierung liefert für Reservierung 7: "
            + demo.bezahleReservierung(7));
    System.out.println(
        "Die Methode bezahleReservierung liefert für Reservierung 1: "
            + demo.bezahleReservierung(1));
    demo.debugPrint();
    System.out.println(
        "Die Methode naechsteReservierungsnummer liefert: " + demo.naechsteReservierungsnummer());
    System.out.println(
        "Die Methode effizienteReservierung liefert für 6 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(6));
    demo.debugPrint();

    System.out.println(
        "Die Methode effizienteReservierung liefert für 100 Leute die Reservierungsnummer: "
            + demo.effizienteReservierung(100));
    demo.debugPrint();
    System.out.println(
        "Nach dem Aufruf der Methode neueVorstellungVorbereiten sieht der Kinosaal wieder so aus:");
    demo.neueVorstellungVorbereiten();
    demo.debugPrint();
    System.out.println("Nach zwei Reservierungen:");
    demo.festePlaetzeReservieren('A', 1, 3);
    demo.festePlaetzeReservieren('D', 4, 7);
    demo.debugPrint();
    System.out.println(
        "Die Methode knoblauchReservierung liefert für 3 Leute die Reservierungsnummer: "
            + demo.knoblauchReservierung(3));
    demo.debugPrint();
    System.out.println(
        "Die Methode knoblauchReservierung liefert für 2 Leute die Reservierungsnummer: "
            + demo.knoblauchReservierung(2));
    demo.debugPrint();
  }

  int[][] getKinosaal() {
    return kinosaal;
  }

  void setKinosaal(int[][] kinosaal) {
    this.kinosaal = kinosaal;
  }

  // bis hier bitte keine Änderungen vornehmen
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

    // durchläuft das gesammte array [1] und setzt alle werte auf 0 [2]

    for (int i = 0; i < kinosaal.length; i++) { // [1]
      for (int j = 0; j < kinosaal[i].length; j++) {
        kinosaal[i][j] = 0; // [2]
      }
    }
  }

  public int naechsteReservierungsnummer() {

    // durchläuft das gesammte array [1] und speichert den höchsten
    // gefundenen wert
    // (wenn es nicht max_value ist) [2], erhöt diesen um 1 [3] und gibt ihn
    // zurück [4]

    int hoechsteNummer = 0;

    for (int i = 0; i < kinosaal.length; i++) { // [1]
      for (int j = 0; j < kinosaal[i].length; j++) {

        if (kinosaal[i][j] >= hoechsteNummer && kinosaal[i][j] != Integer.MAX_VALUE) { // [2]
          hoechsteNummer = kinosaal[i][j];
        }
      }
    }
    hoechsteNummer++; // [3]

    return hoechsteNummer; // [4]
  }

  public boolean platzBelegt(char reihe, int platz) {

    // wandelt den buchstaben der reihe in eine zahl um (0 für a) [1],
    // verringert den wert von platz um 1
    // (da reihe A und platz 1 ja ander stelle [0][0] im array stehen) [2],
    // überprüft ob die plätze überhaut existerien [3],
    // setzt den belegtstatus auf "true" wenn der platz eine gültige
    // reservierungsnummer hat [4] und gibt den status zurück [5]

    boolean belegt = false;
    int reihennummer;

    reihennummer = (int) reihe; // [1]

    if (65 <= reihennummer && reihennummer <= 90) {
      reihennummer = reihennummer - 65; // [2]
    } else if (97 <= reihennummer && reihennummer <= 122) {
      reihennummer = reihennummer - 97;
    }

    platz--;

    if (reihennummer < kinosaal.length
        && reihennummer >= 0
        && platz < kinosaal[0].length
        && platz >= 0) { // [3]
      if (kinosaal[reihennummer][platz] != 0) { // [4]
        belegt = true;
      }
    }

    return belegt; // [5]
  }

  public int festePlaetzeReservieren(char reihe, int start, int ende) {

    // überprüft ob die eingegeben plätze existieren und ob die eingabe in
    // der richtigen reihenfolge erfolgte [1]
    // durchläuft alle zu prüfenden plätze und prüft diese mit der methode
    // platzBelegt [2]
    // wenn einer der plätze belegt ist, wird die varriable buchbar auf
    // false gesetzt und die schleife via break verlassen [3].
    // Wenn die plätze weiterhin buchbar sind wird eine neue
    // reservierungsnummer vergeben [4]
    // und auf die plätze geschrieben [5]. als ausgabe erfolgt die
    // reservierungsnummer (-1 wenn die reservierung nicht möglich war) [6]

    int vergebeneNummer, reihennummer;
    vergebeneNummer = -1;
    boolean buchbar, belegt;
    buchbar = true;

    reihennummer = (int) reihe;

    reihennummer = reihennummer - 65;

    if (start > ende || reihennummer > kinosaal.length || ende > kinosaal[0].length) { // [1]

    } else {
      ende:
      for (int i = start; i <= ende; i++) { // ende: ist eine Sprungmarke - wird nicht mehr benutzt
        // kann weggelassen werden hier und in zeile 154 einfach löschen. Auch 100/100 Punkte in JACK
        belegt = platzBelegt(reihe, i); // [2]

        if (belegt == true) {
          buchbar = false;

          break ende; // [3]
        }
      }

      if (buchbar == true) { // [4]
        vergebeneNummer = naechsteReservierungsnummer();

        while (start <= ende) {
          kinosaal[reihennummer][start - 1] = vergebeneNummer; // [5]
          start++;
        }
      }
    }
    return vergebeneNummer; // [6]
  }

  public boolean bezahleReservierung(int nummer) {

    // wird eine reservierung bezahlt, wird ihr wert mit Integer.MAX_VALUE
    // überschrieben. Es wird jeder platz des kinos auf die
    // nummer überprüft [1]. wird die nummer gefunden, wird sie
    // überschrieben und der bezahlt-status auf "true" gesetzt. [2]

    boolean bezahlt = false;

    for (int i = 0; i < kinosaal.length; i++) { // [1]
      for (int j = 0; j < kinosaal[i].length; j++) {

        if (kinosaal[i][j] == nummer) { // [2]
          kinosaal[i][j] = Integer.MAX_VALUE;
          bezahlt = true;
        }
      }
    }

    return bezahlt;
  }

  public float anteilFreiePlaetze() {

    // um den anteil der freien plätze zu berrechnen, muss man zunächst die
    // maximale anzahl an plätzen kennen. [1]
    // um nun zu wissen wie viele davon belegt sind überprüft man den wert
    // von jedem platz auf != 0 [2]

    float anteilfrei, belegteplaetze, maximaleplaetze;
    belegteplaetze = 0.0f;
    maximaleplaetze = kinosaal.length * kinosaal[0].length; // [1]

    for (int i = 0; i < kinosaal.length; i++) {
      for (int j = 0; j < kinosaal[i].length; j++) {

        if (kinosaal[i][j] != 0) { // [2]
          belegteplaetze++;
        }
      }
    }

    anteilfrei = 1 - (belegteplaetze / maximaleplaetze);

    return anteilfrei;
  }

  public int effizienteReservierung(int anzalLeute) {

    // die methode soll den kinosaal von hinten nach vorne prüfuen um für eine gruppe von leuten eine passende lücke zu
    // suchen. sinn macht das natürlich nur wenn die anzahl der leute in eine reihe passen [1]
    // jetzt wird eine lücke gesucht [2]
    // hierfür wird erstmal ein einzelner platz gesucht. [3]
    // wurde dieser gefunden wird geguckt ob der platz auch für die ganze gruppe reicht [4]
    // buchbar ist die var. die prüft ob die reservierung möglich ist. außerdem wird immer geprüft ob die gruppe
    // genügend platz in der reihe hat um zu verhindern das man werte außerhalb des arrays prüft.
    // ist der platz am ende des prüfens immer noch "buchbar" so wird eine reservierung vorgenommen. [5]
    // hierfür müssen die platznummer und die reihe natürlich noch angepasst werden [6]
    // als rückgabe gibts die reservierungsnummer (-1 wenn keine lücke gefunden wurde) [7]

    boolean buchbar;
    buchbar = false;

    int vergebeneNummer;
    vergebeneNummer = -1;

    char reihe;
    reihe = 'a';

    if (kinosaal[0].length < anzalLeute) { // [1]
    } else {

      for (int i = kinosaal.length - 1; i >= 0 && buchbar == false; i--) { // [2]

        for (int j = kinosaal[i].length - 1; j >= 0 && buchbar == false; j--) {

          if (kinosaal[i][j] == 0 && j - (anzalLeute - 1) >= 0) { // [3]
            buchbar = true;
            for (int a = 0; a < anzalLeute; a++) { // [4]
              if (kinosaal[i][j - a] != 0) {

                buchbar = false;
              }
            }
          }

          if (buchbar == true) { // [5]
            reihe = (char) (i + 65); // [6]
            int start, ende;
            ende = j + 1;
            start = (ende - anzalLeute + 1);

            vergebeneNummer = festePlaetzeReservieren(reihe, start, ende);
          }
        }
      }
    }

    return vergebeneNummer; // [7]
  }

  public int knoblauchReservierung(int anzalLeute) {

    // hier ist alles gleich wie bei der effizienten reservierung. einziger unterschied ist, dass auch das umfeld
    // der gruppe geprüft werden soll. die methode "platzbelegt" liefert nur den wert "true" wenn der platz belegt ist.
    // nicht existente plätze und frei plätze liefern false. es wird also für ein 3x3 feld um jeden platz geprüft ob
    // die rückgabe == false. ist das für alle plätze der fall, so wird die reservierung druchgeführt. [1]

    boolean buchbar, belegt;
    buchbar = false;
    belegt = false;

    int vergebeneNummer;
    vergebeneNummer = -1;

    char reihe;
    reihe = 'a';

    if (kinosaal[0].length <= anzalLeute) {
    } else {

      for (int i = kinosaal.length - 1; i >= 0 && buchbar == false; i--) {

        for (int j = kinosaal[i].length - 1; j >= 0 && buchbar == false; j--) {

          if (kinosaal[i][j] == 0 && j - (anzalLeute - 1) >= 0) {
            buchbar = true;
            for (int a = 0; a < anzalLeute; a++) {

              for (int k = -1; k <= 1; k++) { // [1]
                for (int l = -1; l <= 1; l++) {
                  char c;
                  c = (char) (i + 65 + k);
                  int test;
                  test = ((j + l + 1) - a);
                  belegt = platzBelegt(c, test);

                  if (belegt == true) {

                    buchbar = false;
                  }
                }
              }

              if (kinosaal[i][j - a] != 0) {
                buchbar = false;
              }
            }
          }

          if (buchbar == true) {
            reihe = (char) (i + 65);
            int start, ende;
            ende = j + 1;
            start = (ende - anzalLeute + 1);

            vergebeneNummer = festePlaetzeReservieren(reihe, start, ende);
          }
        }
      }
    }

    return vergebeneNummer;
  }
}
