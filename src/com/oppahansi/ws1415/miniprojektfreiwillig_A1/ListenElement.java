/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class ListenElement {

  private ListenElement vorgaenger, nachfolger;
  private Beschreibung eintrag;

  public ListenElement(ListenElement vorgaenger, ListenElement nachfolger, Beschreibung eintrag) {
    super();
    this.vorgaenger = vorgaenger;
    this.nachfolger = nachfolger;
    this.eintrag = eintrag;
  }

  public ListenElement getVorgaenger() {
    return vorgaenger;
  }

  public void setVorgaenger(ListenElement vorgaenger) {
    this.vorgaenger = vorgaenger;
  }

  public ListenElement getNachfolger() {
    return nachfolger;
  }

  public void setNachfolger(ListenElement nachfolger) {
    this.nachfolger = nachfolger;
  }

  public Beschreibung getEintrag() {
    return eintrag;
  }

  public void setEintrag(Beschreibung eintrag) {
    this.eintrag = eintrag;
  }
}
