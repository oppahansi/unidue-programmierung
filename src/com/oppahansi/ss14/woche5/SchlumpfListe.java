package com.oppahansi.ss14.woche5;

/*
 * Sinn dieser Uebung ist es, den Umgang mit dem Konzept der Liste zu lernen.
 * In der Liste sollen mit Hilfe der vorgegebenen Klasse SchlumpfNode Schluempfe
 * (Klasse Schlumpf) verwaltet werden. Die Schluempfe in der Schlumpfliste
 * sollen zu jedem Zeitpunkt nach der Groesse sortiert sein. Der erste Schlumpf
 * in der Liste soll der kleinste sein, danach folgen Schluempfe in
 * aufsteigender Groesse.
 * Ausserdem sollen in der Liste nur Schluempfe mit einer schlumpfkonformen
 * Groesse sein, d.h. es duerfen sich nur Schluempfe in der Liste befinden deren
 * Groesse den durch SCHLUMPF_MAXIMAL_GROESSE gegebenen Wert nicht
 * ueberschreitet, bzw. nicht unter dem durch SCHLUMPF_MINIMAL_GROESSE gegebenen
 * Wert liegt.
 *
 * Sie benoetigen zusaetzlich die beiden weiteren Klassen Schlumpf und
 * SchlumpfNode. Die beiden Klassen bestehen nur aus Gettern und Settern und
 * sollen nicht weiter modifiziert werden.
 */

/*
 * Implementierung der Methoden von Oppa Hansi.
 */

public class SchlumpfListe {

  public static int SCHLUMPF_MAXIMAL_GROESSE = 20;
  public static int SCHLUMPF_MINIMAL_GROESSE = 8;

  public SchlumpfNode head;

  public SchlumpfListe() {
    head = null;
  }

  // Mit dieser Methode koennen Sie die Namen aller Schluempfe in einer
  // Schlumpfliste ausgeben lassen. Sie soll eine Hilfestellung sein um ihre
  // Tests in der "public static void main" zu erleichtern.
  // Den Inhalt einer Schlumpfliste "liste" koennen Sie mit dem Befehl
  //
  //                printSchlumpfListe(liste);
  //
  // auf der Konsole ausgeben lassen.
  public static void printSchlumpfListe(SchlumpfListe slist) {
    SchlumpfNode iterator = slist.getHead();
    while (iterator != null) {
      if (iterator.schlumpf != null) {
        System.out.print(iterator.getSchlumpf().getName() + ", ");
      } else {
        System.out.print("NULL, ");
      }
      iterator = iterator.getNext();
    }
    System.out.println();
  }

  /*
   * BEGINN des zu bearbeitenden Codes
   */

  /*
   * Hier kommt ihr Testcode hin
   */
  public static void main(String[] args) {

    // Anlegen von 2 Listen zu Testzwecken
    SchlumpfListe list = new SchlumpfListe();
    SchlumpfListe list2 = new SchlumpfListe();

    // Schlumpfe für list
    Schlumpf s1 = new Schlumpf("NummerEins", 8);
    Schlumpf s2 = new Schlumpf("NummerZwei", 12);
    Schlumpf s3 = new Schlumpf("NummerDrei", 10);
    Schlumpf s4 = new Schlumpf("NummerVier", 14);
    Schlumpf s5 = new Schlumpf("NummerFünf", 20);

    // Anlegen eines Schlumpfs, der nicht in eine Liste eingefügt wird
    Schlumpf s6 = new Schlumpf("NummerSechs", 12);

    // Schlumpfe für list2
    Schlumpf s7 = new Schlumpf("NummerSieben", 9);
    Schlumpf s8 = new Schlumpf("NummerAcht", 15);
    Schlumpf s9 = new Schlumpf("NummerNeuen", 18);
    Schlumpf s10 = new Schlumpf("NummerZehn", 17);
    Schlumpf s11 = new Schlumpf("NummerÖlf", 19);

    // Einreihen der Schlumpfe in list (1. Liste)
    list.schlumpfEinreihen(s1);
    list.schlumpfEinreihen(s2);
    list.schlumpfEinreihen(s3);
    list.schlumpfEinreihen(s4);
    list.schlumpfEinreihen(s5);

    // Einreihen der Schlumpfe in list2 (2. Liste)
    list2.schlumpfEinreihen(s7);
    list2.schlumpfEinreihen(s8);
    list2.schlumpfEinreihen(s9);
    list2.schlumpfEinreihen(s10);
    list2.schlumpfEinreihen(s11);

    // Anzeigen der Reihenfolge von Schlumpfen in list
    list.printSchlumpfListe(list);
    // Anzeigen der Reihenfolge von Schlumpfen in list2
    list2.printSchlumpfListe(list2);

    // Eine Zeile frei lassen
    System.out.println();

    // Prüfen, ob der Schlumpf s3 in list ist.
    System.out.println("Schlumpf s3 in der Liste?: " + list.schlumpfInListe(s3));
    // Prüfen, ob der Schlumpf s6 in list ist.
    System.out.println("Schlumpf s6 in der Liste?: " + list.schlumpfInListe(s6));

    System.out.println();

    // Anhand von s1 die Position finden - objektabhängig
    // s6 zu Testwecken erstellt und nicht in die list eingefügt
    System.out.println("Position von s3 anhand des Objektes: " + list.schlumpfPosition(s3));
    System.out.println("Position von s6 anhand des Objektes: " + list.schlumpfPosition(s6));

    System.out.println();

    // Anhand von s1 die Position finden - namensabhängig
    // s6 zu Testwecken erstellt und nicht in die list eingefügt
    System.out.println("Position von s3 anhand des Names: " + list.schlumpfPosition("NummerDrei"));
    System.out.println("Position von s6 anhand des Names: " + list.schlumpfPosition(s6.getName()));

    System.out.println();

    // Liste vor dem Schrumpfen ausgeben
    list.printSchlumpfListe(list);

    // Schlumpfe schrumpfen um 3 cm
    list.schluempfeSchrumpfen(3);

    // Liste nach dem Schrumpfen ausgeben
    list.printSchlumpfListe(list);

    // Ausgabe der Schlumpfgroessen nach dem Schrumpfen, beachte
    // dass die Groesse gleich bleibt, wenn die minimale Groesse unterschritten wurde
    System.out.println("Groessen der Schluempfe nach Schrumpfen: ");
    System.out.println(
        "s1: "
            + s1.getGroesse()
            + " s2: "
            + s2.getGroesse()
            + " s3: "
            + s3.getGroesse()
            + " s4: "
            + s4.getGroesse()
            + " s5: "
            + s5.getGroesse());

    // Abfrage ob einer der zu kleinen Schlumpfe (s1) noch in der Liste ist.
    System.out.println("Schlumpf s1 in der Liste?: " + list.schlumpfInListe(s1));
    System.out.println();

    // Liste vor dem Dehnen ausgeben
    list2.printSchlumpfListe(list2);

    // Dehmen der Schlumpfe um 3 cm
    list2.schluempfeDehnen(3);

    // Liste nach dem Dehnen ausgeben
    list2.printSchlumpfListe(list2);

    // Ausgabe der Schlumpfgroessen nach dem Dehnen, beachte
    // dass die Groesse gleich bleibt, wenn die maximale Groesse ueberschritten wurde
    System.out.println("Groessen der Schluempfe nach Dehnen: ");
    System.out.println(
        "s7: "
            + s7.getGroesse()
            + " s8: "
            + s8.getGroesse()
            + " s9: "
            + s9.getGroesse()
            + " s10: "
            + s10.getGroesse()
            + " s11: "
            + s11.getGroesse());

    // Pruefen, ob einer der zu großen Schlumpfe noch in der Liste ist.
    System.out.println("Schlumpf s11 in der Liste?: " + list2.schlumpfInListe(s11));
  }

  public SchlumpfNode getHead() {
    return head;
  }

  // Mit dieser Methode soll ein Schlumpf in die Liste eingereiht werden.
  // Falls der Schlumpf zu gross oder zu klein ist, soll er NICHT in die Liste
  // eingefuegt werden. Andernfalls soll er so einsortiert werden, dass alle
  // Schluempfe vor ihm kleiner oder gleich gross sind und alle nachfolgenden
  // Schluempfe mindestens so gross wie der einzusortierende Schlumpf.
  public void schlumpfEinreihen(Schlumpf schlumpf) {
    if (schlumpf.getGroesse() >= SCHLUMPF_MINIMAL_GROESSE
        && schlumpf.getGroesse() <= SCHLUMPF_MAXIMAL_GROESSE) {
      if (this.head == null) {
        this.head = new SchlumpfNode(schlumpf, null);
      } else {
        SchlumpfNode newNode = this.getHead();
        while (newNode != null) {

          if (schlumpf.getGroesse() > newNode.getSchlumpf().getGroesse()
              && newNode.getNext() == null) {
            newNode.setNext(new SchlumpfNode(schlumpf, null));
            break;
          } else if (schlumpf.getGroesse() <= newNode.getSchlumpf().getGroesse()) {

            newNode.setNext(new SchlumpfNode(newNode.getSchlumpf(), newNode.getNext()));
            newNode.setSchlumpf(schlumpf);
            break;
          }
          newNode = newNode.getNext();
        }
      }
    }
  }

  // Mit dieser Methode soll geprueft werden, ob ein Schlumpf in der Liste
  // ist. Der Rueckgabewert soll true sein, wenn der Schlumpf in der Liste
  // ist, ansonsten false.
  public boolean schlumpfInListe(Schlumpf schlumpf) {
    SchlumpfNode newNode = this.getHead();

    while (newNode != null) {

      if (newNode.getSchlumpf().equals(schlumpf)) {
        return true;
      }
      newNode = newNode.getNext();
    }

    return false;
  }

  // Mit dieser Methode soll die Position eines Schlumpfes in der Liste
  // zurueckgegeben werden. Der erste Schlumpf in der Liste soll, im Gegen-
  // satz zu Arrays, die Position 1 haben. Ist der Schlumpf nicht in der Liste
  // zu finden, soll der Rueckgabewert -1 sein.
  public int schlumpfPosition(Schlumpf schlumpf) {
    SchlumpfNode newNode = this.getHead();
    int pos = 1;
    while (newNode != null) {
      if (newNode.getSchlumpf().equals(schlumpf)) {
        return pos;
      }
      pos++;
      newNode = newNode.getNext();
    }
    return -1;
  }

  // Die gleiche Methode wie oben, nur dass der Schlumpf nicht durch ein
  // Schlumpfobjekt, sondern durch seinen Namen identifiziert werden soll.
  //
  // HINWEIS: Nutzen Sie zum Vergleich die Methode String.compareTo(String)
  //
  // http://docs.oracle.com/javase/6/docs/api/java/lang/String.html#compareTo(java.lang.String)
  //
  // Wenn Sie eine Variable vom Typ String haben, zB String name, koennen Sie
  // die Methode so aufrufen:
  // name.compareTo(andererString)
  // Ist der Rueckgabewert 0, haben die beiden Strings name und andererString
  // den gleichen Wert.
  //
  // ERLAEUTERUNG: Die beiden Methoden schlumpfPosition tragen offensichtlich
  //               den gleichen Namen. Fuer Java ist bei einem Aufruf der
  //               Methode dennoch klar, welche Methode aufgerufen werden
  //               soll, da dies an Hand des Parameters unterschieden werden
  //               kann. Ist der Parameter ein String, muss die untere Methode
  //               gemeint sein, ist es ein Schlumpfobjekt muss die obere
  //               Methode aufgerufen werden.
  //               Das Phaenomen mehrere Methoden gleichen Namens, aber unter-
  //               schiedlicher Parametrisierung zu haben, nennt man
  //               Ueberladung oder Overloading.
  public int schlumpfPosition(String name) {
    SchlumpfNode newNode = this.getHead();
    int pos = 1;
    while (newNode != null) {
      if (newNode.getSchlumpf().getName().compareTo(name) == 0) {
        return pos;
      }
      pos++;
      newNode = newNode.getNext();
    }
    return -1;
  }

  /*
   * ENDE des zu bearbeitenden Codes
   */

  // Mittels dieser Methode sollen alle Schluempfe in der Liste um den durch
  // cm gegebenen Wert verkleinert werden. Sinkt dabei die Groesse einzelner
  // Schluempfe unter den durch SCHLUMPF_MINIMAL_GROESSE gegebenen Wert,
  // sollen diese aus der Liste entfernt werden.
  public void schluempfeSchrumpfen(int cm) {
    SchlumpfNode newHead;
    SchlumpfNode newNode = this.getHead(), nextNode, prevNode = null;
    int newSize = 0;

    while (newNode != null) {
      newSize = (newNode.getSchlumpf().getGroesse() - cm);

      if (newSize < SCHLUMPF_MINIMAL_GROESSE && newNode.equals(this.getHead())) {
        newHead = newNode.getNext();
        this.head = null;
        head = newHead;
        newNode = this.head;
        prevNode = newNode;
        continue;
      } else if (newSize < SCHLUMPF_MINIMAL_GROESSE) {
        nextNode = newNode.getNext();
        prevNode.setNext(nextNode);
        prevNode = newNode;
      } else {
        newNode.getSchlumpf().setGroesse(newSize);
        prevNode = newNode;
      }
      newNode = newNode.getNext();
    }
  }

  // Mittels dieser Methode sollen alle Schluempfe in der Liste um den durch
  // cm gegebenen Wert vergroessert werden. Steigt dabei die Groesse einzelner
  // Schluempfe ueber den durch SCHLUMPF_MAXIMAL_GROESSE gegebenen Wert,
  // sollen diese aus der Liste entfernt werden.
  public void schluempfeDehnen(int cm) {
    SchlumpfNode currentPos = this.getHead();
    SchlumpfNode newHead, prevNode = currentPos, nextNode;

    int newSize = 0;

    while (currentPos != null) {
      newSize = (currentPos.getSchlumpf().getGroesse() + cm);

      if (newSize > SCHLUMPF_MAXIMAL_GROESSE && currentPos.equals(this.getHead())) {
        newHead = currentPos.getNext();
        this.head = null;
        currentPos = null;
        this.head = newHead;
        currentPos = this.head;
      } else if (newSize > SCHLUMPF_MAXIMAL_GROESSE && currentPos.getNext() == null) {
        currentPos = prevNode;
        currentPos.setNext(null);
        break;
      } else if (newSize > SCHLUMPF_MAXIMAL_GROESSE) {
        nextNode = currentPos.getNext();
        prevNode.setNext(nextNode);
        currentPos = nextNode;
        continue;
      } else {
        currentPos.getSchlumpf().setGroesse(newSize);
      }
      prevNode = currentPos;
      currentPos = currentPos.getNext();
    }
  }
}
