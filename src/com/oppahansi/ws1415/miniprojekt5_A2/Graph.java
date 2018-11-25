/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Daniel Kunze
 */
package com.oppahansi.ws1415.miniprojekt5_A2;

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
    // hier die L�sung eintragen...
    Knoten zeiger = this.kopf;
    int anzahlKanten = 0;

    while (zeiger != null) {
      anzahlKanten += this.anzahlAusKanten(zeiger);
      zeiger = zeiger.nf;
    }

    return anzahlKanten;
  }

  public int anzahlKnoten() {
    // hier die L�sung eintragen...
    Knoten zeiger = this.kopf;
    int anzahlKnoten = 0;

    while (zeiger != null) {
      anzahlKnoten += 1;
      zeiger = zeiger.nf;
    }

    return anzahlKnoten;
  }

  public boolean suche(Knoten p) {
    // hier die L�sung eintragen...
    Knoten zeiger = this.kopf;

    while (zeiger != null) {
      if (zeiger == p) {
        return true;
      }
      zeiger = zeiger.nf;
    }

    return false;
  }

  public Knoten suche(char bez) {
    // hier die L�sung eintragen...
    Knoten zeiger = this.kopf;

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
    return this.anzahlAusKanten(k) + this.anzahlHinKanten(k);
  }

  public int anzahlHinKanten(Knoten k) {
    // hier die L�sung eintragen...
    Knoten zeigerKnoten = kopf;
    int anzahlHinKanten = 0;

    while (zeigerKnoten != null) {
      Kante zeigerKanten = zeigerKnoten.kopf;
      while (zeigerKanten != null) {
        if (zeigerKanten.kante == k) {
          anzahlHinKanten += 1;
        }
        zeigerKanten = zeigerKanten.nf;
      }
      zeigerKnoten = zeigerKnoten.nf;
    }

    return anzahlHinKanten;
  }

  public int anzahlAusKanten(Knoten k) {
    // hier die L�sung eintragen...
    Kante zeiger = k.kopf;
    int anzahlAusKanten = 0;

    while (zeiger != null) {
      anzahlAusKanten += 1;
      zeiger = zeiger.nf;
    }

    return anzahlAusKanten;
  }

  public int maxKantenZahl() {
    // hier die L�sung eintragen...
    int maxKantenZahl = kopf.kopf.zahl;
    Knoten zeigerKnoten = kopf;

    while (zeigerKnoten != null) {
      Kante zeigerKanten = zeigerKnoten.kopf;
      while (zeigerKanten != null) {
        if (zeigerKanten.zahl >= maxKantenZahl) {
          maxKantenZahl = zeigerKanten.zahl;
        }
        zeigerKanten = zeigerKanten.nf;
      }
      zeigerKnoten = zeigerKnoten.nf;
    }

    return maxKantenZahl;
  }

  public int anzKnotenMaxKantenZahl() {
    // hier die L�sung eintragen...
    int maxKantenZahl = this.maxKantenZahl();
    int maxKantenAnzahl = 0;
    Knoten zeigerKnoten = kopf;

    while (zeigerKnoten != null) {
      Kante zeigerKanten = zeigerKnoten.kopf;
      while (zeigerKanten != null) {
        if (zeigerKanten.zahl == maxKantenZahl) {
          maxKantenAnzahl += 1;
        }
        zeigerKanten = zeigerKanten.nf;
      }
      zeigerKnoten = zeigerKnoten.nf;
    }

    return maxKantenAnzahl;
  }

  public int anzSenke() {
    // hier die L�sung eintragen...
    Knoten zeiger = kopf;
    int anzahlSenke = 0;

    while (zeiger != null) {
      if (this.anzahlAusKanten(zeiger) == 0) {
        anzahlSenke += 1;
      }
      zeiger = zeiger.nf;
    }

    return anzahlSenke;
  }

  public boolean quelle(Knoten k) {
    // hier die L�sung eintragen...
    Knoten zeiger = kopf;

    while (zeiger != null) {
      if (this.anzahlAusKanten(zeiger) > 0 && this.anzahlHinKanten(zeiger) == 0) {
        return true;
      }
      zeiger = zeiger.nf;
    }

    return false;
  }

  public boolean exKante(Knoten a, Knoten b) {
    // hier die L�sung eintragen...
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
    // hier die L�sung eintragen...
    if (this.exKante(a, b) && this.exKante(b, a)) {
      return true;
    }

    return false;
  }

  public boolean alone(Knoten k) {
    // hier die L�sung eintragen...
    if (this.anzahlAusKanten(k) == 0 && this.anzahlHinKanten(k) == 0) {
      return true;
    }

    return false;
  }

  public int diff(Knoten k) {
    // hier die L�sung eintragen...
    return Math.abs(this.anzahlAusKanten(k) - this.anzahlHinKanten(k));
  }
}
