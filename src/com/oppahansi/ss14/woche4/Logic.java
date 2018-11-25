package com.oppahansi.ss14.woche4;

// Logik (Huete)
//
// Cecilia sitzt im Wartezimmer ihres Zahnarztes. Durch aufmerksame Beobachtung
// der anderen Patienten hat sie folgendes Schema entdeckt:
// - Alle Maenner mit Brille tragen einen Hut
// - Nur diejenigen Frauen, die keine Brille, aber Ohrringe tragen, tragen ebenfalls einen Hut
// Vervollstaendigen Sie die Methode doesPersonWearHat, welche anhand der als Parameter
// uebergebenen Merkmale voraussagt, ob die jeweilige Person einen Hut traegt.

/*
 * Bearbeitet von Alex S.
 * alias oppahansi
 */

public class Logic {

  public static boolean doesPersonWearHat(boolean isMale, boolean hasGlasses, boolean hasEarrings) {
    /*
     * Fall 1:
     * Alle Männer(isMale ist true) mit Brille(hasGlasses ist true) tragen einen Hut
     * da es boolean Variablen sind und diese nur true oder false sein kann, kann man
     * diese einfach so schreiben - andere Schreibweise wäre:
     * if(isMale == true && hasGlasses == true) {...}
     */
    if (isMale && hasGlasses) {
      return true;
      /* Fall 2:
       * Nur diejenigen Frauen(isMale ist false), die keine Brille(hasGlasses ist false),
       * aber Ohrringe(hasEarrings ist true) tragen, tragen ebenfalls einen Hut.
       */
    } else if (!isMale && !hasGlasses && hasEarrings) {
      return true;
      /*
       * Falls keiner der Fälle zutreffen false zurückgeben
       */
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    // Testaufruf
    String fall1 = "Eine Frau mit Brille und Ohrringen traegt einen Hut: ";
    String fall2 = "Eine Frau ohne Brille und Ohrringen traegt einen Hut: ";
    String fall3 = "Ein Mann mit Brille traegt einen Hut: ";
    String fall4 = "Ein Mann ohne Brille traegt einen Hut: ";
    System.out.println(fall1 + doesPersonWearHat(false, true, true));
    System.out.println("Erwartet false - kein Hut");
    System.out.println();
    System.out.println(fall2 + doesPersonWearHat(false, false, true));
    System.out.println("Erwartet true - mit Hut");
    System.out.println();
    System.out.println(fall3 + doesPersonWearHat(true, true, true));
    System.out.println("Erwartet true - mit Hut");
    System.out.println();
    System.out.println(fall4 + doesPersonWearHat(true, false, true));
    System.out.println("Erwartet false - ohne Hut");
  }
}
