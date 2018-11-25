/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_7;

abstract class Sportler {
  String Name;
  int[] Weite;

  Sportler(String n, int[] w) {
    Name = n;
    Weite = w;
  }

  abstract int Startgeld();

  int Punkte() {
    if (Weite == null || Weite.length < 1) return 0;
    int m = Weite[0];
    for (int i = 1; i < Weite.length; i++) if (Weite[i] > m) m = Weite[i];
    return 2 * m;
  }
}
