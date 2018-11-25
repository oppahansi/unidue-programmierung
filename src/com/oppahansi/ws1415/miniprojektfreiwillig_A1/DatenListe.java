/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Loesungen zu Aufgaben implementiert von Mark Kunze (c)
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class DatenListe extends Datenverwaltung {

  private ListenElement anfang, ende;

  public ListenElement getAnfang() {
    return anfang;
  }

  public ListenElement getEnde() {
    return ende;
  }

  public void einfuegen(Beschreibung eintrag) {
    anfang = fuegeEinRek(eintrag, anfang, null);
  }

  private ListenElement fuegeEinRek(
      Beschreibung eintrag, ListenElement jetzigesElement, ListenElement vorgaenger) {
    if (jetzigesElement == null) {
      ende = new ListenElement(vorgaenger, null, eintrag);
      return ende;
    } else if (jetzigesElement.getEintrag().getProduktId() > eintrag.getProduktId()) {
      ListenElement tmp = new ListenElement(vorgaenger, jetzigesElement, eintrag);
      jetzigesElement.setVorgaenger(tmp);
      return tmp;
    } else {
      jetzigesElement.setNachfolger(
          fuegeEinRek(eintrag, jetzigesElement.getNachfolger(), jetzigesElement));
      return jetzigesElement;
    }
  }

  public void loeschen(int id) { //ITERATIV!
    ListenElement pointer = anfang; //Zeiger zum durchgehen der liste
    while (pointer != null) { //geht bis zum ende durch
      if (pointer.getEintrag().getProduktId() == id) { //Falls eintrag mit id gefunden
        if (pointer.getVorgaenger() != null) //Knoten ist NICHT anfang
        {
          pointer
              .getVorgaenger()
              .setNachfolger(pointer.getNachfolger()); //Zeiger des Vorgängers neu richten
        } else {
          anfang = pointer.getNachfolger(); //Knoten war anfang; Anfang neu setzen
        }
        if (pointer.getNachfolger() != null) //selbiges mit ENDE
        {
          pointer.getNachfolger().setVorgaenger(pointer.getVorgaenger());
        } else {
          ende = pointer.getVorgaenger();
        }
      } //of if ID=id
      pointer = pointer.getNachfolger(); //zeiger weitersetzen
    } //of while
  } //ofloeschen

  public void allesLoeschen() {
    anfang = ende = null;
  }

  public int anzahlEintraege() { //ITERATIV
    int i = 0; //zähler
    ListenElement pointer = anfang; //zeiger
    while (pointer != null) { //läuft liste durch
      i++; //zähler erhöhen
      pointer = pointer.getNachfolger(); //zeiger weitersetzen
    } //of while
    return i; //Zähler zurückgeben
  }

  public DatenListe getAll(int id) {
    DatenListe tmp = new DatenListe();
    ListenElement laeufer = anfang;
    while (laeufer != null && laeufer.getEintrag().getProduktId() <= id) {
      if (laeufer.getEintrag().getProduktId() == id) {
        tmp.einfuegen(laeufer.getEintrag());
      }
      laeufer = laeufer.getNachfolger();
    }
    return tmp;
  }
}
