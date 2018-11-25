package com.oppahansi.ss14.woche7;

/*
 * In dieser Aufgabe soll der Umgang mit Binaerbaeumen und Rekursionen geuebt
 * werden. Aehnlich wie in Listen erfolgt der Zugriff auf die Baumelemente ueber
 * eine Verkettung. Im Fall des Binaerbaums hat jedes Baumelement (TreeNode)
 * maximal zwei Nachfolger vom gleichen Typ (smaller, larger). Ein Nachfolger
 * mit dem Wert null bedeutet, dass der Baum an der Stelle nicht weitergeht.
 * Der Binaerbaum dieser Aufgabe soll eine sortierte Zahlenmenge enthalten. Fuer
 * jeden Knoten im Baum soll gelten, dass seine Zahl groesser ist als die Zahlen
 * aller seiner unter smaller zu findenden Nachfolger und kleiner als alle
 * seiner unter larger zu findenden Nachfolger. Der Baum soll duplikatfrei sein,
 * d.h. keine Zahl soll in dem Baum mehrfach vorkommen.
 *
 * Fuer alle hier zu implementierenden Methoden bietet sich die Verwendung von
 * Rekursionen an.
 *
 * HINWEIS:
 *   Fuer die Implemetierung der Methoden kann es notwendig sein Hilfsmethoden
 *   zu verwenden. Sie duerfen fuer die Loesung dieser Aufgabe beliebige
 *   Hilfsmethoden erstellen.
 */

public class BinaryTree {

  BinaryTreeNode top;

  public BinaryTree() {
    top = null;
  }

  /*
   * BEGINN des zu implementierenden Bereichs
   */

  /*
   * Mit dieser Methode soll ein neuer Knoten mit der durch den Parameter
   * number gegebenen Zahl in den Baum eingefuegt werden. Die vorhandene
   * Struktur des Baumes soll dabei nicht geaendert werden und die neue Zahl
   * als Blatt (Knoten ohne Nachfolger) im Baum zu finden sein.
   * Ist die Zahl bereits im Baum vorhanden, soll nichts geschehen.
   *
   * Beispiel:
   *                             5
   * 							/     \
   *                         2      17
   *                        /      /  \
   *                      -3      8   20
   *
   * Aufruf von Tree.insert(4)
   *
   *                             5
   * 							/     \
   *                         2      17
   *                        / \    /  \
   *                      -3   4  8   20
   */

  public static void main(String[] args) {
    BinaryTree zB = new BinaryTree();

    zB.insert(5);
    zB.insert(2);
    zB.insert(17);
    zB.insert(-3);
    zB.insert(8);
    zB.insert(20);

    zB.ausgabeBaum();

    System.out.println("\nTiefe " + zB.maxDepth() + "\n erwartet 3");
    System.out.println("\nSumme " + zB.sumOfElements() + "\n erwartet 53");
    System.out.println("\nEntferne 17\n");

    zB.maxDepth();

    zB.deleteNumber(17);

    zB.ausgabeBaum2();
  }

  public void insert(int number) {
    if (top == null) {
      this.top = new BinaryTreeNode(number);
    } else {
      if (top.getNumber() > number) {
        top.setSmaller(insertHelp(top.getSmaller(), number));
      } else {
        top.setLarger(insertHelp(top.getLarger(), number));
      }
    }
  }

  /*
   * Diese Methode soll die maximale Tiefe eines Baumes zurueckgeben. Die
   * maximale Tiefe ist die Laenge des weitesten Weges den man von der Wurzel
   * des Baumes zu einem Blatt zuruecklegen kann.
   *
   * Beispiel:
   *                           5
   * 							/ \
   *                         2   17
   *                        /
   *                      -3
   *
   * Die maximale Tiefe wird in diesem Baum entlang des Pfades 5 -> 2 -> -3
   * erreicht. Der Wert betraegt 3. Falls der Baum kein Element enthaelt und
   * damit leer ist, soll die zurueckgegebene Tiefe 0 sein.
   */

  private BinaryTreeNode insertHelp(BinaryTreeNode node, int number) {
    BinaryTreeNode blatt = new BinaryTreeNode(number);

    if (node == null) {
      return blatt;
    } else {
      if (node.getNumber() > number) {
        node.setSmaller(insertHelp(node.getSmaller(), number));
        return node;
      } else {
        node.setLarger(insertHelp(node.getLarger(), number));
        return node;
      }
    }
  }

  public int maxDepth() {
    if (this.top == null) {
      return 0;
    } else {
      int sum1 = size(this.top.getSmaller(), 1);
      int sum2 = size(this.top.getLarger(), 1);
      return (sum1 < sum2) ? sum2 : sum1;
    }
  }

  /*
   * Mit dieser Methode soll die Summe ueber alle Elemente des Baumes
   * zurueckgegeben werden. Ist der Baum leer, soll 0 zurueckgegeben werden.
   *
   * Beispiel:
   *                           5
   * 							/ \
   *                         2   17
   *                        /
   *                      -3
   *
   * Die Summe ueber diesen Baum ware 5 + 2 + (-3) + 17 = 21
   */

  private int size(BinaryTreeNode teilbaum, int tiefe) {
    if (teilbaum == null) {
      return tiefe;
    } else {

      if (teilbaum.getLarger() == null) {
        return size(teilbaum.getSmaller(), tiefe + 1);
      } else {
        return size(teilbaum.getLarger(), tiefe + 1);
      }
    }
  }

  public int sumOfElements() {
    if (this.top == null) {
      return 0;
    } else {
      return sum(this.top, 0);
    }
  }

  /*
   * Mit dieser Methode soll die durch number gegebene Zahl aus dem Baum
   * entfernt werden. Ist diese Zahl nicht im Baum vorhanden, soll nichts
   * geschehen. Dabei ist zu beachten, dass der Baum nach dem Entfernen eines
   * Elements wieder der oben geforderten Sortierung entspricht.
   */

  private int sum(BinaryTreeNode teilbaum, int sum) {
    if (teilbaum == null) {
      return sum;
    } else {
      return sum(teilbaum.getSmaller(), teilbaum.getNumber()) + sum(teilbaum.getLarger(), sum);
    }
  }

  public void deleteNumber(int number) {
    if (number < this.top.getNumber()) {
      delete(number, this.top.getSmaller(), this.top);
    } else {
      delete(number, this.top.getLarger(), this.top);
    }
  }

  private void delete(int number, BinaryTreeNode pointer, BinaryTreeNode previous) {
    if (pointer != null) {
      delete(number, pointer.getSmaller(), pointer);
      delete(number, pointer.getLarger(), pointer);
      if (pointer.getNumber() == number) {
        deleteHelp(pointer, previous);
      }
    }
  }

  /*
   * ENDE des zu implementierenden Bereichs
   */

  private void deleteHelp(BinaryTreeNode current, BinaryTreeNode previous) {
    BinaryTreeNode help;
    if (current.getLarger() != null) {
      help = current.getLarger();
      help.setSmaller(current.getSmaller());
    } else {
      help = current.getSmaller();
    }

    if (current.getNumber() < previous.getNumber()) {
      previous.setSmaller(help);
    } else {
      previous.setLarger(help);
    }
  }

  private void ausgabeBaum() {
    BinaryTreeNode spitze = this.top;
    if (spitze != null) {
      System.out.println(spitze.getNumber() + " spitze" + " | erwartet:  5");
    }
    System.out.println();
    if (spitze.getSmaller() != null) {
      System.out.println(
          spitze.getSmaller().getNumber() + " spitze -> smaller" + " | erwartet:  2");
    }
    if (spitze.getLarger() != null) {
      System.out.println(spitze.getLarger().getNumber() + " spitze -> larger" + " | erwartet:  20");
    }
    System.out.println();
    if (spitze.getSmaller().getSmaller() != null) {
      System.out.println(
          spitze.getSmaller().getSmaller().getNumber()
              + " spitze -> smaller -> smaller"
              + " | erwartet:  -3");
    }
    if (spitze.getSmaller().getLarger() != null) {
      System.out.println(
          spitze.getSmaller().getLarger().getNumber()
              + " spitze -> smaller -> larger"
              + " | erwartet:  4");
    }
    System.out.println();
    if (spitze.getLarger().getSmaller() != null) {
      System.out.println(
          spitze.getLarger().getSmaller().getNumber()
              + " spitze -> larger -> smaller"
              + " | erwartet:  8");
    }
    System.out.println();
    if (spitze.getLarger().getLarger() != null) {
      System.out.println(
          spitze.getLarger().getLarger().getNumber()
              + " spitze -> larger -> larger"
              + " | erwartet:  0");
    }
  }

  private void ausgabeBaum2() {
    BinaryTreeNode spitze = this.top;
    if (spitze != null) {
      System.out.println(spitze.getNumber() + " spitze" + " | erwartet:  5");
    }
    System.out.println();
    if (spitze.getSmaller() != null) {
      System.out.println(
          spitze.getSmaller().getNumber() + " spitze -> smaller" + " | erwartet:  2");
    }
    if (spitze.getLarger() != null) {
      System.out.println(spitze.getLarger().getNumber() + " spitze -> larger" + " | erwartet:  20");
    }
    System.out.println();
    if (spitze.getSmaller().getSmaller() != null) {
      System.out.println(
          spitze.getSmaller().getSmaller().getNumber()
              + " spitze -> smaller -> smaller"
              + " | erwartet:  -3");
    }
    if (spitze.getSmaller().getLarger() != null) {
      System.out.println(
          spitze.getSmaller().getLarger().getNumber()
              + " spitze -> smaller -> larger"
              + " | erwartet:  4");
    }
    System.out.println();
    if (spitze.getLarger().getSmaller() != null) {
      System.out.println(
          spitze.getLarger().getSmaller().getNumber()
              + " spitze -> larger -> smaller"
              + " | erwartet:  8");
    }

    if (spitze.getLarger().getLarger() != null) {
      System.out.println(
          spitze.getLarger().getLarger().getNumber()
              + " spitze -> larger -> larger"
              + " | erwartet:  20");
    }
  }
}
