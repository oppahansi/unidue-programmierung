/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_9;

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
