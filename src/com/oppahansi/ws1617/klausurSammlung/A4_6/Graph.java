/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_6;

public class Graph {
  Knoten kopf, fuss;

  //AUFGABE 4.6 a
  int anzRot() {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      if (kn.farbe == 'r') {
        aus++;
      }
    }
    return aus;
  }

  //AUFGABE 4.6 b
  int Anz_Gleichfarbig() {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kn.farbe == kan.farbe && kan.farbe == kan.kante.farbe) {
          aus++;
          break;
        }
      }
    }
    return aus;
  }

  //AUFGABE 4.6 c
  void faerbe_hinfuehrend() {
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kan.kante.f == 0) {
          kan.kante.f = kan.farbe;
          kan.kante.n++;
        } else if (kan.kante.f != kan.farbe) {
          kan.kante.n++;
        }
      }
    }
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      if (kn.n == 1) {
        kn.farbe = kn.f;
      }
    }
  }
}
