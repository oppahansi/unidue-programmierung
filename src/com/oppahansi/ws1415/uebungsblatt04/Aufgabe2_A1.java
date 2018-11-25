/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Alternative 1 - Live
 */
package com.oppahansi.ws1415.uebungsblatt04;

public class Aufgabe2_A1 {

  public static void main(String[] args) {}
}

class Element {

  int Zahl;
  Element Nf;

  public Element(int Zahl, Element Nf) {
    this.Zahl = Zahl;
    this.Nf = Nf;
  }

  public Element(int Zahl) {
    this(Zahl, null);
  }

  public void ausgabe() {
    System.out.println(Zahl);
  }
}

class Liste {

  Element Kopf, Fuss;

  public void einfuegen(int zahl) {
    Element neu = new Element(zahl);
    if (Kopf == null) {
      Kopf = Fuss = neu;
    } else {
      Fuss.Nf = neu;
      Fuss = Fuss.Nf;
    }
  }

  // Hinweis:
  // Dies ist ein L�sungsansatz zur schrittweisen Erl�uterung,
  // keine vollst�ndige L�sung!
  public void hinzufuegen(Element neu, int position) {

    //Fall: Liste leer
    if (Kopf == null) {
      Kopf = neu;
      Fuss = neu;
    } else {
      // Fall: Liste nicht leer
      neu.Nf = Kopf;
      Element vorgaengerVonNeu = null;
      if (position > 0) {
        vorgaengerVonNeu = Kopf;
        for (int i = 1; i < position; i++) {
          vorgaengerVonNeu = vorgaengerVonNeu.Nf;
        }
      }

      vorgaengerVonNeu.Nf = neu;

      for (int i = 0; i < position; i++) {
        neu.Nf = neu.Nf.Nf;
      }

      /*

      if (position == 0) {
      	neu.Nf = Kopf; // Kopf ist A
      	Kopf = neu;
      } else if (position == 1) {
      	neu.Nf = Kopf.Nf; // Kopf.Nf ist B
      	Kopf.Nf = neu;
      } else if (position == 2) {
      	neu.Nf = Kopf.Nf.Nf; // Kopf.Nf ist B
      	Kopf.Nf.Nf = neu;

      }
      /// ...
      /// Das Grundprinzip w�rde gehen, ist aber eine Dumme Idee:
       *  Es m�sste ein Fall (if-Verzweigung) pro Position
       *  geben und Listen k�nnen sehr sehr sehr lang sein
       *  Daher die Verallgemeinerung weiter oben
       */
    }
  }

  public Element entferne(int position) {
    return null;
  }
}
