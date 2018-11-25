/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class TBaumElement {

  private TBaumElement kleiner, groesser, gleich;
  private Beschreibung eintrag;

  public TBaumElement(
      TBaumElement kleiner, TBaumElement groesser, TBaumElement gleich, Beschreibung eintrag) {
    super();
    this.kleiner = kleiner;
    this.groesser = groesser;
    this.gleich = gleich;
    this.eintrag = eintrag;
  }

  public TBaumElement(Beschreibung eintrag) {
    super();
    this.eintrag = eintrag;
  }

  public TBaumElement getKleiner() {
    return kleiner;
  }

  public void setKleiner(TBaumElement kleiner) {
    this.kleiner = kleiner;
  }

  public TBaumElement getGroesser() {
    return groesser;
  }

  public void setGroesser(TBaumElement groesser) {
    this.groesser = groesser;
  }

  public TBaumElement getGleich() {
    return gleich;
  }

  public void setGleich(TBaumElement gleich) {
    this.gleich = gleich;
  }

  public Beschreibung getEintrag() {
    return eintrag;
  }
}
