/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung05;

public class Node {

  public int zahl;
  public Node next;

  public Node(int zahl, Node next) {
    this.zahl = zahl;
    this.next = next;
  }

  public int getZahl() {
    return zahl;
  }

  public void setZahl(int zahl) {
    this.zahl = zahl;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
