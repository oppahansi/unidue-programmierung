/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A4_1;

public class Graph {
  Knoten kopf, fuss;

  //AUGABE 4.1 a
  void h() {
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        kan.kante.Anz++;
      }
    }
  }

  //AUGABE 4.1 b
  void d() {
    for (Knoten kn = kopf; kn != null; kn = kn.Nf) {
      for (Kante kan = kn.kopf; kan != null; kan = kan.Nf) {
        kn.Anz--;
      }
    }
  }
}
