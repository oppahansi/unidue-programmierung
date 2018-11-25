package com.oppahansi.ss14.miniprojekt5;

public class BulletPersonPrinter extends PersonPrinter {

  @Override
  public void printNames(Person[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.println("* " + items[i].getName());
    }
  }
}
