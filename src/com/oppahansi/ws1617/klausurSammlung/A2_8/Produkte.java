/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_8;

public class Produkte {
  Element kopf, fuss;

  //AUFGABE 2.8 c
  // Funktioniert nur wenn ein Produkt nur ein Zubehoer hat!!!;
  void zubehoer(String a, String b) {
    for (Element e = kopf; e != null; e = e.Nf) {
      if (e.Bez.endsWith(a)) {
        for (Element e1 = kopf; e1 != null; e1 = e1.Nf) {
          if (e1.Bez.equals(b)) {
            e.Zubehoer = e1;
          }
        }
      }
    }
  }

  //AUFGABE 2.8 d
  void geamtpreis() {
    for (Element e = kopf; e != null; e = e.Nf) {
      e.gPreis = gesamtPreis(e);
    }
  }

  float gesamtPreis(Element e) {
    if (e.Zubehoer == null) {
      return e.ePreis;
    } else return e.ePreis + zubehoerPreis(e) * 9 / 10;
  }

  float zubehoerPreis(Element e) {
    if (e.Zubehoer == null) {
      return 0;
    } else {
      return e.Zubehoer.ePreis + zubehoerPreis(e.Zubehoer);
    }
  }

  //AUFGABE 2.8 e
  void angebot() {
    Produkte produktListe = new Produkte();
    new Element("Lampe", 5.00f, produktListe);
    new Element("Bleistift", 0.29f, produktListe);
    new Element("Battarie", 2.00f, produktListe);
    new Element("Compiuter", 400.00f, produktListe);
    new Element("Funkmaus", 28.00f, produktListe);

    produktListe.zubehoer("Lampe", "Battarie");
    produktListe.zubehoer("Compiuter", "Funkmaus");
    produktListe.zubehoer("Funkmaus", "Battarie");
    produktListe.zubehoer("Lampe", "Stecker");

    produktListe.geamtpreis();

    kopf = produktListe.kopf;
    fuss = produktListe.fuss;
  }

  //AUFGABE 2.8 f
  float zweitteuersteProdukt() {
    float teuerste = 0;
    float zweitteuerste = 0;
    for (Element e = kopf; e != null; e = e.Nf) {
      if (e.ePreis > teuerste) {
        teuerste = e.ePreis;
      }
      if (e.ePreis > zweitteuerste && e.ePreis < teuerste) {
        zweitteuerste = e.ePreis;
      }
    }
    int zaeler = 0;
    for (Element e1 = kopf; e1 != null; e1 = e1.Nf) {
      if (e1.ePreis == teuerste) {
        zaeler++;
      }
    }
    if (zaeler > 1) {
      return teuerste;
    }
    return zweitteuerste;
  }
}
