/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ss15.miniprojekt.mp3.a1;

public class Tisch {

  int tischnummer;
  int AnzahlPersonen;
  int maxAnzahlPersonen;
  Tischbuchung tischbuchungen;
  Speise speisen;
  Getraenk getraenke;

  public Tisch(int tischnummer, int maxAnzahlPersonen) {
    this.tischnummer = tischnummer;
    this.maxAnzahlPersonen = maxAnzahlPersonen;
    this.AnzahlPersonen = 0;
  }

  public Speise getSpeisen() {
    return speisen;
  }

  /*
   * Hinzufuegen einer neuen Speise fuer den Tisch.
   */
  public void hinzufuegenSpeise(Speise neueSpeise) {
    Speise neu =
        new Speise(neueSpeise.artNr, neueSpeise.name, neueSpeise.preis, neueSpeise.zutaten.clone());
    if (speisen == null) {
      speisen = neu;
    } else {
      Speise temp = speisen;
      while (temp.getNachfolger() != null) {
        temp = temp.getNachfolger();
      }
      temp.setNachfolger(neu);
    }
  }

  public Getraenk getGetraenke() {
    return getraenke;
  }

  /*
   * Hinzufuegen eines neuen Getraenk fuer den Tisch.
   */
  public void hinzufuegenGetraenk(Getraenk neuesGetraenk) {
    Getraenk neu =
        new Getraenk(
            neuesGetraenk.artNr, neuesGetraenk.name, neuesGetraenk.groesse, neuesGetraenk.preis);
    if (getraenke == null) {
      getraenke = neu;
    } else {
      Getraenk temp = getraenke;
      while (temp.getNachfolger() != null) {
        temp = temp.getNachfolger();
      }
      temp.setNachfolger(neu);
    }
  }

  public int getMaxAnzahlPersonen() {
    return maxAnzahlPersonen;
  }

  public int getAnzahlPersonen() {
    return AnzahlPersonen;
  }

  public void setAnzahlPersonen(int AnzahlPersonen) {
    this.AnzahlPersonen = AnzahlPersonen;
  }

  public int getTischnummer() {
    return tischnummer;
  }

  public Tischbuchung getTischbuchungen() {
    return tischbuchungen;
  }

  /*
   * Hinzufuegen einer neuen Belegung fuer den Tisch.
   */
  public void hinzufuegenTischbuchung(int startZeit, int endZeit) {
    Tischbuchung neu = new Tischbuchung(startZeit, endZeit);
    if (tischbuchungen == null) {
      tischbuchungen = neu;
    } else {
      Tischbuchung temp = tischbuchungen;
      while (temp.getNachfolger() != null) {
        temp = temp.getNachfolger();
      }
      temp.setNachfolger(neu);
    }
  }
}
