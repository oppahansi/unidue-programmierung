package com.oppahansi.ss14.woche6;
/*
 * Codevorlage nicht mein Eigentum.
 * Codevorlage entstand an der Universitaet Duisburg-Essen am Lehrstuhl fuer Angewandte Informatik.
 * Benoetigt fuer die Bearbeitung der RecursiveWordList Aufgabe - Rekursion - Listen
 * Implementierung der Methoden von Oppa Hansi.
 */

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
