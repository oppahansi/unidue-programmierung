/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung06;

public class WordNode {

  private WordNode next;
  private String word;

  public WordNode(String word) {
    this.word = word;
  }

  public WordNode getNext() {
    return next;
  }

  public void setNext(WordNode next) {
    this.next = next;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }
}
