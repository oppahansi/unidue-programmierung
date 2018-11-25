/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung07;

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
