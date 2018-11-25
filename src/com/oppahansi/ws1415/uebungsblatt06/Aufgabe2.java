/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt06;

public class Aufgabe2 {

  private int[] feld; //feld-Array
  private int links; //linke Grenze des Suchbereichs
  private int rechts; //rechte Grenze des Suchbereichs
  private int mitte; //Mitte des Suchbereichs
  private int gesucht; //gesuchte Element

  public static void main(String[] args) {
    int[] feld = {1, 14, 22, 3, 34, 55, 8, 9};
    Aufgabe2 s = new Aufgabe2();

    s.sortiere(feld);
    s.ausgabe(feld);
    System.out.println("Position:" + (s.binaereSuche(14, feld)));
  }

  public int binaereSuche(int n, int[] feld) {
    int ergebnis = -1;
    if (feld == null) {
      System.out.println("Error: feld ist leer!");
    } else {
      this.feld = feld;
      links = 0;
      rechts = feld.length - 1;
      gesucht = n;
      ergebnis = binaerSucheRekusiv();
    }
    return ergebnis;
  }

  private int binaerSucheRekusiv() {
    mitte = (links + rechts) / 2; //Berechnung der Mitte
    //Abbruchbedingung (Rekursionsbasis)
    if (links > rechts) {
      return -1;
    }
    //suche Wert im linken feld
    if (gesucht < feld[mitte]) {
      rechts = mitte - 1;
      return binaerSucheRekusiv();
    }
    //suche Wert im rechten feld
    else if (gesucht > feld[mitte]) {
      links = mitte + 1;
      return binaerSucheRekusiv();
    }
    //Wert wurde an Position index
    else {
      return mitte;
    }
  }

  public void sortiere(int[] feld) {
    int minpos;
    for (int i = 0; i < feld.length; i++) {
      minpos = i;
      for (int k = i + 1; k < feld.length; k++) {
        if (feld[k] < feld[minpos]) {
          minpos = k;
        }
      }
      if (minpos > i) {
        vertausche(i, minpos, feld);
      }
    }
  }

  public void ausgabe(int[] feld) {
    for (int i = 0; i < feld.length; i++) {
      System.out.print(feld[i] + " ");
    }
    System.out.println();
  }

  public void vertausche(int a, int b, int[] feld) {
    int ablage = feld[a];
    feld[a] = feld[b];
    feld[b] = ablage;
  } // vertauschen von zwei Werten im feld-Array
}
