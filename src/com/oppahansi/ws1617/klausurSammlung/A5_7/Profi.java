/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_7;

class Profi extends Sportler {

  Profi(String n, int[] w) {
    super(n, w);
  }

  //AUFGABE 5.7 c
  int Punkte() {
    if (Weite == null || Weite.length <= 1) return 0;

    int m = Weite[0];
    int n = Weite[1];
    int speicher = 0;
    for (int i = 2; i < Weite.length; i++) {
      if (Weite[i] > m) {
        speicher = m;
        m = Weite[i];
        if (speicher > n) {
          n = speicher;
        }
      } else if (Weite[i] > n) {
        speicher = n;
        n = Weite[i];
        if (speicher > m) {
          m = speicher;
        }
      }
    }
    return m + n;
  }

  int Startgeld() {
    return 600;
  }
}
