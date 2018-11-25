/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Medikament {

  private String mediName;
  private String wirkstoff;
  private String verabreichungsform;
  private float preis;

  public Medikament(String mediName, String wirkstoff, String verabreichungsform, float preis) {
    this.mediName = mediName;
    this.wirkstoff = wirkstoff;
    this.verabreichungsform = verabreichungsform;

    this.preis = preis;
  }

  public float getPreis() {
    return this.preis;
  }

  public String getVerabreichungsform() {
    return verabreichungsform;
  }

  public void mediInfoAusgabe() {
    System.out.println(
        "                                                      Medikamentname:       " + mediName);
    System.out.println(
        "                                                      Hauptwirkstoff:       " + wirkstoff);
    System.out.println(
        "                                                      Darreichungsform:     "
            + getVerabreichungsform());
    System.out.println("");
  }
}
