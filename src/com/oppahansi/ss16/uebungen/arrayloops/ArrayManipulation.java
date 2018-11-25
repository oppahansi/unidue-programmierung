/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.arrayloops;

import java.util.Arrays;

public class ArrayManipulation {

  /*
   * Diese Methode soll die beiden Zahlen an index1 und index2 im Array array vertauschen. Die Zahl,
   * die an index1 steht, soll nach dem Aufruf der Methode an index2 stehen, die Zahl an index2 soll
   * nach dem Aufruf der Methode an index1 stehen. Es soll nichts zurueckgegeben werden, das
   * uebergeben Array muss stattdessen veraendert werden. Es werden als index1 und index2 nur Zahlen
   * uebergeben, die auch innerhalb des Arrays liegen. Beispiele: vertausche({1,2,3,4,5}, 2, 3) -->
   * {1,2,4,3,5} vertausche({1,2,3,4,5}, 0, 4) --> {5,2,3,4,1}
   */
  public static void vertausche(int[] array, int index1, int index2) {
    int toSwitch = array[index1];
    array[index1] = array[index2];
    array[index2] = toSwitch;
  }

  /*
   * Diese Methode soll das uebergebene Array "umdrehen". Das heisst, das letzte Element steht nach
   * dem Aufruf an letzter Stelle, ... das erste Element steht an letzter Stelle. Es soll wieder
   * nichts zurueckgegeben werden, das uebergebene Array soll stattdessen veraendert werden. Tipp:
   * Man kann diese Aufgabe einfacher loesen, wenn man dazu die erste Methode geschickt aufruft.
   */
  public static void reverse(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      vertausche(array, i, array.length - i - 1);
    }
  }

  //In der Main Methode kannst du deine Methoden testen
  public static void main(String[] args) {
    int[] test = new int[] {1, 2, 3, 4, 5};
    vertausche(test, 2, 3);
    System.out.println("Diese Ausgabe sollte [1, 2, 4, 3, 5] sein: " + Arrays.toString(test));
    test = new int[] {1, 2, 3, 4, 5};
    vertausche(test, 0, 4);
    System.out.println("Diese Ausgabe sollte [5, 2, 3, 4, 1] sein: " + Arrays.toString(test));
    test = new int[] {1, 2, 3, 4, 5};
    reverse(test);
    System.out.println("Diese Ausgabe sollte [5, 4, 3, 2, 1] sein: " + Arrays.toString(test));
  }
}
