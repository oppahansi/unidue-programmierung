/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Patient {

  private int aufenthaltDauer;
  private int patientenID;
  private char versicherungArt;
  private String name;
  private String vorname;
  private String geburtsDatum;
  private String versicherung;
  private String versicherungNr;
  private Diagnose[] diagnosen;
  private Station station;

  /*
   * AUFGABE
   */
  public Patient(String name, String vorname, String geburtsDatum, int aufenthaltDauer) {}

  /*
   * AUFGABE
   *
   * Setzt die Versicherungsdaten
   */
  public void setVersicherungDaten(
      char versicherungArt, String versicherung, String versicherungNr) {}

  /*
   * AUFGABE
   *
   * Weist dem Patient eine Station zu
   */
  public boolean setStation(Station station) {
    /* wieso boolean? */
    return false;
  }

  /*
   * AUFGABE
   *
   * Fuegt eine neue Diagnose zur Liste
   * der Diagnosen hinzu
   */
  public void fuegeDiagnoseHinzu(Diagnose diagnose) {}

  public String getName() {
    return name;
  }

  public String getVorname() {
    return vorname;
  }

  public String getGeburtsDatum() {
    return geburtsDatum;
  }

  public int getAufenthaltDauer() {
    return aufenthaltDauer;
  }

  public int getPatientenID() {
    return patientenID;
  }

  public void setPatientenID(int patientenID) {
    this.patientenID = patientenID;
  }

  public Station getStation() {
    return station;
  }

  public Diagnose[] getDiagnosen() {
    return diagnosen;
  }

  public char getersicherungArt() {
    return versicherungArt;
  }

  public String getVersicherung() {
    return versicherung;
  }

  public String getVersicherungNr() {
    return versicherungNr;
  }

  public void patientenInfoAusgabe() {
    System.out.println(
        "\n+----------------------------------------------------------------------------------------+\n");
    System.out.println("ID:                        " + patientenID);
    System.out.println("Name:                      " + name);
    System.out.println("Vorname:                   " + vorname);
    System.out.println("Geburtsdatum:              " + geburtsDatum);

    String versicherungArtAusgabe;

    if (versicherungArt == 'P') {
      versicherungArtAusgabe = "privat versichert";
    } else {
      versicherungArtAusgabe = "gesetzlich versichert";
    }

    System.out.println("Versicherungsart:          " + versicherungArtAusgabe);
    System.out.println("Versicherungstraeger:      " + versicherung);
    System.out.println("VersicherungsNummer:       " + versicherungNr);
    System.out.println("Aufenthaltsdauer:          " + aufenthaltDauer);

    if (diagnosen[0] != null) {
      System.out.println("\nDiagnosen:               ");
    }

    for (int i = 0; i < diagnosen.length; i++) {
      if (diagnosen[i] != null) {
        System.out.println("                           +--------------------------+");
        System.out.println("                           |DiagnoseNr:     " + (i + 1) + "         |");
        System.out.println("                           +--------------------------+");
        diagnosen[i].diagnosenInfoAusgabe();
        System.out.println("");
      }
    }

    if (station != null) {
      System.out.println("******************************************");
      System.out.println("Der Patient wurde stationaer behandelt in: ");
      station.stationsInfoAusgabe();
    } else {
      System.out.println("\nDer Patient wurde ambulant behandelt");
    }
  }
}
