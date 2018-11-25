/*
 * ANMERKUNG BITTE LESEN
 *
 * Diese Klausurloesungen wurden nicht von mir (oppahansi) erstellt,
 * sondern von einem Kommilitonen - Khoa Trinh -
 *
 * Falls ich hier einige Sachen im nachhinein veraendere, werde ich es
 * auch kommentieren!
 *
 * Ein Dankeschoen an Khoa Trinh.
 */

package com.oppahansi.ss14.klausurss14Aufg2;

public class Node {

  private int number;
  private Node nextLeft;
  private Node nextRight;

  public Node(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Node getNextLeft() {
    return nextLeft;
  }

  public void setNextLeft(Node node) {
    nextLeft = node;
  }

  public Node getNextRight() {
    return nextRight;
  }

  public void setNextRight(Node node) {
    nextRight = node;
  }
}
