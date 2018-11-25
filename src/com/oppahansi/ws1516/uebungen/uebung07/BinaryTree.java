/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung07;
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
   * 							    /     \
   *                         2      17
   *                        /      /  \
   *                      -3      8   20
   *
   * Aufruf von Tree.insert(4)
   *
   *                             5
   * 							    /     \
   *                         2      17
   *                        / \    /  \
   *                      -3   4  8   20
   */

  public static void main(String[] args) {}

  /*
   * Diese Methode soll die maximale Tiefe eines Baumes zurueckgeben. Die
   * maximale Tiefe ist die Laenge des weitesten Weges den man von der Wurzel
   * des Baumes zu einem Blatt zuruecklegen kann.
   *
   * Beispiel:
   *                           5
   * 							    / \
   *                         2   17
   *                        /
   *                      -3
   *
   * Die maximale Tiefe wird in diesem Baum entlang des Pfades 5 -> 2 -> -3
   * erreicht. Der Wert betraegt 3. Falls der Baum kein Element enthaelt und
   * damit leer ist, soll die zurueckgegebene Tiefe 0 sein.
   */

  public void insert(int number) {}

  /*
   * Mit dieser Methode soll die Summe ueber alle Elemente des Baumes
   * zurueckgegeben werden. Ist der Baum leer, soll 0 zurueckgegeben werden.
   *
   * Beispiel:
   *                           5
   * 							    / \
   *                         2   17
   *                        /
   *                      -3
   *
   * Die Summe ueber diesen Baum ware 5 + 2 + (-3) + 17 = 21
   */

  public int maxDepth() {
    return 0;
  }

  /*
   * Mit dieser Methode soll die durch number gegebene Zahl aus dem Baum
   * entfernt werden. Ist diese Zahl nicht im Baum vorhanden, soll nichts
   * geschehen. Dabei ist zu beachten, dass der Baum nach dem Entfernen eines
   * Elements wieder der oben geforderten Sortierung entspricht.
   */

  public int sumOfElements() {
    return 0;
  }

  /*
   * ENDE des zu implementierenden Bereichs
   */

  public void deleteNumber(int number) {}
}
