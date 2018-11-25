/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Martin. Possible solution - there are other ways to solve these tasks.
 *
 * <p>Lange Nacht der Programmierung
 */
package com.oppahansi.ws1516.uebungen.zusatz.mathterm;

public class Constant implements Expression {

  int value;

  public Constant(int value) {
    this.value = value;
  }

  @Override
  public int evaluate() {
    return value;
  }
}
