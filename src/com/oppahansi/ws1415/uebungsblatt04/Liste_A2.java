/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by oppahansi.
 *
 * <p>Alternative 2
 */
package com.oppahansi.ws1415.uebungsblatt04;

class Liste_A2 {

  // Klasse Element kann aus Alternative 1 verwendet werden, da
  // an ihr nichts verändert wird.
  Element Kopf, Fuss;

  public void einfuegen(int zahl) {
    Element neu = new Element(zahl);
    if (Kopf == null) {
      Kopf = Fuss = neu;
    } else {
      Fuss.Nf = neu;
      Fuss = Fuss.Nf;
    }
  }

  public void hinzufuegen(Element neu, int position) {
    int counter = 1;
    Element element = this.Kopf;
    Element newElement = neu;
    if (position == 1) {
      this.Kopf = neu;
      neu.Nf = element;
    } else {
      while (counter < position - 1) {
        element = element.Nf;
        counter++;
      }
      newElement.Nf = element.Nf;
      element.Nf = newElement;
    }
  }

  public Element entferne(int position) {
    int counter = 1;
    Element element = this.Kopf;
    Element deleted;
    if (position == 1) {
      deleted = this.Kopf;
      this.Kopf = Kopf.Nf;
      return deleted;

    } else {
      while (counter < position - 1) {
        element = element.Nf;
        counter++;
      }
      if (element == null) {
        return null;
      } else {
        deleted = element;
        element.Nf = element.Nf.Nf;
        return deleted;
      }
    }
  }
}
