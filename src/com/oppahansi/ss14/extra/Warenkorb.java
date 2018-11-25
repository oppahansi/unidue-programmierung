package com.oppahansi.ss14.extra;

/*  Code und die Idee von http://www.informatikzentrale.de/getter-setter-java.html
 *	Modifiziert durch oppahansi
 */

public class Warenkorb {

  // Attribute

  protected double rechnungSumme;
  protected int anzahlArtikel;
  protected double enthalteneMehrwertsteuer;

  // ANFANG - Ab hier ist der zu bearbeitende Code

  // Konstruktor
  public Warenkorb(double summe, int anzahl) {
    rechnungSumme = summe;
    // hier fehlt etwas
    // tipp: das Attribut "anzahlArtikel" hat noch keinen Wert!

  }

  // Methoden
  public void berechneMehrwertsteuer() {
    // hier muss die MwSt berechnet werden

  }

  public double getRechnungSumme() {
    // hier muss die rechnungSumme ausgegeben werden
    return 1.0;
  }

  // hier m�ssen noch 2 getter erstellt werden. Die Namen lassen sich leicht herausfinden
  // Achte auf die Fehler im Code, die rot untermalt sind.
  // Achte auf den Datentyp der Methoden und ob Parameter gebraucht werden oder nicht

  // (optional)
  // erstelle auch die setter, die deiner Meinung nach fehlen

  // ENDE des zu bearbeitenden Codes

  //	public void rechnungsDatenAusgeben() {
  //		System.out.println("Rechnungsumme: " + getRechnungSumme());
  //		System.out.println("Anzahl Artikel im Warenkorb: " + getAnzahlArtikel());
  //		System.out.println("Enthaltene MwSt.: " + getEnthalteneMehrwertsteuer());
  //	}

}
