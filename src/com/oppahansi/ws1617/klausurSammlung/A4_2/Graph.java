/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_2;

public class Graph {
  Knoten kopf, fuss;

  //AUFGABE 4.2 a
  int s() {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      if (kn.kopf == null) {
        aus++;
      }
    }
    return aus;
  }

  //AUFGABE 4.2 b
  int d() {
    double aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        for (Kante kan1 = kan.kante.kopf; kan1 != null; kan1 = kan1.Nf) {
          if (kn.equals(kan1.kante)) {
            aus += 0.5;
          }
        }
      }
    }
    return (int) aus;
  }
}
