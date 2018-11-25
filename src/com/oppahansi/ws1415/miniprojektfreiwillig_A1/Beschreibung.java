/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojektfreiwillig_A1;

public class Beschreibung {

  private String autor;
  private int produktId;
  private String text;
  private int anzeigePrioritaet;

  public Beschreibung(String autor, int produktId, String text, int anzeigePrioritaet) {
    super();
    this.autor = autor;
    this.produktId = produktId;
    this.text = text;
    this.anzeigePrioritaet = anzeigePrioritaet;
  }

  public String getAutor() {
    return autor;
  }

  public int getProduktId() {
    return produktId;
  }

  public String getText() {
    return text;
  }

  public int getAnzeigePrioritaet() {
    return anzeigePrioritaet;
  }
}
