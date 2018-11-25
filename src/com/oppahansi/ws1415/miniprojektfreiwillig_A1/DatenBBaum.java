/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Loesungen zu Aufgaben implementiert von Mark Kunze (c)
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class DatenBBaum extends Datenverwaltung {

  private BBaumElement beginn = null;

  public void einfuegen(Beschreibung eintrag) {
    beginn = einfuegen(beginn, new BBaumElement(eintrag));
  }

  private BBaumElement einfuegen(BBaumElement knoten, BBaumElement eintrag) {
    if (knoten == null || eintrag == null) {
      if (knoten == null) {
        return eintrag;
      } else {
        return knoten;
      }
    } else {
      if (knoten.getEintrag().getProduktId() > eintrag.getEintrag().getProduktId()) {
        knoten.setKleiner(einfuegen(knoten.getKleiner(), eintrag));
      } else {
        knoten.setGroesserGleich(einfuegen(knoten.getGroesserGleich(), eintrag));
      }
      return knoten;
    }
  }

  public int anzahlEintraege() {
    return anzahlEintraege(beginn);
  }

  private int anzahlEintraege(BBaumElement eintrag) {
    if (eintrag == null) {
      return 0;
    } else {
      return 1
          + anzahlEintraege(eintrag.getKleiner())
          + anzahlEintraege(eintrag.getGroesserGleich());
    }
  }

  public DatenListe getAll(int id) {
    DatenListe list = new DatenListe(); //initialisiere die Liste
    this.getData(
        id, list, beginn); //hole die Daten mit ID, Referenz zur liste mit übergeben + (Teil-)Baum
    return list; //gebe Liste aus
  } //of getAll

  private void getData(int id, DatenListe list, BBaumElement knoten) { //rekursive Methode
    if (knoten != null) {
      if (knoten.getEintrag().getProduktId() == id) //Eintrag mit ID gefunden...
      {
        list.einfuegen(knoten.getEintrag()); //...dann in liste einfügen
      }
      if (knoten.getEintrag().getProduktId() > id) //ID vom knoten ist größer somit...
      {
        this.getData(id, list, knoten.getKleiner()); //... im linken (Teil-)Baum weitersuchen.
      } else //Knoten-ID <= ID
      {
        this.getData(id, list, knoten.getGroesserGleich()); //...im rechten (Teil-)Baum weitersuchen
      }
    } //of if != null
  } //of getData

  public Beschreibung[] baum2array() {
    DatenListe list = new DatenListe(); //Liste einfacher zu erweitern als Array
    getallData(list, beginn); //speichere Alle Daten nach inorder codierung
    Beschreibung[] result = new Beschreibung[list.anzahlEintraege()]; //Ergebnisarray
    ListenElement pointer = list.getAnfang(); //Zeiger um Liste durchzugehen.
    for (int i = 0; i < result.length; i++) { //geht Array durch (Array.length==liste."länge")
      result[i] = pointer.getEintrag(); //übergibt das Ergebnis
      pointer = pointer.getNachfolger(); //setzt den zeiger weiter
    } //of for
    return result; //Ergebnisweitergabe
  } //of Baum2array

  private void getallData(DatenListe list, BBaumElement knoten) { //rekursive Methode
    if (knoten != null) {
      this.getallData(
          list, knoten.getKleiner()); //Einträge des linken (Teil-)Baums in liste einfügen
      list.einfuegen(knoten.getEintrag()); //wurzel des (Teil-)Baums einfügen
      this.getallData(
          list, knoten.getGroesserGleich()); //Einträge des rechten (Teil-)Baums in liste einfügen
    } //of if !=null
  } //of getallData

  public void array2baum(Beschreibung[] eingabeArray) {
    for (int i = 0; i < eingabeArray.length; i++) //
    {
      this.einfuegen(eingabeArray[i]); //fügt alle Einträge des Arrays in den Baum
    }
    this.baumBalancieren(); //balanciert den baum aus.
  }

  public void baumBalancieren() { //rekursive Methode
    if (beginn == null) {
      return;
    }
    Beschreibung[] array = this.baum2array(); //erstellt ein sortiertes Array aus dem jetzigen baum
    DatenBBaum tree = new DatenBBaum(); //neuer Baum zum verwalten
    for (int i = 0;
        i < array.length / 2;
        i++) { //fügt alles einträge in das Array vom mittlersten Element ausgehend
      tree.einfuegen(
          array[array.length / 2 + i]); //Elemente von Mitte array bis Ende (oder kurz vor Ende)
      tree.einfuegen(array[array.length / 2 - 1 - i]); //Element von 1 vor Mitte bis Anfang
    } //of for
    if (array.length % 2
        == 1) //Falls Array.length ungerade muss letztes Element noch eingefügt werden
    {
      tree.einfuegen(array[array.length - 1]); //fügt letztes Element ein
    }
    beginn = tree.beginn; //übergibt den Baum (Gleiche viele E links wie Rechts (+-1))
    DatenBBaum treeleft = new DatenBBaum(); //linkter Teilbaum in sich NICHT ausbalanciert
    treeleft.beginn = beginn.getKleiner(); //speicher (Teil-)Baum als neuen ganzen Baum
    treeleft.baumBalancieren(); //balanciere diesen aus
    beginn.setKleiner(
        treeleft.beginn); //und setze diesen ausbalancierten Baum als neuen linkten Teilbaum
    DatenBBaum treeright = new DatenBBaum(); //s.o. nur mit rechts
    treeright.beginn = beginn.getGroesserGleich();
    treeright.baumBalancieren();
    beginn.setGroesserGleich(treeright.beginn);
  } //of baum Balancieren

  public int tiefe() {
    return tiefe(beginn);
  }

  private int tiefe(BBaumElement knoten) {
    if (knoten == null) {
      return 0;
    }
    int k = tiefe(knoten.getKleiner());
    int g = tiefe(knoten.getGroesserGleich());
    if (k > g) {
      return k + 1;
    } else {
      return g + 1;
    }
  }

  public void loeschen(int i) {
    beginn = this.delData(i, beginn);
  }

  private BBaumElement delData(int id, BBaumElement knoten) { //rekursive Methode
    if (knoten != null) { //Knoten vorhanden=
      if (knoten.getEintrag().getProduktId() > id) //falls knoten-ID > id ...
      {
        knoten.setKleiner(
            this.delData(
                id,
                knoten
                    .getKleiner())); //..im linken das zu löschende Element suchen (Teilbaum mit Ergebnis ersetzen)
      } else //KnotenID<=id
      if (knoten.getEintrag().getProduktId() == id) { //Knoten-ID==id
        if (knoten.getGroesserGleich() == null) //Fall 1: rechter Teilbaum null
        {
          return knoten.getKleiner();
        } else //einfach rückgabe des linken Teilbaums
        if (knoten.getKleiner() == null) { //Fall 2: linker Teilbaum null
          return this.delData(
              id, knoten.getGroesserGleich()); //einfach Rückgabe des rechten Teilbaums
        } else { //Fall 3: linker!=null rechter!=null
          this.getLeftitem(knoten.getGroesserGleich())
              .setKleiner(
                  knoten
                      .getKleiner()); //setze linken Teilbaum als linken Nachfolger des KLEINSTEN Elements des rechten Teilbaumes
          knoten.setGroesserGleich(
              this.delData(
                  id, knoten.getGroesserGleich())); //im Größergleich nach weiteren Elementen suchen
        } //of else
        return knoten.getGroesserGleich(); //RückGabe des rechten Teilbaums für Fall2+3
      } else //of if knoten-ID == id
      {
        knoten.setGroesserGleich(
            this.delData(id, knoten.getGroesserGleich())); //im größer Teilbaum suchen+löschen
      }
      return knoten; //Teilbaum wiedergeben
    } else //of if knoten!=null
    {
      return null;
    }
  } //of delData

  private BBaumElement getLeftitem(BBaumElement knoten) { //rekursive Methode
    if (knoten != null) { //abfangen von nullpointer-exception :)
      if (knoten.getKleiner() == null) //falls getKleiner==null
      {
        return knoten; //kleinstes Element gefunden und wiedergeben
      } else {
        return this.getLeftitem(knoten.getKleiner()); //...ansonsten weitersuchen!
      }
    }
    return null;
  } //of geLeftItem

  public void allesLoeschen() {
    beginn = null;
  }
}
