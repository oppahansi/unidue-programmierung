/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class Miniprojekt_Rekursion {

  public static void main(String args[]) {
    Miniprojekt_Rekursion mpe = new Miniprojekt_Rekursion();
    System.out.println("Start allgemeiner Test Liste");
    mpe.allgemeinerTest(new DatenListe());
    System.out.println("");
    System.out.println("Start allgemeiner Test Binaer-Baum");
    mpe.allgemeinerTest(new DatenBBaum());
    System.out.println("");
    System.out.println("Start allgemeiner Test Trinaer-Baum");
    mpe.allgemeinerTest(new DatenTBaum());

    System.out.println("");
    System.out.println("");
    System.out.println("Start Test nur fuer Binaer-Baum");
    mpe.binaerBaumTest(new DatenBBaum());
  }

  void allgemeinerTest(Datenverwaltung testobjekt) {
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.loeschen(4571);
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.loeschen(4571);
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.einfuegen(new Beschreibung("", 45, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 23, "", 10));
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.loeschen(4571);
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.einfuegen(new Beschreibung("", 12, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 23, "", 10));
    testobjekt.einfuegen(new Beschreibung("", 4571, "", 10));
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    testobjekt.loeschen(4571);
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
    System.out.println(
        "Es sind "
            + testobjekt.getAll(23).anzahlEintraege()
            + " Eintraege mit der Produkt Id 23 vorhanden.");
    testobjekt.allesLoeschen();
    System.out.println("Es sind " + testobjekt.anzahlEintraege() + " Eintraege vorhanden.");
  }

  void binaerBaumTest(DatenBBaum testobjekt) {
    Beschreibung[] test1 = new Beschreibung[131071];
    for (int i = 0; i < test1.length; i++) {
      test1[i] = new Beschreibung("", (int) (Math.random() * Integer.MAX_VALUE), "", i);
    }
    testobjekt.array2baum(test1);
    System.out.println(
        "Bei "
            + testobjekt.anzahlEintraege()
            + " Eintraegen ist die Tiefe "
            + testobjekt.tiefe()
            + " Ebenen.");

    Beschreibung[] test2 = testobjekt.baum2array();
    boolean test2ArrayOk = true;
    if (test1.length != test2.length) {
      test2ArrayOk = false;
    }
    for (int i = 0; i < test2.length; i++) {
      if (test2[i] == null) {
        test2ArrayOk = false;
      }
    }
    System.out.println(
        "Baum2Array liefert ein Array mit genausoviel Elementen wie der Baum enthalten sollte: "
            + test2ArrayOk);

    testobjekt.baumBalancieren();
    System.out.println(
        "Bei "
            + testobjekt.anzahlEintraege()
            + " Eintraegen ist die Tiefe nach dem Balancieren "
            + testobjekt.tiefe()
            + " Ebenen.");
  }
}
