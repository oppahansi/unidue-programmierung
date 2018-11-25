/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt09;

class Knoten {

  Knoten links, rechts;
  private int value;

  public Knoten(int value) {
    this.setValue(value);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}

class Suchbaeume {

  private Knoten wurzel;

  public Suchbaeume(int value) {
    wurzel = new Knoten(value);
  }

  public Suchbaeume() {
    wurzel = null;
  }

  public static void main(String... strings) {
    Suchbaeume s = new Suchbaeume();

    int[] array = {10, 15, 14, 8, 7, 9};

    /*Aufgabe 2a:
     * Diese Methode soll aus den Elementen eines Arrays einen Suchbaum erstellen
     * */
    s.sortiereEin(array);

    /*Debug ausgbae*/
    s.printSearchTree(s.getRoot(), 0);
    /*
     *         10               10
     *     8       15      <=>   |-15
     *   7   9   14                 |-14
     *                           |-8
     *                              |-9
     *                              |-7
     * */

    System.out.println("\n EinNachfolger:");
    s.einNachfolger();
    System.out.println("\n NofE:" + s.sum(s.getRoot()));

    System.out.println("\n NumberOfNodes:" + s.suche(22)); //
  }

  /*Aufgabe 2: Schreiben Sie eine Methode,
   * welche die Summe aller Elemente eines
   * Suchbaumes zur�ckgibt.
   */

  public Knoten getRoot() {
    return wurzel;
  }

  public void setRoot(Knoten k) {
    wurzel = k;
  }

  //Aufgabe 2a
  public void sortiereEin(int[] value) {
    //loesung
    for (int i = 0; i < value.length; i++) {
      insertNode(value[i]);
    }
  }

  public void insertNode(int value) {
    Knoten temp1 = this.getRoot();

    if (temp1 == null) {
      this.setRoot(new Knoten(value));
    } else {
      Knoten lWurzelKnoten, teilbaum = temp1;

      do {
        lWurzelKnoten = teilbaum;

        if (lWurzelKnoten.getValue() > value) {
          teilbaum = teilbaum.links;
        } else if (lWurzelKnoten.getValue() < value) {
          teilbaum = teilbaum.rechts;
        } else if (lWurzelKnoten.getValue() == value) {
          teilbaum = null;
        }
      } while (teilbaum != null);

      if (lWurzelKnoten.getValue() > value) {
        lWurzelKnoten.links = new Knoten(value);
      } else if (lWurzelKnoten.getValue() < value) {
        lWurzelKnoten.rechts = new Knoten(value);
      }
    }
  }

  // Aufgabe 2b
  private void einNachfolger() {
    //loesung implementieren
    Knoten temp = this.wurzel;

    if (temp != null) {
      einNachfolger(temp);
    }
  }

  private void einNachfolger(Knoten k) {
    //loesung implementieren
    if (k.links != null && k.rechts != null) {
      einNachfolger(k.links);
      einNachfolger(k.rechts);
    } else if (k.links != null && k.rechts == null) {
      System.out.println("Knoten mit value(" + k.getValue() + ") hat genau einen Nachfolger.");
      einNachfolger(k.links);
    } else if (k.links == null && k.rechts != null) {
      System.out.println("Knoten mit value(" + k.getValue() + ") hat genau einen Nachfolger.");
      einNachfolger(k.rechts);
    }
  }

  /*Aufgabe 2c*/
  public int sum(Knoten wurzel) {
    //loesung implementieren
    int summe = 0;

    if (wurzel != null) {
      summe += 1 + sum(wurzel.links) + sum(wurzel.rechts);
    }

    return summe;
  }

  /*Aufgabe d*/
  public int suche(int zahl) {
    //loesung
    int cntBesuchteKnoten = 0;
    boolean find = false;

    Knoten temp1 = this.getRoot();

    do {
      cntBesuchteKnoten++;

      if (temp1.getValue() > zahl) {
        temp1 = temp1.links;
      } else if (temp1.getValue() < zahl) {
        temp1 = temp1.rechts;
      } else if (temp1.getValue() == zahl) {
        find = true;
      }
    } while (temp1 != null && !find);

    if (!find) {
      cntBesuchteKnoten = -1;
    }

    return cntBesuchteKnoten;
  }

  void printSearchTree(Knoten k, int indent) {

    for (int i = 0; i < indent - 1; ++i) {
      System.out.print(" ");
    }
    if (indent > 0) {
      System.out.print("|");
      System.out.println("-" + k.getValue());
    } else {
      System.out.println(k.getValue());
    }

    if (k.rechts != null) {
      printSearchTree(k.rechts, indent + 2);
    }
    if (k.links != null) {
      printSearchTree(k.links, indent + 2);
    }
  }
}
