/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>100/100 In JACK.
 */
package com.oppahansi.ws1415.miniprojekt2;

public class Miniprojekt2_A2_E {

  /*
  Erstellung von Variablen, die ich oft verwenden werde und die sich immer wieder wiederholen werden.
   */
  private final int FREI = 0;
  private final int BEZAHLT = Integer.MAX_VALUE;
  private final int ASCII = 65;
  // ab hier bitte keine Änderungen vornehmen
  int[][] kinosaal;
  private int reservierungsNummer = 0;

  // bis hier bitte keine Änderungen vornehmen
  // hier beginnt der zu bearbeitende Teil

  public Miniprojekt2_A2_E(int anzahlReihen, int anzahlProReihe) {
    this.kinosaal = new int[anzahlReihen][anzahlProReihe];
  }

  public static void main(String[] args) {
    Miniprojekt2_A2_E demo = new Miniprojekt2_A2_E(3, 5);
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

  /*
  1. Hier heißt es nichts anderes als alle Werte im Kinosaal auf 0 setzen.
  2. Außerdem muss man ja fuer die neue Vorstellung Reservierungsnummer wieder auf 0 setzen.
   */
  public void neueVorstellungVorbereiten() {
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzInReihe = 0; platzInReihe < kinosaal[reihenNummer].length; platzInReihe++) {
        kinosaal[reihenNummer][platzInReihe] = FREI; // 1.
      }
    }
    setReservierungsNummer(0); // 2.
  }

  /*
  1. Man braucht eine Variable, um die hoechte Reservierungsnummer abzuspeichern.
  2. Man gibt immer die hoechste Reservierungsnummer aus + 1. + 1 bedeutet naechste
  verfuegbare Reservierungsnummer, die es im Kinosaal noch nicht gibt.
   */
  public int naechsteReservierungsnummer() {
    int groessteReservierungsNummer = 0; // 1.
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
      for (int platzInReihe = 0; platzInReihe < kinosaal[0].length; platzInReihe++) {
        if (kinosaal[reihenNummer][platzInReihe] >= groessteReservierungsNummer
            && kinosaal[reihenNummer][platzInReihe] != BEZAHLT) {
          groessteReservierungsNummer = kinosaal[reihenNummer][platzInReihe];
        }
      }
    }
    return groessteReservierungsNummer + 1; // 2.
  }

  /*
  getter und setter fuer die Reservierungsnummer geschrieben, erleichtert mir die Werte zu setzen
  oder abzurufen.
   */
  public int getReservierungsNummer() {
    return reservierungsNummer;
  }

  public void setReservierungsNummer(int neueReservierungsNummer) {
    this.reservierungsNummer = neueReservierungsNummer;
  }

  /*
  getReiheAusChar(..) ist eine Hilfsmethode, um aus dem char reihe ein int zu machen
  damit spare ich mir immer die gleiche Rechnung

  1. Pruefen ob der Platz ueberhaupt existiert
  2. Im Kinosaal nachsehen, ob der Platz noch immer den Wert 0 hat oder nicht.
   */
  public boolean platzBelegt(char reihe, int platz) {
    if (getReiheAusChar(reihe) < 0
        || getReiheAusChar(reihe) >= kinosaal.length
        || platz < 0
        || platz > kinosaal[0].length) { // 1.
      return false;
    } else {
      if (kinosaal[getReiheAusChar(reihe)][platz - 1] != FREI) { // 2.
        return true;
      } else {
        return false;
      }
    }
  }

  /*
  Überladene platzBelegt(..)-Methode, die ich später verwenden werde.
  Hier wird anstatt eines char direkt die Reihenziffer als int übergeben.
   */
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

  /*
  Hilfmethode zur Berechnung der Reihennummer anhand des uebergeben chars.
   */
  public int getReiheAusChar(char reiheCharWert) {
    return (int) reiheCharWert - ASCII;
  }

  /*
  1. Schauen, ob die Plaetze innerhalb des Kinosaals sind, ob start kleiner als ende ist
  2. Schauen, ob eins der zu reservierenden Plaetze nicht frei ist. Falls eins der Plaetze reserviert oder bezahlt ist, beenden.
  3. Plaetze können reserviert werden, hole mir die naechste Reservierungsnummer
  4. Reserviere die Plaetze
  5. Reservierungsvariable aktualisieren
  6. Die Reservierungsnummer dieser Reservierung ausgeben.
   */
  public int festePlaetzeReservieren(char reihe, int start, int ende) {
    if (getReiheAusChar(reihe) < 0
        || getReiheAusChar(reihe) >= kinosaal.length
        || start < 0
        || start > kinosaal[0].length
        || ende < 0
        || ende > kinosaal[0].length
        || start > ende) { // 1.
      return -1;
    } else {
      for (int platzNummer = start - 1; platzNummer < ende; platzNummer++) { // 2.
        if (platzBelegt(reihe, platzNummer + 1)) {
          return -1;
        }
      }
      int reservierung = naechsteReservierungsnummer(); // 3.
      for (int platzNummer = start - 1; platzNummer < ende; platzNummer++) { // 4.
        kinosaal[getReiheAusChar(reihe)][platzNummer] = reservierung;
      }
      setReservierungsNummer(reservierung); // 5.
      return getReservierungsNummer(); // 6.
    }
  }

  /*
  1. Hilfsvariable zur Pruefung einer ob die Reservierung vorhanden ist
  2. Ueberpruefen ob die Reservierung ueberhaupt vorhanden ist.
  3. Reservierung vorhanden, also die Plaetze mit der Reservierungsnummer auf Bezahlt setzen.
   */
  private boolean bezahleReservierung(int nummer) {
    boolean vorhanden = false; // 1.
    for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) { // 2.
      for (int platzNummer = 0; platzNummer < kinosaal[0].length; platzNummer++) {
        if (kinosaal[reihenNummer][platzNummer] == nummer) { // 2.
          vorhanden = true;
        }
      }
    }
    if (vorhanden) { // 3.
      for (int reihenNummer = 0; reihenNummer < kinosaal.length; reihenNummer++) {
        for (int platzNummer = 0; platzNummer < kinosaal[0].length; platzNummer++) {
          if (kinosaal[reihenNummer][platzNummer] == nummer) { // 3.
            kinosaal[reihenNummer][platzNummer] = BEZAHLT;
          }
        }
      }
    }
    return vorhanden;
  }

  /*
  Simple Mathematik ..
  Eine Hilfsmethode verwendet, um alle freien Plaetze zu zaehlen.
   */
  public float anteilFreiePlaetze() {
    return (float) getAnzFreiePlaetze() / (kinosaal.length * kinosaal[0].length);
  }

  /*
  Hilfsmethode zur Zaehlung aller freier Plaetze im Kinosaal.
   */
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

  /*
  1. Schauen ob die Leute in eine Reihe ueberhaupt reinpassen.
  2. Hilfsvariable zur Zaehlung der noch zu reservierenden Plaetze/Leute
  3. Hilfsmethode zur Pruefung der aktuellen Reihe, ob da genug freie Plaetze vorhanden sind.
  4. Es sind genug freie Plaetze in der Reihe vorhanden, also reserviert man die Plaetze.
  5. Runterzaehlen von den noch zu reservierenden Plaetze/Leute siehe 2. Damit weiß ich dann, wann ich aufhoeren muss.
  6. Siehe in Aufgaben oben, was und wieso.
   */
  public int effizienteReservierung(int anzalLeute) {
    if (anzalLeute > kinosaal[0].length) // 1.
    {
      return -1;
    } else {
      int verbleibendeLeute = anzalLeute; // 2.
      for (int reihenNummer = kinosaal.length - 1; reihenNummer >= 0; reihenNummer--) {
        if (reiheOk(reihenNummer, anzalLeute)) { // 3.
          int reservierung = naechsteReservierungsnummer();
          for (int platzInReihe = kinosaal[0].length - 1;
              platzInReihe >= 0 && verbleibendeLeute > 0;
              platzInReihe--) { // 4.
            if (kinosaal[reihenNummer][platzInReihe] == FREI) {
              kinosaal[reihenNummer][platzInReihe] = reservierung;
              verbleibendeLeute--; // 5.
            }
          }
          setReservierungsNummer(reservierung); // 6.
          return getReservierungsNummer();
        }
      }
      return -1;
    }
  }

  /*
  Hilfsmethode zur pruefung einer Reihe auf genuegend freier Plaetze
   */
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

  /*
  1. Aus anderen aufgaben bekannt.
  2. Durgehen aller Reihen
  3. Direkt schauen, ob die Reihe ueberhaupt genug freie Plaetze hat
  4. Durchgehen aller PLaetze in einer Reihe von rechts nach links(groesste Platznummer zuerst - 0)
  5. Hilfsvariable zur Signalisierung einer geeigneten Stelle
  6. Hilfsvariable zur Abzaehlung der verbleibenden Leute/Plaetze, siehe andere Aufgaben
  7. Pruefen, ob der aktuelle Platz frei ist
  8. Schauen ob die "Ecken" der "Box" frei sind
     Beispiel:
     Angenommen, der Saal sieht so aus, wie hier unten, dann möchten wir die Methode aufrufen mit anzahlLeute = 3.
         1       5
      A: R R - - R
      B: - - - - R
      C: - - - - -

      Die einzige moegliche Luecke wäre (mit V markiert), Ecke mit E markiert
         1       5
      A: R R - - R
      B: - - - - R
      C: V V V - -

     Eine der Ecken, die ich pruefe waere (mit E markiert)
         1       5
      A: R R - - R
      B: - - - E R
      C: V V V - -

      Und das mache ich mit allen anliegenden Ecken, wenn eine davon nicht geht, zum naechsten Platzgehen.
      Ecken und Plaetze außerhalb des Kinosaals werden als gueltig angenommen, denn dann hat man ja keine
      Nachbarn, siehe Post zu Fragen und Antworten zu Unklarheiten..
  9. Hier gehe ich von der aktuellen Platzposition runter zur letzen für uns notwendigen Position und
  10. pruefe ob vom aktuellen Platz ausgehend die Plaetze vor und hinter mir frei sind und zaehle herunter
  11. Wenn meine Hilfsvariable 0 erreicht, habe ich eine gueltige Stelle gefunden.
  12. Falls nicht, einfach sicherheitshalber den Wert meiner Hilfsvariable auf false setzen
  13. Falls in 7. eine gueltige Stelle gefunden wurde, ist die Hilfsvariable true
  14. siehe Aufgaben davor.
  15. Falls oben nichts gefunden wird, wird er die Methode mit -1 beende. Ansonsten beendet er die Methode immer mit
  der Reservierungsnummer.
   */
  public int knoblauchReservierung(int anzalLeute) {
    if (anzalLeute > kinosaal[0].length) // 1.
    {
      return -1;
    } else {
      for (int reihenNummer = kinosaal.length - 1; reihenNummer >= 0; reihenNummer--) { // 2.
        if (reiheOk(reihenNummer, anzalLeute)) { // 3.
          for (int platzInReihe = kinosaal[0].length - 1; platzInReihe >= 0; platzInReihe--) { // 4.
            boolean gueltigePlaetze = false; // 5.
            int verbleibendeLeute = anzalLeute; // 6.
            if (kinosaal[reihenNummer][platzInReihe] == FREI) { // 7.
              if (!platzBelegt(reihenNummer, platzInReihe + 1)
                  && // 8.
                  !platzBelegt(reihenNummer, platzInReihe - anzalLeute)
                  && !platzBelegt(reihenNummer + 1, platzInReihe + 1 + 1)
                  && !platzBelegt(reihenNummer - 1, platzInReihe + 1 + 1)
                  && !platzBelegt(reihenNummer + 1, platzInReihe - anzalLeute + 1)
                  && !platzBelegt(reihenNummer - 1, platzInReihe - anzalLeute + 1)) {

                for (int pruefZaehler = platzInReihe;
                    pruefZaehler >= platzInReihe - (anzalLeute - 1)
                        && platzInReihe - (anzalLeute - 1) >= 0;
                    pruefZaehler--) { // 9.
                  if (!platzBelegt(reihenNummer, pruefZaehler + 1)
                      && // 10.
                      !platzBelegt(reihenNummer + 1, pruefZaehler + 1)
                      && !platzBelegt(reihenNummer - 1, pruefZaehler + 1)) {
                    verbleibendeLeute--;
                  }
                }
                if (verbleibendeLeute == 0) { // 11.
                  gueltigePlaetze = true;
                }
              } else { // 12.
                gueltigePlaetze = false;
              }
            }
            if (gueltigePlaetze) { // 13.
              int reservierung = naechsteReservierungsnummer();
              for (int zaehler = platzInReihe;
                  zaehler >= platzInReihe - (anzalLeute - 1);
                  zaehler--) {
                kinosaal[reihenNummer][zaehler] = reservierung;
              }
              setReservierungsNummer(reservierung); // 14.
              return getReservierungsNummer();
            }
          }
        }
      }
      return -1; // 15.
    }
  }
}
