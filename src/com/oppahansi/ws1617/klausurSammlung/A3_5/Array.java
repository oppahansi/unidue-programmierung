/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A3_5;

public class Array {
  //AUFGABE 3.5 a
  int[] neu() {
    return new int[5];
  }
  //AUFGABE 3.5 b
  boolean sortiert(int[] a) {
    for (int i = 1; i < a[0]; i++) {
      if (a[i] > a[i + 1]) {
        return false;
      }
    }
    return true;
  }
  //AUFGABE 3.5 c
  int[] sortiereEin(int[] a, int e) {
    a[0] += 1;
    int x = e;
    for (int i = 1; i <= a[0]; i++) {
      if (a[i] == 0) {
        a[i] = x;
        break;
      } else if (x <= a[i]) {
        int temp = a[i];
        a[i] = x;
        x = temp;
      }
    }
    return a;
  }

  //AUFGABE 3.5 d
  int suche(int[] a, int e) {
    for (int i = 1; i <= a[0]; i++) {
      if (a[i] == e) {
        return i;
      }
    }
    return 0;
  }

  //AUFGABE 3.5 e
  Knoten suchbaumwurzel(int[] a) {
    // nicht vollstaendig
    return new Knoten(-1); // add a proper implementation, dont forget to add return types - Oppa
  }
}
