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

import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Expression e = new Constant(40);

    System.out.println(e.evaluate());

    List<Expression> list = new LinkedList<>();
    list.add(new Constant(12));
    list.add(new Constant(5));
    list.add(new Constant(2));
    list.add(new Constant(11));
    list.add(new Faculty(new Constant(4)));
    list.add(new Addition(new Faculty(new Constant(3)), new Constant(2)));

    for (Expression exp : list) {
      System.out.println(exp.evaluate());
    }
  }
}
