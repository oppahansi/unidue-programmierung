/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Miniprojekt4 {

  private static String[] aerzte;
  private static Medikament[] medikamente;
  private static Diagnose[] diagnosen;

  public static void main(String args[]) {
    Krankenhaus santamaria =
        new Krankenhaus("Santamaria", 130); // 10 Betten f�r ambulante Behandlungen
    aerzte = erzeugeAerzte();
    Station[] stationen = erzeugeStationen();
    diagnosen = erzeugeDiagnosen();
    medikamente = erzeugeMedikamente();

    santamaria.setStationen(stationen);
    ordneMedikamenteZuDiagnosen();

    //Patient 1 wird ambulant behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Anis", "Manfred", "12.02.1965", 0));
    santamaria.getPatienten(0).setVersicherungDaten('G', "AOT", "2384790");
    santamaria.getPatienten(0).fuegeDiagnoseHinzu(diagnosen[0]);

    //Patient 2 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Amin", "Johannes", "10.03.1952", 12));
    santamaria.getPatienten(1).setVersicherungDaten('P', "AOT", "2459122");
    santamaria.getPatienten(1).setStation(stationen[0]);
    santamaria.getPatienten(1).fuegeDiagnoseHinzu(diagnosen[1]);

    //Patient 3 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Anna", "Claudia", "01.10.1968", 30));
    santamaria.getPatienten(2).setVersicherungDaten('G', "AOT", "2459122");
    santamaria.getPatienten(2).fuegeDiagnoseHinzu(diagnosen[2]);
    santamaria.getPatienten(2).fuegeDiagnoseHinzu(diagnosen[3]);
    santamaria.getPatienten(2).setStation(stationen[1]);

    //Patient 4 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Goldschmied", "Annastasia", "01.10.1954", 12));
    santamaria.getPatienten(3).setVersicherungDaten('G', "AWB", "33892");
    santamaria.getPatienten(3).fuegeDiagnoseHinzu(diagnosen[4]);
    santamaria.getPatienten(3).setStation(stationen[1]);

    //Patient 5 wird ambulant behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Thomas", "Karsten", "01.10.1947", 0));
    santamaria
        .getPatienten(4)
        .setVersicherungDaten('G', "AX", "2009122"); /// darf nicht versetz werden!
    santamaria.getPatienten(4).fuegeDiagnoseHinzu(diagnosen[5]);

    //Patient 6 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Klempner", "Thorsten", "01.10.1961", 21));
    santamaria.getPatienten(5).setVersicherungDaten('P', "AOT", "256732");
    santamaria.getPatienten(5).fuegeDiagnoseHinzu(diagnosen[6]);
    santamaria.getPatienten(5).setStation(stationen[4]);

    //Patient 7 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Kurt", "Andrew", "01.10.1947", 14));
    santamaria.getPatienten(6).setVersicherungDaten('P', "ASM", "456231");
    santamaria.getPatienten(6).fuegeDiagnoseHinzu(diagnosen[7]);
    santamaria.getPatienten(6).setStation(stationen[5]);

    //Patient 8 wird stationaer behandelt
    santamaria.nehmeNeuenPatientAuf(new Patient("Rosa", "Samanta", "01.10.1984", 10));
    santamaria.getPatienten(7).setVersicherungDaten('G', "AXIS", "988354");
    santamaria.getPatienten(7).fuegeDiagnoseHinzu(diagnosen[8]);
    santamaria.getPatienten(7).setStation(stationen[6]);

    santamaria.patientenInfoAusgabe();

    System.out.println("");
    System.out.println(
        "Auslastung stationen: "
            + santamaria.getStationsAuslastung(santamaria.getStation(1))
            + "%");
    System.out.println(
        "Patient "
            + santamaria.getPatientenMitLaengstemAufenthalt()
            + " hat die laengste Aufenthalt");
    System.out.println("Kosten " + santamaria.getKostenFuerPatientenID(3) + " Euro");
  }

  private static String[] erzeugeAerzte() {
    return Konstante.AERZTE;
  }

  private static Station[] erzeugeStationen() {
    return Konstante.STATIONEN;
  }

  private static Diagnose[] erzeugeDiagnosen() {
    return Konstante.DIAGNOSEN;
  }

  private static Medikament[] erzeugeMedikamente() {
    return Konstante.MEDIKAMENTE;
  }

  private static void ordneMedikamenteZuDiagnosen() {
    int i, j = 0;

    for (i = 0; i < medikamente.length; i++) {
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
      diagnosen[j].fuegeMedikamentHinzu(medikamente[i]);
    }
  }
}
