/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.klass;

class A {

  int x = 4;

  A(int x) {
    this.x = x;
  }

  int m(int x) {
    return x + this.x;
  }
}

class B extends A {

  int x = 5;

  B() {
    super(6);
    this.x = x;
  }

  int m(float x) {
    return (int) x + super.x;
  }

  int m(int c) {
    return x - c;
  }
}

public class Haupt {

  public static void main(String[] args) {
    B b = new B();
    A a = b;
    System.out.println(a.x);
    System.out.println(b.x);
    System.out.println(a.m(3));
    System.out.println(b.m(3.0f));
    System.out.println(b.m(3));
  }
}
