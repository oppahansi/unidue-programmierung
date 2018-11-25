/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_8;

public class Main {

  public static void main(String[] args) {
    /*
     * Produkte produktListe = new Produkte(); new Element("Lampe", 5.00f, produktListe); new
     * Element("Bleistift", 0.29f, produktListe); new Element("Battarie", 2.00f, produktListe); new
     * Element("Compiuter", 400.00f, produktListe); new Element("Funkmaus", 28.00f, produktListe);
     * new Element("Stecker", 3.00f, produktListe);
     *
     * <p>produktListe.zubehoer("Lampe", "Battarie"); produktListe.zubehoer("Compiuter",
     * "Funkmaus"); produktListe.zubehoer("Funkmaus", "Battarie"); produktListe.zubehoer("Lampe",
     * "Stecker");
     *
     * <p>produktListe.geamtpreis(); Element kopf = produktListe.kopf; while(kopf!= null){
     * System.out.println(kopf + " " + kopf.Bez + " " + kopf.ePreis + " " + kopf.gPreis + " " +
     * kopf.Nf + " " + kopf.Zubehoer); kopf = kopf.Nf; }
     * System.out.println(produktListe.kopf.Zubehoer.Bez);
     * System.out.println(produktListe.kopf.Zubehoer.Nf.Bez);
     */
    Produkte p = new Produkte();
    p.angebot();
    Element kopf = p.kopf;
    while (kopf != null) {
      System.out.println(
          kopf
              + "  "
              + kopf.Bez
              + "  "
              + kopf.ePreis
              + "  "
              + kopf.gPreis
              + "  "
              + kopf.Nf
              + "  "
              + kopf.Zubehoer);
      kopf = kopf.Nf;
    }
    System.out.println(p.zweitteuersteProdukt());
  }
}
