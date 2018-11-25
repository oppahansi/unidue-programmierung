/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt4_A2;

public class Miniprojekt4 {

  //Main-Methode
  public static void main(String args[]) {
    //Krankenhaus-Objekt anlegen
    Krankenhaus santamaria =
        new Krankenhaus("Santamaria", 130); // 10 Betten f�r ambulante Behandlungen

    //Liste der Aerzte im Krankenhaus

    String[] aerzte = {
      "Dr. Scheel Viktor",
      "Dr. Luther Christoph",
      "Dr.Schreiner Kevin",
      "Dr. Goldbach Sabina",
      "Dr. Schuman Alexandra",
      "" + "Dr. David Jacob",
      "Dr. Hutton",
      "Dr. Schaueble Manfred",
      "Dr. Bohlen Alex",
      "" + "Dr.Schummacher Katharina",
      "Dr. Wagner Christian",
      "Dr.Lehman steven",
      "Dr. Laila Mansour",
      "Dr. Kamilion antonova",
      "" + "Dr. Octavia irene",
      "Dr. Thomson Emanuel",
      "Dr. Ernst Michael",
      "Dr. Severin David",
      "Dr. Maximilian Christian",
      "" + "Dr. Weber Michael",
      "Dr. Anton axel",
      "Dr. Dorloff Hamid",
      "Dr. Goldbach Daniel",
      "Dr. Petrow Erik",
      "" + "Dr. Bethofen Uwe",
      "Dr. Alfred Servantes",
      "Dr. Santos Armin",
      "Dr. Thomas Ingo",
      "Dr. Perez Alexanda"
    };

    //Liste der Stationen im Krankenhaus
    Station[] s = {
      new Station(1, "Innere Medizin", 10, 4),
      new Station(2, "Intensiv Medizin", 12, 6),
      new Station(3, "Unfallchirurgie", 12, 6),
      new Station(4, "Orthopaedie", 20, 6),
      new Station(5, "Onkologie", 8, 4),
      new Station(6, "Schlafmedizin", 4, 2),
      new Station(7, "Gynaekologie", 10, 6),
      new Station(8, "Urologie", 8, 2)
    };

    santamaria.stationen = s;

    //Liste der Diagnosen, die be den Patienten festgestellt werden
    //( String diagS, String diagA, int laborU, int operations)
    Diagnose[] diag = {
      new Diagnose("S63.0", aerzte[1], 0, 0),
      new Diagnose("E04.09", aerzte[0], 3, 2),
      new Diagnose("B75", aerzte[4], 2, 0),
      new Diagnose("R12", aerzte[5], 0, 0),
      new Diagnose("I21.9", aerzte[4], 3, 1),
      new Diagnose("S80", aerzte[3], 0, 0),
      new Diagnose("C93.1", aerzte[12], 6, 1),
      new Diagnose("G47.4", aerzte[16], 0, 0),
      new Diagnose("O04.4", aerzte[20], 0, 0)
    };

    //Liste der Medikamente, die die Patienten bekommen haben aufgrund der Diagnosen

    Medikament[] medi = {
      new Medikament("Katadolon", "Flupirtin", 1, 5.00f),
      new Medikament("Jodid", "Jod", 1, 1.54f),
      new Medikament("Axium", "Levothyroxin", 1, 14.11f),
      new Medikament("Rs2", "Radionuklide", 3, 20.22f),
      new Medikament("Lthyroxin", "Eutorox", 1, 7.05f),
      new Medikament("Mebendazol", "Benzimidazolen", 2, 13.55f),
      new Medikament("Retterspitz", "", 7, 12.5f),
      new Medikament("Godamed", "Acetylsalicylsaeure", 1, 4.5f),
      new Medikament("Anaesthesikum", "Fentanyl und Opiat", 2, 4.75f),
      new Medikament("Dipidolor", "Morphin", 2, 5.9f),
      new Medikament("Aktren", "Ibuprofon", 1, 6.9f),
      new Medikament("propal", "Propolis", 4, 7.9f),
      new Medikament("Bluttransfusion", "Blutkoerperchen", 2, 250.5f),
      new Medikament("Dolgit 800", "Ibuprofon", 1, 19.78f),
      new Medikament("Vigil", "Modafin", 1, 10.7f)
    };

    //Zuordnung der Medikamente zu den Diagnosen
    int i = 0, j = 0;

    for (i = 0; i < medi.length; i++) {
      if (i >= 1 && i <= 4) {
        j = 1;
      } else if (i == 5) {
        j = 2;
      } else if (i == 6) {
        j = 3;
      } else if (i >= 7 && i <= 9) {
        j = 4;
      } else if (i >= 10 && i <= 11) {
        j = 5;
      } else if (i >= 12 && i <= 13) {
        j = 6;
      } else if (i == 14) {
        j = 7;
      }
      diag[j].neuesMedikament(medi[i]);
    }

    //Patient 1 wird ambulant behandelt
    santamaria.neuerPatient(new Patient("Anis", "Manfred", "12.02.1965", 0));
    santamaria.patienten[0].setVers('G', "AOT", "2384790");
    santamaria.patienten[0].neueDiagnose(diag[0]);

    //Patient 2 wird stationaer behandelt
    santamaria.neuerPatient(new Patient("Amin", "Johannes", "10.03.1952", 12));
    santamaria.patienten[1].setVers('P', "AOT", "2459122");
    santamaria.patienten[1].setStation(s[0]);
    santamaria.patienten[1].neueDiagnose(diag[1]);

    //Patient 3 wird stationaer behandelt
    santamaria.neuerPatient(new Patient("Anna", "Claudia", "01.10.1968", 30));
    santamaria.patienten[2].setVers('G', "AOT", "2459122");
    santamaria.patienten[2].neueDiagnose(diag[2]);
    santamaria.patienten[2].neueDiagnose(diag[3]);
    santamaria.patienten[2].setStation(s[1]);

    //Patient 4 wird stationaer behandelt
    santamaria.neuerPatient(new Patient("Goldschmied", "Annastasia", "01.10.1954", 12));
    santamaria.patienten[3].setVers('G', "AWB", "33892");
    santamaria.patienten[3].neueDiagnose(diag[4]);
    santamaria.patienten[3].setStation(s[1]);

    //Patient 5 wird ambulant behandelt
    santamaria.neuerPatient(new Patient("Thomas", "Karsten", "01.10.1947", 0));
    santamaria.patienten[4].setVers('G', "AX", "2009122"); /// darf nicht versetz werden!
    santamaria.patienten[4].neueDiagnose(diag[5]);

    //Patient 6 wird in stationaer behandelt
    santamaria.neuerPatient(new Patient("Klempner", "Thorsten", "01.10.1961", 21));
    santamaria.patienten[5].setVers('P', "AOT", "256732");
    santamaria.patienten[5].neueDiagnose(diag[6]);
    santamaria.patienten[5].setStation(s[4]);

    //Patient 7 wird stationaer behandelt
    santamaria.neuerPatient(new Patient("Kurt", "Andrew", "01.10.1947", 14));
    santamaria.patienten[6].setVers('P', "ASM", "456231");
    santamaria.patienten[6].neueDiagnose(diag[7]);
    santamaria.patienten[6].setStation(s[5]);

    //Patient 8 wird in s7 stationaer behandelt
    santamaria.neuerPatient(new Patient("Rosa", "Samanta", "01.10.1984", 10));
    santamaria.patienten[7].setVers('G', "AXIS", "988354");
    santamaria.patienten[7].neueDiagnose(diag[8]);
    santamaria.patienten[7].setStation(s[6]);

    santamaria.ausgabe();
    System.out.println("");
    System.out.println(
        "Auslastung s: " + santamaria.stationsauslastung(santamaria.stationen[1]) + "%");
    System.out.println(
        "Patient " + santamaria.laengste_Aufenthalt() + " hat die laengste Aufenthalt");
    System.out.println("Kosten " + santamaria.berechnekosten(3) + " Euro");
  }
}
