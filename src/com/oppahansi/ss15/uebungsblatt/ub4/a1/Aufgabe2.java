/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub4.a1;

import java.util.Arrays;

public class Aufgabe2 {

  // Do NOT touch
  public static void main(String[] args) {
    char[] abc = {
      'a', 'b', 'c', 'e', 'g', 'h', 'i', 'j', 'k', 'J', 'K', 'L', 'M', 'P', 's', 't', 'u', 'v', 'w',
      'x', 'y', 'z', 'A', 'B', 'C', 'D', 'F', 'H', 'I', 'l', 'm', 'n', 'o', 'r', 'Q', 'R', 'S', 'T',
      'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    Aufgabe2 s = new Aufgabe2();
    System.out.println("Unsortiertes Alphabet:");
    s.ausgabe(abc);
    System.out.println("Sortiertes Alphabet:");
    s.sortiere(abc);
    s.ausgabe(abc);
    System.out.println("Paar Ausgabe:");
    s.paarAusgabe(abc);
  }

  // Edit from here on.
  public void sortiere(char[] abc) {
    char switchChar;
    for (int i = 0; i < abc.length; i++) {
      for (int j = i; j < abc.length; j++) {
        if ((int) abc[i] > (int) abc[j]) {
          switchChar = abc[i];
          abc[i] = abc[j];
          abc[j] = switchChar;
        }
      }
    }
  }

  public void paarAusgabe(char[] abc) {
    for (int i = 0; i < abc.length / 2; i++) {
      System.out.print("[" + abc[i] + abc[i + abc.length / 2] + "]");
    }
  }

  public void ausgabe(char[] abc) {
    if (abc == null) {
      System.out.println("Array is null.");
    } else {
      System.out.println(Arrays.toString(abc));
    }
  }
}
