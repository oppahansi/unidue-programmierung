package com.oppahansi.ss14.woche5;

public class SchlumpfNode {

  public Schlumpf schlumpf;
  public SchlumpfNode next;

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
