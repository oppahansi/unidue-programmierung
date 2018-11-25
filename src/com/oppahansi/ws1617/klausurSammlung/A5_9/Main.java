/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_9;

public class Main {

  public static void main(String[] args) {
    B b = new B();
    A a = b;

    System.out.println(a.x);
    System.out.println(b.x);
    System.out.println(a.m(3));
    System.out.println(b.m(3.00f));
    System.out.println(b.m(3));
  }
}
