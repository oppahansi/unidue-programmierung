package com.oppahansi.ss14.woche7;

public class BinaryTreeNode {

  int number;
  BinaryTreeNode smaller;
  BinaryTreeNode larger;

  public BinaryTreeNode(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public BinaryTreeNode getSmaller() {
    return smaller;
  }

  public void setSmaller(BinaryTreeNode smaller) {
    this.smaller = smaller;
  }

  public BinaryTreeNode getLarger() {
    return larger;
  }

  public void setLarger(BinaryTreeNode larger) {
    this.larger = larger;
  }
}
