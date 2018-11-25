/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

public class Graph {

  Knoten kopf, fuss;
  boolean flag = false;

  public void fuegeEin(Knoten k) {
    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss = fuss.nf = k;
    }
  }

  public void gibAus() {
    //referenz auf das erste objekt (im graph)
    Knoten tmp = kopf;
    while (tmp != null) {
      tmp.gibAus();
      tmp = tmp.nf;
    }
  }

  //Aufgabe 2b)
  //Die Methode macht nichts anderes als alle Kanten
  //in einer Liste zu speichern.
  public boolean gleicheKanten() {
    Liste l = new Liste();
    Knoten tmpKnoten = kopf;
    while (tmpKnoten != null) {
      Kante tmpKante = tmpKnoten.kopf; //gemeint ist die Kante
      //pr�fe, ob es eine Kante zum Knoten gibt
      while (tmpKante != null) {
        if (tmpKante.bez != null) {
          l.zaehleHoch(tmpKante.bez);
        }
        //alle zu diesem Knoten geh�renden Kanten durchlaufen!
        tmpKante = tmpKante.nf;
      }
      tmpKnoten = tmpKnoten.nf;
    }
    //pruefe, ob Grap doppelte kanten entaelt
    return l.enthaeltDoppelteElemente();
  }

  private boolean sucheWegDFS(Knoten von, Knoten zu) {
    boolean vorhanden = false;
    von.marker = true;
    Kante kante = von.kopf;

    while (kante != null && !vorhanden) {
      if (kante.ziel == zu) {
        vorhanden = true;
      }
      if (!kante.ziel.marker) {
        vorhanden = vorhanden || sucheWegDFS(kante.ziel, zu);
      }
      kante = kante.nf;
    }
    return vorhanden;
  }

  private void loescheMarker() {
    Knoten tmp = kopf;

    while (tmp != null) {
      tmp.marker = false;
      tmp = tmp.nf;
    }
  }

  public boolean sucheWeg(Knoten k1, Knoten k2) {
    boolean vorhanden = sucheWegDFS(k1, k2);
    loescheMarker();
    return vorhanden;
  }

  //Aufgabe 2c)
  public boolean istZyklenfrei() {
    Knoten tmp = kopf;

    while (tmp != null) {
      if (sucheWeg(tmp, tmp)) {
        return false;
      }
      tmp = tmp.nf;
    }
    return true;
  }
}
