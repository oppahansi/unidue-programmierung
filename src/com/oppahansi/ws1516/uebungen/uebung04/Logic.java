package com.oppahansi.ws1516.uebungen.uebung04;

// Logik (Huete)
//
// Cecilia sitzt im Wartezimmer ihres Zahnarztes. Durch aufmerksame Beobachtung
// der anderen Patienten hat sie folgendes Schema entdeckt:
// - Alle Maenner mit Brille tragen einen Hut
// - Nur diejenigen Frauen, die keine Brille, aber Ohrringe tragen, tragen ebenfalls einen Hut
// Vervollstaendigen Sie die Methode doesPersonWearHat, welche anhand der als Parameter
// Uebergebenen Merkmale voraussagt, ob die jeweilige Person einen Hut traegt.
public class Logic {

  public static boolean doesPersonWearHat(boolean isMale, boolean hasGlasses, boolean hasEarrings) {
    return isMale && hasGlasses && !hasEarrings || !isMale && !hasGlasses && hasEarrings;
  }

  public static void main(String[] args) {
    // Testaufruf
    System.out.println(
        "Eine Frau mit Brille und Ohrringen traegt einen Hut: "
            + doesPersonWearHat(false, true, true)
            + " - "
            + "Richtig: false");
    System.out.println(
        "Eine Frau ohne Brille und Ohrringen traegt einen Hut: "
            + doesPersonWearHat(false, false, true)
            + " - "
            + "Richtig: true");
    System.out.println(
        "Ein Mann ohne Brille traegt einen Hut: "
            + doesPersonWearHat(true, false, false)
            + " - "
            + "Richtig: false");
    System.out.println(
        "Eine Mann mit Brille traegt einen Hut: "
            + doesPersonWearHat(true, true, false)
            + " - "
            + "Richtig: true");
  }
}
