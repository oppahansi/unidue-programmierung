/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze
 */
package com.oppahansi.ws1415.miniprojekt4_A1;

public class Patient {

  int id;
  String name, vorname, geburtsdatum;
  String vers, versNr;
  char versArt;
  int aufDauer;
  Diagnose[] diagnosen;
  Station station;

  /*
   * Konstruktor
   */
  public Patient(String name, String vorname, String geburtsdatum, int aufDauer) {
    this.name = name; //Selbsterkl�rend?
    this.vorname = vorname;
    this.geburtsdatum = geburtsdatum;
    this.aufDauer = aufDauer;
    diagnosen = new Diagnose[15];
  } //end proc

  //Getter

  String getName() {
    return name;
  }

  String getVorname() {
    return vorname;
  }

  String getGeburtsdatum() {
    return geburtsdatum;
  }

  int getaufDauer() {
    return aufDauer;
  }

  int getid() {
    return id;
  }

  Station getStation() {
    return station;
  }

  Diagnose[] getDiagnosen() {
    return diagnosen;
  }

  char getVersArt() {
    return versArt;
  }

  String getVers() {
    return vers;
  }

  String getVersNr() {
    return versNr;
  }

  /*
   * Setzt die ID des Patienten
   */
  public void setID(int id) {
    this.id = id;
  }

  /*
   * Setzt die Versicherungsdaten
   */
  public void setVers(char versArt, String vers, String versNr) {
    this.versArt = versArt; //Selbsterkl�rend?
    this.vers = vers;
    this.versNr = versNr;
  } //end proc

  /*
   * Weist dem Patient eine Station zu
   */
  public boolean setStation(Station station) {
    if (station != null) //Pr�ft null zugriff
    {
      if (station.aufnehmen(this)) { //Platz verhanden
        this.station = station; //setze station
        return true; //beende mit true
      } //end of if aufnehmen
    }
    return false; //beende mit false
  } //end proc

  /*
   * F�gt eine neue Diagnose zur Liste
   * der Diagnosen hinzu
   */
  public void neueDiagnose(Diagnose diag) {
    for (int i = 0; i < this.diagnosen.length; i++) {
      if (this.diagnosen[i] == null) {
        this.diagnosen[i] = diag;
        break;
      }
    }
  } //end proc

  /*
   * Gibt s�mtliche Infos des Patienten
   */
  public void ausgabe() {
    System.out.println(
        "\n+----------------------------------------------------------------------------------------+\n");
    System.out.println("ID:                        " + id);
    System.out.println("Name:                      " + name);
    System.out.println("Vorname:                   " + vorname);
    System.out.println("Geburtsdatum:              " + geburtsdatum);

    String vs;
    if (versArt == 'P') {
      vs = "privat versichert";
    } else {
      vs = "gesetzlich versichert";
    }
    System.out.println("Versicherungsart:          " + vs);
    System.out.println("Versicherungstraeger:      " + vers);
    System.out.println("VersicherungsNummer:       " + versNr);
    System.out.println("Aufenthaltsdauer:          " + aufDauer);
    if (diagnosen[0] != null) {
      System.out.println("\nDiagnosen:               ");
    }
    for (int i = 0; i < diagnosen.length; i++) {
      if (diagnosen[i] != null) {
        System.out.println("                           +--------------------------+");
        System.out.println("                           |DiagnoseNr:     " + (i + 1) + "         |");
        System.out.println("                           +--------------------------+");
        diagnosen[i].ausgabe();
        System.out.println("");
      }
    }

    if (station != null) {
      System.out.println("******************************************");
      System.out.println("Der Patient wurde stationaer behandelt in: ");
      station.ausgabe();

    } else {
      System.out.println("\nDer Patient wurde ambulant behandelt");
    }
  }
}
