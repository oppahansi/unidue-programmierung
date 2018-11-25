/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp5;

public class BulletPersonPrinter extends PersonPrinter {

  @Override
  public void printNames(final Person[] items) {
    for (Person currentPerson : items) {
      System.out.println("* " + currentPerson.getName());
    }
  }
}
