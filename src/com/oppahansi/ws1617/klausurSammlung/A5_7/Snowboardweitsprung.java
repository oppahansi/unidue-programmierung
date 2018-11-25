/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_7;

public class Snowboardweitsprung {
  public static void main(String[] unbenutzt) {

    Sportler[] s = new Sportler[5];
    int[] s0 = {9, 14, 16};
    s[0] = new Amateur("Sven", s0);
    int[] s1 = {13, 15, 11};
    s[1] = new Amateur("Lisa", s1);
    int[] s2 = {26, 34, 21, 19};
    s[2] = new Profi("Vera", s2);
    int[] s3 = {33, 12, 24, 27};
    s[3] = new Profi("Erik", s3);
    int[] s4 = {14, 8, 12};
    s[4] = new Amateur("Jens", s4); // ***
    int gA = 0, SiegerA = 0;
    int hoechPunktA = 0;
    int gP = 0, SiegerP = 0;
    int hoechPunktP = 0;

    //AUFGABE 5.7 d
    for (int i = 0; i < s.length; i++) {
      if (s[i] instanceof Amateur) {
        gA += s[i].Startgeld();
        if (s[i].Punkte() > hoechPunktA) {
          hoechPunktA = s[i].Punkte();
        }
      } else {
        gP += s[i].Startgeld();
        if (s[i].Punkte() > hoechPunktP) {
          hoechPunktP = s[i].Punkte();
        }
      }
    }

    for (int i = 0; i < s.length; i++) {
      if (s[i] instanceof Amateur && s[i].Punkte() == hoechPunktA) {
        SiegerA++;
      } else if (s[i] instanceof Profi && s[i].Punkte() == hoechPunktP) {
        SiegerP++;
      }
    }
    for (int i = 0; i < s.length; i++) {
      if (s[i] instanceof Amateur && s[i].Punkte() == hoechPunktA) {
        System.out.println(s[i].Name + " hat gewonnen" + " und erhaelt " + gA / SiegerA + " Euro.");
      } else if (s[i] instanceof Profi && s[i].Punkte() == hoechPunktP) {
        System.out.println(s[i].Name + " hat gewonnen" + " und erhaelt " + gP / SiegerP + " Euro.");
      }
    }
  }
}
