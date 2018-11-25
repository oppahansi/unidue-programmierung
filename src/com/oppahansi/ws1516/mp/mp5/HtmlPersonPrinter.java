/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp5;

public class HtmlPersonPrinter extends PersonPrinter {

  @Override
  public void printNames(final Person[] items) {
    System.out.println("<ul>");

    for (Person currentPerson : items) {
      System.out.println("<li>" + currentPerson.getName() + "</li>");
    }

    System.out.println("</ul>");
  }
}
