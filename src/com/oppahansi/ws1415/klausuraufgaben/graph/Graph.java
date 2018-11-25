/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.graph;

class Graph {

  int Anzahl;
  Knoten kopf, fuss;

  public void fuegeEin(Knoten k) {
    int index = 0;
    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss.nf = k;
      fuss = k;
      index++;
    }
    k.Index = index;
  }

  // Von MiniProjekt Methoden

  private boolean exKante(Knoten a, Knoten b) {
    Kante k = a.kopf;
    while (k != null) {
      if (k.hinKnote == b) {
        return true;
      }
      k = k.nf;
    }

    return false;
  }

  private int anzahlHinKanten(Knoten k) {
    Knoten knoten = this.kopf;
    int counter = 0;
    while (knoten != null) {
      Kante kante = knoten.kopf;
      while (kante != null) {
        if (kante.hinKnote == k) {
          counter++;
        }
        kante = kante.nf;
      }
      knoten = knoten.nf;
    }
    return counter;
  }

  private int anzahlAusKanten(Knoten k) {
    int counter = 0;
    Kante kante = k.kopf;
    while (kante != null) {
      counter++;
      kante = kante.nf;
    }
    return counter;
  }

  // Aufgabe 4.1: Kanten in Graphen

  void AnzHinkante() {
    Knoten k = this.kopf;
    while (k != null) {
      k.Index = anzahlHinKanten(k);
      k = k.nf;
    }
  }

  void AnzDiffer() {
    Knoten k = this.kopf;
    while (k != null) {
      k.Index = anzahlHinKanten(k) - anzahlAusKanten(k);
      k = k.nf;
    }
  }

  // Aufgabe 4.2: Doppelt verbundene Knoten

  int anzSenke() {
    Knoten knoten = this.kopf;
    int counter = 0;
    while (knoten != null) {
      if (knoten.kopf == null) {
        counter++;
      }
      knoten = knoten.nf;
    }

    return counter;
  }

  boolean doppeltVerbunden(Knoten a, Knoten b) {
    return exKante(a, b) && exKante(b, a);
  }

  // Aufgabe 4.3: Abkürzungen in Graphen

  boolean Abk(Knoten k, Kante e) {
    Kante kante = k.kopf;
    while (kante != null) {
      if (kante != e) {
        if (Abk(k, kante.hinKnote, e)) {
          return true;
        }
      }
      kante = kante.nf;
    }
    return false;
  }

  private boolean Abk(Knoten start, Knoten k, Kante e) {
    if (k == start) {
      return false;
    }
    Kante kante = k.kopf;
    while (kante != null) { //while循环实现队列处理,检查一个节点的所有边是否有指向节点e.hinKnote
      //否则检查每个边的下一层所有节点是否通向节点e.hinKnote
      if (kante.hinKnote == e.hinKnote) {
        return true;
      } else if (Abk(start, kante.hinKnote, e)) {
        return true;
      }
      kante = kante.nf;
    }
    return false;
  }

  void loescheAbk() {
    Knoten knoten = this.kopf;
    while (knoten != null) {
      Kante kante = knoten.kopf;
      Kante vorgaenger = knoten.kopf;
      while (kante != null) {
        if (Abk(knoten, kante)) {
          if (kante == knoten.kopf) {
            knoten.kopf = kante.nf;
          } else if (kante == knoten.fuss) {
            knoten.fuss = vorgaenger;
            fuss.nf = null;
          } else {
            vorgaenger.nf = kante.nf;
          }
          kante = vorgaenger.nf;
        } else {
          vorgaenger = kante;
          kante = kante.nf;
        }
      }
      knoten = knoten.nf;
    }
  }

  // Aufgabe 4.5 Graphen und Arrays
  void indiziere() { //初始化所有节点的Index
    Knoten knoten = this.kopf;
    int counter = 0;
    while (knoten != null) {
      knoten.Index = counter;
      counter++;
      knoten = knoten.nf;
    }
    this.Anzahl = counter;
  }

  int[][] Matrix() {
    int[][] maxtrix = new int[Anzahl][Anzahl];
    Knoten knoten = this.kopf;
    while (knoten != null) {
      Kante kante = knoten.kopf;
      while (kante != null) {
        maxtrix[knoten.Index][kante.hinKnote.Index] = kante.Wert;
        kante = kante.nf;
      }
      knoten = knoten.nf;
    }
    return maxtrix;
  }

  int Summe(Knoten k) {
    int summe = 0;
    int[][] matrix = Matrix();
    for (int i : matrix[k.Index]) {
      summe += i;
    }
    for (int[] j : matrix) {
      summe += j[k.Index];
    }
    if (matrix[k.Index][k.Index] != 0) { // 减去指向自身的边权重
      summe -= matrix[k.Index][k.Index];
    }
    return summe;
  }

  int anzMax() {
    int[] zug = new int[Anzahl];
    int[][] matrix = Matrix();
    int maxZahl = 0;
    int anZahl = 0;
    for (int i = 0; i < matrix.length; i++) { // 找出最大的边权重
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > maxZahl) {
          maxZahl = matrix[i][j];
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == maxZahl) {
          zug[i] = 1;
          zug[j] = 1;
        }
      }
    }

    for (int i : zug) {
      if (i == 1) {
        anZahl++;
      }
    }

    return anZahl;
  }
  // Aufgabe 4.6
}

class Kante {

  int Wert; // Kante Wert = Hin-Knote.Index
  Kante nf; // Nachfolger-Kante.
  Knoten hinKnote; // Knoten, zu dem die Kante hinfuehrt.

  public Kante(Knoten knote) {
    this.Wert = knote.Index;
    nf = null;
    this.hinKnote = knote;
  }
}

class Knoten {

  int Index; // Position der Knoten
  Knoten nf; // Nachfolger-Knoten.
  Kante kopf, fuss; // Vom Knoten ausgehende Kanten.

  Knoten() {
    nf = null;
    kopf = fuss = null;
  }

  public void fuegeEin(Kante k) {
    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss.nf = k;
      fuss = k;
    }
  }
}

class strKnoten extends Knoten {

  String bez; // Bezeichnung des Knotens.

  strKnoten(String bez) {
    super();
    this.bez = bez;
  }
}

class intKnoten extends Knoten {

  int zahl;

  intKnoten(int zahl) {
    super();
    this.zahl = zahl;
  }
}
