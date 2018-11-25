/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class BBaumElement {

  private BBaumElement kleiner, groesserGleich;
  private Beschreibung eintrag;

  public BBaumElement(BBaumElement kleiner, BBaumElement groesserGleich, Beschreibung eintrag) {
    super();
    this.kleiner = kleiner;
    this.groesserGleich = groesserGleich;
    this.eintrag = eintrag;
  }

  public BBaumElement(Beschreibung eintrag) {
    super();
    this.eintrag = eintrag;
  }

  public BBaumElement getKleiner() {
    return kleiner;
  }

  public void setKleiner(BBaumElement kleiner) {
    this.kleiner = kleiner;
  }

  public BBaumElement getGroesserGleich() {
    return groesserGleich;
  }

  public void setGroesserGleich(BBaumElement groesserGleich) {
    this.groesserGleich = groesserGleich;
  }

  public Beschreibung getEintrag() {
    return eintrag;
  }
}
