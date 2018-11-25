/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_8;

public class Arbeitszeiten {

  public static void main(String[] unbenutzt) {

    Zeit[] z = new Zeit[5];
    z[0] = new PraesenzBereitschaft(7);
    z[1] = new Einsatz("Feuer geloescht", 11, 14);
    z[2] = new PraesenzBereitschaft(7);
    z[3] = new Einsatz("Kaetzchen vom Dach geholt", 9, 10);
    z[4] = new RufBereitschaft(12345, 16, 24);

    ((Bereitschaft) z[2]).Pausen = true;
    float Bezahlung = 0;

    for (int i = 0; i < z.length; i++) {
      Bezahlung += z[i].Bezahlung();
      System.out.println(z[i].Dauer() + " h, " + z[i].Bezahlung() + " Euro");
    }
    System.out.println("gesamt: " + Bezahlung + " Euro");
    System.out.println(gleich(z));
  }

  //AUFGABE 5.8 f
  static boolean gleich(Zeit[] z) {

    for (int i = 0; i < z.length; i++) {
      for (int j = i + 1; j < z.length; j++) {
        if (z[j] instanceof Bereitschaft
            && z[i] instanceof Bereitschaft
            && z[j].Dauer() != z[i].Dauer()) {
          return false;
        }
      }
    }
    return true;
  }
}
