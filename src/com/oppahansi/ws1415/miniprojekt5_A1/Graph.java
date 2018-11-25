/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Mark Kunze
 */
package com.oppahansi.ws1415.miniprojekt5_A1;

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
    Knoten zeiger = kopf;
    int anz = 0;
    while (zeiger != null) {
      anz += this.anzahlAusKanten(zeiger);
      zeiger = zeiger.nf;
    }
    return anz;
  }

  public int anzahlKnoten() {
    Knoten zeiger = kopf;
    int anz = 0;
    while (zeiger != null) {
      anz += 1;
      zeiger = zeiger.nf;
    }
    return anz;
  }

  public boolean suche(Knoten p) {
    Knoten zeiger = kopf;
    while (zeiger != null) {
      if (zeiger == p) {
        return true;
      }
      zeiger = zeiger.nf;
    }
    return false;
  }

  public Knoten suche(char bez) {
    Knoten zeiger = kopf;
    while (zeiger != null) {
      if (zeiger.bez == bez) {
        return zeiger;
      }
      zeiger = zeiger.nf;
    }
    return null;
  }

  public int anzahlKanten(Knoten k) {
    // hier die L�sung eintragen...

    return this.anzahlHinKanten(k) + this.anzahlAusKanten(k);
  }

  public int anzahlHinKanten(Knoten k) {
    Knoten zeigerKno = kopf;
    int anz = 0;
    while (zeigerKno != null) {
      Kante zeigerKan = zeigerKno.kopf;
      while (zeigerKan != null) {
        if (zeigerKan.kante == k) {
          anz += 1;
        }
        zeigerKan = zeigerKan.nf;
      }
      zeigerKno = zeigerKno.nf;
    }
    return anz;
  }

  public int anzahlAusKanten(Knoten k) {
    Kante zeiger = k.kopf;
    int anz = 0;
    while (zeiger != null) {
      anz += 1;
      zeiger = zeiger.nf;
    }
    return anz;
  }

  public int maxKantenZahl() {
    Knoten zeigerKno = kopf;
    int max = kopf.kopf.zahl;
    while (zeigerKno != null) {
      Kante zeigerKan = zeigerKno.kopf;
      while (zeigerKan != null) {
        if (max < zeigerKan.zahl) {
          max = zeigerKan.zahl;
        }
        zeigerKan = zeigerKan.nf;
      }
      zeigerKno = zeigerKno.nf;
    }
    return max;
  }

  public int anzKnotenMaxKantenZahl() {
    Knoten zeigerKno = kopf;
    int anz = 0;
    int max = this.maxKantenZahl();
    while (zeigerKno != null) {
      Kante zeigerKan = zeigerKno.kopf;
      while (zeigerKan != null) {
        if (zeigerKan.zahl == max) {
          anz += 1;
          break;
        }
        zeigerKan = zeigerKan.nf;
      }
      zeigerKno = zeigerKno.nf;
    }
    return anz;
  }

  public int anzSenke() {
    Knoten zeigerKno = kopf;
    int anz = 0;
    while (zeigerKno != null) {
      if (this.anzahlAusKanten(zeigerKno) == 0) {
        anz += 1;
      }
      zeigerKno = zeigerKno.nf;
    }
    return anz;
  }

  public boolean quelle(Knoten k) {
    return this.anzahlHinKanten(k) == 0 ? true : false;
  }

  public boolean exKante(Knoten a, Knoten b) {
    Kante zeiger = a.kopf;
    while (zeiger != null) {
      if (zeiger.kante == b) {
        return true;
      }
      zeiger = zeiger.nf;
    }
    return false;
  }

  public boolean doppeltVerbunden(Knoten a, Knoten b) {
    return (this.exKante(a, b) && this.exKante(b, a)) ? true : false;
  }

  public boolean alone(Knoten k) {
    return (this.anzahlHinKanten(k) == 0 && this.anzahlAusKanten(k) == 0) ? true : false;
  }

  public int diff(Knoten k) {
    return Math.abs(this.anzahlHinKanten(k) - this.anzahlAusKanten(k));
  }
}
