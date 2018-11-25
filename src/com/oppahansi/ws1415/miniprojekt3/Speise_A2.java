/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze.
 */
package com.oppahansi.ws1415.miniprojekt3;

// Implementierung der Aufgaben von Mark Kunze (c)
public class Speise_A2 {

  public String name;
  public Zutat_A2 kopf, fuss;

  public Speise_A2(String name) {
    super();
    this.name = name;
  }

  // Aufgabe
  public void neueZutat(Lebensmittel lebensmittel, double menge) { // Aufgabe
    Zutat_A2 zeiger = this.kopf; //setzt Zeiger auf erste Zutat
    boolean found = false; //Variable ob lebensmittel schon vorhanden
    if (kopf == null) { //Sonderfall Zutatenliste leer
      kopf = new Zutat_A2(lebensmittel, menge); //Setze erste Zutat
      fuss = kopf; //setze fuss
      found = true; //found wird true weil Element schon eingepfegt
    } //end of if
    while (zeiger != null && found == false) { //geht Zutaten durch um zu pr�fen ob schon vorhanden
      if (zeiger.lebensmittel == lebensmittel) { //lebensmittel in Liste schon vorhanden
        zeiger.menge += menge; //erh�hr die Menge
        found = true; // Gefunden :)
      } //end of if
      zeiger = zeiger.nachfolger; //Zeiger geht auf die n�chste Zutat
    } //end of while
    if (found == false) { //lebensmittel noch nicht in Liste vorhanden
      this.fuss.nachfolger = new Zutat_A2(lebensmittel, menge); //f�ge Zutat hinten an
      this.fuss = fuss.nachfolger; //setze neuen fuss
    } //end of if
  } //end of proc

  // Aufgabe
  public double getKcal() {
    double kcalsum = 0; //setze die Summe auf 0
    Zutat_A2 zeiger = this.kopf; //zeige aufs erste Element
    while (zeiger != null) { //gehe alle Elemente bis zum Ende durch
      kcalsum += zeiger.getKcal(); //Addiere immer die Kalorien der Zutat drauf
      zeiger = zeiger.nachfolger; //n�chste Zutat
    } //end of while
    return kcalsum; //Ausgabe
  } //end of proc

  public boolean findeZutat(Lebensmittel lebensmittel) { // Aufgabe
    Zutat_A2 zeiger = this.kopf; //erste Zutat
    while (zeiger != null) { //gehe Zutaten durch
      if (zeiger.lebensmittel == lebensmittel) //Lebensmittel gefunden
      {
        return true; //return true... beende Proc
      }
      zeiger = zeiger.nachfolger; //n�chste Zuatat
    } //end of while
    return false; //nicht gefunden
  } //end of proc

  public double getPgehalt() {
    double psum = 0; //Summe der Proteine der Speise
    Zutat_A2 zeiger = this.kopf; //erste Zutat
    while (zeiger != null) { //geht alle Zutaten durch
      psum += zeiger.getPgehalt(); //Addiert die Proteine der Zuatat dazu
      zeiger = zeiger.nachfolger; //n�chste Zuatat
    } //end of while
    return psum; //Ausgabe
  } //end of proc

  public double getKgehalt() { //siehe getPgehalt
    double ksum = 0;
    Zutat_A2 zeiger = this.kopf;
    while (zeiger != null) {
      ksum += zeiger.getKgehalt();
      zeiger = zeiger.nachfolger;
    }
    return ksum;
  }

  public double getFgehalt() { //siehe getPgehalt
    double fsum = 0;
    Zutat_A2 zeiger = this.kopf;
    while (zeiger != null) {
      fsum += zeiger.getFgehalt();
      zeiger = zeiger.nachfolger;
    }
    return fsum;
  }

  public void ersetze(Lebensmittel neu, Lebensmittel alt, double faktor) {
    Zutat_A2 zeiger = kopf; //erste Zuatat
    while (zeiger != null) { //gehe Zutaten durch
      if (zeiger.lebensmittel == alt) { //alte Zuatat gefunden
        zeiger.lebensmittel = neu; //ersetze mit neuer Zutat(Lebensmittel)
        zeiger.menge *= faktor; //erh�hre die Menge um den Faktor
      } //end of if
      zeiger = zeiger.nachfolger; //n�chste Zutat
    } //end of while
  } //end of proc

  public boolean enthalten(Speise_A2 speise2) { //mit Zutaten von speise2 kann 'THIS' gekocht werden
    Zutat_A2 zeiger1 = this.kopf; //setze Zeiger auf 1. Zuatat der aufrufenden Speise
    Zutat_A2 zeiger2; //Speichert die Zutat der 2. Speise
    while (zeiger1 != null) { //geht alle Zutaten der 1. Speise durch
      zeiger2 = speise2.kopf; //setzt Zeiger auf die erste Zuatat der 2. Speise
      while (zeiger2 != null) { //geht alle Zutaten der 2. Speise durch
        if (zeiger2.lebensmittel == zeiger1.lebensmittel
            && zeiger2.menge >= zeiger1.menge) //Zutat in hinreichender Menge gefunden...
        {
          break; //innere Schleife kann abgebrochen werden
        }
        zeiger2 =
            zeiger2
                .nachfolger; //Zutat (evtl. in nicht ausreichnder Menge) nicht gefunden -> n�chste Zuatat von Sp.2
      } //end of inner while
      if (zeiger2 == null) {
        return false; //Falls die Zutatenliste der Speise 2 durchlaufen wurde ist die Zutat von 1 dort nicht enthalten... programm beenden mit false
      }
      zeiger1 = zeiger1.nachfolger; //n�chste Zutat von Sp. 1
    } //end of outer while
    return true; //es wurden alle gefunden(Ansonsten w�re das Programm schon oben beendet)
  } //end of proc
} //end of class
