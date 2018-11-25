/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung05;

public class SchlumpfNode {

  public Schlumpf schlumpf;
  public SchlumpfNode next;

  public SchlumpfNode(Schlumpf schlumpf) {
    this.schlumpf = schlumpf;
    this.next = null;
  }

  public SchlumpfNode(Schlumpf schlumpf, SchlumpfNode next) {
    this.schlumpf = schlumpf;
    this.next = next;
  }

  public Schlumpf getSchlumpf() {
    return schlumpf;
  }

  public void setSchlumpf(Schlumpf schlumpf) {
    this.schlumpf = schlumpf;
  }

  public SchlumpfNode getNext() {
    return next;
  }

  public void setNext(SchlumpfNode next) {
    this.next = next;
  }
}
