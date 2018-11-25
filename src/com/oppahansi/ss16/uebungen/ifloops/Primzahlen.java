/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.ifloops;

public class Primzahlen {

  /*
   * Diese Methode soll zurueckgeben, ob die uebergebene Zahl eine Primzahl ist. Eine Zahl ist genau
   * dann eine Primzahl, wenn sie durch genau 2 Zahlen teilbar ist, naemlich 1 und diese Zahl.
   * Anders formuliert koennte man auch sagen: Eine Zahl ist genau dann eine Primzahl, wenn keine
   * Zahl i existiert, fuer die gilt: i>=2 und i < zahl und zahl%i == 0 Sollte die uebergebene Zahl
   * eine Primzahl sein, soll true zureuckgegeben werden, sonst false.
   */
  public static boolean isPrime(int zahl) {
    return false;
  }

  //In der Main Methode kannst du verschieden Faelle testen.
  public static void main(String[] args) {
    System.out.println(isPrime(42)); //sollte false ergeben
    System.out.println(isPrime(41)); //sollte true ergeben
    System.out.println(isPrime(7)); //sollte true ergeben
    System.out.println(isPrime(11)); //sollte true ergeben
    System.out.println(isPrime(100)); //sollte false ergeben
    System.out.println(isPrime(141)); //sollte false ergeben
  }
}
