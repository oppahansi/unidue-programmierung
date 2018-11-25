/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_4;

public class Graph {
  Knoten kopf, fuss;

  //AUGABE 4.4 a
  Kante exKante(Knoten a, Knoten b) {
    for (Kante kan = a.kopf; kan != null; kan = kan.Nf) {
      if (kan.kante.equals(b)) {
        return kan;
      }
    }
    return null;
  }

  //AUFGABE 4.4 b
  void loescheKn(Knoten k) {
    kopf = loescheKn(kopf, k);
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      fuss = kn;
    }
  }

  Knoten loescheKn(Knoten k1, Knoten k) {
    if (k1 != null) {
      if (k1.equals(k)) {
        return k.Nf;
      } else {
        k1.Nf = loescheKn(k1.Nf, k);
      }
    }
    return k1;
  }

  //AUFGABE 4.4 c
  boolean Du(Knoten k) {
    if (hinfuehrend(k) == 1 && wegfuehrend(k) == 1) {
      return true;
    }
    return false;
  }

  int hinfuehrend(Knoten k) {
    int aus = 0;
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (kan.kante.equals(k)) {
          aus++;
        }
      }
    }
    return aus;
  }

  int wegfuehrend(Knoten k) {
    int aus = 0;
    for (Kante kan = k.kopf; kan != null; kan = kan.Nf) {
      aus++;
    }
    return aus;
  }

  //AUFGABE 4.4 d
  void ueberbr() {
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        if (Du(kan.kante)) {
          Knoten zuloeschen = kan.kante;
          kn.kopf.kante = kan.kante;
          loescheKn(zuloeschen);
        }
      }
    }
  }
}
