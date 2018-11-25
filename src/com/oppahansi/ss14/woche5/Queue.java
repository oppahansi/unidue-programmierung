package com.oppahansi.ss14.woche5;

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

/*
 * Codevorlage nicht mein Eigentum.
 * Codevorlage entstand an der Universität Duisburg-Essen am Lehrstuhl für Angewandte Informatik.
 * Benötigt für die Bearbeitung der Queue Aufgabe - Listen
 * Implementierung der Methoden von Oppa Hansi.
 */

public class Queue {

  Node first, last;

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
    if (first == null) {
      this.first = new Node(zahl, null);
      this.last = this.first;
    } else {
      this.last.setNext(new Node(zahl, null));
      this.last = this.last.getNext();
    }
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
    if (this.first == null) {
      return Integer.MIN_VALUE;
    } else if (this.first.equals(this.last)) {
      int num = this.first.getZahl();
      this.first = null;
      this.last = null;
      return num;
    } else {
      int num = this.first.getZahl();
      Node newFirst = this.first.getNext();
      this.first = null;
      this.first = newFirst;
      return num;
    }
  }

  /*
   * Diese Methode soll die Anzahl der Elemente in der Warteschlange
   * zurueckgeben. Ist die Warteschlange leer, soll die Rueckgabe 0 sein, hat
   * die Warteschlange zB 10 Elemente, soll die Rueckgabe 10 sein.
   */
  public int length() {
    if (this.first == null) {
      return 0;
    } else {
      Node node = this.first;
      int counter = 0;
      while (node != null) {
        counter++;
        node = node.getNext();
      }
      return counter;
    }
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
    if (this.first == null) {
      return 0;
    } else {
      Node node = this.first;
      int sum = 0;
      while (node != null) {
        sum += node.getZahl();
        node = node.getNext();
      }
      return sum;
    }
  }
}
