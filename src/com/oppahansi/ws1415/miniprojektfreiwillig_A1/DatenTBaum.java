/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Loesungen zu Aufgaben implementiert von Mark Kunze (c)
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class DatenTBaum extends Datenverwaltung {

  private TBaumElement start = null;

  public void einfuegen(Beschreibung eintrag) {
    start = this.einfuegenRek(start, new TBaumElement(eintrag));
  }

  private TBaumElement einfuegenRek(TBaumElement knoten, TBaumElement eintrag) { //rekursive Methode
    if (knoten == null || eintrag == null) { //sonderfälle
      if (knoten == null) //übergebener Knoten war null ("Vaterknoten"= Blatt)
      {
        return eintrag; //übergebe neuen Blattknoten
      } else //eintrag war null...
      {
        return knoten; //einfach Baum zurückgeben
      }
    } else {
      if (knoten.getEintrag().getProduktId()
          > eintrag.getEintrag().getProduktId()) { //Knoten-ID>eintrad-ID
        knoten.setKleiner(einfuegenRek(knoten.getKleiner(), eintrag)); //im linken Teilbaum einfügen
      } else { //Knoten-ID<=eintrad-ID
        if (knoten.getEintrag().getProduktId()
            == eintrag.getEintrag().getProduktId()) { //Knoten-ID==eintrad-ID
          knoten.setGleich(
              einfuegenRek(knoten.getGleich(), eintrag)); //in "Gleich"-Teilbaum einfügen
        } else {
          knoten.setGroesser(
              einfuegenRek(
                  knoten.getGroesser(), eintrag)); //Knoten-ID<eintrad-ID somit im rechtne einfügen
        }
      } //of if > else
      return knoten;
    } //of if knoten==null||...
  } //of einfuegenRek

  public DatenListe getAll(int id) {
    DatenListe tmp = new DatenListe();
    TBaumElement laeufer = start;
    while (laeufer != null && laeufer.getEintrag().getProduktId() != id) {
      if (laeufer.getEintrag().getProduktId() > id) {
        laeufer = laeufer.getKleiner();
      } else {
        laeufer = laeufer.getGroesser();
      }
    }
    while (laeufer != null) {
      tmp.einfuegen(laeufer.getEintrag());
      laeufer = laeufer.getGleich();
    }
    return tmp;
  }

  public void loeschen(int i) {
    start = this.delData(i, start);
  }

  private TBaumElement delData(int id, TBaumElement knoten) { //rekursive Methode
    //Alles analog zu Binärbaum. es muss nur nicht mehr im rechten weitergesucht werden.
    if (knoten != null) {
      if (knoten.getEintrag().getProduktId() > id) {
        knoten.setKleiner(this.delData(id, knoten.getKleiner()));
      } else if (knoten.getEintrag().getProduktId() == id) {
        if (knoten.getGroesser() == null) {
          return knoten.getKleiner();
        } else if (knoten.getKleiner() == null) {
          return knoten.getGroesser();
        } else {
          this.getLeftitem(knoten.getGroesser()).setKleiner(knoten.getKleiner());
          //hier wurde im Binärbaum weitergesucht
        }
        return knoten.getGroesser();
      } else {
        knoten.setGroesser(this.delData(id, knoten.getGroesser()));
      }
      return knoten;
    } else {
      return null;
    }
  }

  private TBaumElement getLeftitem(TBaumElement knoten) { //siehe Binärbaum
    if (knoten != null) {
      if (knoten.getKleiner() == null) {
        return knoten;
      } else {
        return this.getLeftitem(knoten.getKleiner());
      }
    }
    return null;
  }

  public int anzahlEintraege() {
    return this.anzEintr(start);
  }

  private int anzEintr(TBaumElement knoten) { //rekursive Methode
    if (knoten == null) {
      return 0; //Falls knoten ohne Eintrag gebe 0 zurück
    }
    int kleiner = this.anzEintr(knoten.getKleiner()); //Anzahl einträge des linken Teilbaums
    int gleich = this.anzEintr(knoten.getGleich()); //Anzahl einträge des "Gleich-"Teilbaums
    int groesser = this.anzEintr(knoten.getGroesser()); //Anzahl einträge des rechten Teilbaums
    return kleiner + gleich + groesser
        + 1; //Alles addiert +1 (+1 weil knoten ja exisiert und dieser mitgezählt wird)
  } //of anzEintr

  public void allesLoeschen() {
    start = null; //ultra schwer; Java räumt alles auf =)
    // TODO
  }

  public int tiefelr() {
    return tiefelr(start);
  }

  private int tiefelr(TBaumElement knoten) {
    if (knoten == null) {
      return 0;
    }
    int k = tiefelr(knoten.getKleiner());
    int g = tiefelr(knoten.getGroesser());
    if (k > g) {
      return k + 1;
    } else {
      return g + 1;
    }
  }
}
