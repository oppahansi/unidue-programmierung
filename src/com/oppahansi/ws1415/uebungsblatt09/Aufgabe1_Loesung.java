/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt09;

class Liste {

  private Element kopf;

  public Liste() {
    this.kopf = new Element(-1);
    this.kopf.nachfolger = null;
  }

  public Element getKopf() {
    return kopf;
  }

  public Element setKopf(Element kopf) {
    return this.kopf = kopf;
  }

  public void addElement(Element neu) {
    //Loesung
    Element temp = this.getKopf();
    boolean find = false;

    while (temp.nachfolger != null && !find) {
      if (temp.nachfolger.getValue() > neu.getValue()) {
        find = true;
      } else {
        temp = temp.nachfolger;
      }
    }

    neu.nachfolger = temp.nachfolger;
    temp.nachfolger = neu;
  }

  public void output(int nr) {
    System.out.println("\nListe" + nr + ":");
    Element temp = kopf;
    while (temp != null) {
      temp.output();
      temp = temp.nachfolger;
    }
    if (temp == null) {
      System.out.print("null\n");
    }
  }
}

class Element {

  Element nachfolger;
  private int value = 0;

  public Element(int value) {
    setValue(value);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int index) {
    value = index;
  }

  public void output() {
    if (getValue() != -1) {
      System.out.print("[" + getValue() + "]" + "-->");
    } else {
      System.out.print("[Kopf]" + "-->");
    }
  }
}

class Listenmanipulation {

  public static void main(String[] args) {
    Listenmanipulation lm = new Listenmanipulation();
    Liste l1 = new Liste();
    Liste l2 = new Liste();

    l2.addElement(new Element(3));
    l2.addElement(new Element(8));

    l2.output(1);

    l1.addElement(new Element(1));
    l1.addElement(new Element(4));
    l1.addElement(new Element(10));
    l1.addElement(new Element(9));
    l1.output(2);

    //Aufgabe 1a
    lm.mergeList(l1, l2);

    l1.output(3);

    //Aufgabe 1b
    System.out.println(lm.averageValue(l1));

    //Aufgabe 1c
    lm.reverseList(l1);
    l1.output(4);
  }

  /*1a*/
  public void mergeList(Liste list1, Liste list2) {
    // Loesung
    Element temp = list2.getKopf();

    int value = -1;

    while (temp.nachfolger != null) {
      value = temp.nachfolger.getValue();

      list1.addElement(new Element(value));

      temp = temp.nachfolger;
    }
  }

  /*Aufgabe 1.2*/
  public double averageValue(Liste list1) {
    //Loesung
    double summe = 0;
    int cnt = 0;

    Element temp = list1.getKopf();

    while (temp.nachfolger != null) {
      cnt++;
      summe += temp.nachfolger.getValue();

      temp = temp.nachfolger;
    }

    return summe / cnt;
  }

  /*Aufgabe 1.3*/
  public void reverseList(Liste list1) {
    //Loesung
    Element temp1 = list1.getKopf();
    Element neuKopf = new Element(-1);

    Element temp2 = null;

    while (temp1.nachfolger != null) {
      temp2 = new Element(temp1.nachfolger.getValue());

      temp2.nachfolger = neuKopf.nachfolger;
      neuKopf.nachfolger = temp2;

      temp1 = temp1.nachfolger;
    }

    //neuKopf
    list1.setKopf(neuKopf);
  }
}
