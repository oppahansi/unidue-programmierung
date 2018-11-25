/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung05;
/*
 * Diese Aufgabe soll ein einfacher Einstieg in Listen sein.
 * Das hier zu implementierende Konzept ist unter dem Namen Warteschlange oder
 * Queue bekannt. Wie in einer Warteschlange an einer Supermarktkasse werden
 * neue Elemente (Node) hinten angefuegt und wenn ein Element entnommen wird,
 * muss dies in jedem Fall das vorderste oder erste Element der Warteschlange
 * sein.
 *
 * In dieser Vorgabe verfuegt die Warteschlange schon ueber zwei vorgegebene
 * Nodes, first und last. Es bietet sich an in first das vorderste Element der
 * Schlange zu speichern und in last das letzte Element. Die Verwendung dieser
 * zwei Verweise sollte die Realisierung der Warteschlange recht einfach
 * gestalten.
 *
 * Die eigentlich gespeicherten Elemente sollen in dieser Warteschlange ganze
 * Zahlen (int) sein.
 *
 * HINWEIS:
 * - Bei dieser Aufgabe kann es leicht passieren, aus Versehen Endlosschleifen
 *   oder Endlosmethodenaufrufe zu programmieren. Wenn JACK unerwartet lange
 *   fuer die Auswertung Ihrer Abgabe benoetigt, koennte das der Grund sein.
 *   Testen Sie bitte selbst Ihren Programmcode auf Endlosschleifen. Benutzen
 *   Sie dazu die Hilfestellung in der public static void main. Die Ausfuehrung
 *   des Programms sollte nicht laenger als eine Sekunde dauern.
 */

public class Queue {

  private Node first, last;

  /*
   * Testen Sie hier Ihre Implementierung.
   */
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.push(4); // Inhalt der Warteschlange: (4)
    queue.push(17); // Inhalt der Warteschlange: (4, 17)
    queue.pop(); // ...                       (17)
    queue.push(33); // 							 (17, 33)
    queue.push(-13); //							 (17, 33, -13)
    queue.pop(); //							 (33, -13)
    System.out.println("Erwartete Laenge der Warteschlange: 2");
    System.out.println("Tatsaechliche Laenge:               " + queue.length());
    System.out.println();
    System.out.println("Erwartete Summe ueber der Warteschlange: 20");
    System.out.println("Tatsaechliche Summe:                     " + queue.sum());
  }

  /*
   * BEGINN des zu bearbeitenden Codes
   */

  public void Warteschlange() {
    first = null;
    last = null;
  }

  /*
   * Mit Hilfe dieser Methode soll eine neue Zahl ans Ende der Warteschlange
   * angehaengt werden. Beruecksichtigen Sie auch den Fall ein neues Element
   * in eine leere Schlange einzufuegen.
   */
  public void push(int zahl) {
    if (getFirst() == null) {
      setFirst(new Node(zahl, getLast()));
      setLast(getFirst());
    } else {
      getLast().setNext(new Node(zahl, null));
      setLast(getLast().getNext());
    }
  }

  public Node getFirst() {
    return first;
  }

  public void setFirst(Node first) {
    this.first = first;
  }

  public Node getLast() {
    return last;
  }

  public void setLast(Node last) {
    this.last = last;
  }

  /*
   * Diese Methode soll das vorderste Element aus der Warteschlange zurueck-
   * geben und aus der Warteschlange entfernen. Beruecksichtigen Sie auch hier
   * die Sonderfaelle einer leeren Warteschlange und einer Warteschlange mit
   * nur einem Element. Wenn die Warteschlange leer ist, soll der kleinste
   * moegliche Wert fuer eine Integervariable zurueckgegeben werden.
   * Den kleinsten moeglichen Wert erhalten Sie durch "Integer.MIN_VALUE".
   */
  public int pop() {
    if (getFirst() == null) {
      return Integer.MIN_VALUE;
    } else if (getFirst().getNext() == null) {
      int result = getFirst().getZahl();

      setFirst(null);
      setLast(getFirst());

      return result;
    } else {
      int result = getFirst().getZahl();

      setFirst(getFirst().getNext());

      return result;
    }
  }

  /*
   * Diese Methode soll die Anzahl der Elemente in der Warteschlange
   * zurueckgeben. Ist die Warteschlange leer, soll die Rueckgabe 0 sein, hat
   * die Warteschlange zB 10 Elemente, soll die Rueckgabe 10 sein.
   */
  public int length() {
    int result = 0;
    Node node = getFirst();

    while (node != null) {
      result++;
      node = node.getNext();
    }

    return result;
  }

  /*
   * ENDE des zu bearbeitenden Codes
   */

  /*
   * Diese Methode hat nichts mit dem Konzept der Warteschlange zu tun und
   * dient nur der Uebung des Umgangs mit Listenelementen. Der Rueckgabewert
   * soll die Summe aller Zahlen in der Warteschlange sein. Ist die
   * Warteschlange leer, soll der Rueckgabewert 0 sein.
   */
  public int sum() {
    int result = 0;
    Node node = getFirst();

    while (node != null) {
      result += node.getZahl();
      node = node.getNext();
    }

    return result;
  }
}
