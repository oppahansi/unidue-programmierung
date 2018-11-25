/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_5;

public class Graph {
  Knoten kopf, fuss;
  int Anzahl;
  //AUFGABE 4.5 a
  void indiziere() {
    int index = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      kn.index = index;
      index++;
    }
    Anzahl = index;
  }

  //AUFGABE 4.5 b
  int[][] Matrix() {
    int aus[][] = new int[Anzahl][Anzahl];
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        aus[kn.index][kan.kante.index] = kan.zahl;
      }
    }
    return aus;
  }

  //AUFGABE 4.5 c
  int summe(Knoten k) {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kan.kante.equals(k)) {
          aus += kan.zahl;
        }
      }
    }
    for (Kante kan = k.kopf; kan != null; kan = kan.Nf) {
      aus += kan.zahl;
    }
    return aus;
  }

  //AUFGABE 4.5 d
  int anzMax() {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      if (hinMax(kn) || ausMax(kn)) {
        aus++;
      }
    }
    return aus;
  }

  int max() {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kan.zahl > aus) {
          aus = kan.zahl;
        }
      }
    }
    return aus;
  }

  boolean hinMax(Knoten k) {
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kan.zahl == max() && kan.kante.equals(k)) {
          return true;
        }
      }
    }
    return false;
  }

  boolean ausMax(Knoten k) {
    for (Kante kan = k.kopf; kan != null; kan = kan.Nf) {
      if (kan.zahl == max()) {
        return true;
      }
    }
    return false;
  }
}
