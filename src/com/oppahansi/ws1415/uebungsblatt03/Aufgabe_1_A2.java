/*
 * Created by Rogerg Fu on 10.11.2014.
 *
 * <p>Altermative 2
 */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_1_A2 {

  public static void main(String[] args) {

    for (int y = 100; y < 500; y++) {
      if (y % 9 == 0 || y % 17 == 0) {
        System.out.println(y);
      }
    }

    int x = 100; // bei der while-schleife muss die "zählvariable" vorher bestimmt werden...

    while (x < 500) {
      if (x % 9 == 0 || x % 17 == 0) {
        System.out.println(x);
      }
      x++; // ...und am ende um 1 erhöht werden. wird das vergessen hängt sich das programm auf
    }
  }
}
