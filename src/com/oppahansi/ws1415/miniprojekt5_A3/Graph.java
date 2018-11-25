/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Oppa Hansi
 */
package com.oppahansi.ws1415.miniprojekt5_A3;

class Graph {

  Knoten kopf, fuss;

  public void fuegeEin(Knoten k) {
    if (kopf == null) {
      kopf = fuss = k;
    } else {
      fuss.nf = k;
      fuss = k;
    }
  }

  public int anzahlKanten() {
    int counter = 0;
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        counter++;
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return counter;
  }

  public int anzahlKnoten() {
    int counter = 0;
    Knoten knot = kopf;
    while (knot != null) {
      counter++;
      knot = knot.nf;
    }
    return counter;
  }

  public boolean suche(Knoten p) {
    Knoten knot = kopf;
    while (knot != null) {
      if (knot == p) {
        return true;
      }
      knot = knot.nf;
    }
    return false;
  }

  public Knoten suche(char bez) {
    Knoten knot = kopf;
    while (knot != null) {
      if (knot.bez == bez) {
        return knot;
      }
      knot = knot.nf;
    }
    return null;
  }

  public int anzahlKanten(Knoten k) {
    return anzahlHinKanten(k) + anzahlAusKanten(k);
  }

  public int anzahlHinKanten(Knoten k) {
    int counter = 0;
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        if (kant.kante == k) {
          counter++;
        }
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return counter;
  }

  public int anzahlAusKanten(Knoten k) {
    int counter = 0;
    Kante kant = k.kopf;
    while (kant != null) {
      counter++;
      kant = kant.nf;
    }
    return counter;
  }

  public int maxKantenZahl() {
    int max = 0;
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        if (kant.zahl >= max) {
          max = kant.zahl;
        }
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return max;
  }

  public int anzKnotenMaxKantenZahl() {
    int max = maxKantenZahl();
    int counter = 0;
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        if (kant.zahl == max) {
          counter++;
        }
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return counter;
  }

  public int anzSenke() {
    int counter = 0;
    Knoten knot = kopf;
    while (knot != null) {
      if (knot.kopf == null) {
        counter++;
      }
      knot = knot.nf;
    }
    return counter;
  }

  public boolean quelle(Knoten k) {
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        if (kant.kante == k) {
          return false;
        }
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return true;
  }

  public boolean exKante(Knoten a, Knoten b) {
    return a.kopf.kante == b;
  }

  public boolean doppeltVerbunden(Knoten a, Knoten b) {
    return a.kopf.kante == b && b.kopf.kante == a;
  }

  public boolean alone(Knoten k) {
    Knoten knot = kopf;
    while (knot != null) {
      Kante kant = knot.kopf;
      while (kant != null) {
        if (kant.kante == k) {
          return false;
        }
        kant = kant.nf;
      }
      knot = knot.nf;
    }
    return true;
  }

  public int diff(Knoten k) {
    return Math.abs(anzahlHinKanten(k) - anzahlAusKanten(k));
  }
}
