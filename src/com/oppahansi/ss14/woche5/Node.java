package com.oppahansi.ss14.woche5;

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
