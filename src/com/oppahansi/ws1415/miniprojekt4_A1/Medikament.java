/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt4_A1;

public class Medikament {

  String medName, wirkstoff;
  int darreichungsform;
  float preis;

  /*
   * Konstruktor
   */
  public Medikament(String MedName, String Wirkstoff, int Darreichungsform, float preis) {
    this.medName = MedName;
    this.wirkstoff = Wirkstoff;
    this.darreichungsform = Darreichungsform;

    this.preis = preis;
  }

  /*
   * liefert die Kosten des Medikaments zur�ck.
   * */
  public float getPreis() {
    return this.preis;
  }

  /*
   * liefert die Darreichungsform des Medikaments zur�ck
   */
  public String getDarreichungsform() {
    switch (darreichungsform) {
      case 1:
        return "Tabletten";
      case 2:
        return "Infusion";
      case 3:
        return "Spritze";
      case 4:
        return "Creme";
      case 5:
        return "Augentropfen";
      case 6:
        return "Nasenspray";
      case 7:
        return "Saft";
      default:
        return "K.A.";
    }
  }

  /*
   * gibt Infos des Medikamentes aus
   */
  public void ausgabe() {
    System.out.println(
        "                                                      Medikamentname:       " + medName);
    System.out.println(
        "                                                      Hauptwirkstoff:       " + wirkstoff);
    System.out.println(
        "                                                      Darreichungsform:     "
            + getDarreichungsform());
    System.out.println("");
  }
}
